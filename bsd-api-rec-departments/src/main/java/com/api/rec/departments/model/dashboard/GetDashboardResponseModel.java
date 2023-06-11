package com.api.rec.departments.model.dashboard;

import java.util.List;

import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.entity.ViewDashJobResume;
import com.api.rec.departments.model.ResponseModel;

public class GetDashboardResponseModel extends ResponseModel {

	public GetDashboardResponseModel(GetDashboardRequestModel requestModel) {
		super(requestModel);
	}

	private TbUser tbUser;

	private String parseLimit;

	private String token;

	private String totalJob;

	private String totalResume;

	private List<ViewDashJobResume> lstViewDashJobResume;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public String getParseLimit() {
		return parseLimit;
	}

	public void setParseLimit(String parseLimit) {
		this.parseLimit = parseLimit;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTotalJob() {
		return totalJob;
	}

	public void setTotalJob(String totalJob) {
		this.totalJob = totalJob;
	}

	public String getTotalResume() {
		return totalResume;
	}

	public void setTotalResume(String totalResume) {
		this.totalResume = totalResume;
	}

	public List<ViewDashJobResume> getLstViewDashJobResume() {
		return lstViewDashJobResume;
	}

	public void setLstViewDashJobResume(List<ViewDashJobResume> lstViewDashJobResume) {
		this.lstViewDashJobResume = lstViewDashJobResume;
	}
}
