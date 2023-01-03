import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { DepartmentService } from 'app/services/department/department.service';
import { PostAddDepartmentRequest } from 'app/services/department/postadddepartmentrequest';
import { PostAddDepartmentResponse } from 'app/services/department/postadddepartmentresponse';
import { GetDepartmentRequest } from 'app/services/department/getdepartmentrequest';
import { GetDepartmentResponse } from 'app/services/department/getdepartmentresponse';
import { Util } from 'app/util';

@Component({
  selector: 'app-departments-detail',
  templateUrl: './departments-detail.component.html'
})
export class DepartmentsDetailComponent implements OnInit {
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
  postAddDepartmentRequest: PostAddDepartmentRequest = new PostAddDepartmentRequest();
  postAddDepartmentResponse: PostAddDepartmentResponse = new PostAddDepartmentResponse();
  getDepartmentRequest: GetDepartmentRequest = new GetDepartmentRequest();
  getDepartmentResponse: GetDepartmentResponse = new GetDepartmentResponse();

  constructor(private route: ActivatedRoute, private router: Router, private departmentService: DepartmentService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.postAddDepartmentRequest.tbDepartment.tbdUuid = params.get('tbdUuid');

      if (this.postAddDepartmentRequest.tbDepartment.tbdUuid != '0') {
        this.departmentService.getDepartment(this.postAddDepartmentRequest.tbDepartment.tbdUuid)
        .subscribe(
          successResponse => {
            this.getDepartmentResponse = successResponse;

            this.postAddDepartmentRequest.tbDepartment.tbdUuid = this.getDepartmentResponse.tbDepartment.tbdUuid;
            this.postAddDepartmentRequest.tbDepartment.tbdName = this.getDepartmentResponse.tbDepartment.tbdName;
            this.postAddDepartmentRequest.tbDepartment.tbdStatus = this.getDepartmentResponse.tbDepartment.tbdStatus;
          },
          errorResponse => {            
            this.getDepartmentResponse = new GetDepartmentResponse();
          }
        );

        this.saveUpdate = 'Update';
      } else {
        this.saveUpdate = 'Save';
      }
    });
  }

  getPage(pageEvent: PageEvent) {    
  }

  back() {
    this.router.navigate(['/departments']);
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

    this.departmentService.postAddDepartment(this.postAddDepartmentRequest)
    .subscribe(
      successResponse => {
        this.clicked = !this.clicked;
        this.postAddDepartmentResponse = successResponse;
        this.util.showNotification('info', 'top', 'center', successResponse.message);
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.postAddDepartmentResponse = new PostAddDepartmentResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

}
