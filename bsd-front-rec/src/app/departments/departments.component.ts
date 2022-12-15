import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';

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

  constructor(private router: Router) { }

  ngOnInit() {
  }

  getPage(pageEvent: PageEvent) {    
  }

  add() {
    this.router.navigate(['/departments/0']);
  }

  searchFormClick() {
    this.searchForm = !this.searchForm;
  }

}
