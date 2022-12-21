package com.api.rec.departments.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.rec.departments.model.department.GetDepartmentListRequestModel;
import com.api.rec.departments.model.department.GetDepartmentListResponseModel;
import com.api.rec.departments.service.DepartmentService;
import com.api.rec.departments.util.Uid;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {

	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/getdepartmentlist")
	public HttpEntity<?> getDepartmentList(@RequestParam String tbdName, @RequestParam String tbdStatus, @RequestParam String length, @RequestParam String pageSize, @RequestParam String pageIndex, @RequestParam String email, @RequestParam String token, @RequestParam String requestId, @RequestParam String requestDate) throws Exception {
		GetDepartmentListRequestModel requestModel = new GetDepartmentListRequestModel();
		requestModel.setEmail(email);
		requestModel.setToken(token);
		requestModel.setRequestId(requestId);
		requestModel.setRequestDate(requestDate);
		
		String fid = new Uid().generateString(20);
		log.info("[fid:" + fid + "] requestModel : " + objectMapper.writeValueAsString(requestModel));
		
		GetDepartmentListResponseModel responseModel = departmentService.getDepartmentList(tbdName, tbdStatus, length, pageSize, pageIndex, requestModel);
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(responseModel, responseModel.getStatus().equals("200") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		log.info("[fid:" + fid + "] responseEntity : " + objectMapper.writeValueAsString(responseEntity));

		return responseEntity;
	}
}
