package com.api.rec.departments.service;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
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

import com.affinda.api.client.AffindaAPI;
import com.affinda.api.client.AffindaAPIBuilder;
import com.affinda.api.client.AffindaTokenCredential;
import com.affinda.api.client.models.ResumeRequestBody;
import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbResume;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.entity.ViewJobDepartment;
import com.api.rec.departments.db.repository.TbJobRepository;
import com.api.rec.departments.db.repository.TbResumeRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.db.repository.ViewJobDepartmentRepository;
import com.api.rec.departments.model.department.PostResumeRequestModel;
import com.api.rec.departments.model.department.PostResumeResponseModel;
import com.api.rec.departments.model.job.GetJobDepartmentListRequestModel;
import com.api.rec.departments.model.job.GetJobDepartmentListResponseModel;
import com.api.rec.departments.model.job.GetJobListRequestModel;
import com.api.rec.departments.model.job.GetJobListResponseModel;
import com.api.rec.departments.model.job.GetJobRequestModel;
import com.api.rec.departments.model.job.GetJobResponseModel;
import com.api.rec.departments.model.job.PostAddJobRequestModel;
import com.api.rec.departments.model.job.PostAddJobResponseModel;
import com.api.rec.departments.model.resume.PostUploadResumeRequestModel;
import com.api.rec.departments.model.resume.PostUploadResumeResponseModel;
import com.api.rec.departments.util.TokenUtil;
import com.api.rec.departments.util.Uid;
import com.azure.core.credential.TokenCredential;

import reactor.core.publisher.Flux;

@Service
public class ResumeService {

	private Logger log = LoggerFactory.getLogger(ResumeService.class);
	
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
	private TbResumeRepository tbResumeRepository;

