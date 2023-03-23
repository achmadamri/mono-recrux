package com.api.rec.resumescheduler.model.job;

import com.api.rec.resumescheduler.db.entity.TbJob;
import com.api.rec.resumescheduler.model.RequestModel;

public class GetJobRequestModel extends RequestModel {
	private TbJob tbJob;

	public TbJob getTbJob() {
		return tbJob;
	}

	public void setTbJob(TbJob tbJob) {
		this.tbJob = tbJob;
	}
}
