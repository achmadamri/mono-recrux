import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-departments-detail',
  templateUrl: './departments-detail.component.html'
})
export class DepartmentsDetailComponent implements OnInit {
  searchForm = false;
  clicked = false;
  length = 100;
  pageSize = 5;
  pageIndex = 0;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  pageEvent: PageEvent;
  pageDisabled: boolean = false;

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      // this.postOrderEditRequest.tboId = params.get('tboId') == null ? '0' : params.get('tboId');

      // this.getOrder(this.postOrderEditRequest.tboId);
    });
  }

  getPage(pageEvent: PageEvent) {    
  }

  searchFormClick() {
    this.searchForm = !this.searchForm;
  }

  back() {
    this.router.navigate(['/departments']);
  }

}
