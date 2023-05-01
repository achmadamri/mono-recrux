package com.api.rec.departments.model.job;

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.model.ResponseModel;

public class GetJobDescriptionResponseModel extends ResponseModel {

	public GetJobDescriptionResponseModel(GetJobDescriptionRequestModel requestModel) {
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
