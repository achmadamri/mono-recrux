import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { Util } from 'app/util';
import { GetResumeListRequest } from 'app/services/resume/getresumelistrequest';
import { GetResumeListResponse } from 'app/services/resume/getresumelistresponse';
import { ResumeService } from 'app/services/resume/resume.service';
import { PostAddResumeRequest } from 'app/services/resume/postaddresumerequest';
import { PostAddResumeResponse } from 'app/services/resume/postaddresumeresponse';
import { GetResumeRequest } from 'app/services/resume/getresumerequest';
import { GetResumeResponse } from 'app/services/resume/getresumeresponse';
import { getSystemErrorMap } from 'util';
import { GetResumeJobListRequest } from 'app/services/resume/getresumejoblistrequest';
import { GetResumeJobListResponse } from 'app/services/resume/getresumejoblistresponse';
import { ViewResumeJob } from 'app/services/resume/viewresumejob';

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
  getResumeJobListRequest: GetResumeJobListRequest = new GetResumeJobListRequest();
  getResumeJobListResponse: GetResumeJobListResponse = new GetResumeJobListResponse();

  constructor(
    private router: Router,
    private resumeService: ResumeService
  ) { }

  ngOnInit() {
    this.pageEvent = this.util.cachePaginator('resume.pageEvent');
    this.getResumeJobListRequest = this.util.cachePaginatorRequest('resume.request');
    this.getResumeJobListRequest == null ? this.getResumeJobListRequest = new GetResumeJobListRequest() : this.getResumeJobListRequest;    
    this.getResumeJobListRequest.viewResumeJob = new ViewResumeJob();

    this.getResumeList(this.pageEvent);
  }

  getResumeList(pageEvent: PageEvent) {
    this.clicked = !this.clicked;

    if (pageEvent != null) this.pageEvent = pageEvent;

    localStorage.setItem('resume.pageEvent', JSON.stringify(this.pageEvent));
    localStorage.setItem('resume.request', JSON.stringify(this.getResumeJobListRequest));

    this.resumeService.getResumeJobList(this.getResumeJobListRequest, this.pageEvent.length, this.pageEvent.pageSize, this.pageEvent.pageIndex, 'tbr_create_date', 'desc')
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;
          this.getResumeJobListResponse = successResponse;

          this.length = this.getResumeJobListResponse.length;
          this.pageSize = this.pageEvent.pageSize;
          this.pageIndex = this.pageEvent.pageIndex;
          this.previousPageIndex = this.pageEvent.previousPageIndex;     
        },
        errorResponse => {
          this.length = 0;
          this.clicked = !this.clicked;
          this.getResumeJobListResponse = new GetResumeJobListResponse();
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

  refresh() {
    this.getResumeList(this.pageEvent);
  }

  clear() {
    this.getResumeJobListRequest.viewResumeJob.tbjUuid = '';
    this.getResumeJobListRequest.viewResumeJob.tbjName = '';
    this.getResumeJobListRequest.viewResumeJob.tbrUuid = '';
    this.getResumeJobListRequest.viewResumeJob.tbrDataNameRaw = '';
    this.getResumeJobListRequest.viewResumeJob.tbrStatus = '';
  }

}
