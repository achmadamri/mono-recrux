package com.api.rec.departments.model.department;

import com.api.rec.departments.db.entity.TbDepartment;
import com.api.rec.departments.model.RequestModel;

public class PostResumeRequestModel extends RequestModel {
	private TbDepartment tbDepartment;

	public TbDepartment getTbDepartment() {
		return tbDepartment;
	}

	public void setTbDepartment(TbDepartment tbDepartment) {
		this.tbDepartment = tbDepartment;
	}
}
