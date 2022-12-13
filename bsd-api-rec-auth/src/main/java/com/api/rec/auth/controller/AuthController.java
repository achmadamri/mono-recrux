package com.api.rec.auth.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rec.auth.model.auth.GetInvalidateRequestModel;
import com.api.rec.auth.model.auth.GetInvalidateResponseModel;
import com.api.rec.auth.model.auth.PostAddRequestModel;
import com.api.rec.auth.model.auth.PostAddResponseModel;
import com.api.rec.auth.model.auth.PostCheckRequestModel;
import com.api.rec.auth.model.auth.PostCheckResponseModel;
import com.api.rec.auth.model.auth.PostGenerateRequestModel;
import com.api.rec.auth.model.auth.PostGenerateResponseModel;
import com.api.rec.auth.model.auth.PutUpdateRequestModel;
import com.api.rec.auth.model.auth.PutUpdateResponseModel;
import com.api.rec.auth.service.AuthService;
import com.api.rec.auth.util.MD5;
import com.api.rec.auth.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

	private Logger log = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
    private AuthService authService;
	
	@PostMapping("/postadd")
	@Transactional
	public HttpEntity<?> postAdd(@Valid @RequestBody PostAddRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		requestModel.setFid(fid);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostAddResponseModel responseModel = authService.postAdd(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("208") ? HttpStatus.ALREADY_REPORTED : HttpStatus.OK);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PutMapping("/putupdate")
	@Transactional
	public HttpEntity<?> putUpdate(@Valid @RequestBody PutUpdateRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		requestModel.setFid(fid);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PutUpdateResponseModel responseModel = authService.putUpdate(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("208") ? HttpStatus.ALREADY_REPORTED : HttpStatus.OK);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postgenerate")
	@Transactional
	public HttpEntity<?> postGenerate(@Valid @RequestBody PostGenerateRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		requestModel.setFid(fid);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		MD5 md5 = new MD5();
		requestModel.setTbaPassword(md5.get(requestModel.getTbaPassword()));
		
		PostGenerateResponseModel responseModel = authService.postGenerate(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : (responseModel.getStatus().equals("500") ? HttpStatus.INTERNAL_SERVER_ERROR : HttpStatus.UNAUTHORIZED));
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postcheck")
	@Transactional
	public HttpEntity<?> postCheck(@Valid @RequestBody PostCheckRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		requestModel.setFid(fid);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostCheckResponseModel responseModel = authService.postCheck(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}

	
	@GetMapping("/invalidate/{tbaEmail}")
	public HttpEntity<?> getInvalidate(@RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetInvalidateRequestModel requestModel = new GetInvalidateRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		requestModel.setFid(fid);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetInvalidateResponseModel responseModel = authService.getInvalidate(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
