package com.api.rec.member.model.departments;

import com.api.rec.member.db.entity.TbUser;
import com.api.rec.member.model.ResponseModel;

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
