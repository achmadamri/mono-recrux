import { Location } from '@angular/common';
import { HttpEventType } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { ActivatedRoute, Router } from '@angular/router';
import { GetJobRequest } from 'app/services/job/getjobrequest';
import { GetJobResponse } from 'app/services/job/getjobresponse';
import { JobService } from 'app/services/job/job.service';
import { PostAddJobRequest } from 'app/services/job/postaddjobrequest';
import { PostAddJobResponse } from 'app/services/job/postaddjobresponse';
import { PostUploadResumeRequest } from 'app/services/job/postuploadresumerequest';
import { PostUploadResumeResponse } from 'app/services/job/postuploadresumeresponse';
import { GetResumeJobListRequest } from 'app/services/resume/getresumejoblistrequest';
import { GetResumeJobListResponse } from 'app/services/resume/getresumejoblistresponse';
import { PostAddResumeRequest } from 'app/services/resume/postaddresumerequest';
import { PostAddResumeResponse } from 'app/services/resume/postaddresumeresponse';
import { ResumeService } from 'app/services/resume/resume.service';
import { Util } from 'app/util';

@Component({
  selector: 'app-pages-jobs-detail',
  templateUrl: './jobs-detail.component.html'
})
export class JobsDetailComponent implements OnInit {
  @ViewChild('fileInput', { static: false }) fileInput;
  searchForm = false;
  clicked = false;
  util: Util = new Util();
  length = 100;
  pageSize = 5;
  pageIndex = 0;
  previousPageIndex = 0;
  pageSizeOptions: number[] = [5, 10, 25, 100];
  pageEvent: PageEvent = new PageEvent();
  pageDisabled: boolean = false;
  saveUpdate: string = '';
  postAddJobRequest: PostAddJobRequest = new PostAddJobRequest();
  postAddJobResponse: PostAddJobResponse = new PostAddJobResponse();
  getJobRequest: GetJobRequest = new GetJobRequest();
  getJobResponse: GetJobResponse = new GetJobResponse();
  selectedFiles: File[] = [];
  postUploadResumeRequest: PostUploadResumeRequest = new PostUploadResumeRequest();
  postUploadResumeResponse: PostUploadResumeResponse = new PostUploadResumeResponse();
  uploadPercentage = 0;
  totalUpload = 0;
  totalFiles: String[] = Array(new String());
  totalUploadNumber = 0;  
  getResumeJobListRequest: GetResumeJobListRequest = new GetResumeJobListRequest();
  getResumeJobListResponse: GetResumeJobListResponse = new GetResumeJobListResponse();
  postAddResumeRequest: PostAddResumeRequest = new PostAddResumeRequest();
  postAddResumeResponse: PostAddResumeResponse = new PostAddResumeResponse();

  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private router: Router,
    private jobService: JobService,
    private resumeService: ResumeService
  ) { }

  ngOnInit() {
    this.pageEvent = this.util.cachePaginator('jobs-detail.pageEvent');
    this.postAddJobRequest = this.util.cachePaginatorRequest('jobs-detail.request');
    this.postAddJobRequest == null ? this.postAddJobRequest = new PostAddJobRequest() : this.postAddJobRequest;

    this.route.paramMap.subscribe(params => {
      this.postAddJobRequest.tbJob.tbjUuid = params.get('tbjUuid');

      if (this.postAddJobRequest.tbJob.tbjUuid != '0') {
        this.jobService.getJob(this.postAddJobRequest.tbJob.tbjUuid)
          .subscribe(
            successResponse => {
              this.getJobResponse = successResponse;

              this.postAddJobRequest.tbJob.tbjId = this.getJobResponse.tbJob.tbjId;
              this.postAddJobRequest.tbJob.tbjUuid = this.getJobResponse.tbJob.tbjUuid;
              this.postAddJobRequest.tbJob.tbjName = this.getJobResponse.tbJob.tbjName;
              this.postAddJobRequest.tbJob.tbjDescription = this.getJobResponse.tbJob.tbjDescription;
              this.postAddJobRequest.tbJob.tbjStatus = this.getJobResponse.tbJob.tbjStatus;

              this.getResumeJobListRequest.viewResumeJob.tbjId = this.postAddJobRequest.tbJob.tbjId;

              this.getResumeJobList(this.pageEvent);
            },
            errorResponse => {
              this.getJobResponse = new GetJobResponse();
              this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
            }
          );

        this.saveUpdate = 'Update';
      } else {
        this.saveUpdate = 'Save';
      }
    });
  }

  setUnset(tbrUuid: string, tbjId: number) {
    this.clicked = !this.clicked;

    this.postAddResumeRequest.tbResume.tbrUuid = tbrUuid;   

    if (tbjId == undefined) {
      this.postAddResumeRequest.tbResume.tbjId = this.postAddJobRequest.tbJob.tbjId;
    } else {
      this.postAddResumeRequest.tbResume.tbjId = 0;
    }

    this.resumeService.postAddResume(this.postAddResumeRequest)
    .subscribe(
      successResponse => {
        this.clicked = !this.clicked;
        this.postAddResumeResponse = successResponse;
        this.util.showNotification('info', 'top', 'center', successResponse.message);

        this.getResumeJobList(this.pageEvent);
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.postAddJobResponse = new PostAddJobResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

  saveupdate() {
    this.clicked = !this.clicked;

    this.jobService.postAddJob(this.postAddJobRequest)
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;
          this.postAddJobResponse = successResponse;
          this.util.showNotification('info', 'top', 'center', successResponse.message);

          if (this.postAddJobRequest.tbJob.tbdId == 0) {
            this.router.navigate(['/jobs' + '/' + this.postAddJobResponse.tbJob.tbjUuid]);
          } else {
            this.jobService.getJob(this.postAddJobRequest.tbJob.tbjUuid)
              .subscribe(
                successResponse => {
                  this.getJobResponse = successResponse;

                  this.postAddJobRequest.tbJob.tbjId = this.getJobResponse.tbJob.tbjId;
                  this.postAddJobRequest.tbJob.tbjUuid = this.getJobResponse.tbJob.tbjUuid;
                  this.postAddJobRequest.tbJob.tbjName = this.getJobResponse.tbJob.tbjName;
                  this.postAddJobRequest.tbJob.tbjStatus = this.getJobResponse.tbJob.tbjStatus;

                  this.getResumeJobListRequest.viewResumeJob.tbjId = this.postAddJobRequest.tbJob.tbjId;

                  this.getResumeJobList(this.pageEvent);
                },
                errorResponse => {
                  this.getJobResponse = new GetJobResponse();
                  this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
                }
              );
          }          
        },
        errorResponse => {
          this.clicked = !this.clicked;
          this.postAddJobResponse = new PostAddJobResponse();
          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
  }

  onFileChanged(event) {
    for (const file of event.target.files) {
      this.selectedFiles.push(file);
    }
  }

  upload() {
    this.clicked = !this.clicked;

    if (this.selectedFiles.length === 0) {
      this.clicked = !this.clicked;
      this.util.showNotification('info', 'top', 'center', 'No files selected');
    } else {
      this.util.showNotification('info', 'top', 'center', 'Uploading ' + this.selectedFiles.length + ' files');
      this.totalUpload = 0;
      this.totalFiles = Array(new String());
      this.totalUploadNumber = this.selectedFiles.length;
      for (const file of this.selectedFiles) {
        this.resumeService.postUploadResume(this.postAddJobRequest.tbJob.tbjUuid, file)
          .subscribe(
            successResponse => {
              if (successResponse.type === HttpEventType.UploadProgress) {
                this.uploadPercentage = Math.round(100 * successResponse.loaded / successResponse.total);
              } else if (successResponse.type === HttpEventType.Response) {
                this.totalUpload++;
                this.totalFiles.push(successResponse.body.fileNameOri);

                this.postUploadResumeResponse = successResponse.body;
                this.util.showNotification('info', 'top', 'center', this.postUploadResumeResponse.fileNameOri + ' - ' + this.postUploadResumeResponse.message);

                if (this.totalUpload == this.selectedFiles.length) {
                  this.getResumeJobList(this.pageEvent);

                  this.clicked = !this.clicked;
                  this.selectedFiles = [];
                  this.fileInput.nativeElement.value = '';                  
                }
              }
            },
            errorResponse => {
              this.clicked = !this.clicked;
              this.selectedFiles = [];
              this.fileInput.nativeElement.value = '';
              this.postUploadResumeResponse = new PostUploadResumeResponse();
              if (errorResponse.status == 0) {
                this.util.showNotification('danger', 'top', 'center', errorResponse.statusText);
              } else {
                this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
              }
            }
          );
      }
    }
  }

  getPage(pageEvent: PageEvent) {
    this.getResumeJobList(pageEvent);
  }

  back() {
    this.location.back();
  }

  filter() {
    this.searchForm = !this.searchForm;
  }

  search() {
    this.pageEvent.pageIndex = 0;
    this.getResumeJobList(this.pageEvent);
    this.searchForm = !this.searchForm;
  }

  refresh() {
    this.getResumeJobList(this.pageEvent);
  }

  clear() {
    this.getResumeJobListRequest.viewResumeJob.tbrDataNameRaw = '';
    this.getResumeJobListRequest.viewResumeJob.tbrAssigned = '';
  }

  getResumeJobList(pageEvent: PageEvent) {
    this.clicked = !this.clicked;

    if (pageEvent != null) this.pageEvent = pageEvent;

    localStorage.setItem('jobs-detail.pageEvent', JSON.stringify(this.pageEvent));
    localStorage.setItem('jobs-detail.request', JSON.stringify(this.postAddJobRequest));

    this.resumeService.getResumeJobList(this.getResumeJobListRequest, this.pageEvent.length, this.pageEvent.pageSize, this.pageEvent.pageIndex)
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;
          this.getResumeJobListResponse = successResponse;

          this.length = this.getResumeJobListResponse.length;
          this.pageSize = this.pageEvent.pageSize;
          this.pageIndex = this.pageEvent.pageIndex;
          this.previousPageIndex = this.pageEvent.previousPageIndex;   
        },
        errorResponse => {
          this.length = 0;
          this.clicked = !this.clicked;
          this.getResumeJobListResponse = new GetResumeJobListResponse();
          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
  }

  edit(tbrUuid: string) {
    this.router.navigate(['/resumes/' + tbrUuid]);
  }

}
