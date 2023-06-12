package com.api.rec.member.model.departments;

import com.api.rec.member.model.RequestModel;

public class PostUserRegisterRequestModel extends RequestModel {
	private TbUser tbUser;

	private TbCompany tbCompany;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public TbCompany getTbCompany() {
		return tbCompany;
	}

	public void setTbCompany(TbCompany tbCompany) {
		this.tbCompany = tbCompany;
	}
}
