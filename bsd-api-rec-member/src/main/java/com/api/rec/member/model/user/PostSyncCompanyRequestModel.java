package com.api.rec.member.model.user;

import com.api.rec.member.db.entity.TbCompany;
import com.api.rec.member.model.RequestModel;

public class PostSyncCompanyRequestModel extends RequestModel {
	private TbCompany tbCompany;

	public TbCompany getTbCompany() {
		return tbCompany;
	}

	public void setTbCompany(TbCompany tbCompany) {
		this.tbCompany = tbCompany;
	}
}
