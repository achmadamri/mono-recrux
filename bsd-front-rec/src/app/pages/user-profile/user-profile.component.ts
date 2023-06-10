import { Component, OnInit } from '@angular/core';
import { Util } from 'app/util';
import { Router } from '@angular/router';
import { UserService } from 'app/services/user/user.service';
import { UserGetRequest } from 'app/services/user/usergetrequest';
import { UserGetResponse } from 'app/services/user/usergetresponse';
import { PostAddRequest } from 'app/services/payment/postaddrequest';
import { PostAddResponse } from 'app/services/payment/postaddresponse';
import { PaymentService } from 'app/services/payment/payment.service';
import { IOnInitCallbackActions, IPayPalConfig } from 'ngx-paypal';
import { TbCompany } from 'app/services/user/tbcompany';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  util: Util = new Util();
  userGetRequest: UserGetRequest = new UserGetRequest();
  userGetResponse: UserGetResponse = new UserGetResponse();
  payPalConfig: IPayPalConfig;
  payPalAction: IOnInitCallbackActions;
  postAddRequest: PostAddRequest = new PostAddRequest();
  postAddResponse: PostAddResponse = new PostAddResponse();  
  subs: string[] = ['Enterprise Subscription'];  
  subsAmount: string[] = ['1200'];
  sub: string;
  orderName: string;
  orderAmount: string;
  disablePaymentRadio: boolean = false;

  constructor(
    private router: Router,
    private userService: UserService,
    private paymentService: PaymentService,
    private cdr: ChangeDetectorRef
  ) { }

  subEvent(e) {
    this.payPalAction.enable();
  }

  ngOnInit() {
    this.userGetResponse.tbCompany = new TbCompany();

    this.disablePaymentRadio = true;

    this.payPalConfig = {
      clientId: 'Ae3-Xtq7YMEO1QEoXJghga4nQOWL50Odcq9sH69CkJkI0jLlndgTucTGorGdQgJj8P3hyfBEHCSo7Y9g',
      createOrderOnClient: (data: any) => {
        // Implementation to create the PayPal order on the client-side
        return {
          intent: 'CAPTURE',
          purchase_units: [{
            amount: {
              currency_code: 'USD',
              value: this.orderAmount,
              breakdown: {
                item_total: {
                  currency_code: 'USD',
                  value: this.orderAmount
                }
              }
            },
            items: [{
              name: this.orderName,
              quantity: '1',
              category: 'DIGITAL_GOODS',
              unit_amount: {
                currency_code: 'USD',
                value: this.orderAmount,
              },
            }]
          }],
        };
      },
      onApprove: (data: any, actions: any) => {
        // Implementation to handle the payment approval
        actions.order.capture().then((details: any) => {

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

                this.userGetRequest.tbuId = '';
                this.userService.getUser(this.userGetRequest)
                .subscribe(
                  successResponse => {
                    this.userGetResponse = successResponse;

                    this.cdr.detectChanges();

                    this.util.showNotification('info', 'top', 'center', 'Payment completed. Please refresh this page for the changes to take effect.');
                  },
                  errorResponse => {
                    this.util.showNotification('danger', 'top', 'center', errorResponse.error.error + '<br>' + errorResponse.error.message);
                  }
                );
              },
              errorResponse => {
                this.postAddResponse = new PostAddResponse();
                this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
              }
            );
        });
      },
      onInit: (data, actions) => {
        this.payPalAction = actions;
        this.payPalAction.disable();
        this.disablePaymentRadio = false;
      },
      onClick: (data, actions) => {
        if (this.sub == null) {
          this.util.showNotification('danger', 'top', 'center', 'Pick subscription');
        } else {
          for (var index in this.subs) {
            if (this.sub == this.subs[index]) {
              this.orderName = this.subs[index];
              this.orderAmount = this.subsAmount[index];
            }
          }
        }
      },
      onError: (err: any) => {
        // Implementation to handle payment errors
        console.error('Error during payment', err);
        this.util.showNotification('danger', 'top', 'center', 'Error during payment');
      },
      onCancel: (data: any, actions: any) => {
        // Implementation to handle payment cancellation
        this.util.showNotification('danger', 'top', 'center', 'Payment cancelled');
      }
    };

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
