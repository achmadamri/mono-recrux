package com.api.rec.departments.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
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
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.entity.ViewJobDepartment;
import com.api.rec.departments.db.repository.TbJobRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.db.repository.ViewJobDepartmentRepository;
import com.api.rec.departments.model.job.GetJobDepartmentListRequestModel;
import com.api.rec.departments.model.job.GetJobDepartmentListResponseModel;
import com.api.rec.departments.model.job.GetJobListRequestModel;
import com.api.rec.departments.model.job.GetJobListResponseModel;
import com.api.rec.departments.model.job.GetJobRequestModel;
import com.api.rec.departments.model.job.GetJobResponseModel;
import com.api.rec.departments.model.job.PostAddJobRequestModel;
import com.api.rec.departments.model.job.PostAddJobResponseModel;
import com.api.rec.departments.model.job.PostUploadResumeRequestModel;
import com.api.rec.departments.model.job.PostUploadResumeResponseModel;
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

	@Autowired
	private ViewJobDepartmentRepository viewJobDepartmentRepository;
	
	public PostUploadResumeResponseModel postUploadResume(PostUploadResumeRequestModel requestModel, MultipartFile file) throws Exception {
		PostUploadResumeResponseModel responseModel = new PostUploadResumeResponseModel(requestModel);

		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			String fileName = responseModel.getResponseId() + "-" + StringUtils.cleanPath(file.getOriginalFilename());
			Files.copy(file.getInputStream(), Paths.get(env.getProperty("file.upload.dir") + fileName), StandardCopyOption.REPLACE_EXISTING);

			responseModel.setFileName(fileName);
			responseModel.setHttpStatus(HttpStatus.OK);
		} else {
			responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}

		return responseModel;
	}

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
						tbJob.setTbjUuid(new Uid().generateString(5).toUpperCase());
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

			Page<TbJob> pgTbJob = tbJobRepository.findAll(Example.of(exampleTbJob), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbjId").ascending()));
			
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

	public GetJobDepartmentListResponseModel getJobDepartmentList(Integer tbdId, String tbjName, String tbdjStatus, String length, String pageSize, String pageIndex, GetJobDepartmentListRequestModel requestModel) throws Exception {
		GetJobDepartmentListResponseModel responseModel = new GetJobDepartmentListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			List<ViewJobDepartment> lstViewJobDepartment = 
			tbdjStatus.equals("")
			?
			viewJobDepartmentRepository.findByTbdId(optTbUser.get().getTbuCreateIdc(), tbdId, tbjName, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbj_id", "tbd_id").ascending()))
			:
			viewJobDepartmentRepository.findByTbdId(optTbUser.get().getTbuCreateIdc(), tbdId, tbjName, tbdjStatus, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbj_id", "tbd_id").ascending()));


			if (lstViewJobDepartment.size() > 0) {
				responseModel.setLstViewJobDepartment(lstViewJobDepartment);				
				responseModel.setLength(
					tbdjStatus.equals("")
					?
					viewJobDepartmentRepository.countByTbdId(optTbUser.get().getTbuCreateIdc(), tbjName, tbdId)
					:
					viewJobDepartmentRepository.countByTbdId(optTbUser.get().getTbuCreateIdc(), tbjName, tbdjStatus, tbdId)
				);
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
