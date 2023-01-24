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
  getResumeListRequest: GetResumeListRequest = new GetResumeListRequest();
  getResumeListResponse: GetResumeListResponse = new GetResumeListResponse();
  postAddResumeRequest: PostAddResumeRequest = new PostAddResumeRequest();
  postAddResumeResponse: PostAddResumeResponse = new PostAddResumeResponse();
  getResumeRequest: GetResumeRequest = new GetResumeRequest();
  getResumeResponse: GetResumeResponse = new GetResumeResponse();

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

    this.resumeService.getResumeList(this.getResumeListRequest.tbResume.tbrDataNameRaw, this.getResumeListRequest.tbResume.tbrStatus, this.pageEvent.length, this.pageEvent.pageSize, this.pageEvent.pageIndex)
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;
          this.getResumeListResponse = successResponse;
          this.length = this.getResumeListResponse.length;
          this.pageSize = this.pageEvent.pageSize;
          this.pageIndex = this.pageEvent.pageIndex;
          this.previousPageIndex = this.pageEvent.previousPageIndex;     
        },
        errorResponse => {
          this.length = 0;
          this.clicked = !this.clicked;
          this.getResumeListResponse = new GetResumeListResponse();
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
    this.getResumeList(null);
    this.searchForm = !this.searchForm;
  }

  clear() {
    this.getResumeListRequest.tbResume.tbrDataNameRaw = '';
    this.getResumeListRequest.tbResume.tbrStatus = '';
  }

}
