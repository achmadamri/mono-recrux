package com.api.rec.resume.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.rec.resume.model.resume.PostUploadResumeRequestModel;
import com.api.rec.resume.model.resume.PostUploadResumeResponseModel;
import com.api.rec.resume.service.ResumeService;
import com.api.rec.resume.util.Uid;
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
		responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
