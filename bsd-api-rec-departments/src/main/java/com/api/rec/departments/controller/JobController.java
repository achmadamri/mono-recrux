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
import com.api.rec.departments.model.job.GetJobDescriptionRequestModel;
import com.api.rec.departments.model.job.GetJobDescriptionResponseModel;
import com.api.rec.departments.model.job.GetJobListRequestModel;
import com.api.rec.departments.model.job.GetJobListResponseModel;
import com.api.rec.departments.model.job.GetJobRequestModel;
import com.api.rec.departments.model.job.GetJobResponseModel;
import com.api.rec.departments.model.job.PostAddJobRequestModel;
import com.api.rec.departments.model.job.PostAddJobResponseModel;
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
	public HttpEntity<?> getJobDepartmentList(@RequestParam Integer tbdId, @RequestParam String tbjUuid, @RequestParam String tbjName, @RequestParam String tbjStatus, @RequestParam String tbjAssigned, @RequestParam String length, @RequestParam String pageSize, @RequestParam String pageIndex, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetJobDepartmentListRequestModel requestModel = new GetJobDepartmentListRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetJobDepartmentListResponseModel responseModel = jobService.getJobDepartmentList(tbdId, tbjUuid, tbjName, tbjStatus, tbjAssigned, length, pageSize, pageIndex, requestModel);
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

	@GetMapping("/getjobdescription")
	public HttpEntity<?> getJobDescription(@RequestParam String tbjUuid, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetJobDescriptionRequestModel requestModel = new GetJobDescriptionRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetJobDescriptionResponseModel responseModel = jobService.getJobDescription(tbjUuid, requestModel);
		responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
