package com.api.rec.resumescheduler.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.api.rec.resumescheduler.db.entity.TbJob;
import com.api.rec.resumescheduler.db.entity.TbResume;
import com.api.rec.resumescheduler.db.entity.TbResumeEducation;
import com.api.rec.resumescheduler.db.entity.TbResumeSkill;
import com.api.rec.resumescheduler.db.entity.TbResumeWorkExperience;
import com.api.rec.resumescheduler.db.repository.TbJobRepository;
import com.api.rec.resumescheduler.db.repository.TbResumeEducationRepository;
import com.api.rec.resumescheduler.db.repository.TbResumeRepository;
import com.api.rec.resumescheduler.db.repository.TbResumeSkillRepository;
import com.api.rec.resumescheduler.db.repository.TbResumeWorkExperienceRepository;
import com.api.rec.resumescheduler.util.Uid;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ResumeService {

	private Logger log = LoggerFactory.getLogger(ResumeService.class);

	@Autowired
	private Environment env;

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

	public JsonNode postUploadResumeParser(String filePath, String port) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("file", new FileSystemResource(filePath));

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:" + port + "/resume/postuploadresume";
		log.info("url: " + url);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(response.getBody());

		return rootNode;
	}

	public void parseResume(TbResume tbResume, String port) throws Exception {
		// Start Parse Resume
		JsonNode rootNode = postUploadResumeParser(env.getProperty("file.resume.dir") + tbResume.getTbrMetaFileName(), port);
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

		tbResume.setTbrUpdateDate(new Date());
		tbResume.setTbrUpdateId(0);
		tbResume.setTbrStatus(TbResumeRepository.Active);
		tbResumeRepository.save(tbResume);
		// End Parse Resume

		// Start Work Experience
		JsonNode workExperienceArray = rootNode.path("json").path("work_experience");

		Iterator<JsonNode> workExperienceIterator = workExperienceArray.elements();
		List<TbResumeWorkExperience> lstTbResumeWorkExperience = new ArrayList<TbResumeWorkExperience>();
		while (workExperienceIterator.hasNext()) {
			JsonNode experienceNode = workExperienceIterator.next();
			TbResumeWorkExperience tbResumeWorkExperience = new TbResumeWorkExperience();
			tbResumeWorkExperience.setTbrweCreateId(tbResume.getTbrCreateId());
			tbResumeWorkExperience.setTbrweCreateDate(new Date());
			tbResumeWorkExperience.setTbrweCreateIdc(tbResume.getTbrCreateIdc());
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
		tbResumeWorkExperienceRepository.deleteByTbrId(tbResume.getTbrId());
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
						tbResumeEducation.setTbreCreateId(tbResume.getTbrCreateId());
						tbResumeEducation.setTbreCreateDate(new Date());
						tbResumeEducation.setTbreCreateIdc(tbResume.getTbrCreateIdc());
						tbResumeEducation.setTbreStatus(TbResumeEducationRepository.Active);
						tbResumeEducation.setTbreUuid(new Uid().generateString(5));
						tbResumeEducation.setTbrId(tbResume.getTbrId());
						tbResumeEducation.setTbreText(str);

						lstTbResumeEducation.add(tbResumeEducation);
					}
				}
			}
		}
		tbResumeEducationRepository.deleteByTbrId(tbResume.getTbrId());
		tbResumeEducationRepository.saveAll(lstTbResumeEducation);
		// End Education

		// Start Skills
		String skillsArray[] = rootNode.path("json").path("pyresparser_skills").asText()
				.replaceAll("'skills': \\[", "")
				.replaceAll("\\]", "")
				.replaceAll("'", "")
				.split(",");
		List<TbResumeSkill> lstTbResumeSkill = new ArrayList<TbResumeSkill>();

		// Score Skills Using OpenAI
		TbJob tbJob = tbJobRepository.findById(tbResume.getTbjId()).get();
		String prompt = "Job Title : " + tbJob.getTbjName() + ".\\nSkills : ";
		for (String skill : skillsArray) {
			prompt += skill.trim() + ", ";
		}
		prompt = prompt.substring(0, prompt.length() - 2);
		prompt += ".\\nScore each skill on a scale of 0-10 for how relevant it is to the job title.";

		final String uri = "https://api.openai.com/v1/completions";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth("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");

		String requestJson = "{\"model\": \"text-davinci-003\", \"prompt\": \"" + prompt + "\", \"max_tokens\": 100, \"temperature\": 0}";

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

		log.info("------------------------------------------------------------------");		
		log.info(response.getBody());
		log.info("------------------------------------------------------------------");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNodeGpt = mapper.readTree(response.getBody());
		JsonNode choicesNode = rootNodeGpt.path("choices");
		Iterator<JsonNode> choicesIterator = choicesNode.elements();
		Integer totalScore = 0;
		Integer totalStar = 0;
		while (choicesIterator.hasNext()) {
			JsonNode choiceNode = choicesIterator.next();
			if (choiceNode.get("text") != null) {
				String text = choiceNode.get("text").asText();
				String strs[] = text.split("\n");
				for (String str : strs) {
					if (!str.equals("")) {
						String strs2[] = str.split(":");
						if (strs2.length == 2) {
							String skill = strs2[0].trim();
							String score = strs2[1].trim();
							if (score.equals("0")) {
								score = "1";
							}

							TbResumeSkill tbResumeSkill = new TbResumeSkill();
							tbResumeSkill.setTbrsCreateId(tbResume.getTbrCreateId());
							tbResumeSkill.setTbrsCreateDate(new Date());
							tbResumeSkill.setTbrsCreateIdc(tbResume.getTbrCreateIdc());
							tbResumeSkill.setTbrsStatus(TbResumeSkillRepository.Active);
							tbResumeSkill.setTbrsUuid(new Uid().generateString(5));
							tbResumeSkill.setTbrId(tbResume.getTbrId());
							tbResumeSkill.setTbrsType("hard_skill");
							tbResumeSkill.setTbrsName(skill.trim());
							tbResumeSkill.setTbrsScore(Integer.parseInt(score));

							lstTbResumeSkill.add(tbResumeSkill);

							totalScore += Integer.parseInt(score);
							if (Integer.parseInt(score) == 10) {
								totalStar++;
							}
						}
					}
				}
			}
		}

		// Save Skills
		tbResumeSkillRepository.deleteByTbrId(tbResume.getTbrId());
		tbResumeSkillRepository.saveAll(lstTbResumeSkill);

		tbResume.setTbrScore(totalScore);
		tbResume.setTbrStar(totalStar);
		tbResumeRepository.save(tbResume);
	}
	
	@Autowired
	private ObjectMapper objectMapper = new ObjectMapper();

	AtomicInteger threadRun0 = new AtomicInteger(0);
	AtomicInteger threadRun1 = new AtomicInteger(0);
	AtomicInteger threadRun2 = new AtomicInteger(0);
	AtomicInteger threadRun3 = new AtomicInteger(0);

	static Map<String, Integer> mapThreadRun = new HashMap<String, Integer>();
	int threadCount = 4;

	@Scheduled(fixedDelay = 1 * 1000)
	public void schedParseResume() throws Exception {
		List<TbResume> tbResumeList = tbResumeRepository.findParsePending();

		log.info("------------------------------------------------------------------");
		log.info("mapThreadRun : " + objectMapper.writeValueAsString(mapThreadRun));
		log.info("tbResumeList.size() : " + tbResumeList.size());
		log.info("threadRun0.get() : " + threadRun0.get());			
		log.info("threadRun1.get() : " + threadRun1.get());			
		log.info("threadRun2.get() : " + threadRun2.get());			
		log.info("threadRun3.get() : " + threadRun3.get());

		if (tbResumeList.size() > 0 && threadRun0.get() == 0) {			
			TbResume tbResume = tbResumeList.get(0);
			tbResumeList.remove(0);
			Thread t = new Thread(() -> {
				try {
					mapThreadRun.put("threadRun0Data", tbResume.getTbrId());
					log.info("------------------------------------------------------------------");
					log.info("tbResume.getTbrId() : " + tbResume.getTbrId());
					log.info("------------------------------------------------------------------");
					tbResume.setTbrStatus(TbResumeRepository.Parsing);
					tbResumeRepository.save(tbResume);					
					parseResume(tbResume, "3080");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					mapThreadRun.remove("threadRun0Data");
					threadRun0.getAndDecrement();
				}
			});
			t.start();
			threadRun0.getAndIncrement();		
		}

		if (tbResumeList.size() > 0 && threadRun1.get() == 0) {			
			TbResume tbResume = tbResumeList.get(0);
			tbResumeList.remove(0);
			Thread t = new Thread(() -> {
				try {
					mapThreadRun.put("threadRun1Data", tbResume.getTbrId());
					log.info("------------------------------------------------------------------");
					log.info("tbResume.getTbrId() : " + tbResume.getTbrId());
					log.info("------------------------------------------------------------------");
					tbResume.setTbrStatus(TbResumeRepository.Parsing);
					tbResumeRepository.save(tbResume);
					parseResume(tbResume, "3081");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					mapThreadRun.remove("threadRun1Data");
					threadRun1.getAndDecrement();
				}
			});
			t.start();
			threadRun1.getAndIncrement();		
		}

		if (tbResumeList.size() > 0 && threadRun2.get() == 0) {			
			TbResume tbResume = tbResumeList.get(0);
			tbResumeList.remove(0);
			Thread t = new Thread(() -> {
				try {
					mapThreadRun.put("threadRun2Data", tbResume.getTbrId());
					log.info("------------------------------------------------------------------");
					log.info("tbResume.getTbrId() : " + tbResume.getTbrId());
					log.info("------------------------------------------------------------------");
					tbResume.setTbrStatus(TbResumeRepository.Parsing);
					tbResumeRepository.save(tbResume);
					parseResume(tbResume, "3082");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					mapThreadRun.remove("threadRun2Data");
					threadRun2.getAndDecrement();
				}
			});
			t.start();
			threadRun2.getAndIncrement();		
		}

		if (tbResumeList.size() > 0 && threadRun3.get() == 0) {			
			TbResume tbResume = tbResumeList.get(0);
			tbResumeList.remove(0);
			Thread t = new Thread(() -> {
				try {
					mapThreadRun.put("threadRun3Data", tbResume.getTbrId());
					log.info("------------------------------------------------------------------");
					log.info("tbResume.getTbrId() : " + tbResume.getTbrId());
					log.info("------------------------------------------------------------------");
					tbResume.setTbrStatus(TbResumeRepository.Parsing);
					tbResumeRepository.save(tbResume);
					parseResume(tbResume, "3083");
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					mapThreadRun.remove("threadRun3Data");
					threadRun3.getAndDecrement();
				}
			});
			t.start();
			threadRun3.getAndIncrement();		
		}

		log.info("------------------------------------------------------------------");
	}
}
