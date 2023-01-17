package com.api.rec.departments.model.job;

import java.util.List;

import com.api.rec.departments.db.entity.ViewJobResume;
import com.api.rec.departments.model.ResponseModel;

public class GetJobResumeListResponseModel extends ResponseModel {
	
	public GetJobResumeListResponseModel(GetJobResumeListRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<ViewJobResume> lstViewJobResume;
	
	private Long length;

	public List<ViewJobResume> getLstViewJobResume() {
		return lstViewJobResume;
	}

	public void setLstViewJobResume(List<ViewJobResume> lstViewJobResume) {
		this.lstViewJobResume = lstViewJobResume;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
}
