import { HttpClient, HttpEvent, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable, isDevMode } from '@angular/core';
import { Util } from 'app/util';
import { Observable } from 'rxjs';
import { PostUploadResumeRequest } from './postuploadresumerequest';
import { PostUploadResumeResponse } from './postuploadresumeresponse';

@Injectable({
  providedIn: 'root'
})
export class ResumeService {
  util: Util = new Util();
  apiUrl = isDevMode() ? '/apidepartments/resume' : 'https://domain.com/2082/resume';

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
}
