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
  clicked = false;
  util: Util = new Util();
  pageEvent: PageEvent = new PageEvent();  
  postAddResumeRequest: PostAddResumeRequest = new PostAddResumeRequest();
  postAddResumeResponse: PostAddResumeResponse = new PostAddResumeResponse();
  getResumeRequest: GetResumeRequest = new GetResumeRequest();
  getResumeResponse: GetResumeResponse = new GetResumeResponse();

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

}
