package com.api.rec.resumescheduler.model.job;

import java.util.List;

import com.api.rec.resumescheduler.db.entity.TbJob;
import com.api.rec.resumescheduler.model.ResponseModel;

public class GetJobListResponseModel extends ResponseModel {
	
	public GetJobListResponseModel(GetJobListRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<TbJob> lstTbJob;
	
	private Long length;

	public List<TbJob> getLstTbJob() {
		return lstTbJob;
	}

	public void setLstTbJob(List<TbJob> lstTbJob) {
		this.lstTbJob = lstTbJob;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
}
