package com.api.rec.departments.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.entity.ViewJobDepartment;
import com.api.rec.departments.db.entity.ViewResumeJob;
import com.api.rec.departments.db.repository.TbJobRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.db.repository.ViewJobDepartmentRepository;
import com.api.rec.departments.db.repository.ViewResumeJobRepository;
import com.api.rec.departments.model.job.GetJobDepartmentListRequestModel;
import com.api.rec.departments.model.job.GetJobDepartmentListResponseModel;
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

	private Logger log = LoggerFactory.getLogger(JobService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();

	@Autowired
	private TbUserRepository tbUserRepository;

	@Autowired
	private TbJobRepository tbJobRepository;

	@Autowired
	private ViewJobDepartmentRepository viewJobDepartmentRepository;

	@Autowired
	private ViewResumeJobRepository viewResumeJobRepository;

	public PostAddJobResponseModel postAddJob(PostAddJobRequestModel requestModel) throws Exception {
		PostAddJobResponseModel responseModel = new PostAddJobResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		if (optTbUser.isPresent()) {
			if (requestModel.getTbJob().getTbjUuid().equals("0")) {
				if (requestModel.getTbJob().getTbjName() != null) {
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
						tbJob.setTbjUuid(new Uid().generateString(5));
						tbJob = tbJobRepository.save(tbJob);
		
						responseModel.setTbJob(tbJob);
						responseModel.setHttpStatus(HttpStatus.OK);
					}
				} else {
					responseModel.setHttpStatus(HttpStatus.BAD_REQUEST);
				}				
			} else {
				TbJob exampleTbJob = new TbJob();
				exampleTbJob.setTbjUuid(requestModel.getTbJob().getTbjUuid());
				exampleTbJob.setTbjCreateIdc(optTbUser.get().getTbuCreateIdc());
				Optional<TbJob> optTbJob = tbJobRepository.findOne(Example.of(exampleTbJob));
				
				if (optTbJob.isPresent()) {
					TbJob tbJob = optTbJob.get();
					tbJob.setTbjUpdateId(optTbUser.get().getTbuId());
					tbJob.setTbjUpdateDate(new Date());

					if (requestModel.getTbJob().getTbjName() != null) tbJob.setTbjName(requestModel.getTbJob().getTbjName());
					if (requestModel.getTbJob().getTbjStatus() != null) tbJob.setTbjStatus(requestModel.getTbJob().getTbjStatus());
					if (requestModel.getTbJob().getTbdId() != null) tbJob.setTbdId(requestModel.getTbJob().getTbdId());
					if (requestModel.getTbJob().getTbdId() != null) {
						if (requestModel.getTbJob().getTbdId() == 0) {
							tbJob.setTbjAssigned(TbJobRepository.NotAssigned);
							tbJob.setTbdId(null);
						} else {							
							tbJob.setTbjAssigned(TbJobRepository.Assigned);
							tbJob.setTbdId(requestModel.getTbJob().getTbdId());
						}
					}
					
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

	public GetJobResponseModel getJob(String tbjUuid, GetJobRequestModel requestModel) throws Exception {
		GetJobResponseModel responseModel = new GetJobResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbJob exampleTbJob = new TbJob();
			exampleTbJob.setTbjUuid(tbjUuid);
			exampleTbJob.setTbjCreateId(optTbUser.get().getTbuCreateId());
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

	public GetJobListResponseModel getJobList(String tbjName, String tbjStatus, String length, String pageSize, String pageIndex, GetJobListRequestModel requestModel) throws Exception {
		GetJobListResponseModel responseModel = new GetJobListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbJob exampleTbJob = new TbJob();
			exampleTbJob.setTbjCreateIdc(optTbUser.get().getTbuCreateIdc());
			if (!tbjName.equals("")) exampleTbJob.setTbjName(tbjName);
			if (!tbjStatus.equals("")) exampleTbJob.setTbjStatus(tbjStatus);

			ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("tbjName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("tbjStatus", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			;

			Page<TbJob> pgTbJob = tbJobRepository.findAll(Example.of(exampleTbJob, matcher), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbjId").ascending()));
			
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

	public GetJobDepartmentListResponseModel getJobDepartmentList(Integer tbdId, String tbjUuid, String tbjName, String tbjStatus, String tbjAssigned, String length, String pageSize, String pageIndex, GetJobDepartmentListRequestModel requestModel) throws Exception {
		GetJobDepartmentListResponseModel responseModel = new GetJobDepartmentListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			List<ViewJobDepartment> lstViewJobDepartment = null;

			if (tbjAssigned.equals("")) {
				if (tbdId == null) {
					lstViewJobDepartment = viewJobDepartmentRepository.findList(optTbUser.get().getTbuCreateIdc(), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbr_id").ascending()));
				} else {
					lstViewJobDepartment = viewJobDepartmentRepository.find(optTbUser.get().getTbuCreateIdc(), tbdId, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbd_id").ascending()));
				}				
			} else {
				if (tbjAssigned.equals("assigned")) {
					lstViewJobDepartment = viewJobDepartmentRepository.findAssigned(optTbUser.get().getTbuCreateIdc(), tbdId, tbjUuid, tbjName, tbjStatus, tbjAssigned, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbd_id").ascending()));
				} else if (tbjAssigned.equals("notassigned")) {
					lstViewJobDepartment = viewJobDepartmentRepository.findNotAssigned(optTbUser.get().getTbuCreateIdc(), tbjUuid, tbjName, tbjStatus, tbjAssigned, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbd_id").ascending()));
				}
			}
			
			if (lstViewJobDepartment.size() > 0) {
				responseModel.setLstViewJobDepartment(lstViewJobDepartment);

				if (tbjAssigned.equals("")) {
					if (tbdId == null) {
						responseModel.setLength(viewJobDepartmentRepository.countList(optTbUser.get().getTbuCreateIdc()));
					} else {
						responseModel.setLength(viewJobDepartmentRepository.count(optTbUser.get().getTbuCreateIdc(), tbdId));
					}	
				} else {
					if (tbjAssigned.equals("assigned")) {
						responseModel.setLength(viewJobDepartmentRepository.countAssigned(optTbUser.get().getTbuCreateIdc(), tbdId, tbjUuid, tbjName, tbjStatus, tbjAssigned));
					} else if (tbjAssigned.equals("notassigned")) {
						responseModel.setLength(viewJobDepartmentRepository.countNotAssigned(optTbUser.get().getTbuCreateIdc(), tbjUuid, tbjName, tbjStatus, tbjAssigned));
					}
				}

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
