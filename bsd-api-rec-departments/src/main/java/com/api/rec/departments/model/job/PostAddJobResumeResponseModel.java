package com.api.rec.departments.model.job;

import com.api.rec.departments.db.entity.TbJobResume;
import com.api.rec.departments.model.ResponseModel;

public class PostAddJobResumeResponseModel extends ResponseModel {

	public PostAddJobResumeResponseModel(PostAddJobResumeRequestModel requestModel) {
		super(requestModel);
	}

	private TbJobResume tbJobResume;

	public TbJobResume getTbJobResume() {
		return tbJobResume;
	}

	public void setTbJobResume(TbJobResume tbJobResume) {
		this.tbJobResume = tbJobResume;
	}
}
