import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { ActivatedRoute } from '@angular/router';
import { GetResumeRequest } from 'app/services/resume/getresumerequest';
import { GetResumeResponse } from 'app/services/resume/getresumeresponse';
import { PostAddResumeRequest } from 'app/services/resume/postaddresumerequest';
import { PostAddResumeResponse } from 'app/services/resume/postaddresumeresponse';
import { ResumeService } from 'app/services/resume/resume.service';
import { Util } from 'app/util';

@Component({
  selector: 'app-resumes-detail',
  templateUrl: './resumes-detail.component.html'
})
export class ResumesDetailComponent implements OnInit {
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
  postAddResumeRequest: PostAddResumeRequest = new PostAddResumeRequest();
  postAddResumeResponse: PostAddResumeResponse = new PostAddResumeResponse();
  getResumeRequest: GetResumeRequest = new GetResumeRequest();
  getResumeResponse: GetResumeResponse = new GetResumeResponse();
  displayedColumnsSkill: string[] = ['No', 'Type', 'Name', 'Action'];
  displayedColumnsEducation: string[] = ['No', 'Organization', 'Education', 'Level', 'Grade', 'Location', 'Action'];

  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private resumeService: ResumeService
  ) { }

  ngOnInit() {
    this.pageEvent = this.util.cachePaginator('Resumes-detail.pageEvent');

    this.route.paramMap.subscribe(params => {
      this.postAddResumeRequest.tbResume.tbrUuid = params.get('tbrUuid');

      this.resumeService.getResume(this.postAddResumeRequest.tbResume.tbrUuid)
        .subscribe(
          successResponse => {
            this.getResumeResponse = successResponse;

            this.postAddResumeRequest.tbResume = this.getResumeResponse.tbResume;
          },
          errorResponse => {            
            this.getResumeResponse = new GetResumeResponse();
            this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
          }
        );
    });
  }

  back() {
    this.location.back();
  }

  update() {
    
  }

  add() {
    // this.router.navigate(['/resumes/0']);
  }

  edit(tbrUuid: string) {
    // this.router.navigate(['/resumes/' + tbrUuid]);
  }

  nonActive(tbjUuid: string) {
    // this.clicked = !this.clicked;

    // this.resumeService.getResume(tbjUuid)
    // .subscribe(
    //   successResponse => {
    //     this.getResumeResponse = successResponse;

    //     if (this.getResumeResponse.tbResume.tbrStatus == 'active') {
    //       this.getResumeResponse.tbResume.tbrStatus = 'not active';
    //     } else {
    //       this.getResumeResponse.tbResume.tbrStatus = 'active';
    //     }

    //     this.postAddResumeRequest.tbResume = this.getResumeResponse.tbResume;

    //     this.resumeService.postAddResume(this.postAddResumeRequest)
    //     .subscribe(
    //       successResponse => {
    //         this.clicked = !this.clicked;
    //         this.postAddResumeResponse = successResponse;
    //         this.util.showNotification('info', 'top', 'center', successResponse.message);

    //         this.getResumeList(this.pageEvent);
    //       },
    //       errorResponse => {
    //         this.clicked = !this.clicked;
    //         this.postAddResumeResponse = new PostAddResumeResponse();
    //         this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
    //       }
    //     );
    //   },
    //   errorResponse => {
    //     this.clicked = !this.clicked;
    //     this.getResumeResponse = new GetResumeResponse();
    //     this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
    //   }
    // );
  }

}
