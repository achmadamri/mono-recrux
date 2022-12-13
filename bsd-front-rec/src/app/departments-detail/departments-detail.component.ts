import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-departments-detail',
  templateUrl: './departments-detail.component.html'
})
export class DepartmentsDetailComponent implements OnInit {
  clicked = false;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      // this.postOrderEditRequest.tboId = params.get('tboId') == null ? '0' : params.get('tboId');

      // this.getOrder(this.postOrderEditRequest.tboId);
    });
  }

}
