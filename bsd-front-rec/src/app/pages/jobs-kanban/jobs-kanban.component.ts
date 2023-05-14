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
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import { GetResumeRequest } from 'app/services/resume/getresumerequest';
import { GetResumeResponse } from 'app/services/resume/getresumeresponse';

@Component({
  selector: 'app-pages-jobs-kanban',
  templateUrl: './jobs-kanban.component.html',
  styleUrls: ['./jobs-kanban.component.css']
})
export class JobsKanbanComponent implements OnInit {
  @ViewChild('fileInput', { static: false }) fileInput;
  searchForm = false;
  clicked = false;
  util: Util = new Util();
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
  // todo = ['Get to work', 'Pick up groceries', 'Go home', 'Fall asleep'];
  // done = ['Get up', 'Brush teeth', 'Take a shower', 'Check e-mail', 'Walk dog'];
  // kanbanList = [
  //   { title: 'Todo', list: this.todo },
  //   { title: 'Done', list: this.done }
  // ];
  kanbanList = [];
  getKanbanResumeRequest: GetResumeRequest = new GetResumeRequest();
  getKanbanResumeResponse: GetResumeResponse = new GetResumeResponse();

  constructor(
    private location: Location,
    private route: ActivatedRoute,
    private router: Router,
    private jobService: JobService,
    private resumeService: ResumeService
  ) { }

  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex
      );
    }

    for (let i = 0; i < this.kanbanList.length; i++) {
      if (this.kanbanList[i].list === event.container.data) {
        console.log(this.kanbanList[i].title);
        console.log(this.kanbanList[i].list);

        for (let ii = 0; ii < this.kanbanList[i].list.length; ii++) {
          console.log(this.kanbanList[i].list[ii]);

          this.postAddResumeRequest.tbResume.tbrUuid = this.kanbanList[i].list[ii].tbrUuid;
          this.postAddResumeRequest.tbResume.tbrResumeStatus = this.kanbanList[i].title;

          this.resumeService.postKanbanResume(this.postAddResumeRequest)
            .subscribe(
              successResponse => {
                this.postAddResumeResponse = successResponse;

                this.resumeService.getResume(this.postAddResumeRequest.tbResume.tbrUuid)
                  .subscribe(
                    successResponse => {
                      this.getKanbanResumeResponse = successResponse;

                      this.getResumeJobList(null);
                    },
                    errorResponse => {
                      this.getKanbanResumeResponse = new GetResumeResponse();
                      this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
                    }
                  );
              },
              errorResponse => {
                this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
              }
            );
        }
        break;
      }
    }
  }

  getResumeJobList(pageEvent: PageEvent) {
    this.clicked = !this.clicked;

    this.resumeService.getResumeJobList(this.getResumeJobListRequest, 999999, 999999, 0)
      .subscribe(
        successResponse => {
          this.clicked = !this.clicked;
          this.getResumeJobListResponse = successResponse;

          // iterate this.postAddJobRequest.tbJob.tbjResumeStatus split by comma
          this.kanbanList = [];
          this.postAddJobRequest.tbJob.tbjResumeStatus.split(',').forEach(element => {
            let kanban = {
              title: element.trim(),
              // get data from this.getResumeJobListResponse.lstViewResumeJob where tbrResumeStatus = element
              list: this.getResumeJobListResponse.lstViewResumeJob.filter(x => x.tbrResumeStatus == element.trim())
            };
            this.kanbanList.push(kanban);
          });
        },
        errorResponse => {
          this.clicked = !this.clicked;
          this.getResumeJobListResponse = new GetResumeJobListResponse();
          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
  }

  ngOnInit() {
    this.postAddJobRequest == new PostAddJobRequest();

    this.route.paramMap.subscribe(params => {
      this.postAddJobRequest.tbJob.tbjUuid = params.get('tbjUuid');

      this.jobService.getJob(this.postAddJobRequest.tbJob.tbjUuid)
      .subscribe(
        successResponse => {
          this.getJobResponse = successResponse;

          this.postAddJobRequest.tbJob.tbjId = this.getJobResponse.tbJob.tbjId;
          this.postAddJobRequest.tbJob.tbjUuid = this.getJobResponse.tbJob.tbjUuid;
          this.postAddJobRequest.tbJob.tbjName = this.getJobResponse.tbJob.tbjName;
          this.postAddJobRequest.tbJob.tbjDescription = this.getJobResponse.tbJob.tbjDescription;
          this.postAddJobRequest.tbJob.tbjStatus = this.getJobResponse.tbJob.tbjStatus;
          this.postAddJobRequest.tbJob.tbjResumeStatus = this.getJobResponse.tbJob.tbjResumeStatus;

          this.getResumeJobListRequest.viewResumeJob.tbjId = this.postAddJobRequest.tbJob.tbjId;

          this.getResumeJobList(null);
        },
        errorResponse => {
          this.getJobResponse = new GetJobResponse();
          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
    });
  }

  view(tbrUuid: string) {
    this.router.navigate(['/resumes/' + tbrUuid]);
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
                  this.getResumeJobList(null);

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

  back() {
    this.location.back();
  }

  generate() {
    this.clicked = !this.clicked;

    this.jobService.getJobDescription(this.postAddJobRequest.tbJob.tbjUuid)
      .subscribe(
        successResponse => {
          this.getJobResponse = successResponse;

          this.postAddJobRequest.tbJob.tbjDescription = this.getJobResponse.tbJob.tbjDescription;

          this.clicked = !this.clicked;
        },
        errorResponse => {
          this.clicked = !this.clicked;

          this.getJobResponse = new GetJobResponse();
          this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
        }
      );
  }

}
