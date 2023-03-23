package com.api.rec.resumescheduler.model.resume;

import com.api.rec.resumescheduler.db.entity.TbResume;
import com.api.rec.resumescheduler.model.ResponseModel;

public class PostParseResumeResponseModel extends ResponseModel {
	
	public PostParseResumeResponseModel(PostParseResumeRequestModel requestModel) {
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
