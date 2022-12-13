package com.api.rec.member.model.user;

import java.util.List;

import com.api.rec.member.db.entity.TbUser;
import com.api.rec.member.db.entity.ViewUserMenu;
import com.api.rec.member.model.RequestModel;

public class PostUserEditRequestModel extends RequestModel {
	private TbUser tbUser;

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
}
