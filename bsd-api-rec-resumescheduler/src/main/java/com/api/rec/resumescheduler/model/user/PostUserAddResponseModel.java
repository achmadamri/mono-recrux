package com.api.rec.resumescheduler.model.user;

import com.api.rec.resumescheduler.db.entity.TbUser;
import com.api.rec.resumescheduler.model.ResponseModel;

public class PostUserAddResponseModel extends ResponseModel {

	public PostUserAddResponseModel(PostUserAddRequestModel requestModel) {
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
