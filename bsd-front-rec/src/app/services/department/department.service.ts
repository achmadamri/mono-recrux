import { Injectable, isDevMode } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Util } from 'app/util';
import { GetDepartmentListResponse } from './getdepartmentlistresponse';
import { PostAddDepartmentRequest } from './postadddepartmentrequest';
import { PostAddDepartmentResponse } from './postadddepartmentresponse';
import { GetDepartmentResponse } from './getdepartmentresponse';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  util: Util = new Util();
  // local
  apiUrl = isDevMode() ? 'http://localhost:2082/department' : 'https://domain.com/2082/department';
  // codespace
  // apiUrl = isDevMode() ? '/apidepartments/department' : 'https://domain.com/2082/department';

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
      .set('tbdName', tbdName == null ? '' : tbdName)
      .set('tbdStatus', tbdStatus  == null ? '' : tbdStatus)
      ;

    return this.httpClient.get<GetDepartmentListResponse>(`${this.apiUrl}/getdepartmentlist`, { headers, params });
  }

  postAddDepartment(postAddDepartmentRequest: PostAddDepartmentRequest): Observable<PostAddDepartmentResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    postAddDepartmentRequest.email = localStorage.getItem('email');
    postAddDepartmentRequest.token = localStorage.getItem('token');
    postAddDepartmentRequest.requestId = this.util.randomString(10);
    postAddDepartmentRequest.requestDate = ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000';

    return this.httpClient.post<PostAddDepartmentResponse>(`${this.apiUrl}/postadddepartment`, postAddDepartmentRequest, { headers });
  }

  getDepartment(tbdUuid: string): Observable<GetDepartmentResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    const params = new HttpParams()
      .set('requestId', this.util.randomString(10))
      .set('requestDate', ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000')
      .set('email', localStorage.getItem('email'))
      .set('token', localStorage.getItem('token'))
      .set('tbdUuid', tbdUuid)
      ;

    return this.httpClient.get<GetDepartmentResponse>(`${this.apiUrl}/getdepartment`, { headers, params });
  }
}
