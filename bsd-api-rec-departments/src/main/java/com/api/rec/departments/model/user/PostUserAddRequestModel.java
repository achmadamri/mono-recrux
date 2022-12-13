package com.api.rec.departments.model.user;

import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.model.RequestModel;

public class PostUserAddRequestModel extends RequestModel {
	private TbUser tbUser;
	
	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}
}
