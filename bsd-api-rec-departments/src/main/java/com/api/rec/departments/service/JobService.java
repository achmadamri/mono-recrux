package com.api.rec.departments.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.repository.TbJobRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.model.job.GetJobListRequestModel;
import com.api.rec.departments.model.job.GetJobListResponseModel;
import com.api.rec.departments.model.job.GetJobRequestModel;
import com.api.rec.departments.model.job.GetJobResponseModel;
import com.api.rec.departments.model.job.PostAddJobRequestModel;
import com.api.rec.departments.model.job.PostAddJobResponseModel;
import com.api.rec.departments.util.TokenUtil;
import com.api.rec.departments.util.Uid;

@Service
public class JobService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();

	@Autowired
	private TbUserRepository tbUserRepository;

	@Autowired
	private TbJobRepository tbJobRepository;

	public PostAddJobResponseModel postAddJob(PostAddJobRequestModel requestModel) throws Exception {
		PostAddJobResponseModel responseModel = new PostAddJobResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		if (optTbUser.isPresent()) {
			if (requestModel.getTbJob().getTbjUuid().equals("0")) {
				TbJob exampleTbJob = new TbJob();
				exampleTbJob.setTbjName(requestModel.getTbJob().getTbjName());
				Optional<TbJob> optTbJob = tbJobRepository.findOne(Example.of(exampleTbJob));
				
				if (optTbJob.isPresent()) {
					responseModel.setHttpStatus(HttpStatus.ALREADY_REPORTED);
				} else {
					TbJob tbJob = new TbJob();
					tbJob = requestModel.getTbJob();
					tbJob.setTbjCreateId(optTbUser.get().getTbuId());
					tbJob.setTbjCreateIdc(optTbUser.get().getTbuCreateIdc());
					tbJob.setTbjCreateDate(new Date());
					tbJob.setTbjStatus(TbJobRepository.Active);
					tbJob.setTbjUuid(new Uid().generateString(5).toUpperCase());
					tbJob = tbJobRepository.save(tbJob);
	
					responseModel.setTbJob(tbJob);
					responseModel.setHttpStatus(HttpStatus.OK);
				}
			} else {
				TbJob exampleTbJob = new TbJob();
				exampleTbJob.setTbjUuid(requestModel.getTbJob().getTbjUuid());
				Optional<TbJob> optTbJob = tbJobRepository.findOne(Example.of(exampleTbJob));
				
				if (optTbJob.isPresent()) {
					TbJob tbJob = optTbJob.get();
					tbJob.setTbjUpdateId(optTbUser.get().getTbuId());
					tbJob.setTbjUpdateDate(new Date());
					tbJob.setTbjName(requestModel.getTbJob().getTbjName());
					tbJob.setTbjStatus(requestModel.getTbJob().getTbjStatus());
					tbJob = tbJobRepository.save(tbJob);
	
					responseModel.setTbJob(tbJob);
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

	public GetJobResponseModel getJob(String tbdUuid, GetJobRequestModel requestModel) throws Exception {
		GetJobResponseModel responseModel = new GetJobResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbJob exampleTbJob = new TbJob();
			exampleTbJob.setTbjUuid(tbdUuid);
			exampleTbJob.setTbjCreateId(optTbUser.get().getTbuId());
			Optional<TbJob> optTbJob = tbJobRepository.findOne(Example.of(exampleTbJob));
			
			if (optTbJob.isPresent()) {
				responseModel.setTbJob(optTbJob.get());
				responseModel.setHttpStatus(HttpStatus.OK);
			} else {
				responseModel.setHttpStatus(HttpStatus.NOT_FOUND);
			}
		} else {
			responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}
		
		return responseModel;
	}

	public GetJobListResponseModel getJobList(String tbdName, String tbdStatus, String length, String pageSize, String pageIndex, GetJobListRequestModel requestModel) throws Exception {
		GetJobListResponseModel responseModel = new GetJobListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbJob exampleTbJob = new TbJob();
			exampleTbJob.setTbjCreateIdc(optTbUser.get().getTbuCreateIdc());
			if (!tbdName.equals("")) exampleTbJob.setTbjName(tbdName);
			if (!tbdStatus.equals("")) exampleTbJob.setTbjStatus(tbdStatus);

			Page<TbJob> pgTbJob = tbJobRepository.findAll(Example.of(exampleTbJob), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbdId").ascending()));
			
			if (pgTbJob.toList().size() > 0) {
				responseModel.setLstTbJob(pgTbJob.toList());				
				responseModel.setLength(tbJobRepository.count(Example.of(exampleTbJob)));
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
