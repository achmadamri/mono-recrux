import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { Util } from 'app/util';
import { GetDepartmentListRequest } from 'app/services/department/getdepartmentlistrequest';
import { GetDepartmentListResponse } from 'app/services/department/getDepartmentlistresponse';
import { DepartmentService } from 'app/services/department/department.service';

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

  constructor(private router: Router, private departmentService: DepartmentService) { }

  ngOnInit() {
    this.getDepartmentList(null);
  }

  getDepartmentList(pageEvent: PageEvent) {
    this.clicked = !this.clicked;

    this.departmentService.getDepartmentList(this.getDepartmentListRequest.department.tbdName, this.getDepartmentListRequest.department.tbdStatus, pageEvent != null ? pageEvent.length : this.length, pageEvent != null ? pageEvent.pageSize : this.pageSize, pageEvent != null ? pageEvent.pageIndex : this.pageIndex)
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
        }
      );
  }

  getPage(pageEvent: PageEvent) {
    this.getDepartmentList(pageEvent);
  }

  add() {
    this.router.navigate(['/departments/0']);
  }

  filter() {
    this.searchForm = !this.searchForm;
  }

  search() {
    this.getDepartmentList(null);
  }

  clear() {
    this.getDepartmentListRequest.department.tbdName = '';
    this.getDepartmentListRequest.department.tbdStatus = '';
  }

}
