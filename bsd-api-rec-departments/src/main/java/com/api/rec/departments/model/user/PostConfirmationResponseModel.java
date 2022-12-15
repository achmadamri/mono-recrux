package com.api.rec.departments.model.user;

import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.model.ResponseModel;

public class PostConfirmationResponseModel extends ResponseModel {
	
	public PostConfirmationResponseModel(PostConfirmationRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUser tbUsers;

	public TbUser getTbUsers() {
		return tbUsers;
	}

	public void setTbUsers(TbUser tbUsers) {
		this.tbUsers = tbUsers;
	}
}
