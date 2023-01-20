package com.api.rec.departments.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rec.departments.model.job.GetJobDepartmentListRequestModel;
import com.api.rec.departments.model.job.GetJobDepartmentListResponseModel;
import com.api.rec.departments.model.job.GetJobListRequestModel;
import com.api.rec.departments.model.job.GetJobListResponseModel;
import com.api.rec.departments.model.job.GetJobRequestModel;
import com.api.rec.departments.model.job.GetJobResponseModel;
import com.api.rec.departments.model.job.GetJobResumeListRequestModel;
import com.api.rec.departments.model.job.GetJobResumeListResponseModel;
import com.api.rec.departments.model.job.PostAddJobRequestModel;
import com.api.rec.departments.model.job.PostAddJobResponseModel;
import com.api.rec.departments.model.job.PostAddJobResumeRequestModel;
import com.api.rec.departments.model.job.PostAddJobResumeResponseModel;
import com.api.rec.departments.service.JobService;
import com.api.rec.departments.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/job")
public class JobController {

	private Logger log = LoggerFactory.getLogger(JobController.class);
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private JobService jobService;

	@PostMapping("/postaddjobresume")
	@Transactional
	public HttpEntity<?> postAddJobResume(@Valid @RequestBody PostAddJobResumeRequestModel requestModel) throws Exception {		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostAddJobResumeResponseModel responseModel = jobService.postAddJobResume(requestModel);
		responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@PostMapping("/postaddjob")
	@Transactional
	public HttpEntity<?> postAddJob(@Valid @RequestBody PostAddJobRequestModel requestModel) throws Exception {		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostAddJobResponseModel responseModel = jobService.postAddJob(requestModel);
		responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@GetMapping("/getjoblist")
	public HttpEntity<?> getJobList(@RequestParam String tbjName, @RequestParam String tbjStatus, @RequestParam String length, @RequestParam String pageSize, @RequestParam String pageIndex, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetJobListRequestModel requestModel = new GetJobListRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetJobListResponseModel responseModel = jobService.getJobList(tbjName, tbjStatus, length, pageSize, pageIndex, requestModel);
		responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());

		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@GetMapping("/getjobdepartmentlist")
	public HttpEntity<?> getJobDepartmentList(@RequestParam Integer tbdId, @RequestParam String tbjName, @RequestParam String tbdjStatus, @RequestParam String length, @RequestParam String pageSize, @RequestParam String pageIndex, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetJobDepartmentListRequestModel requestModel = new GetJobDepartmentListRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetJobDepartmentListResponseModel responseModel = jobService.getJobDepartmentList(tbdId, tbjName, tbdjStatus, length, pageSize, pageIndex, requestModel);
		responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());

		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@GetMapping("/getjobresumelist")
	public HttpEntity<?> getJobResumeList(@RequestParam Integer tbjId, @RequestParam String tbrDataNameRaw, @RequestParam String tbrStatus, @RequestParam String length, @RequestParam String pageSize, @RequestParam String pageIndex, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetJobResumeListRequestModel requestModel = new GetJobResumeListRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetJobResumeListResponseModel responseModel = jobService.getJobResumeList(tbjId, tbrDataNameRaw, tbrStatus, length, pageSize, pageIndex, requestModel);
		responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());

		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@GetMapping("/getjob")
	public HttpEntity<?> getJob(@RequestParam String tbjUuid, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetJobRequestModel requestModel = new GetJobRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetJobResponseModel responseModel = jobService.getJob(tbjUuid, requestModel);
		responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
