import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, isDevMode } from '@angular/core';
import { Util } from 'app/util';
import { Observable } from 'rxjs';
import { PostAddRequest } from './postaddrequest';
import { PostAddResponse } from './postaddresponse';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  util: Util = new Util();  
  apiUrl = isDevMode() ? 'http://localhost:2081/payment' : 'https://amplifio.tech/2081/payment';
  // codespace
  // apiUrl = isDevMode() ? '/apimember/payment' : 'https://amplifio.tech/2081/payment';

  constructor(private httpClient: HttpClient) { }

  postAdd(postAddRequest: PostAddRequest): Observable<PostAddResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    postAddRequest.email = localStorage.getItem('email');
    postAddRequest.token = localStorage.getItem('token');
    postAddRequest.requestId = this.util.randomString(10);
    postAddRequest.requestDate = ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000';

    return this.httpClient.post<PostAddResponse>(`${this.apiUrl}/postadd`, postAddRequest, { headers });
  }
}
