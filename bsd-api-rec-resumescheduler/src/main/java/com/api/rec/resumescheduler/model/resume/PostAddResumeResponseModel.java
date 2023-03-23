package com.api.rec.resumescheduler.model.resume;

import com.api.rec.resumescheduler.db.entity.TbResume;
import com.api.rec.resumescheduler.model.ResponseModel;

public class PostAddResumeResponseModel extends ResponseModel {

	public PostAddResumeResponseModel(PostAddResumeRequestModel requestModel) {
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
