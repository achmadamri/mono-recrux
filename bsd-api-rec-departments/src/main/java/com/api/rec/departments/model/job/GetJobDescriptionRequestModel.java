package com.api.rec.departments.model.job;

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.model.RequestModel;

public class GetJobDescriptionRequestModel extends RequestModel {
	private TbJob tbJob;

	public TbJob getTbJob() {
		return tbJob;
	}

	public void setTbJob(TbJob tbJob) {
		this.tbJob = tbJob;
	}
}
