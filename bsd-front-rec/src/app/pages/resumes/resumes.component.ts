import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { Util } from 'app/util';
import { GetResumeListRequest } from 'app/services/resume/getResumelistrequest';
import { GetResumeListResponse } from 'app/services/resume/getResumelistresponse';
import { ResumeService } from 'app/services/Resume/resume.service';
import { PostAddResumeRequest } from 'app/services/resume/postaddresumerequest';
import { PostAddResumeResponse } from 'app/services/resume/postaddresumeresponse';
import { GetResumeRequest } from 'app/services/resume/getresumerequest';
import { GetResumeResponse } from 'app/services/resume/getresumeresponse';
import { GetJobResumeListRequest } from 'app/services/job/getjobresumelistrequest';
import { GetJobResumeListResponse } from 'app/services/job/getjobresumelistresponse';

@Component({
  selector: 'app-pages-resumes',
  templateUrl: './resumes.component.html'
})
export class ResumesComponent implements OnInit {
  searchForm = false;
  clicked = false;
  length = 100;
  pageSize = 5;
  pageIndex = 0;
  previousPageIndex = 0;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  pageEvent: PageEvent = new PageEvent();
  pageDisabled: boolean = false;
  util: Util = new Util();
  postAddResumeRequest: PostAddResumeRequest = new PostAddResumeRequest();
  postAddResumeResponse: PostAddResumeResponse = new PostAddResumeResponse();
  getResumeRequest: GetResumeRequest = new GetResumeRequest();
  getResumeResponse: GetResumeResponse = new GetResumeResponse();
  getJobResumeListRequest: GetJobResumeListRequest = new GetJobResumeListRequest();
  getJobResumeListResponse: GetJobResumeListResponse = new GetJobResumeListResponse();

  constructor(
    private router: Router,
    private resumeService: ResumeService
  ) { }

  ngOnInit() {
    this.pageEvent = this.util.cachePaginator('resume.pageEvent');

    this.getResumeList(this.pageEvent);
  }

  getResumeList(pageEvent: PageEvent) {
    this.clicked = !this.clicked;

    if (pageEvent != null) this.pageEvent = pageEvent;

    localStorage.setItem('resume.pageEvent', JSON.stringify(this.pageEvent));

    this.resumeService.getJobResumeList(this.getJobResumeListRequest, this.pageEvent.length, this.pageEvent.pageSize, this.pageEvent.pageIndex)
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;
          this.getJobResumeListResponse = successResponse;
          this.length = this.getJobResumeListResponse.length;
          this.pageSize = this.pageEvent.pageSize;
          this.pageIndex = this.pageEvent.pageIndex;
          this.previousPageIndex = this.pageEvent.previousPageIndex;     
        },
        errorResponse => {
          this.length = 0;
          this.clicked = !this.clicked;
          this.getJobResumeListResponse = new GetJobResumeListResponse();
          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
  }

  getPage(pageEvent: PageEvent) {
    this.getResumeList(pageEvent);
  }

  add() {
    this.router.navigate(['/resumes/0']);
  }

  edit(tbrUuid: string) {
    this.router.navigate(['/resumes/' + tbrUuid]);
  }

  nonActive(tbjUuid: string) {
    this.clicked = !this.clicked;

    this.resumeService.getResume(tbjUuid)
    .subscribe(
      successResponse => {
        this.getResumeResponse = successResponse;

        if (this.getResumeResponse.tbResume.tbrStatus == 'active') {
          this.getResumeResponse.tbResume.tbrStatus = 'not active';
        } else {
          this.getResumeResponse.tbResume.tbrStatus = 'active';
        }

        this.postAddResumeRequest.tbResume = this.getResumeResponse.tbResume;

        this.resumeService.postAddResume(this.postAddResumeRequest)
        .subscribe(
          successResponse => {
            this.clicked = !this.clicked;
            this.postAddResumeResponse = successResponse;
            this.util.showNotification('info', 'top', 'center', successResponse.message);

            this.getResumeList(this.pageEvent);
          },
          errorResponse => {
            this.clicked = !this.clicked;
            this.postAddResumeResponse = new PostAddResumeResponse();
            this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
          }
        );
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.getResumeResponse = new GetResumeResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

  filter() {
    this.searchForm = !this.searchForm;
  }

  search() {
    this.pageEvent.pageIndex = 0;
    this.getResumeList(this.pageEvent);
    this.searchForm = !this.searchForm;
  }

  clear() {
    this.getJobResumeListRequest.viewJobResume.tbjUuid = '';
    this.getJobResumeListRequest.viewJobResume.tbjName = '';
    this.getJobResumeListRequest.viewJobResume.tbrUuid = '';
    this.getJobResumeListRequest.viewJobResume.tbrDataNameRaw = '';
    this.getJobResumeListRequest.viewJobResume.tbrStatus = '';
  }

}
