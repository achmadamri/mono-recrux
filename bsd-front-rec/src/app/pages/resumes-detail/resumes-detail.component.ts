import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-resumes-detail',
  templateUrl: './resumes-detail.component.html'
})
export class ResumesDetailComponent implements OnInit {
  clicked = false;

  constructor(
    private location: Location
  ) { }

  ngOnInit() {
  }

  back() {
    this.location.back();
  }

}
