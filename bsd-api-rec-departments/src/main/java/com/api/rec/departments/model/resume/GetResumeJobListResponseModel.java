package com.api.rec.departments.model.resume;

import java.util.List;

import com.api.rec.departments.db.entity.ViewResumeJob;
import com.api.rec.departments.model.ResponseModel;

public class GetResumeJobListResponseModel extends ResponseModel {
	
	public GetResumeJobListResponseModel(GetResumeJobListRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<ViewResumeJob> lstViewResumeJob;
	
	private Long length;

	public List<ViewResumeJob> getLstViewResumeJob() {
		return lstViewResumeJob;
	}

	public void setLstViewResumeJob(List<ViewResumeJob> lstViewResumeJob) {
		this.lstViewResumeJob = lstViewResumeJob;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
}
