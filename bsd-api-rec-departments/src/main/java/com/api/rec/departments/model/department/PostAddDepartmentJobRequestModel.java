package com.api.rec.departments.model.department;

import com.api.rec.departments.db.entity.TbDepartmentJob;
import com.api.rec.departments.model.RequestModel;

public class PostAddDepartmentJobRequestModel extends RequestModel {
	private TbDepartmentJob tbDepartmentJob;

	public TbDepartmentJob getTbDepartmentJob() {
		return tbDepartmentJob;
	}

	public void setTbDepartmentJob(TbDepartmentJob tbDepartmentJob) {
		this.tbDepartmentJob = tbDepartmentJob;
	}
}
