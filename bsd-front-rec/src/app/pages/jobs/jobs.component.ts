import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { Util } from 'app/util';
import { GetJobListRequest } from 'app/services/job/getjoblistrequest';
import { GetJobListResponse } from 'app/services/job/getjoblistresponse';
import { JobService } from 'app/services/job/job.service';
import { PostAddJobRequest } from 'app/services/job/postaddjobrequest';
import { PostAddJobResponse } from 'app/services/job/postaddjobresponse';
import { GetJobRequest } from 'app/services/job/getjobrequest';
import { GetJobResponse } from 'app/services/job/getjobresponse';

@Component({
  selector: 'app-pages-jobs',
  templateUrl: './jobs.component.html'
})
export class JobsComponent implements OnInit {
  searchForm = false;
  clicked = false;
  length = 100;
  pageSize = 5;
  pageIndex = 0;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  pageEvent: PageEvent;
  pageDisabled: boolean = false;
  util: Util = new Util();
  getJobListRequest: GetJobListRequest = new GetJobListRequest();
  getJobListResponse: GetJobListResponse = new GetJobListResponse();
  postAddJobRequest: PostAddJobRequest = new PostAddJobRequest();
  postAddJobResponse: PostAddJobResponse = new PostAddJobResponse();
  getJobRequest: GetJobRequest = new GetJobRequest();
  getJobResponse: GetJobResponse = new GetJobResponse();

  constructor(
    private router: Router,
    private jobService: JobService
  ) { }

  ngOnInit() {
    this.getJobList(null);
  }

  getJobList(pageEvent: PageEvent) {
    this.clicked = !this.clicked;

    this.pageEvent = pageEvent;

    this.jobService.getJobList(this.getJobListRequest.tbJob.tbjName, this.getJobListRequest.tbJob.tbjStatus, pageEvent != null ? pageEvent.length : this.length, pageEvent != null ? pageEvent.pageSize : this.pageSize, pageEvent != null ? pageEvent.pageIndex : this.pageIndex)
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;
          this.getJobListResponse = successResponse;
          this.length = this.getJobListResponse.length;

          if (pageEvent != null) {
            this.length = pageEvent.length;
            this.pageSize = pageEvent.pageSize;
            this.pageIndex = pageEvent.pageIndex;
          }          
        },
        errorResponse => {
          this.length = 0;
          this.clicked = !this.clicked;
          this.getJobListResponse = new GetJobListResponse();
          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
  }

  getPage(pageEvent: PageEvent) {
    this.getJobList(pageEvent);
  }

  add() {
    this.router.navigate(['/jobs/0']);
  }

  edit(tbjUuid: string) {
    this.router.navigate(['/jobs/' + tbjUuid]);
  }

  nonActive(tbjUuid: string) {
    this.clicked = !this.clicked;

    this.jobService.getJob(tbjUuid)
    .subscribe(
      successResponse => {
        this.getJobResponse = successResponse;

        if (this.getJobResponse.tbJob.tbjStatus == 'active') {
          this.getJobResponse.tbJob.tbjStatus = 'not active';
        } else {
          this.getJobResponse.tbJob.tbjStatus = 'active';
        }

        this.postAddJobRequest.tbJob = this.getJobResponse.tbJob;

        this.jobService.postAddJob(this.postAddJobRequest)
        .subscribe(
          successResponse => {
            this.clicked = !this.clicked;
            this.postAddJobResponse = successResponse;
            this.util.showNotification('info', 'top', 'center', successResponse.message);

            this.getJobList(this.pageEvent);
          },
          errorResponse => {
            this.clicked = !this.clicked;
            this.postAddJobResponse = new PostAddJobResponse();
            this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
          }
        );
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.getJobResponse = new GetJobResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

  filter() {
    this.searchForm = !this.searchForm;
  }

  search() {
    this.getJobList(null);
  }

  clear() {
    this.getJobListRequest.tbJob.tbjName = '';
    this.getJobListRequest.tbJob.tbjStatus = '';
  }

}
