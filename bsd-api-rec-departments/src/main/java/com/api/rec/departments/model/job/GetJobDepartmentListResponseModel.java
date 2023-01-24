package com.api.rec.departments.model.job;

import java.util.List;

import com.api.rec.departments.db.entity.ViewJobDepartment;
import com.api.rec.departments.model.ResponseModel;

public class GetJobDepartmentListResponseModel extends ResponseModel {
	
	public GetJobDepartmentListResponseModel(GetJobDepartmentListRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<ViewJobDepartment> lstViewJobDepartment;
	
	private Long length;

	public List<ViewJobDepartment> getLstViewJobDepartment() {
		return lstViewJobDepartment;
	}

	public void setLstViewJobDepartment(List<ViewJobDepartment> lstViewJobDepartment) {
		this.lstViewJobDepartment = lstViewJobDepartment;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
}
