package com.api.rec.resumescheduler.model.user;

import com.api.rec.resumescheduler.model.ResponseModel;

public class GetUserMenuListResponseModel extends ResponseModel {
	
	public GetUserMenuListResponseModel(GetUserMenuListRequestModel requestModel) {
		super(requestModel);
	}
	
	private Long length;

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
}
