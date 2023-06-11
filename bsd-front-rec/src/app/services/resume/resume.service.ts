import { HttpClient, HttpEvent, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable, isDevMode } from '@angular/core';
import { Util } from 'app/util';
import { Observable } from 'rxjs';
import { GetResumeJobListRequest } from './getresumejoblistrequest';
import { GetResumeJobListResponse } from './getresumejoblistresponse';
import { GetResumeListResponse } from './getresumelistresponse';
import { GetResumeResponse } from './getresumeresponse';
import { PostAddResumeRequest } from './postaddresumerequest';
import { PostAddResumeResponse } from './postaddresumeresponse';
import { PostUploadResumeRequest } from './postuploadresumerequest';
import { PostUploadResumeResponse } from './postuploadresumeresponse';

@Injectable({
  providedIn: 'root'
})
export class ResumeService {
  util: Util = new Util();
  apiUrl = isDevMode() ? 'http://localhost:2082/resume' : 'https://domain.com/2082/resume';
  // codespace
  // apiUrl = isDevMode() ? '/apidepartments/resume' : 'https://domain.com/2082/resume';

  constructor(private httpClient: HttpClient) { }

  postUploadResume(tbjUuid: string, selectedFile: File): Observable<HttpEvent<PostUploadResumeResponse>> {
    const headers = new HttpHeaders()
      .set('asd', 'asd');

    const params = new HttpParams()
      .set('requestId', this.util.randomString(10))
      .set('requestDate', ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000')
      .set('email', localStorage.getItem('email'))
      .set('token', localStorage.getItem('token'))
      .set('tbjUuid', tbjUuid)
      ;

    const formData = new FormData();
    formData.append('file', selectedFile, selectedFile.name);

    return this.httpClient.post<PostUploadResumeResponse>(`${this.apiUrl}/postuploadresume`, formData, { headers, params, reportProgress: true, observe: 'events' });
  }
  
  getResumeList(tbrDataNameRaw: string, tbrStatus: string, length: number, pageSize: number, pageIndex: number): Observable<GetResumeListResponse> {
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
      .set('tbrDataNameRaw', tbrDataNameRaw == null ? '' : tbrDataNameRaw)
      .set('tbrStatus', tbrStatus  == null ? '' : tbrStatus)
      ;

    return this.httpClient.get<GetResumeListResponse>(`${this.apiUrl}/getresumelist`, { headers, params });
  }
  
  getResumeJobList(getResumeJobListRequest: GetResumeJobListRequest, length: number, pageSize: number, pageIndex: number): Observable<GetResumeJobListResponse> {
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
      .set('tbjId', getResumeJobListRequest.viewResumeJob.tbjId == null ? '' : getResumeJobListRequest.viewResumeJob.tbjId)
      .set('tbjName', getResumeJobListRequest.viewResumeJob.tbjName == null ? '' : getResumeJobListRequest.viewResumeJob.tbjName)
      .set('tbrUuid', getResumeJobListRequest.viewResumeJob.tbrUuid == null ? '' : getResumeJobListRequest.viewResumeJob.tbrUuid)
      .set('tbrDataNameRaw', getResumeJobListRequest.viewResumeJob.tbrDataNameRaw == null ? '' : getResumeJobListRequest.viewResumeJob.tbrDataNameRaw)
      .set('tbrStatus', getResumeJobListRequest.viewResumeJob.tbrStatus  == null ? '' : getResumeJobListRequest.viewResumeJob.tbrStatus)
      .set('tbrAssigned', getResumeJobListRequest.viewResumeJob.tbrAssigned  == null ? '' : getResumeJobListRequest.viewResumeJob.tbrAssigned)
      ;

    return this.httpClient.get<GetResumeJobListResponse>(`${this.apiUrl}/getresumejoblist`, { headers, params });
  }

  postAddResume(postAddResumeRequest: PostAddResumeRequest): Observable<PostAddResumeResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    postAddResumeRequest.email = localStorage.getItem('email');
    postAddResumeRequest.token = localStorage.getItem('token');
    postAddResumeRequest.requestId = this.util.randomString(10);
    postAddResumeRequest.requestDate = ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000';

    return this.httpClient.post<PostAddResumeResponse>(`${this.apiUrl}/postaddresume`, postAddResumeRequest, { headers });
  }

  postKanbanResume(postAddResumeRequest: PostAddResumeRequest): Observable<PostAddResumeResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    postAddResumeRequest.email = localStorage.getItem('email');
    postAddResumeRequest.token = localStorage.getItem('token');
    postAddResumeRequest.requestId = this.util.randomString(10);
    postAddResumeRequest.requestDate = ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000';

    return this.httpClient.post<PostAddResumeResponse>(`${this.apiUrl}/postkanbanresume`, postAddResumeRequest, { headers });
  }
  
  getResume(tbjUuid: string): Observable<GetResumeResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    const params = new HttpParams()
      .set('requestId', this.util.randomString(10))
      .set('requestDate', ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000')
      .set('email', localStorage.getItem('email'))
      .set('token', localStorage.getItem('token'))
      .set('tbjUuid', tbjUuid)
      ;

    return this.httpClient.get<GetResumeResponse>(`${this.apiUrl}/getresume`, { headers, params });
  }
  
  getRegenerate(tbjUuid: string): Observable<GetResumeResponse> {
    const headers = new HttpHeaders()
      .set('Content-Type', 'application/json');

    const params = new HttpParams()
      .set('requestId', this.util.randomString(10))
      .set('requestDate', ((new Date(Date.now() - ((new Date()).getTimezoneOffset() * 60000))).toISOString().slice(0, -1)) + '000')
      .set('email', localStorage.getItem('email'))
      .set('token', localStorage.getItem('token'))
      .set('tbjUuid', tbjUuid)
      ;

    return this.httpClient.get<GetResumeResponse>(`${this.apiUrl}/getregenerate`, { headers, params });
  }
}
