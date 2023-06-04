package com.api.rec.departments.model.job;

import com.api.rec.departments.db.entity.TbResume;
import com.api.rec.departments.model.ResponseModel;

public class GetJobQuestionResponseModel extends ResponseModel {

	public GetJobQuestionResponseModel(GetJobQuestionRequestModel requestModel) {
		super(requestModel);
	}

	private TbResume tbResume;

	public TbResume getTbResume() {
		return tbResume;
	}

	public void setTbResume(TbResume tbResume) {
		this.tbResume = tbResume;
	}
}
