package com.api.rec.departments.service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
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
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.affinda.api.client.AffindaAPI;
import com.affinda.api.client.AffindaAPIBuilder;
import com.affinda.api.client.AffindaTokenCredential;
import com.affinda.api.client.models.ResumeRequestBody;
import com.api.rec.departments.db.entity.TbDepartment;
import com.api.rec.departments.db.entity.TbDepartmentJob;
import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbResume;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.repository.TbDepartmentJobRepository;
import com.api.rec.departments.db.repository.TbDepartmentRepository;
import com.api.rec.departments.db.repository.TbJobRepository;
import com.api.rec.departments.db.repository.TbResumeRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.model.department.GetDepartmentListRequestModel;
import com.api.rec.departments.model.department.GetDepartmentListResponseModel;
import com.api.rec.departments.model.department.GetDepartmentRequestModel;
import com.api.rec.departments.model.department.GetDepartmentResponseModel;
import com.api.rec.departments.model.department.PostAddDepartmentJobRequestModel;
import com.api.rec.departments.model.department.PostAddDepartmentJobResponseModel;
import com.api.rec.departments.model.department.PostAddDepartmentRequestModel;
import com.api.rec.departments.model.department.PostAddDepartmentResponseModel;
import com.api.rec.departments.model.department.PostResumeRequestModel;
import com.api.rec.departments.model.department.PostResumeResponseModel;
import com.api.rec.departments.util.TokenUtil;
import com.api.rec.departments.util.Uid;
import com.azure.core.credential.TokenCredential;
import com.azure.core.exception.HttpResponseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import reactor.core.publisher.Flux;

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

	@Autowired
	private TbDepartmentJobRepository tbDepartmentJobRepository;

	@Autowired
	private TbJobRepository tbJobRepository;

	@Autowired
	private TbResumeRepository tbResumeRepository;

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
						tbDepartment.setTbdUuid(new Uid().generateString(5).toUpperCase());
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

	public PostAddDepartmentJobResponseModel postAddDepartmentJob(PostAddDepartmentJobRequestModel requestModel) throws Exception {
		PostAddDepartmentJobResponseModel responseModel = new PostAddDepartmentJobResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		if (optTbUser.isPresent()) {
			if (requestModel.getTbDepartmentJob().getTbdjUuid() == null) {
				TbDepartment exampleTbDepartment = new TbDepartment();
				exampleTbDepartment.setTbdUuid(requestModel.getTbDepartment().getTbdUuid());
				exampleTbDepartment.setTbdCreateIdc(optTbUser.get().getTbuCreateIdc());
				Optional<TbDepartment> optTbDepartment = tbDepartmentRepository.findOne(Example.of(exampleTbDepartment));

				TbJob exampleTbJob = new TbJob();
				exampleTbJob.setTbjUuid(requestModel.getTbJob().getTbjUuid());
				exampleTbJob.setTbjCreateIdc(optTbUser.get().getTbuCreateIdc());
				Optional<TbJob> optTbJob = tbJobRepository.findOne(Example.of(exampleTbJob));

				TbDepartmentJob tbDepartmentJob = new TbDepartmentJob();
				tbDepartmentJob.setTbdjCreateId(optTbUser.get().getTbuId());
				tbDepartmentJob.setTbdjCreateDate(new Date());
				tbDepartmentJob.setTbdjCreateIdc(optTbUser.get().getTbuCreateIdc());
				tbDepartmentJob.setTbdjStatus(TbDepartmentJobRepository.Active);
				tbDepartmentJob.setTbdId(optTbDepartment.get().getTbdId());
				tbDepartmentJob.setTbjId(optTbJob.get().getTbjId());
				tbDepartmentJob.setTbdjUuid(new Uid().generateString(5).toUpperCase());
				tbDepartmentJobRepository.save(tbDepartmentJob);

				responseModel.setTbDepartmentJob(tbDepartmentJob);
				responseModel.setHttpStatus(HttpStatus.OK);
			} else {
				TbDepartment exampleTbDepartment = new TbDepartment();
				exampleTbDepartment.setTbdUuid(requestModel.getTbDepartment().getTbdUuid());
				exampleTbDepartment.setTbdCreateIdc(optTbUser.get().getTbuCreateIdc());
				Optional<TbDepartment> optTbDepartment = tbDepartmentRepository.findOne(Example.of(exampleTbDepartment));

				TbJob exampleTbJob = new TbJob();
				exampleTbJob.setTbjUuid(requestModel.getTbJob().getTbjUuid());
				exampleTbJob.setTbjCreateIdc(optTbUser.get().getTbuCreateIdc());
				Optional<TbJob> optTbJob = tbJobRepository.findOne(Example.of(exampleTbJob));

				TbDepartmentJob exampleTbDepartmentJob = new TbDepartmentJob();
				exampleTbDepartmentJob.setTbdjUuid(requestModel.getTbDepartmentJob().getTbdjUuid());
				exampleTbDepartmentJob.setTbdjCreateIdc(optTbUser.get().getTbuCreateIdc());
				Optional<TbDepartmentJob> optTbDepartmentJob = tbDepartmentJobRepository.findOne(Example.of(exampleTbDepartmentJob));

				if (optTbDepartment.isPresent() && optTbDepartmentJob.isPresent() && optTbJob.isPresent()) {
					TbDepartmentJob tbDepartmentJob = optTbDepartmentJob.get();
					tbDepartmentJob.setTbdjUpdateId(optTbUser.get().getTbuId());
					tbDepartmentJob.setTbdjUpdateDate(new Date());
					tbDepartmentJob.setTbdjStatus(requestModel.getTbDepartmentJob().getTbdjStatus());
					tbDepartmentJob = tbDepartmentJobRepository.save(tbDepartmentJob);

					responseModel.setTbDepartmentJob(tbDepartmentJob);
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

			Page<TbDepartment> pgTbDepartment = tbDepartmentRepository.findAll(Example.of(exampleTbDepartment), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbdId").ascending()));
			
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
