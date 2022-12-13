package com.api.rec.departments.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rec.departments.model.user.PostUserAddRequestModel;
import com.api.rec.departments.model.user.PostUserAddResponseModel;
import com.api.rec.departments.model.user.PostUserChangePasswordRequestModel;
import com.api.rec.departments.model.user.PostUserChangePasswordResponseModel;
import com.api.rec.departments.model.user.PostUserEditRequestModel;
import com.api.rec.departments.model.user.PostUserEditResponseModel;
import com.api.rec.departments.model.user.PostUserRegisterRequestModel;
import com.api.rec.departments.model.user.PostUserRegisterResponseModel;
import com.api.rec.departments.service.UserService;
import com.api.rec.departments.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
    private UserService userService;
	
	@PostMapping("/postuseradd")
	@Transactional
	public HttpEntity<?> postUserAdd(@Valid @RequestBody PostUserAddRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostUserAddResponseModel responseModel = userService.postUserAdd(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("403") ? HttpStatus.FORBIDDEN : (responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND));
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postuserregister")
	@Transactional
	public HttpEntity<?> postUserRegister(@Valid @RequestBody PostUserRegisterRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostUserRegisterResponseModel responseModel = userService.postUserRegister(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("403") ? HttpStatus.FORBIDDEN : (responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND));
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postuseredit")
	@Transactional
	public HttpEntity<?> postUserEdit(@Valid @RequestBody PostUserEditRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostUserEditResponseModel responseModel = userService.postUserEdit(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("403") ? HttpStatus.FORBIDDEN : (responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND));
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
	
	@PostMapping("/postuserchangepassword")
	@Transactional
	public HttpEntity<?> postUserChangePassword(@Valid @RequestBody PostUserChangePasswordRequestModel requestModel) throws Exception {
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		PostUserChangePasswordResponseModel responseModel = userService.postUserChangePassword(requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("403") ? HttpStatus.FORBIDDEN : (responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND));
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
