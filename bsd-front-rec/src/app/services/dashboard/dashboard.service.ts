import { Injectable, isDevMode } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Util } from 'app/util';
import { GetDashboardResponse } from './getdashboardresponse';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {
  util: Util = new Util();
  // local
  // apiUrl = isDevMode() ? 'http://localhost:2082/dashboard' : 'https://app.amplifio.tech/2082/dashboard';
  // codespace
  apiUrl = isDevMode() ? '/apidepartments/dashboard' : 'https://app.amplifio.tech/2082/dashboard';

  constructor(private httpClient: HttpClient) { }

  getDashboard(): Observable<GetDashboardResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    const params = new HttpParams()
      .set('requestId', this.util.randomString(10))
      .set('requestDate', ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000')
      .set('email', localStorage.getItem('email'))
      .set('token', localStorage.getItem('token'))
      ;

    return this.httpClient.get<GetDashboardResponse>(`${this.apiUrl}/getdashboard`, { headers, params });
  }
}
