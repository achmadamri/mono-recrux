package com.api.rec.resumescheduler.model.department;

import com.api.rec.resumescheduler.db.entity.TbDepartment;
import com.api.rec.resumescheduler.model.ResponseModel;

public class PostAddDepartmentResponseModel extends ResponseModel {

	public PostAddDepartmentResponseModel(PostAddDepartmentRequestModel requestModel) {
		super(requestModel);
	}

	private TbDepartment tbDepartment;

	public TbDepartment getTbDepartment() {
		return tbDepartment;
	}

	public void setTbDepartment(TbDepartment tbDepartment) {
		this.tbDepartment = tbDepartment;
	}
}
