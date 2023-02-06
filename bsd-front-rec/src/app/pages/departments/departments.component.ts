import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { Util } from 'app/util';
import { GetDepartmentListRequest } from 'app/services/department/getdepartmentlistrequest';
import { GetDepartmentListResponse } from 'app/services/department/getdepartmentlistresponse';
import { DepartmentService } from 'app/services/department/department.service';
import { PostAddDepartmentRequest } from 'app/services/department/postadddepartmentrequest';
import { PostAddDepartmentResponse } from 'app/services/department/postadddepartmentresponse';
import { GetDepartmentRequest } from 'app/services/department/getdepartmentrequest';
import { GetDepartmentResponse } from 'app/services/department/getdepartmentresponse';

@Component({
  selector: 'app-pages-departments',
  templateUrl: './departments.component.html'
})
export class DepartmentsComponent implements OnInit {
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
  getDepartmentListRequest: GetDepartmentListRequest = new GetDepartmentListRequest();
  getDepartmentListResponse: GetDepartmentListResponse = new GetDepartmentListResponse();
  postAddDepartmentRequest: PostAddDepartmentRequest = new PostAddDepartmentRequest();
  postAddDepartmentResponse: PostAddDepartmentResponse = new PostAddDepartmentResponse();
  getDepartmentRequest: GetDepartmentRequest = new GetDepartmentRequest();
  getDepartmentResponse: GetDepartmentResponse = new GetDepartmentResponse();

  constructor(
    private router: Router,
    private departmentService: DepartmentService
  ) { }

  ngOnInit() {
    this.pageEvent = this.util.cachePaginator('departments.pageEvent');
    this.getDepartmentListRequest = this.util.cachePaginatorRequest('departments.request');
    this.getDepartmentListRequest == null ? this.getDepartmentListRequest = new GetDepartmentListRequest() : this.getDepartmentListRequest;

    this.getDepartmentList(this.pageEvent);
  }

  getDepartmentList(pageEvent: PageEvent) {
    this.clicked = !this.clicked;

    if (pageEvent != null) this.pageEvent = pageEvent;

    localStorage.setItem('departments.pageEvent', JSON.stringify(this.pageEvent));
    localStorage.setItem('departments.request', JSON.stringify(this.getDepartmentListRequest));

    this.departmentService.getDepartmentList(this.getDepartmentListRequest.tbDepartment.tbdName, this.getDepartmentListRequest.tbDepartment.tbdStatus, this.pageEvent.length, this.pageEvent.pageSize, this.pageEvent.pageIndex)
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;
          this.getDepartmentListResponse = successResponse;
          this.length = this.getDepartmentListResponse.length;
          this.pageSize = this.pageEvent.pageSize;
          this.pageIndex = this.pageEvent.pageIndex;
          this.previousPageIndex = this.pageEvent.previousPageIndex;
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
          this.getDepartmentResponse.tbDepartment.tbdStatus = 'notactive';
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
    this.pageEvent.pageIndex = 0;
    this.getDepartmentList(this.pageEvent);
    this.searchForm = !this.searchForm;
  }

  clear() {
    this.getDepartmentListRequest.tbDepartment.tbdName = '';
    this.getDepartmentListRequest.tbDepartment.tbdStatus = '';
  }

}
