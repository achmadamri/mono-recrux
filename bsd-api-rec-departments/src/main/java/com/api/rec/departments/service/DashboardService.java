package com.api.rec.departments.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.rec.departments.db.entity.TbCompany;
import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbResume;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.repository.TbCompanyRepository;
import com.api.rec.departments.db.repository.TbJobRepository;
import com.api.rec.departments.db.repository.TbResumeRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.db.repository.ViewDashJobCompletionRepository;
import com.api.rec.departments.db.repository.ViewDashJobFillRepository;
import com.api.rec.departments.model.dashboard.GetDashboardRequestModel;
import com.api.rec.departments.model.dashboard.GetDashboardResponseModel;
import com.api.rec.departments.util.TokenUtil;

@Service
public class DashboardService {

	private Logger log = LoggerFactory.getLogger(DashboardService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	@Autowired
	private TbCompanyRepository tbCompanyRepository;
	
	@Autowired
	private ViewDashJobFillRepository viewDashJobFillRepository;

	@Autowired
	private ViewDashJobCompletionRepository viewDashJobCompletionRepository;

	@Autowired
	private TbJobRepository tbJobRepository;

	@Autowired
	private TbResumeRepository tbResumeRepository;

	public GetDashboardResponseModel getDashboard(GetDashboardRequestModel requestModel) throws Exception {
		GetDashboardResponseModel responseModel = new GetDashboardResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			responseModel.setTbUser(optTbUser.get());

			TbCompany exampleTbCompany = new TbCompany();
			exampleTbCompany.setTbcId(optTbUser.get().getTbuCreateIdc());
			TbCompany tbCompany = tbCompanyRepository.findOne(Example.of(exampleTbCompany)).get();

			TbJob exampleTbJob = new TbJob();
			exampleTbJob.setTbjCreateIdc(optTbUser.get().getTbuCreateIdc());

			TbResume exampleTbResume = new TbResume();
			exampleTbResume.setTbrCreateIdc(optTbUser.get().getTbuCreateIdc());

			responseModel.setParseLimit(tbCompany.getTbcParse());
			responseModel.setToken(tbCompany.getTbcToken());

			responseModel.setTotalJob(tbJobRepository.count(Example.of(exampleTbJob)));
			responseModel.setTotalResume(tbResumeRepository.count(Example.of(exampleTbResume)));

			responseModel.setLstViewDashJobFill(viewDashJobFillRepository.findAll());
			responseModel.setLstViewDashJobCompletion(viewDashJobCompletionRepository.findAll());

			responseModel.setHttpStatus(HttpStatus.OK);
		} else {
			responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}
		
		return responseModel;
	}
}
