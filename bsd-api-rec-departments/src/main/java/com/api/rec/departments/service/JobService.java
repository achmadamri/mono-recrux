package com.api.rec.departments.service;

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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.entity.ViewJobDepartment;
import com.api.rec.departments.db.repository.TbJobRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.db.repository.ViewJobDepartmentRepository;
import com.api.rec.departments.db.repository.ViewResumeJobRepository;
import com.api.rec.departments.model.job.GetJobDepartmentListRequestModel;
import com.api.rec.departments.model.job.GetJobDepartmentListResponseModel;
import com.api.rec.departments.model.job.GetJobDescriptionRequestModel;
import com.api.rec.departments.model.job.GetJobDescriptionResponseModel;
import com.api.rec.departments.model.job.GetJobListRequestModel;
import com.api.rec.departments.model.job.GetJobListResponseModel;
import com.api.rec.departments.model.job.GetJobRequestModel;
import com.api.rec.departments.model.job.GetJobResponseModel;
import com.api.rec.departments.model.job.PostAddJobRequestModel;
import com.api.rec.departments.model.job.PostAddJobResponseModel;
import com.api.rec.departments.util.TokenUtil;
import com.api.rec.departments.util.Uid;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
						tbJob.setTbjId(null);
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
					if (requestModel.getTbJob().getTbjDescription() != null) tbJob.setTbjDescription(requestModel.getTbJob().getTbjDescription());
					if (requestModel.getTbJob().getTbjStatus() != null) tbJob.setTbjStatus(requestModel.getTbJob().getTbjStatus());
					if (requestModel.getTbJob().getTbjResumeStatus() != null) tbJob.setTbjResumeStatus(requestModel.getTbJob().getTbjResumeStatus());
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
	
	public GetJobDescriptionResponseModel getJobDescription(String tbjUuid, GetJobDescriptionRequestModel requestModel) throws Exception {
		GetJobDescriptionResponseModel responseModel = new GetJobDescriptionResponseModel(requestModel);
		
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
				String prompt = "You act as my human resources expert and create a job description for " + optTbJob.get().getTbjName() + ".";
		
				final String uri = "https://api.openai.com/v1/completions";
				RestTemplate restTemplate = new RestTemplate();
		
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				headers.setBearerAuth("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");
		
				String requestJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + prompt + "\", \"max_tokens\": 1000, \"temperature\": 0}";
		
				HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		
				ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

				log.info("------------------------------------------------------------------");				
				log.info(response.getBody());
				log.info("------------------------------------------------------------------");
				
				// Save the job description
				ObjectMapper mapper = new ObjectMapper();
				JsonNode rootNodeGpt = mapper.readTree(response.getBody());
				JsonNode choicesNodeGpt = rootNodeGpt.path("choices");
				JsonNode choiceNodeGpt = choicesNodeGpt.get(0);
				JsonNode textNodeGpt = choiceNodeGpt.path("text");
				String tbjDescription = textNodeGpt.asText();
				log.info("------------------------------------------------------------------");				
				log.info(tbjDescription);
				log.info("------------------------------------------------------------------");
				
				// Save the job description and trim for 1000 char. Convert non readable characters to empty string
				tbjDescription = tbjDescription.substring(0, Math.min(tbjDescription.length(), 10000));
				tbjDescription = tbjDescription.replaceAll("[^\\x00-\\x7F]", "");
				optTbJob.get().setTbjDescription(tbjDescription);
				tbJobRepository.save(optTbJob.get());

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
			List<ViewJobDepartment> lstViewJobDepartment = 
			
			tbjAssigned == "" ?
				viewJobDepartmentRepository.find(optTbUser.get().getTbuCreateIdc(), tbdId, tbjUuid, tbjName, tbjStatus, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbj_id").ascending()))
				:
				viewJobDepartmentRepository.findAssigned(optTbUser.get().getTbuCreateIdc(), tbdId, tbjUuid, tbjName, tbjStatus, tbjAssigned, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbj_id").ascending()));

			if (lstViewJobDepartment.size() > 0) {
				responseModel.setLstViewJobDepartment(lstViewJobDepartment);				
				responseModel.setLength(
					tbjAssigned == "" ?
						viewJobDepartmentRepository.count(optTbUser.get().getTbuCreateIdc(), tbdId, tbjUuid, tbjName, tbjStatus)
						:
						viewJobDepartmentRepository.countAssigned(optTbUser.get().getTbuCreateIdc(), tbdId, tbjUuid, tbjName, tbjStatus, tbjAssigned));
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
