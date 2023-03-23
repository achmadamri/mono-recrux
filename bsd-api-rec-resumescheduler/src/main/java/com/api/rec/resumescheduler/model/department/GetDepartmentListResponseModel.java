package com.api.rec.resumescheduler.model.department;

import java.util.List;

import com.api.rec.resumescheduler.db.entity.TbDepartment;
import com.api.rec.resumescheduler.model.ResponseModel;

public class GetDepartmentListResponseModel extends ResponseModel {
	
	public GetDepartmentListResponseModel(GetDepartmentListRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<TbDepartment> lstTbDepartment;
	
	private Long length;

	public List<TbDepartment> getLstTbDepartment() {
		return lstTbDepartment;
	}

	public void setLstTbDepartment(List<TbDepartment> lstTbDepartment) {
		this.lstTbDepartment = lstTbDepartment;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
}
