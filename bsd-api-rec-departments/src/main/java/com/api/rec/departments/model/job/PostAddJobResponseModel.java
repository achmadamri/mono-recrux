package com.api.rec.departments.model.job;

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.model.ResponseModel;

public class PostAddJobResponseModel extends ResponseModel {

	public PostAddJobResponseModel(PostAddJobRequestModel requestModel) {
		super(requestModel);
	}

	private TbJob tbJob;

	public TbJob getTbJob() {
		return tbJob;
	}

	public void setTbJob(TbJob tbJob) {
		this.tbJob = tbJob;
	}
}
