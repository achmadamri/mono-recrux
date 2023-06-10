package com.api.rec.departments.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbResume;
import com.api.rec.departments.db.entity.TbResumeCertification;
import com.api.rec.departments.db.entity.TbResumeEducation;
import com.api.rec.departments.db.entity.TbResumeSkill;
import com.api.rec.departments.db.entity.TbResumeWorkExperience;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.repository.TbCompanyRepository;
import com.api.rec.departments.db.repository.TbResumeCertificationRepository;
import com.api.rec.departments.db.repository.TbResumeEducationRepository;
import com.api.rec.departments.db.repository.TbResumeSkillRepository;
import com.api.rec.departments.db.repository.TbResumeWorkExperienceRepository;
import com.api.rec.departments.db.repository.TbUserRepository;
import com.api.rec.departments.model.resume.GetResumeRequestModel;
import com.api.rec.departments.model.resume.GetResumeResponseModel;
import com.api.rec.departments.util.TokenUtil;

@Service
public class DashboardService {

	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private Environment env;
	
	private TokenUtil tokenUtil = new TokenUtil();
	
	@Autowired
	private TbUserRepository tbUserRepository;
	
	@Autowired
	private TbCompanyRepository tbCompanyRepository;

	public GetResumeResponseModel getResume(String tbjUuid, GetResumeRequestModel requestModel) throws Exception {
		GetResumeResponseModel responseModel = new GetResumeResponseModel(requestModel);
		
		tokenUtil.claims(requestModel);
		
		TbUser exampleTbUser = new TbUser();
		exampleTbUser.setTbuEmail(requestModel.getEmail());
		exampleTbUser.setTbuStatus(TbUserRepository.Active);
		Optional<TbUser> optTbUser = tbUserRepository.findOne(Example.of(exampleTbUser));
		
		if (optTbUser.isPresent()) {
			// TbResume exampleTbResume = new TbResume();
			// exampleTbResume.setTbrUuid(tbjUuid);
			// exampleTbResume.setTbrCreateId(optTbUser.get().getTbuCreateId());
			// Optional<TbResume> optTbResume = tbResumeRepository.findOne(Example.of(exampleTbResume));					
			
			// if (optTbResume.isPresent()) {
			// 	TbResumeCertification exampleTbResumeCertification = new TbResumeCertification();
			// 	exampleTbResumeCertification.setTbrId(optTbResume.get().getTbrId());
			// 	exampleTbResumeCertification.setTbrcStatus(TbResumeCertificationRepository.Active);
			// 	List<TbResumeCertification> tbResumeCertifications = tbResumeCertificationRepository.findAll(Example.of(exampleTbResumeCertification));

			// 	TbResumeEducation exampleTbResumeEducation = new TbResumeEducation();
			// 	exampleTbResumeEducation.setTbrId(optTbResume.get().getTbrId());
			// 	exampleTbResumeEducation.setTbreStatus(TbResumeEducationRepository.Active);
			// 	List<TbResumeEducation> tbResumeEducations = tbResumeEducationRepository.findAll(Example.of(exampleTbResumeEducation));

			// 	TbResumeSkill exampleTbResumeSkill = new TbResumeSkill();
			// 	exampleTbResumeSkill.setTbrId(optTbResume.get().getTbrId());
			// 	exampleTbResumeSkill.setTbrsStatus(TbResumeSkillRepository.Active);
			// 	exampleTbResumeSkill.setTbrsType("hard_skill");				
			// 	List<TbResumeSkill> tbResumeSkillsHard = tbResumeSkillRepository.findAll(Example.of(exampleTbResumeSkill), Sort.by(Sort.Direction.DESC, "tbrsScore"));

			// 	exampleTbResumeSkill = new TbResumeSkill();
			// 	exampleTbResumeSkill.setTbrId(optTbResume.get().getTbrId());
			// 	exampleTbResumeSkill.setTbrsStatus(TbResumeSkillRepository.Active);
			// 	exampleTbResumeSkill.setTbrsType("soft_skill");				
			// 	List<TbResumeSkill> tbResumeSkillsSoft = tbResumeSkillRepository.findAll(Example.of(exampleTbResumeSkill), Sort.by(Sort.Direction.DESC, "tbrsScore"));

			// 	TbResumeWorkExperience exampleTbResumeWorkExperience = new TbResumeWorkExperience();
			// 	exampleTbResumeWorkExperience.setTbrId(optTbResume.get().getTbrId());
			// 	exampleTbResumeWorkExperience.setTbrweStatus(TbResumeWorkExperienceRepository.Active);
			// 	List<TbResumeWorkExperience> tbResumeWorkExperiences = tbResumeWorkExperienceRepository.findAll(Example.of(exampleTbResumeWorkExperience));
			// 	tbResumeWorkExperiences.forEach(tbResumeWorkExperience -> {
			// 		if (tbResumeWorkExperience.getTbrweStartDate() != null) tbResumeWorkExperience.setTbrweStart(new SimpleDateFormat("yyyy-MM-dd").format(tbResumeWorkExperience.getTbrweStartDate()));
			// 		if (tbResumeWorkExperience.getTbrweEndDate() != null) tbResumeWorkExperience.setTbrweEnd(new SimpleDateFormat("yyyy-MM-dd").format(tbResumeWorkExperience.getTbrweEndDate()));
			// 	});

			// 	if (optTbResume.get().getTbjId() != null) {
			// 		TbJob exampleTbJob = new TbJob();
			// 		exampleTbJob.setTbjId(optTbResume.get().getTbjId());
			// 		Optional<TbJob> optTbJob = tbJobRepository.findOne(Example.of(exampleTbJob));
			// 		responseModel.setTbJob(optTbJob.get());
			// 	} else {
			// 		responseModel.setTbJob(new TbJob());
			// 	}

			// 	responseModel.setLstTbResumeCertification(tbResumeCertifications);
			// 	responseModel.setLstTbResumeEducation(tbResumeEducations);
			// 	responseModel.setLstTbResumeSkillHard(tbResumeSkillsHard);
			// 	responseModel.setLstTbResumeSkillSoft(tbResumeSkillsSoft);
			// 	responseModel.setLstTbResumeWorkExperience(tbResumeWorkExperiences);				
			// 	responseModel.setTbResume(optTbResume.get());				
				
			// 	responseModel.setHttpStatus(HttpStatus.OK);
			// } else {
			// 	responseModel.setHttpStatus(HttpStatus.NOT_FOUND);
			// }
		} else {
			responseModel.setHttpStatus(HttpStatus.UNAUTHORIZED);
		}
		
		return responseModel;
	}
}
