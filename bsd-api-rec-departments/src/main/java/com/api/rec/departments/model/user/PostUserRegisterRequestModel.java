package com.api.rec.departments.model.user;

import com.api.rec.departments.db.entity.TbCompany;
import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.model.RequestModel;

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
