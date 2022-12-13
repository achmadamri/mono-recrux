package com.api.rec.member.model.user;

import java.util.List;

import com.api.rec.member.db.entity.ViewUserMenu;
import com.api.rec.member.model.ResponseModel;

public class GetUserMenuListResponseModel extends ResponseModel {
	
	public GetUserMenuListResponseModel(GetUserMenuListRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<ViewUserMenu> lstViewUserMenu;
	
	private Long length;

	public List<ViewUserMenu> getLstViewUserMenu() {
		return lstViewUserMenu;
	}

	public void setLstViewUserMenu(List<ViewUserMenu> lstViewUserMenu) {
		this.lstViewUserMenu = lstViewUserMenu;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
}
