import { Injectable } from '@angular/core';
import { AuthGenerateResponse } from './services/auth/authgenerateresponse';
import * as moment from 'moment';
import { UserGetResponse } from './services/user/usergetresponse';
import { PageEvent } from '@angular/material/paginator';

declare let $: any;

@Injectable({ providedIn: 'root' })
export class Util {
    constructor() { }

    /**
     * Generate uuid for given length
     * Uuid consist of 0-9 and a-z
     * @param length
     */
    generateUuid(length: number): string {
      let outString = '';
      const inOptions = 'abcdefghijklmnopqrstuvwxyz0123456789';

      for (let i = 0; i < length; i++) {
        outString += inOptions.charAt(Math.floor(Math.random() * inOptions.length));
      }

      return outString;
    }

    cachePaginatorReset(name: string) {
      let pageEvent: PageEvent = new PageEvent();
      pageEvent.length = 100;
      pageEvent.pageSize = 5;
      pageEvent.pageIndex = 0;
      pageEvent.previousPageIndex = 0;
      localStorage.setItem(name, JSON.stringify(pageEvent));
    }

    cachePaginator(name: string): PageEvent {
      let pageEvent: PageEvent = new PageEvent();
      if (localStorage.getItem(name) != null) {
        pageEvent = JSON.parse(localStorage.getItem(name));
      } else {
        pageEvent.length = 100;
        pageEvent.pageSize = 5;
        pageEvent.pageIndex = 0;
        pageEvent.previousPageIndex = 0;
      }
      return pageEvent;
    }

    cachePaginatorRequest(name: string): any {
      let request: any;
      if (localStorage.getItem(name) != null) {
        request =  JSON.parse(localStorage.getItem(name));
      }
      return request;
    }

    randomString(length: number): string {
      let outString = '';
      const inOptions = 'abcdefghijklmnopqrstuvwxyz0123456789';

      for (let i = 0; i < length; i++) {
        outString += inOptions.charAt(Math.floor(Math.random() * inOptions.length));
      }

      return outString;
    }

    setLonglat(longitude: number, latitude: number) {
      localStorage.setItem('longitude', longitude.toString());
      localStorage.setItem('latitude', latitude.toString());
    }

    setSession(authGenerateResponse: AuthGenerateResponse) {
      localStorage.setItem('email', authGenerateResponse.claims.name);
      localStorage.setItem('token', authGenerateResponse.token);
      localStorage.setItem('exp', authGenerateResponse.claims.exp.toString());
    }

    setSessionUser(userGetResponse: UserGetResponse) {
      localStorage.setItem('user', JSON.stringify(userGetResponse.tbUser));
      localStorage.setItem('menu', JSON.stringify(userGetResponse.lstViewUserMenu));
    }

    logout() {
      localStorage.removeItem('longitude');
      localStorage.removeItem('latitude');

      localStorage.removeItem('email');
      localStorage.removeItem('token');
      localStorage.removeItem('exp');
      
      localStorage.removeItem('user');
      localStorage.removeItem('menu');
      localStorage.removeItem('brand');
    }

    isLoggedIn() {
      const day = moment.unix(Number(localStorage.getItem('exp')));
      return moment().isBefore(day);
    }

    showNotification(type, from, align, message) {
        // const type = ['', 'info', 'success', 'warning', 'danger'];

        // const color = 4;

        $.notify({
            icon: 'notifications',
            message: message

        }, {
                type: type,
                timer: 5000,
                placement: {
                    from: from,
                    align: align
                },
                template: '<div data-notify="container" class="col-xl-4 col-lg-4 col-11 col-sm-4 col-md-4 alert alert-{0} alert-with-icon" role="alert">' +
                    '<button mat-button  type="button" aria-hidden="true" class="close mat-button" data-notify="dismiss">  <i class="material-icons">close</i></button>' +
                    '<i class="material-icons" data-notify="icon">notifications</i> ' +
                    '<span data-notify="title">{1}</span> ' +
                    '<span data-notify="message">{2}</span>' +
                    '<div class="progress" data-notify="progressbar">' +
                    '<div class="progress-bar progress-bar-{0}" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%;"></div>' +
                    '</div>' +
                    '<a href="{3}" target="{4}" data-notify="url"></a>' +
                    '</div>'
            });
    }
}
