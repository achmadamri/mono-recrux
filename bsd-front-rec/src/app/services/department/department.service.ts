import { Injectable, isDevMode } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Util } from 'app/util';
import { GetDepartmentListResponse } from './getDepartmentlistresponse';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  util: Util = new Util();
  apiUrl = isDevMode() ? '/apidepartments/department' : 'https://domain.com/2082/department';

  constructor(private httpClient: HttpClient) { }
  
  getDepartmentList(tbdName: string, tbdStatus: string, length: number, pageSize: number, pageIndex: number): Observable<GetDepartmentListResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    const params = new HttpParams()
      .set('requestId', this.util.randomString(10))
      .set('requestDate', ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000')
      .set('email', localStorage.getItem('email'))
      .set('token', localStorage.getItem('token'))
      .set('length', length.toString())
      .set('pageSize', pageSize.toString())
      .set('pageIndex', pageIndex.toString())
      .set('tbdName', tbdName)
      .set('tbdStatus', tbdStatus)
      ;

    return this.httpClient.get<GetDepartmentListResponse>(`${this.apiUrl}/getdepartmentlist`, { headers, params });
  }
}
