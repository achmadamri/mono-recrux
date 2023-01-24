package com.api.rec.departments.model.job;

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.db.entity.TbJobResume;
import com.api.rec.departments.db.entity.TbResume;
import com.api.rec.departments.model.RequestModel;

public class PostAddJobResumeRequestModel extends RequestModel {
	private TbJob tbJob;

	private TbResume tbResume;

	private TbJobResume tbJobResume;

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

	public TbJobResume getTbJobResume() {
		return tbJobResume;
	}

	public void setTbJobResume(TbJobResume tbJobResume) {
		this.tbJobResume = tbJobResume;
	}
}
