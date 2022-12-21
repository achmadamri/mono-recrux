package com.api.rec.departments.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.rec.departments.db.entity.TbDepartment;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.repository.TbDepartmentRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.model.department.GetDepartmentListRequestModel;
import com.api.rec.departments.model.department.GetDepartmentListResponseModel;
import com.api.rec.departments.util.TokenUtil;

@Service
public class DepartmentService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();

	@Autowired
	private TbUserRepository tbUserRepository;

	@Autowired
	private TbDepartmentRepository tbDepartmentRepository;

	public GetDepartmentListResponseModel getDepartmentList(String brand, String length, String pageSize, String pageIndex, GetDepartmentListRequestModel requestModel) throws Exception {
		GetDepartmentListResponseModel responseModel = new GetDepartmentListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbDepartment exampleTbDepartment = new TbDepartment();
			exampleTbDepartment.setTbdCreateIdc(optTbUser.get().getTbuCreateIdc());

			Page<TbDepartment> pgTbDepartment = tbDepartmentRepository.findAll(Example.of(exampleTbDepartment), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbdId").ascending()));
			
			if (pgTbDepartment.toList().size() > 0) {
				responseModel.setLstTbDepartment(pgTbDepartment.toList());				
				responseModel.setLength(tbDepartmentRepository.count(Example.of(exampleTbDepartment)));				
				responseModel.setStatus("200");				
				responseModel.setMessage(env.getProperty("service.department.getdepartmentlist.200"));
			} else {
				responseModel.setStatus("404");				
				responseModel.setMessage(env.getProperty("service.department.getdepartmentlist.404"));
			}
		} else {
			responseModel.setStatus("401");			
			responseModel.setMessage(env.getProperty("service.department.getdepartmentlist.401"));
		}
		
		return responseModel;
	}
}
