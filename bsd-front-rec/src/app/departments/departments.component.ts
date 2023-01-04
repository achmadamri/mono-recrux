import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { Util } from 'app/util';
import { GetDepartmentListRequest } from 'app/services/department/getdepartmentlistrequest';
import { GetDepartmentListResponse } from 'app/services/department/getDepartmentlistresponse';
import { DepartmentService } from 'app/services/department/department.service';
import { PostAddDepartmentRequest } from 'app/services/department/postadddepartmentrequest';
import { PostAddDepartmentResponse } from 'app/services/department/postadddepartmentresponse';
import { GetDepartmentRequest } from 'app/services/department/getdepartmentrequest';
import { GetDepartmentResponse } from 'app/services/department/getdepartmentresponse';

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html'
})
export class DepartmentsComponent implements OnInit {
  searchForm = false;
  clicked = false;
  length = 100;
  pageSize = 5;
  pageIndex = 0;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  pageEvent: PageEvent;
  pageDisabled: boolean = false;
  util: Util = new Util();
  getDepartmentListRequest: GetDepartmentListRequest = new GetDepartmentListRequest();
  getDepartmentListResponse: GetDepartmentListResponse = new GetDepartmentListResponse();
  postAddDepartmentRequest: PostAddDepartmentRequest = new PostAddDepartmentRequest();
  postAddDepartmentResponse: PostAddDepartmentResponse = new PostAddDepartmentResponse();
  getDepartmentRequest: GetDepartmentRequest = new GetDepartmentRequest();
  getDepartmentResponse: GetDepartmentResponse = new GetDepartmentResponse();

  constructor(private router: Router, private departmentService: DepartmentService) { }

  ngOnInit() {
    this.getDepartmentList(null);
  }

  getDepartmentList(pageEvent: PageEvent) {
    this.clicked = !this.clicked;

    this.pageEvent = pageEvent;

    this.departmentService.getDepartmentList(this.getDepartmentListRequest.tbDepartment.tbdName, this.getDepartmentListRequest.tbDepartment.tbdStatus, pageEvent != null ? pageEvent.length : this.length, pageEvent != null ? pageEvent.pageSize : this.pageSize, pageEvent != null ? pageEvent.pageIndex : this.pageIndex)
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;
          this.getDepartmentListResponse = successResponse;
          this.length = this.getDepartmentListResponse.length;

          if (pageEvent != null) {
            this.length = pageEvent.length;
            this.pageSize = pageEvent.pageSize;
            this.pageIndex = pageEvent.pageIndex;
          }          
        },
        errorResponse => {
          this.length = 0;
          this.clicked = !this.clicked;
          this.getDepartmentListResponse = new GetDepartmentListResponse();
          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
  }

  getPage(pageEvent: PageEvent) {
    this.getDepartmentList(pageEvent);
  }

  add() {
    this.router.navigate(['/departments/0']);
  }

  edit(tbdUuid: string) {
    this.router.navigate(['/departments/' + tbdUuid]);
  }

  nonActive(tbdUuid: string) {
    this.clicked = !this.clicked;

    this.departmentService.getDepartment(tbdUuid)
    .subscribe(
      successResponse => {
        this.getDepartmentResponse = successResponse;

        if (this.getDepartmentResponse.tbDepartment.tbdStatus == 'active') {
          this.getDepartmentResponse.tbDepartment.tbdStatus = 'not active';
        } else {
          this.getDepartmentResponse.tbDepartment.tbdStatus = 'active';
        }

        this.postAddDepartmentRequest.tbDepartment = this.getDepartmentResponse.tbDepartment;

        this.departmentService.postAddDepartment(this.postAddDepartmentRequest)
        .subscribe(
          successResponse => {
            this.clicked = !this.clicked;
            this.postAddDepartmentResponse = successResponse;
            this.util.showNotification('info', 'top', 'center', successResponse.message);

            this.getDepartmentList(this.pageEvent);
          },
          errorResponse => {
            this.clicked = !this.clicked;
            this.postAddDepartmentResponse = new PostAddDepartmentResponse();
            this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
          }
        );
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.getDepartmentResponse = new GetDepartmentResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

  filter() {
    this.searchForm = !this.searchForm;
  }

  search() {
    this.getDepartmentList(null);
  }

  clear() {
    this.getDepartmentListRequest.tbDepartment.tbdName = '';
    this.getDepartmentListRequest.tbDepartment.tbdStatus = '';
  }

}
