import { Component, OnInit } from '@angular/core';
import { Util } from 'app/util';
import { Router } from '@angular/router';
import { UserService } from 'app/services/user/user.service';
import { UserGetRequest } from 'app/services/user/usergetrequest';
import { UserGetResponse } from 'app/services/user/usergetresponse';
import { PostAddRequest } from 'app/services/payment/postaddrequest';
import { PostAddResponse } from 'app/services/payment/postaddresponse';
import { PaymentService } from 'app/services/payment/payment.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  util: Util = new Util();
  userGetRequest: UserGetRequest = new UserGetRequest();
  userGetResponse: UserGetResponse = new UserGetResponse();
  public payPalConfig: any;
  postAddRequest: PostAddRequest = new PostAddRequest();
  postAddResponse: PostAddResponse = new PostAddResponse();

  constructor(
    private router: Router,
    private userService: UserService,
    private paymentService: PaymentService
  ) {
    this.payPalConfig = {
      clientId: 'Ae3-Xtq7YMEO1QEoXJghga4nQOWL50Odcq9sH69CkJkI0jLlndgTucTGorGdQgJj8P3hyfBEHCSo7Y9g',
      createOrderOnClient: (data: any) => {
        // Implementation to create the PayPal order on the client-side
        return {
          intent: 'CAPTURE',
          purchase_units: [{
            amount: {
              currency_code: 'USD',
              value: '10.00',
              breakdown: {
                item_total: {
                  currency_code: 'USD',
                  value: '10.00'
                }
              }
            },
            items: [{
              name: 'Enterprise Subscription',
              quantity: '1',
              category: 'DIGITAL_GOODS',
              unit_amount: {
                currency_code: 'USD',
                value: '10.00',
              },
            }]
          }],
        };
      },
      onApprove: (data: any, actions: any) => {
        // Implementation to handle the payment approval
        console.log('Payment approved', data);
        actions.order.capture().then((details: any) => {
          console.log('Payment completed', details);

          // Implement further logic after payment completion
          this.postAddRequest.tbPayment.tbpOrderId = data.orderID;
          this.postAddRequest.tbPayment.tbpPayerId = data.payerID;
          this.postAddRequest.tbPayment.tbpPaymentSource = data.paymentSource;
          this.postAddRequest.tbPayment.tbpIntent = details.intent;
          this.postAddRequest.tbPayment.tbpLinks = JSON.stringify(details.links);
          this.postAddRequest.tbPayment.tbpPayer = JSON.stringify(details.payer);
          this.postAddRequest.tbPayment.tbpPurchaseUnits = JSON.stringify(details.purchase_units);
          this.postAddRequest.tbPayment.tbpStatus = details.status;
          this.postAddRequest.tbPayment.tbpCreateTime = details.create_time;
          this.postAddRequest.tbPayment.tbpUpdateTime = details.update_time;

          this.paymentService.postAdd(this.postAddRequest)
          .subscribe(
            successResponse => {
              this.postAddResponse = successResponse;

              this.util.showNotification('info', 'top', 'center', 'Payment completed');
            },
            errorResponse => {
              this.postAddResponse = new PostAddResponse();
              this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
            }
          );
        });
      },
      onError: (err: any) => {
        // Implementation to handle payment errors
        console.error('Error during payment', err);
        this.util.showNotification('danger', 'bottom', 'center', 'Error during payment');
      },
      onCancel: (data: any, actions: any) => {
        // Implementation to handle payment cancellation
        console.log('Payment cancelled', data);
        this.util.showNotification('danger', 'bottom', 'center', 'Payment cancelled');
      }
    };
  }

  ngOnInit() {
    this.userGetRequest.tbuId = '';
    this.userService.getUser(this.userGetRequest)
    .subscribe(
      successResponse => {
        this.userGetResponse = successResponse;
      },
      errorResponse => {
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.error + '<br>' + errorResponse.error.message);
      }
    );
  }

}
