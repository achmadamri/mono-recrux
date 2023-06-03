import { Component, OnInit } from '@angular/core';
import { PaymentService } from 'app/services/payment/payment.service';
import { PostAddRequest } from 'app/services/payment/postaddrequest';
import { PostAddResponse } from 'app/services/payment/postaddresponse';
import { TbPayment } from 'app/services/payment/tbpayment';
import { Util } from 'app/util';

@Component({
  selector: 'app-user-subscription',
  templateUrl: './user-subscription.component.html'
})
export class UserSubscriptionComponent implements OnInit {
  public payPalConfig: any;
  util: Util = new Util();
  postAddRequest: PostAddRequest = new PostAddRequest();
  postAddResponse: PostAddResponse = new PostAddResponse();

  constructor(
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
            },
            errorResponse => {
              this.postAddResponse = new PostAddResponse();
              this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
            }
          );

          this.util.showNotification('info', 'bottom', 'center', 'Payment completed');
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
  }

}
