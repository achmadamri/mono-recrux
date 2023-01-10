import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PageEvent } from '@angular/material/paginator';
import { JobService } from 'app/services/job/job.service';
import { PostAddJobRequest } from 'app/services/job/postaddjobrequest';
import { PostAddJobResponse } from 'app/services/job/postaddjobresponse';
import { GetJobRequest } from 'app/services/job/getjobrequest';
import { GetJobResponse } from 'app/services/job/getjobresponse';
import { Util } from 'app/util';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-pages-jobs-detail',
  templateUrl: './jobs-detail.component.html'
})
export class JobsDetailComponent implements OnInit {
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

  public uploadForm: FormGroup;
  public uploadProgress = 0;
  public uploading = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private jobService: JobService,
    private formBuilder: FormBuilder
  ) {
    this.uploadForm = this.formBuilder.group({
      file: [null, [Validators.required]],
    });    
  }

  public onSubmit() {
    // start the file upload process
    this.uploading = true;
    this.uploadFile(this.uploadForm.value.file)
      .then(() => {
        // reset the form and progress bar when the upload is complete
        this.uploadForm.reset();
        this.uploadProgress = 0;
        this.uploading = false;
      })
      .catch(() => {
        // handle any errors that may occur during the upload process
        this.uploading = false;
      });
  }

  private async uploadFile(file: File) {
    // implement the file upload logic here
    // you can use an HTTP library like HttpClient to make a POST request to an API endpoint with the file as the request body
    // you can update the uploadProgress property to reflect the progress of the upload
  }

  private getErrorMessage() {
    if (this.formControl.hasError('required')) {
      return 'You must select a file';
    }
    return '';
  }

  private get formControl() {
    return this.uploadForm.get('file');
  }

  ngOnInit() {
    if (localStorage.getItem('jobs-detail.pageEvent') != null) {
      this.pageEvent = JSON.parse(localStorage.getItem('jobs-detail.pageEvent'));
    } else {
      this.pageEvent.length = this.length;
      this.pageEvent.pageSize = this.pageSize;
      this.pageEvent.pageIndex = this.pageIndex;
      this.pageEvent.previousPageIndex = this.previousPageIndex;
    }

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
            this.postAddJobRequest.tbJob.tbjStatus = this.getJobResponse.tbJob.tbjStatus;
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

  back() {
    this.router.navigate(['/jobs']);
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

    this.jobService.postAddJob(this.postAddJobRequest)
    .subscribe(
      successResponse => {
        this.clicked = !this.clicked;
        this.postAddJobResponse = successResponse;
        this.util.showNotification('info', 'top', 'center', successResponse.message);
        this.router.navigate(['/jobs' + '/' + this.postAddJobResponse.tbJob.tbjUuid]);
      },
      errorResponse => {
        this.clicked = !this.clicked;
        this.postAddJobResponse = new PostAddJobResponse();
        this.util.showNotification('danger', 'top', 'center', errorResponse.error.message);
      }
    );
  }

}
