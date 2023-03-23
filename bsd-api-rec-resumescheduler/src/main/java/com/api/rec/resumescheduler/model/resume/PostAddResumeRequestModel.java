package com.api.rec.resumescheduler.model.resume;

import java.util.List;

import com.api.rec.resumescheduler.db.entity.TbResume;
import com.api.rec.resumescheduler.db.entity.TbResumeEducation;
import com.api.rec.resumescheduler.db.entity.TbResumeWorkExperience;
import com.api.rec.resumescheduler.model.RequestModel;

public class PostAddResumeRequestModel extends RequestModel {
	private TbResume tbResume;
	
	private List<TbResumeEducation> lstTbResumeEducation;
	
	private List<TbResumeWorkExperience> lstTbResumeWorkExperience;

	public TbResume getTbResume() {
		return tbResume;
	}

	public void setTbResume(TbResume tbResume) {
		this.tbResume = tbResume;
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
}
