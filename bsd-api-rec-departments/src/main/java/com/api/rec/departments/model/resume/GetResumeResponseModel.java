package com.api.rec.departments.model.resume;

import com.api.rec.departments.db.entity.TbResume;
import com.api.rec.departments.model.ResponseModel;

public class GetResumeResponseModel extends ResponseModel {

	public GetResumeResponseModel(GetResumeRequestModel requestModel) {
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
