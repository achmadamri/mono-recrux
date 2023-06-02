import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-subscription',
  templateUrl: './user-subscription.component.html'
})
export class UserSubscriptionComponent implements OnInit {
  public payPalConfig: any;

  constructor() {
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
            },
          }],
        };
      },
      onApprove: (data: any, actions: any) => {
        // Implementation to handle the payment approval
        console.log('Payment approved', data);
        actions.order.capture().then((details: any) => {
          console.log('Payment completed', details);
          // Implement further logic after payment completion
        });
      },
      onError: (err: any) => {
        // Implementation to handle payment errors
        console.error('Error during payment', err);
      }
    };
  }

  ngOnInit() {
  }

}
