package com.api.rec.member.model.user;

import com.api.rec.member.db.entity.TbUser;
import com.api.rec.member.db.entity.TbUserMenu;
import com.api.rec.member.model.ResponseModel;

public class PostUserAddResponseModel extends ResponseModel {

	public PostUserAddResponseModel(PostUserAddRequestModel requestModel) {
		super(requestModel);
	}

	private TbUser tbUser;
	
	private TbUserMenu tbUserMenu[];

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public TbUserMenu[] getTbUserMenu() {
		return tbUserMenu;
	}

	public void setTbUserMenu(TbUserMenu[] tbUserMenu) {
		this.tbUserMenu = tbUserMenu;
	}
}
