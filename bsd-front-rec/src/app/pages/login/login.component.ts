import { Component, OnInit } from '@angular/core';
import { AuthService } from 'app/services/auth/auth.service';
import { AuthGenerateRequest } from 'app/services/auth/authgeneraterequest';
import { AuthGenerateResponse } from 'app/services/auth/authgenerateresponse';
import { UserService } from 'app/services/user/user.service';
import { UserGetRequest } from 'app/services/user/usergetrequest';
import { UserGetResponse } from 'app/services/user/usergetresponse';
import { Util } from 'app/util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
  clicked = false;
  util: Util = new Util();
  latitude: number;
  authGenerateRequest: AuthGenerateRequest = new AuthGenerateRequest();
  authGenerateResponse: AuthGenerateResponse = new AuthGenerateResponse();
  userGetRequest: UserGetRequest = new UserGetRequest();
  userGetResponse: UserGetResponse = new UserGetResponse();

  constructor(
    private router: Router,
    private authService: AuthService,
    private userService: UserService
  ) { }

  ngOnInit() {
  }

  register() {
    this.router.navigate(['/register']);
  }

  login() {
    this.clicked = !this.clicked;

    this.authGenerateRequest.tbaIdLogin = this.authGenerateRequest.tbaEmail;

    this.authService.postGenerate(this.authGenerateRequest)
      .subscribe(
        successResponse => {
          this.authGenerateResponse = successResponse;

          this.util.setSession(this.authGenerateResponse);

          this.userGetRequest.tbuId = '';

          this.util.showNotification('info', 'top', 'center', successResponse.message);

          this.userService.getUser(this.userGetRequest)
            .subscribe(
              successResponse => {
                this.userGetResponse = successResponse;

                this.util.setSessionUser(this.userGetResponse);

                window.location.href = '/';
              },
              errorResponse => {
                this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
              }
            );
        },
        errorResponse => {
          this.clicked = !this.clicked;

          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
  }

}
