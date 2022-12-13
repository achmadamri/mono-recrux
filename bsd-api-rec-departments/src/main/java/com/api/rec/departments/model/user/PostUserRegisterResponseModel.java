package com.api.rec.departments.model.user;

import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.model.ResponseModel;

public class PostUserRegisterResponseModel extends ResponseModel {

	public PostUserRegisterResponseModel(PostUserRegisterRequestModel requestModel) {
		super(requestModel);
	}

	private TbUser tbUser;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}
}
