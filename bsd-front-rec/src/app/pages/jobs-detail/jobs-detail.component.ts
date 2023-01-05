import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { JobService } from 'app/services/job/job.service';
import { PostAddJobRequest } from 'app/services/job/postaddjobrequest';
import { PostAddJobResponse } from 'app/services/job/postaddjobresponse';
import { GetJobRequest } from 'app/services/job/getjobrequest';
import { GetJobResponse } from 'app/services/job/getjobresponse';
import { Util } from 'app/util';

@Component({
  selector: 'app-pages-jobs-detail',
  templateUrl: './jobs-detail.component.html'
})
export class JobsDetailComponent implements OnInit {
  searchForm = false;
  clicked = false;
  util: Util = new Util();
  length = 100;
  pageSize = 5;
  pageIndex = 0;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  pageEvent: PageEvent;
  pageDisabled: boolean = false;
  saveUpdate: string = '';
  postAddJobRequest: PostAddJobRequest = new PostAddJobRequest();
  postAddJobResponse: PostAddJobResponse = new PostAddJobResponse();
  getJobRequest: GetJobRequest = new GetJobRequest();
  getJobResponse: GetJobResponse = new GetJobResponse();

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private jobService: JobService
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.postAddJobRequest.tbJob.tbjUuid = params.get('tbjUuid');

      if (this.postAddJobRequest.tbJob.tbjUuid != '0') {
        this.jobService.getJob(this.postAddJobRequest.tbJob.tbjUuid)
        .subscribe(
          successResponse => {
            this.getJobResponse = successResponse;

            this.postAddJobRequest.tbJob.tbjId = this.getJobResponse.tbJob.tbjId;
            this.postAddJobRequest.tbJob.tbjUuid = this.getJobResponse.tbJob.tbjUuid;
            this.postAddJobRequest.tbJob.tbjName = this.getJobResponse.tbJob.tbjName;
            this.postAddJobRequest.tbJob.tbjStatus = this.getJobResponse.tbJob.tbjStatus;
          },
          errorResponse => {            
            this.getJobResponse = new GetJobResponse();
            this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
          }
        );

        this.saveUpdate = 'Update';
      } else {
        this.saveUpdate = 'Save';
      }
    });
  }

  back() {
    this.router.navigate(['/jobs']);
  }

  filter() {
    this.searchForm = !this.searchForm;
  }

  search() {
    
  }

  clear() {
    
  }

  saveupdate() {
    this.clicked = !this.clicked;

    this.jobService.postAddJob(this.postAddJobRequest)
    .subscribe(
      successResponse => {
        this.clicked = !this.clicked;
        this.postAddJobResponse = successResponse;
        this.util.showNotification('info', 'top', 'center', successResponse.message);
        this.router.navigate(['/jobs' + '/' + this.postAddJobResponse.tbJob.tbjUuid]);
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.postAddJobResponse = new PostAddJobResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

}
