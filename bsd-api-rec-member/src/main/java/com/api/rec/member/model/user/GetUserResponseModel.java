package com.api.rec.member.model.user;

import java.util.List;

import com.api.rec.member.db.entity.TbCompany;
import com.api.rec.member.db.entity.TbUser;
import com.api.rec.member.db.entity.ViewUserMenu;
import com.api.rec.member.model.ResponseModel;

public class GetUserResponseModel extends ResponseModel {
	
	public GetUserResponseModel(GetUserRequestModel requestModel) {
		super(requestModel);
	}
	
	private TbUser tbUser;
	
	private TbCompany tbCompany;
	
	private List<ViewUserMenu> lstViewUserMenu;
	
	public TbUser getTbUser() {
		return tbUser;
	}

	public List<ViewUserMenu> getLstViewUserMenu() {
		return lstViewUserMenu;
	}

	public void setLstViewUserMenu(List<ViewUserMenu> lstViewUserMenu) {
		this.lstViewUserMenu = lstViewUserMenu;
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
