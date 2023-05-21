package com.api.rec.departments.model.user;

import com.api.rec.departments.db.entity.TbCompany;
import com.api.rec.departments.model.RequestModel;

public class PostSyncCompanyRequestModel extends RequestModel {
	private TbCompany tbCompany;

	public TbCompany getTbCompany() {
		return tbCompany;
	}

	public void setTbCompany(TbCompany tbCompany) {
		this.tbCompany = tbCompany;
	}
}
