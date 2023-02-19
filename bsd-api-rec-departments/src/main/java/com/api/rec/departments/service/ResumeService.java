package com.api.rec.departments.service;

import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.affinda.api.client.AffindaAPI;
import com.affinda.api.client.AffindaAPIBuilder;
import com.affinda.api.client.AffindaTokenCredential;
import com.affinda.api.client.models.ResumeRequestBody;
import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbResume;
import com.api.rec.departments.db.entity.TbResumeCertification;
import com.api.rec.departments.db.entity.TbResumeEducation;
import com.api.rec.departments.db.entity.TbResumeSkill;
import com.api.rec.departments.db.entity.TbResumeWorkExperience;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.entity.ViewResumeJob;
import com.api.rec.departments.db.repository.TbJobRepository;
import com.api.rec.departments.db.repository.TbResumeCertificationRepository;
import com.api.rec.departments.db.repository.TbResumeEducationRepository;
import com.api.rec.departments.db.repository.TbResumeRepository;
import com.api.rec.departments.db.repository.TbResumeSkillRepository;
import com.api.rec.departments.db.repository.TbResumeWorkExperienceRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.db.repository.ViewResumeJobRepository;
import com.api.rec.departments.model.resume.GetResumeJobListRequestModel;
import com.api.rec.departments.model.resume.GetResumeJobListResponseModel;
import com.api.rec.departments.model.resume.GetResumeListRequestModel;
import com.api.rec.departments.model.resume.GetResumeListResponseModel;
import com.api.rec.departments.model.resume.GetResumeRequestModel;
import com.api.rec.departments.model.resume.GetResumeResponseModel;
import com.api.rec.departments.model.resume.PostAddResumeRequestModel;
import com.api.rec.departments.model.resume.PostAddResumeResponseModel;
import com.api.rec.departments.model.resume.PostUploadResumeRequestModel;
import com.api.rec.departments.model.resume.PostUploadResumeResponseModel;
import com.api.rec.departments.util.TokenUtil;
import com.api.rec.departments.util.Uid;
import com.azure.core.credential.TokenCredential;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

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
	private TbResumeRepository tbResumeRepository;

	@Autowired
	private TbResumeEducationRepository tbResumeEducationRepository;

	@Autowired
	private TbResumeWorkExperienceRepository tbResumeWorkExperienceRepository;

	@Autowired
	private TbResumeSkillRepository tbResumeSkillRepository;

	@Autowired
	private TbResumeCertificationRepository tbResumeCertificationRepository;

	@Autowired
	private ViewResumeJobRepository viewResumeJobRepository;

	public TbResume postUploadResumeAffinda(TbUser tbUser, MultipartFile file) throws Exception {
		Gson gson = new Gson();

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
		tbResume.setTbrCreateId(tbUser.getTbuId());
		tbResume.setTbrCreateDate(new Date());
		tbResume.setTbrCreateIdc(tbUser.getTbuCreateIdc());
		tbResume.setTbrStatus(TbResumeRepository.Active);
		tbResume.setTbrAssigned(TbResumeRepository.Assigned);
		tbResume.setTbrUuid(new Uid().generateString(5));

		if (dataName != null) {
			tbResume.setTbrDataNameRaw((String) dataName.get("raw"));
			tbResume.setTbrDataNameFirst((String) dataName.get("first"));
			tbResume.setTbrDataNameLast((String) dataName.get("last"));
			tbResume.setTbrDataNameMiddle((String) dataName.get("middle"));
			tbResume.setTbrDataNameTitle((String) dataName.get("title"));
		}

		if (data != null) {
			tbResume.setTbrDataPhoneNumbers(gson.toJson(data.get("phoneNumbers")));
			tbResume.setTbrDataWebsites(gson.toJson(data.get("websites")));
			tbResume.setTbrDataEmails(gson.toJson(data.get("emails")));
			tbResume.setTbrDataDateOfBirth((String) data.get("dateOfBirth"));
			tbResume.setTbrDataObjective((String) data.get("objective"));
			tbResume.setTbrDataLanguages(gson.toJson(data.get("languages")));
			tbResume.setTbrDataSummary((String) data.get("summary"));
			tbResume.setTbrDataTotalYearsExperience((Integer) data.get("totalYearsExperience"));
			tbResume.setTbrDataProfession((String) data.get("profession"));
			tbResume.setTbrDataLinkedin((String) data.get("linkedin"));
			tbResume.setTbrDataCertifications(gson.toJson(data.get("certifications")));
			tbResume.setTbrDataPublications(gson.toJson(data.get("publications")));
			tbResume.setTbrDataIsResumeProbability((Integer) data.get("isResumeProbability"));
		}

		if (dataLocation != null) {
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
		}
		
		if (dataEducation != null) {
			tbResume.setTbrDataEducation(gson.toJson(dataEducation));
		}
		
		if (dataWorkExperience != null) {
			tbResume.setTbrDataWorkExperience(gson.toJson(dataWorkExperience));
		}

		if (dataSkills != null) {
			tbResume.setTbrDataSkills(gson.toJson(dataSkills));
		}
		
		if (dataReferees != null) {
			tbResume.setTbrDataReferees(gson.toJson(dataReferees));
		}
		
		if (meta != null) {
			tbResume.setTbrMetaIdentifier((String) meta.get("identifier"));
			tbResume.setTbrMetaFileName((String) meta.get("fileName"));
			tbResume.setTbrMetaReady((boolean) meta.get("ready") == true ? 1 : 0);
			tbResume.setTbrMetaReadyDt((String) meta.get("readyDt"));
			tbResume.setTbrMetaFailed((boolean) meta.get("failed") == true ? 1 : 0);
			tbResume.setTbrMetaExpiryTime((String) meta.get("expiryTime"));
			tbResume.setTbrMetaLanguage((String) meta.get("language"));
			tbResume.setTbrMetaIsVerified((boolean) meta.get("isVerified") == true ? 1 : 0);
			tbResume.setTbrMetaReviewUrl((String) meta.get("reviewUrl"));
			tbResume.setTbrMetaOcrConfidence((Double) meta.get("ocrConfidence"));
		}		

		tbResumeRepository.save(tbResume);

		return tbResume;
	}

	public JsonNode postUploadResumeParser(TbUser tbUser, String filePath) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", new FileSystemResource(filePath));

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange("http://localhost:2083/resume/postuploadresume", HttpMethod.POST, requestEntity, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(response.getBody());

		return rootNode;
	}

	public PostUploadResumeResponseModel postUploadResume(PostUploadResumeRequestModel requestModel, MultipartFile file) throws Exception {
		PostUploadResumeResponseModel responseModel = new PostUploadResumeResponseModel(requestModel);

		tokenUtil.claims(requestModel);

		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		if (optTbUser.isPresent()) {
			TbJob exampleTbJob = new TbJob();
			exampleTbJob.setTbjCreateIdc(optTbUser.get().getTbuCreateIdc());
			exampleTbJob.setTbjUuid(requestModel.getTbjUuid());
			Optional<TbJob> optTbJob = tbJobRepository.findOne(Example.of(exampleTbJob));

			if (optTbJob.isPresent()) {
				String fileNameOri = StringUtils.cleanPath(file.getOriginalFilename());
				String fileName = StringUtils.cleanPath(file.getOriginalFilename()) + "_" + (new Uid().generateString(5)) + ".pdf";
				Files.copy(file.getInputStream(), Paths.get(env.getProperty("file.resume.dir") + fileName), StandardCopyOption.REPLACE_EXISTING);
				String filePath = env.getProperty("file.resume.dir") + fileName;	
				
				// Start Resume
				JsonNode rootNode = postUploadResumeParser(optTbUser.get(), filePath);

				TbResume tbResume = new TbResume();
				tbResume.setTbrCreateId(optTbUser.get().getTbuId());
				tbResume.setTbrCreateDate(new Date());
				tbResume.setTbrCreateIdc(optTbUser.get().getTbuCreateIdc());
				tbResume.setTbrStatus(TbResumeRepository.Active);
				tbResume.setTbrAssigned(TbResumeRepository.Assigned);
				tbResume.setTbrUuid(new Uid().generateString(5));
				tbResume.setTbrMetaFileName(fileName);

				tbResume.setTbjId(optTbJob.get().getTbjId());

				JsonNode basics = rootNode.path("json").path("basics");
				
				if (basics.path("name").path("firstName") != null)				
					tbResume.setTbrDataNameFirst(basics.path("name").path("firstName").asText());
				
				if (basics.path("name").path("surname") != null)
					tbResume.setTbrDataNameLast(basics.path("name").path("surname").asText());
				
				tbResume.setTbrDataNameRaw(tbResume.getTbrDataNameFirst() + " " + tbResume.getTbrDataNameLast());
				
				if (basics.path("email").get(0) != null)
					tbResume.setTbrDataEmails(basics.path("email").get(0).asText());

				if (basics.path("phone").get(0) != null)				
					tbResume.setTbrDataPhoneNumbers(basics.path("phone").get(0).asText().replaceAll(" ", ""));
				
				tbResumeRepository.save(tbResume);
				// End Resume

				// Start Work Experience
				JsonNode workExperienceArray = rootNode.path("json").path("work_experience");

				Iterator<JsonNode> workExperienceIterator = workExperienceArray.elements();
				List<TbResumeWorkExperience> lstTbResumeWorkExperience = new ArrayList<TbResumeWorkExperience>();
				while (workExperienceIterator.hasNext()) {
					JsonNode experienceNode = workExperienceIterator.next();
					TbResumeWorkExperience tbResumeWorkExperience = new TbResumeWorkExperience();
					tbResumeWorkExperience.setTbrweCreateId(optTbUser.get().getTbuId());
					tbResumeWorkExperience.setTbrweCreateDate(new Date());
					tbResumeWorkExperience.setTbrweCreateIdc(optTbUser.get().getTbuCreateIdc());
					tbResumeWorkExperience.setTbrweStatus(TbResumeWorkExperienceRepository.Active);
					tbResumeWorkExperience.setTbrweUuid(new Uid().generateString(5));
					tbResumeWorkExperience.setTbrId(tbResume.getTbrId());

					if (experienceNode.get("date_start") != null)
						tbResumeWorkExperience.setTbrweStart(experienceNode.get("date_start").asText());

					if (experienceNode.get("date_end") != null)
						tbResumeWorkExperience.setTbrweEnd(experienceNode.get("date_end").asText());

					if (experienceNode.get("jobtitle") != null)
						tbResumeWorkExperience.setTbrweJobTitle(experienceNode.get("jobtitle").asText());

					if (experienceNode.get("organization") != null)
						tbResumeWorkExperience.setTbrweOrganization(experienceNode.get("organization").asText());
					
					if (experienceNode.get("text") != null)
						tbResumeWorkExperience.setTbrweText(experienceNode.get("text").asText());
					
					lstTbResumeWorkExperience.add(tbResumeWorkExperience);
				}
				tbResumeWorkExperienceRepository.saveAll(lstTbResumeWorkExperience);
				// End Work Experience

				// Start Education
				JsonNode educationArray = rootNode.path("json").path("education_and_training");

				Iterator<JsonNode> educationIterator = educationArray.elements();
				List<TbResumeEducation> lstTbResumeEducation = new ArrayList<TbResumeEducation>();
				while (educationIterator.hasNext()) {
					JsonNode educationNode = educationIterator.next();

					// Get an iterator of all the field names in the educationNode
					Iterator<String> fieldNamesIterator = educationNode.fieldNames();
					List<String> lstValue = new ArrayList<String>();
					while (fieldNamesIterator.hasNext()) {
						String fieldName = fieldNamesIterator.next();
						// Get the value of the field using the fieldName variable
						JsonNode fieldValue = educationNode.get(fieldName);
						if (fieldValue.isValueNode()) {
							lstValue.add(fieldValue.asText());
						}
					}

					for (String strArray : lstValue) {
						String strs[] = strArray.split("\n");
						for (String str : strs) {
							if (!str.equals("")) {
								TbResumeEducation tbResumeEducation = new TbResumeEducation();
								tbResumeEducation.setTbreCreateId(optTbUser.get().getTbuId());
								tbResumeEducation.setTbreCreateDate(new Date());
								tbResumeEducation.setTbreCreateIdc(optTbUser.get().getTbuCreateIdc());
								tbResumeEducation.setTbreStatus(TbResumeEducationRepository.Active);
								tbResumeEducation.setTbreUuid(new Uid().generateString(5));
								tbResumeEducation.setTbrId(tbResume.getTbrId());
								tbResumeEducation.setTbreText(str);

								lstTbResumeEducation.add(tbResumeEducation);
							}
						}
					}
				}
				tbResumeEducationRepository.saveAll(lstTbResumeEducation);
				// End Education
	
				responseModel.setTbResume(tbResume);
				responseModel.setFileName(fileName);
				responseModel.setFileNameOri(fileNameOri);
				responseModel.setHttpStatus(HttpStatus.OK);
			} else {
				responseModel.setHttpStatus(HttpStatus.NOT_FOUND);
			}
		} else {
			responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}

		return responseModel;
	}
	
	public GetResumeListResponseModel getResumeList(String tbrDataNameRaw, String tbrStatus, String length, String pageSize, String pageIndex, GetResumeListRequestModel requestModel) throws Exception {
		GetResumeListResponseModel responseModel = new GetResumeListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbResume exampleTbResume = new TbResume();
			exampleTbResume.setTbrCreateIdc(optTbUser.get().getTbuCreateIdc());
			if (!tbrDataNameRaw.equals("")) exampleTbResume.setTbrDataNameRaw(tbrDataNameRaw);
			if (!tbrStatus.equals("")) exampleTbResume.setTbrStatus(tbrStatus);

			ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("tbrDataNameRaw", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("tbrStatus", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
			;

			Page<TbResume> pgTbResume = tbResumeRepository.findAll(Example.of(exampleTbResume, matcher), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbrId").ascending()));
			
			if (pgTbResume.toList().size() > 0) {
				responseModel.setLstTbResume(pgTbResume.toList());				
				responseModel.setLength(tbResumeRepository.count(Example.of(exampleTbResume)));
				responseModel.setHttpStatus(HttpStatus.OK);
			} else {
				responseModel.setHttpStatus(HttpStatus.NOT_FOUND);
			}
		} else {
			responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}
		
		return responseModel;
	}

	public GetResumeJobListResponseModel getResumeJobList(Integer tbjId, String tbrUuid, String tbrDataNameRaw, String tbrStatus, String tbrAssigned, String length, String pageSize, String pageIndex, GetResumeJobListRequestModel requestModel) throws Exception {
		GetResumeJobListResponseModel responseModel = new GetResumeJobListResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		if (optTbUser.isPresent()) {
			List<ViewResumeJob> lstViewResumeJob = null;

			if (tbrAssigned.equals("")) {
				if (tbjId == null) {
					lstViewResumeJob = viewResumeJobRepository.findList(optTbUser.get().getTbuCreateIdc(), PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbr_id").ascending()));
				} else {
					lstViewResumeJob = viewResumeJobRepository.find(optTbUser.get().getTbuCreateIdc(), tbjId, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbr_id").ascending()));
				}				
			} else {
				if (tbrAssigned.equals("assigned")) {
					lstViewResumeJob = viewResumeJobRepository.findAssigned(optTbUser.get().getTbuCreateIdc(), tbjId, tbrUuid, tbrDataNameRaw, tbrStatus, tbrAssigned, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbr_id").ascending()));
				} else if (tbrAssigned.equals("notassigned")) {
					lstViewResumeJob = viewResumeJobRepository.findNotAssigned(optTbUser.get().getTbuCreateIdc(), tbrUuid, tbrDataNameRaw, tbrStatus, tbrAssigned, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by("tbr_id").ascending()));
				}
			}			
			
			if (lstViewResumeJob.size() > 0) {
				responseModel.setLstViewResumeJob(lstViewResumeJob);

				if (tbrAssigned.equals("")) {
					if (tbjId == null) {
						responseModel.setLength(viewResumeJobRepository.countList(optTbUser.get().getTbuCreateIdc()));
					} else {
						responseModel.setLength(viewResumeJobRepository.count(optTbUser.get().getTbuCreateIdc(), tbjId));
					}					
				} else {
					if (tbrAssigned.equals("assigned")) {
						responseModel.setLength(viewResumeJobRepository.countAssigned(optTbUser.get().getTbuCreateIdc(), tbjId, tbrUuid, tbrDataNameRaw, tbrStatus, tbrAssigned));
					} else if (tbrAssigned.equals("notassigned")) {
						responseModel.setLength(viewResumeJobRepository.countNotAssigned(optTbUser.get().getTbuCreateIdc(), tbrUuid, tbrDataNameRaw, tbrStatus, tbrAssigned));
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
	
	public PostAddResumeResponseModel postAddResume(PostAddResumeRequestModel requestModel) throws Exception {
		PostAddResumeResponseModel responseModel = new PostAddResumeResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));

		if (optTbUser.isPresent()) {
			if (requestModel.getTbResume().getTbrUuid().equals("0")) {
				if (requestModel.getTbResume().getTbrDataNameRaw() != null) {
					TbResume exampleTbResume = new TbResume();
					exampleTbResume.setTbrDataNameRaw(requestModel.getTbResume().getTbrDataNameRaw());
					Optional<TbResume> optTbResume = tbResumeRepository.findOne(Example.of(exampleTbResume));
					
					if (optTbResume.isPresent()) {
						responseModel.setHttpStatus(HttpStatus.ALREADY_REPORTED);
					} else {
						TbResume tbResume = new TbResume();
						tbResume = requestModel.getTbResume();
						tbResume.setTbrCreateId(optTbUser.get().getTbuId());
						tbResume.setTbrCreateIdc(optTbUser.get().getTbuCreateIdc());
						tbResume.setTbrCreateDate(new Date());
						tbResume.setTbrStatus(TbResumeRepository.Active);
						tbResume.setTbrUuid(new Uid().generateString(5));
						tbResume = tbResumeRepository.save(tbResume);
		
						responseModel.setTbResume(tbResume);
						responseModel.setHttpStatus(HttpStatus.OK);
					}
				} else {
					responseModel.setHttpStatus(HttpStatus.BAD_REQUEST);
				}				
			} else {
				TbResume exampleTbResume = new TbResume();
				exampleTbResume.setTbrUuid(requestModel.getTbResume().getTbrUuid());
				exampleTbResume.setTbrCreateIdc(optTbUser.get().getTbuCreateIdc());
				Optional<TbResume> optTbResume = tbResumeRepository.findOne(Example.of(exampleTbResume));
				
				if (optTbResume.isPresent()) {
					TbResume tbResume = optTbResume.get();
					tbResume.setTbrUpdateId(optTbUser.get().getTbuId());
					tbResume.setTbrUpdateDate(new Date());

					if (requestModel.getTbResume().getTbrDataNameRaw() != null) tbResume.setTbrDataNameRaw(requestModel.getTbResume().getTbrDataNameRaw());
					if (requestModel.getTbResume().getTbrStatus() != null) tbResume.setTbrStatus(requestModel.getTbResume().getTbrStatus());
					if (requestModel.getTbResume().getTbjId() != null) {
						if (requestModel.getTbResume().getTbjId() == 0) {
							tbResume.setTbrAssigned(TbResumeRepository.NotAssigned);
							tbResume.setTbjId(null);
						} else {
							tbResume.setTbrAssigned(TbResumeRepository.Assigned);							
							tbResume.setTbjId(requestModel.getTbResume().getTbjId());
						}
					}
					
					tbResume = tbResumeRepository.save(tbResume);
	
					responseModel.setTbResume(tbResume);
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

	public GetResumeResponseModel getResume(String tbjUuid, GetResumeRequestModel requestModel) throws Exception {
		GetResumeResponseModel responseModel = new GetResumeResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			TbResume exampleTbResume = new TbResume();
			exampleTbResume.setTbrUuid(tbjUuid);
			exampleTbResume.setTbrCreateId(optTbUser.get().getTbuCreateId());
			Optional<TbResume> optTbResume = tbResumeRepository.findOne(Example.of(exampleTbResume));					
			
			if (optTbResume.isPresent()) {
				TbResumeCertification exampleTbResumeCertification = new TbResumeCertification();
				exampleTbResumeCertification.setTbrId(optTbResume.get().getTbrId());
				exampleTbResumeCertification.setTbrcStatus(TbResumeCertificationRepository.Active);
				List<TbResumeCertification> tbResumeCertifications = tbResumeCertificationRepository.findAll(Example.of(exampleTbResumeCertification));

				TbResumeEducation exampleTbResumeEducation = new TbResumeEducation();
				exampleTbResumeEducation.setTbrId(optTbResume.get().getTbrId());
				exampleTbResumeEducation.setTbreStatus(TbResumeEducationRepository.Active);
				List<TbResumeEducation> tbResumeEducations = tbResumeEducationRepository.findAll(Example.of(exampleTbResumeEducation));

				TbResumeSkill exampleTbResumeSkill = new TbResumeSkill();
				exampleTbResumeSkill.setTbrId(optTbResume.get().getTbrId());
				exampleTbResumeSkill.setTbrsStatus(TbResumeSkillRepository.Active);
				exampleTbResumeSkill.setTbrsType("hard_skill");				
				List<TbResumeSkill> tbResumeSkillsHard = tbResumeSkillRepository.findAll(Example.of(exampleTbResumeSkill), Sort.by(Sort.Direction.ASC, "tbrsName"));

				exampleTbResumeSkill = new TbResumeSkill();
				exampleTbResumeSkill.setTbrId(optTbResume.get().getTbrId());
				exampleTbResumeSkill.setTbrsStatus(TbResumeSkillRepository.Active);
				exampleTbResumeSkill.setTbrsType("soft_skill");				
				List<TbResumeSkill> tbResumeSkillsSoft = tbResumeSkillRepository.findAll(Example.of(exampleTbResumeSkill), Sort.by(Sort.Direction.ASC, "tbrsName"));

				TbResumeWorkExperience exampleTbResumeWorkExperience = new TbResumeWorkExperience();
				exampleTbResumeWorkExperience.setTbrId(optTbResume.get().getTbrId());
				exampleTbResumeWorkExperience.setTbrweStatus(TbResumeWorkExperienceRepository.Active);
				List<TbResumeWorkExperience> tbResumeWorkExperiences = tbResumeWorkExperienceRepository.findAll(Example.of(exampleTbResumeWorkExperience));

				responseModel.setLstTbResumeCertification(tbResumeCertifications);
				responseModel.setLstTbResumeEducation(tbResumeEducations);
				responseModel.setLstTbResumeSkillHard(tbResumeSkillsHard);
				responseModel.setLstTbResumeSkillSoft(tbResumeSkillsSoft);
				responseModel.setLstTbResumeWorkExperience(tbResumeWorkExperiences);				
				responseModel.setTbResume(optTbResume.get());
				
				responseModel.setHttpStatus(HttpStatus.OK);
			} else {
				responseModel.setHttpStatus(HttpStatus.NOT_FOUND);
			}
		} else {
			responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}
		
		return responseModel;
	}

	private Integer getJsonInteger(JsonElement jsonElement, String path) {
		try {
			String[] paths = path.split("\\.");
			for (String p : paths) {
				jsonElement = jsonElement.getAsJsonObject().get(p);
				if (jsonElement == null) {
					return null;
				}
			}
			return jsonElement.getAsInt();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	private Date getJsonDate(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(date);
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	private String getJson(JsonElement jsonElement, String path) {
		try {
			String[] paths = path.split("\\.");
			for (String p : paths) {
				jsonElement = jsonElement.getAsJsonObject().get(p);
				if (jsonElement == null) {
					return null;
				}
			}
			return jsonElement.getAsString();
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}		
	}

	private String getJsonArray(String jsonData) {
		try {
			Gson gson = new Gson();
			String[] data = gson.fromJson(jsonData, String[].class);
			String result = "";
			for (String d : data) {
				if (result.equals("")) {
					result = d;
				} else {
					result = result + ", " + d;
				}			
			}
			return result;
		} catch (Exception e) {
			log.error(e.getMessage());
			return jsonData;
		}
	}
}
