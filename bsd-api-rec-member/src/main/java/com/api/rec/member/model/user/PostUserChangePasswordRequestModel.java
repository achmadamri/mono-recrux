package com.api.rec.member.model.user;

import com.api.rec.member.db.entity.TbUser;
import com.api.rec.member.model.RequestModel;

public class PostUserChangePasswordRequestModel extends RequestModel {
	private TbUser tbUser;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}
}