	public PostResumeResponseModel postResume(PostResumeRequestModel requestModel, MultipartFile file) throws Exception {
		PostResumeResponseModel responseModel = new PostResumeResponseModel(requestModel);
		
		// tokenUtil.claims(requestModel);
		
		// TbUser exampleTbUser = new TbUser();
		// exampleTbUser.setTbuEmail(requestModel.getEmail());
		// exampleTbUser.setTbuStatus(TbUserRepository.Active);
		// Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		// if (optTbUser.isPresent()) {
			String fileName = responseModel.getResponseId() + "-" + StringUtils.cleanPath(file.getOriginalFilename());
			Files.copy(file.getInputStream(), Paths.get(env.getProperty("file.upload.dir") + fileName), StandardCopyOption.REPLACE_EXISTING);
			
			String apiKey = env.getProperty("key.affinda");
			TokenCredential credential = new AffindaTokenCredential(apiKey);
			AffindaAPI client = new AffindaAPIBuilder().credential(credential).buildClient();
			Flux<ByteBuffer> flux = Flux.just(ByteBuffer.wrap(file.getBytes()));
			ResumeRequestBody body = new ResumeRequestBody().setFile(flux);

			LinkedHashMap createResume = (LinkedHashMap) client.createResume(body);
			LinkedHashMap data = (LinkedHashMap) createResume.get("data");
			LinkedHashMap dataName = (LinkedHashMap) data.get("name");
			LinkedHashMap dataLocation = (LinkedHashMap) data.get("location");
			ArrayList dataEducation = (ArrayList) data.get("education");
			ArrayList dataWorkExperience = (ArrayList) data.get("workExperience");
			ArrayList dataSkills = (ArrayList) data.get("skills");
			ArrayList dataReferees = (ArrayList) data.get("referees");
			LinkedHashMap meta = (LinkedHashMap) createResume.get("meta");

			TbResume tbResume = new TbResume();
			// tbResume.setTbrCreateId(optTbUser.get().getTbuId());
			tbResume.setTbrCreateDate(new Date());
			// tbResume.setTbrCreateIdc(optTbUser.get().getTbuCreateIdc());
			tbResume.setTbrStatus(TbResumeRepository.Active);
			tbResume.setTbrUuid(new Uid().generateString(5).toUpperCase());
			
			tbResume.setTbrDataNameRaw((String) dataName.get("raw"));
			tbResume.setTbrDataNameFirst((String) dataName.get("first"));
			tbResume.setTbrDataNameLast((String) dataName.get("last"));
			tbResume.setTbrDataNameMiddle((String) dataName.get("middle"));
			tbResume.setTbrDataNameTitle((String) dataName.get("title"));
			
			tbResume.setTbrDataPhoneNumbers(((ArrayList) data.get("phoneNumbers")).toString());
			tbResume.setTbrDataWebsites(((ArrayList) data.get("websites")).toString());
			tbResume.setTbrDataEmails(((ArrayList) data.get("emails")).toString());
			tbResume.setTbrDataDateOfBirth((String) data.get("dateOfBirth"));
			
			tbResume.setTbrDataLocationFormatted((String) dataLocation.get("formatted"));
			tbResume.setTbrDataLocationPostalCode((String) dataLocation.get("postalCode"));
			tbResume.setTbrDataLocationState((String) dataLocation.get("state"));
			tbResume.setTbrDataLocationCountry((String) dataLocation.get("country"));
			tbResume.setTbrDataLocationCountryCode((String) dataLocation.get("countryCode"));
			tbResume.setTbrDataLocationRawInput((String) dataLocation.get("rawInput"));
			tbResume.setTbrDataLocationStreetNumber((String) dataLocation.get("streetNumber"));
			tbResume.setTbrDataLocationStreet((String) dataLocation.get("street"));
			tbResume.setTbrDataLocationApartmentNumber((String) dataLocation.get("apartmentNumber"));
			tbResume.setTbrDataLocationCity((String) dataLocation.get("city"));
			
			tbResume.setTbrDataObjective((String) data.get("objective"));
			tbResume.setTbrDataLanguages(((ArrayList) data.get("languages")).toString());
			// tbResume.setTbrDataLanguageCodes(((ArrayList) data.get("languageCodes")).toString());
			
			tbResume.setTbrDataSummary((String) data.get("summary"));
			tbResume.setTbrDataTotalYearsExperience((Integer) data.get("totalYearsExperience"));
			// tbResume.setTbrDataHeadShot((String) data.get("headShot"));
			tbResume.setTbrDataEducation(dataEducation.toString());
			tbResume.setTbrDataProfession((String) data.get("profession"));
			tbResume.setTbrDataLinkedin((String) data.get("linkedin"));
			tbResume.setTbrDataWorkExperience(dataWorkExperience.toString());
			tbResume.setTbrDataSkills(dataSkills.toString());
			tbResume.setTbrDataCertifications(((ArrayList) data.get("certifications")).toString());
			tbResume.setTbrDataPublications(((ArrayList) data.get("publications")).toString());
			tbResume.setTbrDataReferees(dataReferees.toString());
			tbResume.setTbrDataIsResumeProbability((Integer) data.get("isResumeProbability"));
			// tbResume.setTbrDataRawText((String) data.get("rawText"));

			tbResume.setTbrMetaIdentifier((String) meta.get("identifier"));
			tbResume.setTbrMetaFileName((String) meta.get("fileName"));
			tbResume.setTbrMetaReady((boolean) meta.get("ready") == true ? 1 : 0);
			tbResume.setTbrMetaReadyDt((String) meta.get("readyDt"));
			tbResume.setTbrMetaFailed((boolean) meta.get("failed") == true ? 1 : 0);
			tbResume.setTbrMetaExpiryTime((String) meta.get("expiryTime"));
			tbResume.setTbrMetaLanguage((String) meta.get("language"));
			// tbResume.setTbrMetaPdf((String) meta.get("pdf"));
			tbResume.setTbrMetaIsVerified((boolean) meta.get("isVerified") == true ? 1 : 0);
			tbResume.setTbrMetaReviewUrl((String) meta.get("reviewUrl"));
			tbResume.setTbrMetaOcrConfidence((Double) meta.get("ocrConfidence"));

			tbResumeRepository.save(tbResume);

			responseModel.setHttpStatus(HttpStatus.OK);
		// } else {
		// 	responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		// }
		
		return responseModel;
	}
	
	public PostUploadResumeResponseModel postUploadResume(PostUploadResumeRequestModel requestModel, MultipartFile file) throws Exception {
		PostUploadResumeResponseModel responseModel = new PostUploadResumeResponseModel(requestModel);

		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			String fileNameOri = StringUtils.cleanPath(file.getOriginalFilename());
			String fileName = responseModel.getResponseId() + "-" + StringUtils.cleanPath(file.getOriginalFilename());
			Files.copy(file.getInputStream(), Paths.get(env.getProperty("file.upload.dir") + fileName), StandardCopyOption.REPLACE_EXISTING);

			responseModel.setFileName(fileName);
			responseModel.setFileNameOri(fileNameOri);
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
