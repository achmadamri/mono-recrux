package com.api.rec.departments.model.department;

import com.api.rec.departments.db.entity.TbDepartment;
import com.api.rec.departments.db.entity.TbDepartmentJob;
import com.api.rec.departments.db.entity.TbJob;
import com.api.rec.departments.model.RequestModel;

public class PostAddDepartmentJobRequestModel extends RequestModel {
	private TbDepartmentJob tbDepartmentJob;

	private TbDepartment tbDepartment;

	private TbJob tbJob;

	public TbDepartmentJob getTbDepartmentJob() {
		return tbDepartmentJob;
	}

	public void setTbDepartmentJob(TbDepartmentJob tbDepartmentJob) {
		this.tbDepartmentJob = tbDepartmentJob;
	}

	public TbDepartment getTbDepartment() {
		return tbDepartment;
	}

	public void setTbDepartment(TbDepartment tbDepartment) {
		this.tbDepartment = tbDepartment;
	}

	public TbJob getTbJob() {
		return tbJob;
	}

	public void setTbJob(TbJob tbJob) {
		this.tbJob = tbJob;
	}
}
