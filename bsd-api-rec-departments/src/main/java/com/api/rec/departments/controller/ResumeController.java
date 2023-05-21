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
import org.springframework.web.multipart.MultipartFile;

import com.api.rec.departments.model.resume.GetResumeJobListRequestModel;
import com.api.rec.departments.model.resume.GetResumeJobListResponseModel;
import com.api.rec.departments.model.resume.GetResumeListRequestModel;
import com.api.rec.departments.model.resume.GetResumeListResponseModel;
import com.api.rec.departments.model.resume.GetResumeRequestModel;
import com.api.rec.departments.model.resume.GetResumeResponseModel;
import com.api.rec.departments.model.resume.PostAddResumeRequestModel;
import com.api.rec.departments.model.resume.PostAddResumeResponseModel;
import com.api.rec.departments.model.resume.PostUploadResumeRequestModel;
import com.api.rec.departments.model.resume.PostUploadResumeResponseModel;
import com.api.rec.departments.service.ResumeService;
import com.api.rec.departments.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/resume")
public class ResumeController {

	private Logger log = LoggerFactory.getLogger(ResumeController.class);
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private ResumeService resumeService;
	
	@PostMapping("/postuploadresume")
	public HttpEntity<?> postUploadResume(PostUploadResumeRequestModel requestModel, @Valid @RequestParam("file") MultipartFile file) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + file.toString());
		
		PostUploadResumeResponseModel responseModel = resumeService.postUploadResume(requestModel, file);
		if (responseModel.getMessage() == null ) responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@GetMapping("/getresumelist")
	public HttpEntity<?> getResumeList(@RequestParam String tbrDataNameRaw, @RequestParam String tbrStatus, @RequestParam String length, @RequestParam String pageSize, @RequestParam String pageIndex, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetResumeListRequestModel requestModel = new GetResumeListRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetResumeListResponseModel responseModel = resumeService.getResumeList(tbrDataNameRaw, tbrStatus, length, pageSize, pageIndex, requestModel);
		if (responseModel.getMessage() == null ) responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());

		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@GetMapping("/getresumejoblist")
	public HttpEntity<?> getResumeJobList(@RequestParam Integer tbjId, @RequestParam String tbrUuid, @RequestParam String tbrDataNameRaw, @RequestParam String tbrStatus, @RequestParam String tbrAssigned, @RequestParam String length, @RequestParam String pageSize, @RequestParam String pageIndex, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetResumeJobListRequestModel requestModel = new GetResumeJobListRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetResumeJobListResponseModel responseModel = resumeService.getResumeJobList(tbjId, tbrUuid, tbrDataNameRaw, tbrStatus, tbrAssigned, length, pageSize, pageIndex, requestModel);
		if (responseModel.getMessage() == null ) responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());

		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@PostMapping("/postaddresume")
	@Transactional
	public HttpEntity<?> postAddResume(@Valid @RequestBody PostAddResumeRequestModel requestModel) throws Exception {		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostAddResumeResponseModel responseModel = resumeService.postAddResume(requestModel);
		if (responseModel.getMessage() == null ) responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@PostMapping("/postkanbanresume")
	@Transactional
	public HttpEntity<?> postKanbanResume(@Valid @RequestBody PostAddResumeRequestModel requestModel) throws Exception {		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostAddResumeResponseModel responseModel = resumeService.postKanbanResume(requestModel);
		if (responseModel.getMessage() == null ) responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@GetMapping("/getresume")
	public HttpEntity<?> getResume(@RequestParam String tbjUuid, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetResumeRequestModel requestModel = new GetResumeRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetResumeResponseModel responseModel = resumeService.getResume(tbjUuid, requestModel);
		if (responseModel.getMessage() == null ) responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	@GetMapping("/getregenerate")
	public HttpEntity<?> getRegenerate(@RequestParam String tbjUuid, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetResumeRequestModel requestModel = new GetResumeRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetResumeResponseModel responseModel = resumeService.getRegenerate(tbjUuid, requestModel);
		if (responseModel.getMessage() == null ) responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
