package com.api.rec.departments.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.rec.departments.db.entity.TbDepartment;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.repository.TbDepartmentRepository;
import com.api.rec.departments.db.repository.TbJobRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.model.department.GetDepartmentListRequestModel;
import com.api.rec.departments.model.department.GetDepartmentListResponseModel;
import com.api.rec.departments.model.department.GetDepartmentRequestModel;
import com.api.rec.departments.model.department.GetDepartmentResponseModel;
import com.api.rec.departments.model.department.PostAddDepartmentRequestModel;
import com.api.rec.departments.model.department.PostAddDepartmentResponseModel;
import com.api.rec.departments.util.TokenUtil;
import com.api.rec.departments.util.Uid;

@Service
public class DepartmentService {

	private Logger log = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();

	@Autowired
	private TbUserRepository tbUserRepository;

	@Autowired
	private TbDepartmentRepository tbDepartmentRepository;

	@Autowired
	private TbJobRepository tbJobRepository;

	public PostAddDepartmentResponseModel postAddDepartment(PostAddDepartmentRequestModel requestModel) throws Exception {
		PostAddDepartmentResponseModel responseModel = new PostAddDepartmentResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		if (optTbUser.isPresent()) {
			if (requestModel.getTbDepartment().getTbdUuid().equals("0")) {
				if (requestModel.getTbDepartment().getTbdName() != null) {
					TbDepartment exampleTbDepartment = new TbDepartment();
					exampleTbDepartment.setTbdName(requestModel.getTbDepartment().getTbdName());
					exampleTbDepartment.setTbdCreateIdc(optTbUser.get().getTbuCreateIdc());
					Optional<TbDepartment> optTbDepartment = tbDepartmentRepository.findOne(Example.of(exampleTbDepartment));
					
					if (optTbDepartment.isPresent()) {
						responseModel.setHttpStatus(HttpStatus.ALREADY_REPORTED);
					} else {
						TbDepartment tbDepartment = new TbDepartment();
						tbDepartment = requestModel.getTbDepartment();
						tbDepartment.setTbdCreateId(optTbUser.get().getTbuId());
						tbDepartment.setTbdCreateIdc(optTbUser.get().getTbuCreateIdc());
						tbDepartment.setTbdCreateDate(new Date());
						tbDepartment.setTbdStatus(TbDepartmentRepository.Active);
						tbDepartment.setTbdUuid(new Uid().generateString(5));
						tbDepartment = tbDepartmentRepository.save(tbDepartment);
		
						responseModel.setTbDepartment(tbDepartment);
						responseModel.setHttpStatus(HttpStatus.OK);
					}
				} else {
					responseModel.setHttpStatus(HttpStatus.BAD_REQUEST);
				}
			} else {
				TbDepartment exampleTbDepartment = new TbDepartment();
				exampleTbDepartment.setTbdUuid(requestModel.getTbDepartment().getTbdUuid());
				exampleTbDepartment.setTbdCreateIdc(optTbUser.get().getTbuCreateIdc());
				Optional<TbDepartment> optTbDepartment = tbDepartmentRepository.findOne(Example.of(exampleTbDepartment));
				
				if (optTbDepartment.isPresent()) {
					TbDepartment tbDepartment = optTbDepartment.get();
					tbDepartment.setTbdUpdateId(optTbUser.get().getTbuId());
					tbDepartment.setTbdUpdateDate(new Date());
					tbDepartment.setTbdName(requestModel.getTbDepartment().getTbdName());
					tbDepartment.setTbdStatus(requestModel.getTbDepartment().getTbdStatus());
					tbDepartment = tbDepartmentRepository.save(tbDepartment);
	
					responseModel.setTbDepartment(tbDepartment);
					responseModel.setHttpStatus(HttpStatus.OK);
				} else {
					responseModel.setHttpStatus(HttpStatus.NOT_FOUND);
				}
			}
		} else {
			responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}
		
		return responseModel;
	}

	public GetDepartmentResponseModel getDepartment(String tbdUuid, GetDepartmentRequestModel requestModel) throws Exception {
		GetDepartmentResponseModel responseModel = new GetDepartmentResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbDepartment exampleTbDepartment = new TbDepartment();
			exampleTbDepartment.setTbdUuid(tbdUuid);
			exampleTbDepartment.setTbdCreateId(optTbUser.get().getTbuId());
			Optional<TbDepartment> optTbDepartment = tbDepartmentRepository.findOne(Example.of(exampleTbDepartment));
			
			if (optTbDepartment.isPresent()) {
				responseModel.setTbDepartment(optTbDepartment.get());
				responseModel.setHttpStatus(HttpStatus.OK);
			} else {
				responseModel.setHttpStatus(HttpStatus.NOT_FOUND);
			}
		} else {
			responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}
		
		return responseModel;
	}

	public GetDepartmentListResponseModel getDepartmentList(String tbdName, String tbdStatus, String length, String pageSize, String pageIndex, GetDepartmentListRequestModel requestModel) throws Exception {
		GetDepartmentListResponseModel responseModel = new GetDepartmentListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbDepartment exampleTbDepartment = new TbDepartment();
			exampleTbDepartment.setTbdCreateIdc(optTbUser.get().getTbuCreateIdc());
			if (!tbdName.equals("")) exampleTbDepartment.setTbdName(tbdName);
			if (!tbdStatus.equals("")) exampleTbDepartment.setTbdStatus(tbdStatus);

			ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("tbdName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("tbdStatus", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			;

			Page<TbDepartment> pgTbDepartment = tbDepartmentRepository.findAll(Example.of(exampleTbDepartment, matcher), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbdId").ascending()));
			
			if (pgTbDepartment.toList().size() > 0) {
				responseModel.setLstTbDepartment(pgTbDepartment.toList());				
				responseModel.setLength(tbDepartmentRepository.count(Example.of(exampleTbDepartment)));
				responseModel.setHttpStatus(HttpStatus.OK);
			} else {
				responseModel.setHttpStatus(HttpStatus.NOT_FOUND);
			}
		} else {
			responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}
		
		return responseModel;
	}
}
