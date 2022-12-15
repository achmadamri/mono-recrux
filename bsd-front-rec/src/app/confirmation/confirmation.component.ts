import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user/user.service';
import { UserConfirmationRequest } from '../services/user/userconfirmationrequest';
import { UserConfirmationResponse } from '../services/user/userconfirmationresponse';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Util } from '../util';

@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html'
})
export class ConfirmationComponent implements OnInit {
  util: Util = new Util();
  message: string;
  userConfirmationRequest: UserConfirmationRequest = new UserConfirmationRequest();
  userConfirmationResponse: UserConfirmationResponse = new UserConfirmationResponse();

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserService) { }

  ngOnInit() {
    let uuid: string;
    this.route.queryParams.forEach((params: Params) => {
      uuid = params['uuid'];
    });

    this.userConfirmationRequest.tbuUid = uuid;

    this.userService.postConfirmation(this.userConfirmationRequest).subscribe(
      successConfirmationResponse => {
        this.userConfirmationResponse = successConfirmationResponse;

        this.message = this.userConfirmationResponse.message;

        this.util.showNotification('info', 'top', 'center', this.userConfirmationResponse.message);
      },
      errorResponse => {
        this.message = errorResponse.error.message;

        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

  login() {
    this.router.navigate(['/login']);
  }

}
