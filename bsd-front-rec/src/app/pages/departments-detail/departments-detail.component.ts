import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { DepartmentService } from 'app/services/department/department.service';
import { PostAddDepartmentRequest } from 'app/services/department/postadddepartmentrequest';
import { PostAddDepartmentResponse } from 'app/services/department/postadddepartmentresponse';
import { GetDepartmentRequest } from 'app/services/department/getdepartmentrequest';
import { GetDepartmentResponse } from 'app/services/department/getdepartmentresponse';
import { Util } from 'app/util';
import { GetJobDepartmentListRequest } from 'app/services/job/getjobdepartmentlistrequest';
import { GetJobDepartmentListResponse } from 'app/services/job/getjobdepartmentlistresponse';
import { JobService } from 'app/services/job/job.service';
import { Location } from '@angular/common';
import { PostAddJobRequest } from 'app/services/job/postaddjobrequest';
import { PostAddJobResponse } from 'app/services/job/postaddjobresponse';

@Component({
  selector: 'app-pages-departments-detail',
  templateUrl: './departments-detail.component.html'
})
export class DepartmentsDetailComponent implements OnInit {
  searchForm = false;
  clicked = false;
  util: Util = new Util();
  length = 100;
  pageSize = 5;
  pageIndex = 0;
  previousPageIndex = 0;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  pageEvent: PageEvent = new PageEvent();
  pageDisabled: boolean = false;
  saveUpdate: string = '';
  postAddDepartmentRequest: PostAddDepartmentRequest = new PostAddDepartmentRequest();
  postAddDepartmentResponse: PostAddDepartmentResponse = new PostAddDepartmentResponse();
  getDepartmentRequest: GetDepartmentRequest = new GetDepartmentRequest();
  getDepartmentResponse: GetDepartmentResponse = new GetDepartmentResponse();
  getJobDepartmentListRequest: GetJobDepartmentListRequest = new GetJobDepartmentListRequest();
  getJobDepartmentListResponse: GetJobDepartmentListResponse = new GetJobDepartmentListResponse();
  postAddJobRequest: PostAddJobRequest = new PostAddJobRequest();
  postAddJobResponse: PostAddJobResponse = new PostAddJobResponse();

  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private router: Router,
    private departmentService: DepartmentService,
    private jobService: JobService
  ) { }

  ngOnInit() {
    this.pageEvent = this.util.cachePaginator('departments-detail.pageEvent');
    this.postAddDepartmentRequest = this.util.cachePaginatorRequest('departments-detail.request');
    this.postAddDepartmentRequest == null ? this.postAddDepartmentRequest = new PostAddDepartmentRequest() : this.postAddDepartmentRequest;

    this.route.paramMap.subscribe(params => {
      this.postAddDepartmentRequest.tbDepartment.tbdUuid = params.get('tbdUuid');

      if (this.postAddDepartmentRequest.tbDepartment.tbdUuid != '0') {
        this.departmentService.getDepartment(this.postAddDepartmentRequest.tbDepartment.tbdUuid)
          .subscribe(
            successResponse => {
              this.getDepartmentResponse = successResponse;

              this.postAddDepartmentRequest.tbDepartment.tbdId = this.getDepartmentResponse.tbDepartment.tbdId;
              this.postAddDepartmentRequest.tbDepartment.tbdUuid = this.getDepartmentResponse.tbDepartment.tbdUuid;
              this.postAddDepartmentRequest.tbDepartment.tbdName = this.getDepartmentResponse.tbDepartment.tbdName;
              this.postAddDepartmentRequest.tbDepartment.tbdStatus = this.getDepartmentResponse.tbDepartment.tbdStatus;

              this.getJobDepartmentListRequest.viewJobDepartment.tbdId = this.postAddDepartmentRequest.tbDepartment.tbdId;

              this.getJobDepartmentList(this.pageEvent);
            },
            errorResponse => {
              this.getDepartmentResponse = new GetDepartmentResponse();
              this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
            }
          );

        this.saveUpdate = 'Update';
      } else {
        this.postAddDepartmentRequest.tbDepartment.tbdId = null;
        this.postAddDepartmentRequest.tbDepartment.tbdName = null;

        this.saveUpdate = 'Save';
      }
    });
  }

  getJobDepartmentList(pageEvent: PageEvent) {
    this.clicked = !this.clicked;

    if (pageEvent != null) this.pageEvent = pageEvent;

    localStorage.setItem('departments-detail.pageEvent', JSON.stringify(this.pageEvent));
    localStorage.setItem('departments-detail.request', JSON.stringify(this.postAddDepartmentRequest));

    this.jobService.getJobDepartmentList(this.getJobDepartmentListRequest, this.pageEvent.length, this.pageEvent.pageSize, this.pageEvent.pageIndex)
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;
          this.getJobDepartmentListResponse = successResponse;
          this.length = this.getJobDepartmentListResponse.length;
          this.pageSize = this.pageEvent.pageSize;
          this.pageIndex = this.pageEvent.pageIndex;
          this.previousPageIndex = this.pageEvent.previousPageIndex;   
        },
        errorResponse => {
          this.length = 0;
          this.clicked = !this.clicked;
          this.getJobDepartmentListResponse = new GetJobDepartmentListResponse();
        }
      );
  }

  getPage(pageEvent: PageEvent) {
    this.getJobDepartmentList(pageEvent);
  }

  back() {
    this.location.back();
  }

  filter() {
    this.searchForm = !this.searchForm;
  }

  search() {
    this.pageEvent.pageIndex = 0;
    this.getJobDepartmentList(this.pageEvent);
    this.searchForm = !this.searchForm;
  }

  clear() {
    this.getJobDepartmentListRequest.viewJobDepartment.tbjName = '';
    this.getJobDepartmentListRequest.viewJobDepartment.tbjAssigned = '';
  }

  saveupdate() {
    this.clicked = !this.clicked;

    this.departmentService.postAddDepartment(this.postAddDepartmentRequest)
    .subscribe(
      successResponse => {
        this.clicked = !this.clicked;
        this.postAddDepartmentResponse = successResponse;
        this.util.showNotification('info', 'top', 'center', successResponse.message);
        this.router.navigate(['/departments' + '/' + this.postAddDepartmentResponse.tbDepartment.tbdUuid]);
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.postAddDepartmentResponse = new PostAddDepartmentResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

  setUnset(tbjUuid: string, tbdId: number) {
    this.clicked = !this.clicked;

    this.postAddJobRequest.tbJob.tbjUuid = tbjUuid;

    if (tbdId == undefined) {
      this.postAddJobRequest.tbJob.tbdId = this.postAddDepartmentRequest.tbDepartment.tbdId;
    } else {
      this.postAddJobRequest.tbJob.tbdId = 0;
    }

    this.jobService.postAddJob(this.postAddJobRequest)
    .subscribe(
      successResponse => {
        this.clicked = !this.clicked;
        this.postAddJobResponse = successResponse;
        this.util.showNotification('info', 'top', 'center', successResponse.message);

        this.getJobDepartmentList(this.pageEvent);
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.postAddJobResponse = new PostAddJobResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }
  
  edit(tbjUuid: string) {
    this.router.navigate(['/jobs/' + tbjUuid]);
  }

}
