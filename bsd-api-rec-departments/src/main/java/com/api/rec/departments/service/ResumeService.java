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
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode;
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
			String[] tbrDataPhoneNumbersArray = tbResume.getTbrDataPhoneNumbers().split(",");
			String tbrDataPhoneNumbersString = "";
			for (int i = 0; i < tbrDataPhoneNumbersArray.length; i++) {
				tbrDataPhoneNumbersString += tbrDataPhoneNumbersArray[i].replace("[", "").replace("]", "").replace("\"",
						"") + ",";
			}
			tbResume.setTbrDataPhoneNumbers(
					tbrDataPhoneNumbersString.substring(0, tbrDataPhoneNumbersString.length() - 1));

			tbResume.setTbrDataWebsites(gson.toJson(data.get("websites")));
			String[] tbrDataWebsitesArray = tbResume.getTbrDataWebsites().split(",");
			String tbrDataWebsitesString = "";
			for (int i = 0; i < tbrDataWebsitesArray.length; i++) {
				tbrDataWebsitesString += tbrDataWebsitesArray[i].replace("[", "").replace("]", "").replace("\"", "")
						+ ",";
			}
			tbResume.setTbrDataWebsites(tbrDataWebsitesString.substring(0, tbrDataWebsitesString.length() - 1));

			tbResume.setTbrDataEmails(gson.toJson(data.get("emails")));
			String[] tbrDataEmailsArray = tbResume.getTbrDataEmails().split(",");
			String tbrDataEmailsString = "";
			for (int i = 0; i < tbrDataEmailsArray.length; i++) {
				tbrDataEmailsString += tbrDataEmailsArray[i].replace("[", "").replace("]", "").replace("\"", "") + ",";
			}
			tbResume.setTbrDataEmails(tbrDataEmailsString.substring(0, tbrDataEmailsString.length() - 1));

			tbResume.setTbrDataDateOfBirth((String) data.get("dateOfBirth"));
			tbResume.setTbrDataObjective((String) data.get("objective"));
			
			tbResume.setTbrDataLanguages(gson.toJson(data.get("languages")));
			String[] tbrDataLanguagesArray = tbResume.getTbrDataLanguages().split(",");
			String tbrDataLanguagesString = "";
			for (int i = 0; i < tbrDataLanguagesArray.length; i++) {
				tbrDataLanguagesString += tbrDataLanguagesArray[i].replace("[", "").replace("]", "").replace("\"", "")
						+ ",";
			}
			tbResume.setTbrDataLanguages(tbrDataLanguagesString.substring(0, tbrDataLanguagesString.length() - 1));
			
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
		
		if (dataEducation != null) {
			rootNode = mapper.readTree(tbResume.getTbrDataEducation());
			for (JsonNode node : rootNode) {
				try {
					String organization = node.get("organization") == null ? "" : node.get("organization").asText();
					String education = node.get("accreditation") == null ? "" : node.get("accreditation").get("education") == null ? "" : node.get("accreditation").get("education").asText();
					String completionDate = node.get("dates") == null ? "" : node.get("dates").get("completionDate") == null ? "" : node.get("dates").get("completionDate").asText();

					TbResumeEducation tbResumeEducation = new TbResumeEducation();
					tbResumeEducation.setTbrId(tbResume.getTbrId());
					tbResumeEducation.setTbreCreateId(tbUser.getTbuId());
					tbResumeEducation.setTbreCreateDate(new Date());
					tbResumeEducation.setTbreCreateIdc(tbUser.getTbuCreateIdc());
					tbResumeEducation.setTbreStatus(TbResumeRepository.Active);
					tbResumeEducation.setTbreUuid(new Uid().generateString(5));
					tbResumeEducation.setTbreOrganization(organization);
					tbResumeEducation.setTbreEducation(education);
					try {
						tbResumeEducation.setTbreCompletionDate(new SimpleDateFormat("yyyy-MM-dd").parse(completionDate));
					} catch (Exception ex) {
						log.error(ex.getMessage());
					}
					tbResumeEducationRepository.save(tbResumeEducation);
				} catch (Exception ex) {
					log.error(ex.getMessage());
				}
			}
		}		
		
		if (dataWorkExperience != null) {
			rootNode = mapper.readTree(tbResume.getTbrDataWorkExperience());
			for (JsonNode node : rootNode) {
				try {
					String jobTitle = node.get("jobTitle") == null ? "" : node.get("jobTitle").asText();
					String organization = node.get("organization") == null ? "" : node.get("organization").asText();
					String startDate = node.get("dates") == null ? "" : node.get("dates").get("startDate") == null ? "" : node.get("dates").get("startDate").asText();
					String endDate = node.get("dates") == null ? "" : node.get("dates").get("endDate") == null ? "" : node.get("dates").get("endDate").asText();
					String monthsInPosition = node.get("dates") == null ? "" : node.get("dates").get("monthsInPosition") == null ? "" : node.get("dates").get("monthsInPosition").asText();
					String isCurrent = node.get("dates") == null ? "" : node.get("dates").get("isCurrent") == null ? "" : node.get("dates").get("isCurrent").asText();
					String jobDescription = node.get("jobDescription") == null ? "" : node.get("jobDescription").asText();			

					TbResumeWorkExperience tbResumeWorkExperience = new TbResumeWorkExperience();
					tbResumeWorkExperience.setTbrId(tbResume.getTbrId());
					tbResumeWorkExperience.setTbrweCreateId(tbUser.getTbuId());
					tbResumeWorkExperience.setTbrweCreateDate(new Date());
					tbResumeWorkExperience.setTbrweCreateIdc(tbUser.getTbuCreateIdc());
					tbResumeWorkExperience.setTbrweStatus(TbResumeWorkExperienceRepository.Active);
					tbResumeWorkExperience.setTbrweUuid(new Uid().generateString(5));
					tbResumeWorkExperience.setTbrweJobTitle(jobTitle);
					tbResumeWorkExperience.setTbrweOrganization(organization);
					try {
						tbResumeWorkExperience.setTbrweStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
						tbResumeWorkExperience.setTbrweEndDate(new SimpleDateFormat("yyyy-MM-dd").parse(endDate));
						tbResumeWorkExperience.setTbrweMonthsInPosition(Integer.parseInt(monthsInPosition));
					} catch (Exception ex) {
						log.error(ex.getMessage());
					}					
					tbResumeWorkExperience.setTbrweIsCurrent(isCurrent);
					tbResumeWorkExperience.setTbrweJobDescription(jobDescription);
					tbResumeWorkExperienceRepository.save(tbResumeWorkExperience);
				} catch (Exception ex) {
					log.error(ex.getMessage());
				}
			}
		}

		if (dataSkills != null) {
			rootNode = mapper.readTree(tbResume.getTbrDataSkills());
			for (JsonNode node : rootNode) {
				try {				
					String name = node.get("name") == null ? "" : node.get("name").asText();
					String lastUsed = node.get("lastUsed") == null ? "" : node.get("lastUsed").asText();
					String numberOfMonths = node.get("numberOfMonths") == null ? "" : node.get("numberOfMonths").asText();
					String type = node.get("type") == null ? "" : node.get("type").asText();

					TbResumeSkill tbResumeSkill = new TbResumeSkill();
					tbResumeSkill.setTbrId(tbResume.getTbrId());
					tbResumeSkill.setTbrsCreateId(tbUser.getTbuId());
					tbResumeSkill.setTbrsCreateDate(new Date());
					tbResumeSkill.setTbrsCreateIdc(tbUser.getTbuCreateIdc());
					tbResumeSkill.setTbrsStatus(TbResumeSkillRepository.Active);
					tbResumeSkill.setTbrsUuid(new Uid().generateString(5));
					tbResumeSkill.setTbrsName(name);
					try {
						tbResumeSkill.setTbrsLastUsed(new SimpleDateFormat("yyyy-MM-dd").parse(lastUsed));
						tbResumeSkill.setTbrsNumberOfMonths(Integer.parseInt(numberOfMonths));
					} catch (Exception ex) {
						log.error(ex.getMessage());
					}										
					tbResumeSkill.setTbrsType(type);
					tbResumeSkillRepository.save(tbResumeSkill);
				} catch (Exception ex) {
					log.error(ex.getMessage());
				}
			}
		}

		return tbResume;
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
				String ext = fileNameOri.substring(fileNameOri.lastIndexOf(".") + 1);

				if (ext.equals("pdf")) {
					String fileName = StringUtils.cleanPath(file.getOriginalFilename()) + "_" + (new Uid().generateString(5)) + "." + ext;
					Files.copy(file.getInputStream(), Paths.get(env.getProperty("file.resume.dir") + fileName), StandardCopyOption.REPLACE_EXISTING);				
	
					TbResume tbResume = postUploadResumeAffinda(optTbUser.get(), file);
					// TbResume exampleTbResume = new TbResume();
					// exampleTbResume.setTbrUuid("NMXZJ");
					// TbResume tbResume = tbResumeRepository.findOne(Example.of(exampleTbResume)).orElse(new TbResume());
					tbResume.setTbrCreateId(optTbUser.get().getTbuId());
					tbResume.setTbrCreateDate(new Date());
					tbResume.setTbrCreateIdc(optTbUser.get().getTbuCreateIdc());
					tbResume.setTbrStatus(TbResumeRepository.Active);
					tbResume.setTbrAssigned(TbResumeRepository.Assigned);
					tbResume.setTbrDataNameRaw(tbResume.getTbrDataNameFirst() + " " + tbResume.getTbrDataNameMiddle() + " " + tbResume.getTbrDataNameLast());
					tbResume.setTbrUuid(new Uid().generateString(5));
					tbResume.setTbrMetaFileName(fileName);
					tbResume.setTbjId(optTbJob.get().getTbjId());
					tbResume.setTbrResumeStatus(optTbJob.get().getTbjResumeStatus().split(",")[0].trim());					
					tbResumeRepository.save(tbResume);

					// Open AI Start ---------------------------------------------------------------------------------------------
					TbJob tbJob = tbJobRepository.findById(tbResume.getTbjId()).get();
					String prompt = "";					
					
					prompt += "\\nYou act as my recruiter.";

					TbResumeWorkExperience exampleTbResumeWorkExperience = new TbResumeWorkExperience();
					exampleTbResumeWorkExperience.setTbrId(tbResume.getTbrId());
					List<TbResumeWorkExperience> lstTbResumeWorkExperience = tbResumeWorkExperienceRepository.findAll(Example.of(exampleTbResumeWorkExperience));
					if (lstTbResumeWorkExperience.size() > 0) {
						prompt += "\\nI have a candidate with work experiences : ";
						for (TbResumeWorkExperience tbResumeWorkExperience : lstTbResumeWorkExperience) {
							prompt += tbResumeWorkExperience.getTbrweJobTitle() + ", ";
						}
						prompt = prompt.substring(0, prompt.length() - 2) + ".";
					} else {
						prompt += "\\nI have a candidate no experience.";
					}
					
					prompt += "\\nDo an assesment for candidate for opening job with job title " + tbJob.getTbjName() + ".";
					prompt += "\\nGive score and summary for the candidate with the following format : score: value|summary.";
					prompt += "\\nValue is integer between 0 and 100.";

					final String uri = "https://api.openai.com/v1/completions";
					RestTemplate restTemplate = new RestTemplate();

					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_JSON);
					headers.setBearerAuth("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");

					String requestJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + prompt + "\", \"max_tokens\": 1024, \"temperature\": 0}";

					log.info("------------------------------------------------------------------");		
					log.info(requestJson);
					log.info("------------------------------------------------------------------");

					HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

					ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

					log.info("------------------------------------------------------------------");		
					log.info(response.getBody());
					log.info("------------------------------------------------------------------");

					ObjectMapper mapper = new ObjectMapper();
					JsonNode rootNodeGpt = mapper.readTree(response.getBody());
					JsonNode choicesNode = rootNodeGpt.path("choices");
					Iterator<JsonNode> choicesIterator = choicesNode.elements();
					Integer score = 0;
					String note = "";
					while (choicesIterator.hasNext()) {
						JsonNode choiceNode = choicesIterator.next();
						if (choiceNode.get("text") != null) {
							// text = \n\nScore: 70|The candidate has a good set of skills and work experiences that could be beneficial in the role of Song Writer. The candidate has a good technical background in web services, programming languages and cloud platforms, as well as experience in managing teams and projects. The candidate could benefit from some additional knowledge and experience in the areas of music composition and songwriting.
							// split text using |							
							String[] arrText = choiceNode.get("text").asText().split("\\|");
							log.info(arrText[0]); // Score: 70
							log.info(arrText[1]); // The candidate has a good set of skills and work experiences that could be beneficial in the role of Song Writer. The candidate has a good technical background in web services, programming languages and cloud platforms, as well as experience in managing teams and projects. The candidate could benefit from some additional knowledge and experience in the areas of music composition and songwriting.
							score = Integer.parseInt(arrText[0].split(": ")[1]);
							note = arrText[1];
						}
					}

					tbResume.setTbrScore(score);
					tbResume.setTbrAINote(note);
					tbResumeRepository.save(tbResume);

					// Open AI End ---------------------------------------------------------------------------------------------
		
					responseModel.setTbResume(tbResume);
					responseModel.setFileName(fileName);
					responseModel.setFileNameOri(fileNameOri);
					responseModel.setHttpStatus(HttpStatus.OK);
				} else {
					responseModel.setMessage("File must be PDF");
					responseModel.setHttpStatus(HttpStatus.BAD_REQUEST);
				}
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
			List<ViewResumeJob> lstViewResumeJob = new ArrayList<ViewResumeJob>();

			if (tbrAssigned.equals("")) {
				if (tbjId == null) {
					lstViewResumeJob = viewResumeJobRepository.findList(optTbUser.get().getTbuCreateIdc(), tbrUuid, tbrDataNameRaw, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by(Sort.Order.asc("tbj_id"), Sort.Order.desc("tbr_score"))));
				} else {
					lstViewResumeJob = viewResumeJobRepository.find(optTbUser.get().getTbuCreateIdc(), tbjId, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by(Sort.Order.asc("tbj_id"), Sort.Order.desc("tbr_score"))));
				}				
			} else {
				if (tbrAssigned.equals("assigned")) {
					lstViewResumeJob = viewResumeJobRepository.findAssigned(optTbUser.get().getTbuCreateIdc(), tbjId, tbrUuid, tbrDataNameRaw, tbrStatus, tbrAssigned, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by(Sort.Order.asc("tbj_id"), Sort.Order.desc("tbr_score"))));
				} else if (tbrAssigned.equals("not assigned")) {
					lstViewResumeJob = viewResumeJobRepository.findNotAssigned(optTbUser.get().getTbuCreateIdc(), tbrUuid, tbrDataNameRaw, tbrStatus, tbrAssigned, PageRequest.of(Integer.valueOf(pageIndex), Integer.valueOf(pageSize), Sort.by(Sort.Order.asc("tbj_id"), Sort.Order.desc("tbr_score"))));
				}
			}			
			
			if (lstViewResumeJob.size() > 0) {
				responseModel.setLstViewResumeJob(lstViewResumeJob);

				if (tbrAssigned.equals("")) {
					if (tbjId == null) {
						responseModel.setLength(viewResumeJobRepository.countList(optTbUser.get().getTbuCreateIdc(), tbrUuid, tbrDataNameRaw));
					} else {
						responseModel.setLength(viewResumeJobRepository.count(optTbUser.get().getTbuCreateIdc(), tbjId));
					}					
				} else {
					if (tbrAssigned.equals("assigned")) {
						responseModel.setLength(viewResumeJobRepository.countAssigned(optTbUser.get().getTbuCreateIdc(), tbjId, tbrUuid, tbrDataNameRaw, tbrStatus, tbrAssigned));
					} else if (tbrAssigned.equals("not assigned")) {
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

					if (requestModel.getTbResume().getTbrDataNameFirst() != null) tbResume.setTbrDataNameFirst(requestModel.getTbResume().getTbrDataNameFirst());
					if (requestModel.getTbResume().getTbrDataNameMiddle() != null) tbResume.setTbrDataNameMiddle(requestModel.getTbResume().getTbrDataNameMiddle());
					if (requestModel.getTbResume().getTbrDataNameLast() != null) tbResume.setTbrDataNameLast(requestModel.getTbResume().getTbrDataNameLast());

					if (requestModel.getTbResume().getTbrDataPhoneNumbers() != null) tbResume.setTbrDataPhoneNumbers(requestModel.getTbResume().getTbrDataPhoneNumbers());
					if (requestModel.getTbResume().getTbrDataEmails() != null) tbResume.setTbrDataEmails(requestModel.getTbResume().getTbrDataEmails());
					if (requestModel.getTbResume().getTbrDataWebsites() != null) tbResume.setTbrDataWebsites(requestModel.getTbResume().getTbrDataWebsites());

					if (requestModel.getTbResume().getTbrDataLocationStreet() != null) tbResume.setTbrDataLocationStreet(requestModel.getTbResume().getTbrDataLocationStreet());
					if (requestModel.getTbResume().getTbrDataLocationApartmentNumber() != null) tbResume.setTbrDataLocationApartmentNumber(requestModel.getTbResume().getTbrDataLocationApartmentNumber());
					if (requestModel.getTbResume().getTbrDataLocationCity() != null) tbResume.setTbrDataLocationCity(requestModel.getTbResume().getTbrDataLocationCity());

					if (requestModel.getTbResume().getTbrDataLocationState() != null) tbResume.setTbrDataLocationState(requestModel.getTbResume().getTbrDataLocationState());
					if (requestModel.getTbResume().getTbrDataLocationCountry() != null) tbResume.setTbrDataLocationCountry(requestModel.getTbResume().getTbrDataLocationCountry());
					if (requestModel.getTbResume().getTbrDataLocationPostalCode() != null) tbResume.setTbrDataLocationPostalCode(requestModel.getTbResume().getTbrDataLocationPostalCode());

					if (requestModel.getTbResume().getTbrDataLanguages() != null) tbResume.setTbrDataLanguages(requestModel.getTbResume().getTbrDataLanguages());
					
					tbResume.setTbrDataNameRaw(
						(tbResume.getTbrDataNameFirst() == null ? "" : tbResume.getTbrDataNameFirst()) + " " + 
						(tbResume.getTbrDataNameMiddle() == null ? "" : tbResume.getTbrDataNameMiddle()) + " " + 
						(tbResume.getTbrDataNameLast() == null ? "" : tbResume.getTbrDataNameLast())
					);

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

					tbResume.setTbrNote(requestModel.getTbResume().getTbrNote());
					
					tbResume = tbResumeRepository.save(tbResume);

					for (TbResumeEducation tbResumeEducation : requestModel.getLstTbResumeEducation()) {
						if (tbResumeEducation.getTbreId() == null) {
							tbResumeEducation.setTbreCreateId(optTbUser.get().getTbuId());
							tbResumeEducation.setTbreCreateDate(new Date());
							tbResumeEducation.setTbreCreateIdc(optTbUser.get().getTbuCreateIdc());
							tbResumeEducation.setTbreStatus(TbResumeEducationRepository.Active);
							tbResumeEducation.setTbreUuid(new Uid().generateString(5));
							tbResumeEducation.setTbrId(tbResume.getTbrId());
						} else {
							tbResumeEducation.setTbreUpdateId(optTbUser.get().getTbuId());
							tbResumeEducation.setTbreUpdateDate(new Date());
						}
						tbResumeEducationRepository.save(tbResumeEducation);						
					}

					for (TbResumeWorkExperience tbResumeWorkExperience : requestModel.getLstTbResumeWorkExperience()) {
						if (tbResumeWorkExperience.getTbrweId() == null) {
							tbResumeWorkExperience.setTbrweCreateId(optTbUser.get().getTbuId());
							tbResumeWorkExperience.setTbrweCreateDate(new Date());
							tbResumeWorkExperience.setTbrweCreateIdc(optTbUser.get().getTbuCreateIdc());
							tbResumeWorkExperience.setTbrweStatus(TbResumeWorkExperienceRepository.Active);
							tbResumeWorkExperience.setTbrweUuid(new Uid().generateString(5));
							tbResumeWorkExperience.setTbrId(tbResume.getTbrId());
						} else {
							tbResumeWorkExperience.setTbrweUpdateId(optTbUser.get().getTbuId());
							tbResumeWorkExperience.setTbrweUpdateDate(new Date());
							tbResumeWorkExperience.setTbrweCreateIdc(optTbUser.get().getTbuCreateIdc());
							tbResumeWorkExperience.setTbrId(tbResume.getTbrId());							
						}
						tbResumeWorkExperienceRepository.save(tbResumeWorkExperience);
					}
	
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
				List<TbResumeSkill> tbResumeSkillsHard = tbResumeSkillRepository.findAll(Example.of(exampleTbResumeSkill), Sort.by(Sort.Direction.DESC, "tbrsScore"));

				exampleTbResumeSkill = new TbResumeSkill();
				exampleTbResumeSkill.setTbrId(optTbResume.get().getTbrId());
				exampleTbResumeSkill.setTbrsStatus(TbResumeSkillRepository.Active);
				exampleTbResumeSkill.setTbrsType("soft_skill");				
				List<TbResumeSkill> tbResumeSkillsSoft = tbResumeSkillRepository.findAll(Example.of(exampleTbResumeSkill), Sort.by(Sort.Direction.DESC, "tbrsScore"));

				TbResumeWorkExperience exampleTbResumeWorkExperience = new TbResumeWorkExperience();
				exampleTbResumeWorkExperience.setTbrId(optTbResume.get().getTbrId());
				exampleTbResumeWorkExperience.setTbrweStatus(TbResumeWorkExperienceRepository.Active);
				List<TbResumeWorkExperience> tbResumeWorkExperiences = tbResumeWorkExperienceRepository.findAll(Example.of(exampleTbResumeWorkExperience));
				tbResumeWorkExperiences.forEach(tbResumeWorkExperience -> {
					if (tbResumeWorkExperience.getTbrweStartDate() != null) tbResumeWorkExperience.setTbrweStart(new SimpleDateFormat("yyyy-MM-dd").format(tbResumeWorkExperience.getTbrweStartDate()));
					if (tbResumeWorkExperience.getTbrweEndDate() != null) tbResumeWorkExperience.setTbrweEnd(new SimpleDateFormat("yyyy-MM-dd").format(tbResumeWorkExperience.getTbrweEndDate()));
				});

				TbJob exampleTbJob = new TbJob();
				exampleTbJob.setTbjId(optTbResume.get().getTbjId());
				Optional<TbJob> optTbJob = tbJobRepository.findOne(Example.of(exampleTbJob));

				responseModel.setLstTbResumeCertification(tbResumeCertifications);
				responseModel.setLstTbResumeEducation(tbResumeEducations);
				responseModel.setLstTbResumeSkillHard(tbResumeSkillsHard);
				responseModel.setLstTbResumeSkillSoft(tbResumeSkillsSoft);
				responseModel.setLstTbResumeWorkExperience(tbResumeWorkExperiences);				
				responseModel.setTbResume(optTbResume.get());
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
}
