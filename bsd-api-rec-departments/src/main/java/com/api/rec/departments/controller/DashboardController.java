package com.api.rec.departments.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rec.departments.model.resume.GetResumeRequestModel;
import com.api.rec.departments.model.resume.GetResumeResponseModel;
import com.api.rec.departments.service.DashboardService;
import com.api.rec.departments.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
    private DashboardService dashboardService;
	
	@GetMapping("/getresume")
	public HttpEntity<?> getResume(@RequestParam String tbjUuid, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetResumeRequestModel requestModel = new GetResumeRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetResumeResponseModel responseModel = dashboardService.getResume(tbjUuid, requestModel);
		if (responseModel.getMessage() == null ) responseModel.setMessage(responseModel.getHttpStatus().getReasonPhrase());
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getHttpStatus());
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
