package com.api.rec.departments.model.job;

import java.util.List;

import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.model.ResponseModel;

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
