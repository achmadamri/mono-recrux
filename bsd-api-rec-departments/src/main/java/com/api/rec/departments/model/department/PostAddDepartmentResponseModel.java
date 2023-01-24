package com.api.rec.departments.model.department;

import com.api.rec.departments.db.entity.TbDepartment;
import com.api.rec.departments.model.ResponseModel;

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
