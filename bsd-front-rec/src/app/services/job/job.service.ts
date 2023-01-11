import { Injectable, isDevMode } from '@angular/core';
import { HttpClient, HttpEvent, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Util } from 'app/util';
import { GetJobListResponse } from './getjoblistresponse';
import { PostAddJobRequest } from './postaddjobrequest';
import { PostAddJobResponse } from './postaddjobresponse';
import { GetJobResponse } from './getjobresponse';
import { GetJobDepartmentListResponse } from './getjobdepartmentlistresponse';
import { PostUploadResumeRequest } from './postuploadresumerequest';
import { PostUploadResumeResponse } from './postuploadresumeresponse';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  util: Util = new Util();
  apiUrl = isDevMode() ? '/apidepartments/job' : 'https://domain.com/2082/job';

  constructor(private httpClient: HttpClient) { }

  postUploadResume(PostUploadResumeRequest: PostUploadResumeRequest, selectedFile: File): Observable<HttpEvent<PostUploadResumeResponse>> {
    const headers = new HttpHeaders()
      .set('asd', 'asd');

    const params = new HttpParams()
      .set('requestId', this.util.randomString(10))
      .set('requestDate', ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000')
      .set('email', localStorage.getItem('email'))
      .set('token', localStorage.getItem('token'));

    const formData = new FormData();
    formData.append('file', selectedFile, selectedFile.name);

    return this.httpClient.post<PostUploadResumeResponse>(`${this.apiUrl}/postuploadresume`, formData, { headers, params, reportProgress: true, observe: 'events' });
  }
  
  getJobDepartmentList(tbdId: number, tbjName: string, tbdjStatus: string, length: number, pageSize: number, pageIndex: number): Observable<GetJobDepartmentListResponse> {
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
      .set('tbdId', tbdId)
      .set('tbjName', tbjName == null ? '' : tbjName)
      .set('tbdjStatus', tbdjStatus  == null ? '' : tbdjStatus)
      ;

    return this.httpClient.get<GetJobDepartmentListResponse>(`${this.apiUrl}/getjobdepartmentlist`, { headers, params });
  }
  
  getJobList(tbjName: string, tbjStatus: string, length: number, pageSize: number, pageIndex: number): Observable<GetJobListResponse> {
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
      .set('tbjName', tbjName == null ? '' : tbjName)
      .set('tbjStatus', tbjStatus  == null ? '' : tbjStatus)
      ;

    return this.httpClient.get<GetJobListResponse>(`${this.apiUrl}/getjoblist`, { headers, params });
  }

  postAddJob(postAddJobRequest: PostAddJobRequest): Observable<PostAddJobResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    postAddJobRequest.email = localStorage.getItem('email');
    postAddJobRequest.token = localStorage.getItem('token');
    postAddJobRequest.requestId = this.util.randomString(10);
    postAddJobRequest.requestDate = ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000';

    return this.httpClient.post<PostAddJobResponse>(`${this.apiUrl}/postaddjob`, postAddJobRequest, { headers });
  }

  getJob(tbjUuid: string): Observable<GetJobResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    const params = new HttpParams()
      .set('requestId', this.util.randomString(10))
      .set('requestDate', ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000')
      .set('email', localStorage.getItem('email'))
      .set('token', localStorage.getItem('token'))
      .set('tbjUuid', tbjUuid)
      ;

    return this.httpClient.get<GetJobResponse>(`${this.apiUrl}/getjob`, { headers, params });
  }
}
