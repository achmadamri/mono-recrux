package com.api.rec.departments.model.resume;

import java.util.List;

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbResume;
import com.api.rec.departments.db.entity.TbResumeCertification;
import com.api.rec.departments.db.entity.TbResumeEducation;
import com.api.rec.departments.db.entity.TbResumeSkill;
import com.api.rec.departments.db.entity.TbResumeWorkExperience;
import com.api.rec.departments.model.ResponseModel;

public class GetResumeResponseModel extends ResponseModel {

	public GetResumeResponseModel(GetResumeRequestModel requestModel) {
		super(requestModel);
	}

	private TbJob tbJob;

	private TbResume tbResume;

	private List<TbResumeSkill> lstTbResumeSkillHard;

	private List<TbResumeSkill> lstTbResumeSkillSoft;

	private List<TbResumeEducation> lstTbResumeEducation;

	private List<TbResumeWorkExperience> lstTbResumeWorkExperience;

	private List<TbResumeCertification> lstTbResumeCertification;

	public TbJob getTbJob() {
		return tbJob;
	}

	public void setTbJob(TbJob tbJob) {
		this.tbJob = tbJob;
	}

	public TbResume getTbResume() {
		return tbResume;
	}

	public void setTbResume(TbResume tbResume) {
		this.tbResume = tbResume;
	}

	public List<TbResumeSkill> getLstTbResumeSkillHard() {
		return lstTbResumeSkillHard;
	}

	public void setLstTbResumeSkillHard(List<TbResumeSkill> lstTbResumeSkillHard) {
		this.lstTbResumeSkillHard = lstTbResumeSkillHard;
	}

	public List<TbResumeSkill> getLstTbResumeSkillSoft() {
		return lstTbResumeSkillSoft;
	}

	public void setLstTbResumeSkillSoft(List<TbResumeSkill> lstTbResumeSkillSoft) {
		this.lstTbResumeSkillSoft = lstTbResumeSkillSoft;
	}

	public List<TbResumeEducation> getLstTbResumeEducation() {
		return lstTbResumeEducation;
	}

	public void setLstTbResumeEducation(List<TbResumeEducation> lstTbResumeEducation) {
		this.lstTbResumeEducation = lstTbResumeEducation;
	}

	public List<TbResumeWorkExperience> getLstTbResumeWorkExperience() {
		return lstTbResumeWorkExperience;
	}

	public void setLstTbResumeWorkExperience(List<TbResumeWorkExperience> lstTbResumeWorkExperience) {
		this.lstTbResumeWorkExperience = lstTbResumeWorkExperience;
	}

	public List<TbResumeCertification> getLstTbResumeCertification() {
		return lstTbResumeCertification;
	}

	public void setLstTbResumeCertification(List<TbResumeCertification> lstTbResumeCertification) {
		this.lstTbResumeCertification = lstTbResumeCertification;
	}	
}
