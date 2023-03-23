package com.api.rec.resumescheduler.model.department;

import com.api.rec.resumescheduler.db.entity.TbDepartment;
import com.api.rec.resumescheduler.model.RequestModel;

public class GetDepartmentRequestModel extends RequestModel {
	private TbDepartment tbDepartment;

	public TbDepartment getTbDepartment() {
		return tbDepartment;
	}

	public void setTbDepartment(TbDepartment tbDepartment) {
		this.tbDepartment = tbDepartment;
	}
}
