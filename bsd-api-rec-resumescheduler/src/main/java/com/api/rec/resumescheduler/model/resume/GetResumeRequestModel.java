package com.api.rec.resumescheduler.model.resume;

import com.api.rec.resumescheduler.db.entity.TbResume;
import com.api.rec.resumescheduler.model.RequestModel;

public class GetResumeRequestModel extends RequestModel {
	private TbResume tbResume;

	public TbResume getTbResume() {
		return tbResume;
	}

	public void setTbResume(TbResume tbResume) {
		this.tbResume = tbResume;
	}
}
