package com.api.rec.departments.model.department;

import com.api.rec.departments.db.entity.TbDepartmentJob;
import com.api.rec.departments.model.ResponseModel;

public class PostAddDepartmentJobResponseModel extends ResponseModel {

	public PostAddDepartmentJobResponseModel(PostAddDepartmentJobRequestModel requestModel) {
		super(requestModel);
	}

	private TbDepartmentJob tbDepartmentJob;

	public TbDepartmentJob getTbDepartmentJob() {
		return tbDepartmentJob;
	}

	public void setTbDepartmentJob(TbDepartmentJob tbDepartmentJob) {
		this.tbDepartmentJob = tbDepartmentJob;
	}
}
