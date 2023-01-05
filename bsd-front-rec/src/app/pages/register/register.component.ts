import { Component, OnInit } from '@angular/core';
import { UserService } from 'app/services/user/user.service';
import { Util } from 'app/util';
import { Router } from '@angular/router';
import { UserRegisterRequest } from 'app/services/user/userregisterrequest';
import { UserRegisterResponse } from 'app/services/user/userregisterresponse';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit {
  test: Date = new Date();
  clicked = false;
  util: Util = new Util();
  latitude: number;
  userRegisterRequest: UserRegisterRequest = new UserRegisterRequest();
  userRegisterResponse: UserRegisterResponse = new UserRegisterResponse();

  constructor(
    private router: Router,
    private userService: UserService
  ) { }

  ngOnInit() {
  }

  register() {
    this.clicked = !this.clicked;

    this.userService.postUserRegister(this.userRegisterRequest)
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;

          this.userRegisterResponse = successResponse;

          this.util.showNotification('info', 'top', 'center', successResponse.message);

          this.router.navigate(['/login']);
        },
        errorResponse => {
          this.clicked = !this.clicked;

          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
  }

  login() {
    this.router.navigate(['/login']);
  }

}
