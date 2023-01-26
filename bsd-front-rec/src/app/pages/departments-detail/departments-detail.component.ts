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
import { PostAddDepartmentJobRequest } from 'app/services/department/postadddepartmentjobrequest';
import { PostAddDepartmentJobResponse } from 'app/services/department/postadddepartmentjobresponse';
import { Location } from '@angular/common';

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
  postAddDepartmentJobRequest: PostAddDepartmentJobRequest = new PostAddDepartmentJobRequest();
  postAddDepartmentJobResponse: PostAddDepartmentJobResponse = new PostAddDepartmentJobResponse();

  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private router: Router,
    private departmentService: DepartmentService,
    private jobService: JobService
  ) { }

  ngOnInit() {
    this.pageEvent = this.util.cachePaginator('departments-detail.pageEvent');

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

            this.getJobDepartmentList(this.pageEvent);
          },
          errorResponse => {            
            this.getDepartmentResponse = new GetDepartmentResponse();
            this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
          }
        );

        this.saveUpdate = 'Update';
      } else {
        this.saveUpdate = 'Save';
      }
    });
  }

  getJobDepartmentList(pageEvent: PageEvent) {
    this.clicked = !this.clicked;

    if (pageEvent != null) this.pageEvent = pageEvent;

    localStorage.setItem('departments-detail.pageEvent', JSON.stringify(this.pageEvent));

    this.jobService.getJobDepartmentList(this.postAddDepartmentRequest.tbDepartment.tbdId, this.getJobDepartmentListRequest.viewJobDepartment.tbjName, this.getJobDepartmentListRequest.viewJobDepartment.tbdjStatus, this.pageEvent.length, this.pageEvent.pageSize, this.pageEvent.pageIndex)
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
          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
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
    this.util.cachePaginatorReset('departments-detail.pageEvent');
    this.getJobDepartmentList(null);
    this.searchForm = !this.searchForm;
  }

  clear() {
    this.getJobDepartmentListRequest.viewJobDepartment.tbjName = '';
    this.getJobDepartmentListRequest.viewJobDepartment.tbdjStatus = '';
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

  setUnset(tbdUuid: string, tbjUuid: string, tbdjUuid: string, tbdjStatus: string) {
    this.clicked = !this.clicked;

    if (tbdUuid == undefined) {
      this.postAddDepartmentJobRequest.tbDepartment.tbdUuid = this.postAddDepartmentRequest.tbDepartment.tbdUuid;
    } else {
      this.postAddDepartmentJobRequest.tbDepartment.tbdUuid = tbdUuid;
    }
        
    this.postAddDepartmentJobRequest.tbJob.tbjUuid = tbjUuid;
    this.postAddDepartmentJobRequest.tbDepartmentJob.tbdjUuid = tbdjUuid;
    this.postAddDepartmentJobRequest.tbDepartmentJob.tbdjStatus = tbdjStatus;

    this.departmentService.postAddDepartmentJob(this.postAddDepartmentJobRequest)
    .subscribe(
      successResponse => {
        this.clicked = !this.clicked;
        this.postAddDepartmentJobResponse = successResponse;
        this.util.showNotification('info', 'top', 'center', successResponse.message);

        this.getJobDepartmentList(this.pageEvent);
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.postAddDepartmentJobResponse = new PostAddDepartmentJobResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }
  
  edit(tbjUuid: string) {
    this.router.navigate(['/jobs/' + tbjUuid]);
  }

}
