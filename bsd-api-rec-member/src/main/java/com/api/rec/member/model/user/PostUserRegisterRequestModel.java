package com.api.rec.member.model.user;

import com.api.rec.member.db.entity.TbUser;
import com.api.rec.member.model.RequestModel;

public class PostUserRegisterRequestModel extends RequestModel {
	private TbUser tbUser;

	private String agree;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}
	
}
