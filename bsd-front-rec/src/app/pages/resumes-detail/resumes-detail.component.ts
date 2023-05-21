import { Location } from '@angular/common';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { ActivatedRoute } from '@angular/router';
import { GetResumeRequest } from 'app/services/resume/getresumerequest';
import { GetResumeResponse } from 'app/services/resume/getresumeresponse';
import { PostAddResumeRequest } from 'app/services/resume/postaddresumerequest';
import { PostAddResumeResponse } from 'app/services/resume/postaddresumeresponse';
import { ResumeService } from 'app/services/resume/resume.service';
import { TbResumeWorkExperience } from 'app/services/resume/tbresumeworkexperience';
import { Util } from 'app/util';
import { TbResumeEducation } from 'app/services/resume/tbresumeeducation';

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
  hoveredRowIndexSkill = -1;
  displayedColumnsEducation: string[] = ['No', 'Organization', 'Education', 'Level', 'Grade', 'Location', 'Action'];
  hoveredRowIndexEducation = -1;
  displayedColumnsWorkExperience: string[] = ['No', 'Title', 'Title Normalized', 'Organization', 'Start Date', 'End Date', 'Months', 'Current', 'Major', 'Sub Major', 'Minor', 'Level', 'Action'];
  hoveredRowIndexWorkExperience = -1;  
  @ViewChild('pdfFrame') pdfFrame: ElementRef;

  constructor(
    private location: Location,
    private router: Router,
    private route: ActivatedRoute,
    private resumeService: ResumeService
  ) { }

  ngOnInit() {
    this.pageEvent = this.util.cachePaginator('resumes-detail.pageEvent');

    this.route.paramMap.subscribe(params => {
      this.postAddResumeRequest.tbResume.tbrUuid = params.get('tbrUuid');

      this.resumeService.getResume(this.postAddResumeRequest.tbResume.tbrUuid)
      .subscribe(
        successResponse => {
          this.getResumeResponse = successResponse;

          this.postAddResumeRequest.lstTbResumeEducation = this.getResumeResponse.lstTbResumeEducation;
          this.postAddResumeRequest.lstTbResumeWorkExperience = this.getResumeResponse.lstTbResumeWorkExperience;

          const fileUrl = 'http://localhost/resume/' + this.getResumeResponse.tbResume.tbrMetaFileName;
          this.pdfFrame.nativeElement.src = fileUrl;

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

  regenerate() {
    this.clicked = !this.clicked;

    this.resumeService.getRegenerate(this.postAddResumeRequest.tbResume.tbrUuid)
    .subscribe(
      successResponse => {
        this.clicked = !this.clicked;
        this.getResumeResponse = successResponse;

        this.postAddResumeRequest.lstTbResumeEducation = this.getResumeResponse.lstTbResumeEducation;
        this.postAddResumeRequest.lstTbResumeWorkExperience = this.getResumeResponse.lstTbResumeWorkExperience;

        this.postAddResumeRequest.tbResume = this.getResumeResponse.tbResume;

        this.util.showNotification('info', 'top', 'center', this.getResumeResponse.message);
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.getResumeResponse = new GetResumeResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

  update() {
    this.clicked = !this.clicked;
    
    this.resumeService.postAddResume(this.postAddResumeRequest)
    .subscribe(
      successResponse => {
        this.clicked = !this.clicked;
        this.postAddResumeResponse = successResponse;
        this.util.showNotification('info', 'top', 'center', successResponse.message);

        this.resumeService.getResume(this.postAddResumeRequest.tbResume.tbrUuid)
        .subscribe(
          successResponse => {
            this.getResumeResponse = successResponse;

            this.postAddResumeRequest.lstTbResumeEducation = this.getResumeResponse.lstTbResumeEducation;
            this.postAddResumeRequest.lstTbResumeWorkExperience = this.getResumeResponse.lstTbResumeWorkExperience;

            this.postAddResumeRequest.tbResume = this.getResumeResponse.tbResume;
          },
          errorResponse => {
            this.getResumeResponse = new GetResumeResponse();
            this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
          }
      );
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

  add() {
    // this.router.navigate(['/resumes/0']);
  }

  edit(tbrUuid: string) {
    // this.router.navigate(['/resumes/' + tbrUuid]);
  }

  nonActiveEducation(tbreUuid: string) {
    const education = this.getResumeResponse.lstTbResumeEducation.find(x => x.tbreUuid === tbreUuid);
    if (education) {      
      if (education.tbreId === null) {
        const index = this.getResumeResponse.lstTbResumeEducation.indexOf(education);
        this.getResumeResponse.lstTbResumeEducation.splice(index, 1);
      } else {
        if (education.tbreStatus === 'not active') {
          education.tbreStatus = 'active';
        }
        else if (education.tbreStatus === 'active') {
          education.tbreStatus = 'not active';
        }
      }
    }
  }

  addNewEducation() {
    let tbEducation = new TbResumeEducation();
    tbEducation.tbreId = null;
    tbEducation.tbreUuid = this.util.generateUuid(5).toUpperCase();
    tbEducation.tbreStatus = 'active';
    this.getResumeResponse.lstTbResumeEducation.push(tbEducation);
  }
  
  nonActiveWorkExperience(tbrweUuid: string) {
    const workExperience = this.getResumeResponse.lstTbResumeWorkExperience.find(x => x.tbrweUuid === tbrweUuid);
    if (workExperience) {      
      if (workExperience.tbrweId === null) {
        const index = this.getResumeResponse.lstTbResumeWorkExperience.indexOf(workExperience);
        this.getResumeResponse.lstTbResumeWorkExperience.splice(index, 1);
      } else {
        if (workExperience.tbrweStatus === 'not active') {
          workExperience.tbrweStatus = 'active';
        }
        else if (workExperience.tbrweStatus === 'active') {
          workExperience.tbrweStatus = 'not active';
        }
      }
    }
  }

  addNewWorkExperience() {
    let tbWorkExperience = new TbResumeWorkExperience();
    tbWorkExperience.tbrweId = null;
    tbWorkExperience.tbrweUuid = this.util.generateUuid(5).toUpperCase();
    tbWorkExperience.tbrweStatus = 'active';
    this.getResumeResponse.lstTbResumeWorkExperience.push(tbWorkExperience);
  }
  
}
