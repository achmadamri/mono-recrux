package com.api.rec.departments.model.dashboard;

import java.util.List;

import com.api.rec.departments.db.entity.TbUser;
import com.api.rec.departments.db.entity.ViewDashJobCompletion;
import com.api.rec.departments.db.entity.ViewDashJobFill;
import com.api.rec.departments.model.ResponseModel;

public class GetDashboardResponseModel extends ResponseModel {

	public GetDashboardResponseModel(GetDashboardRequestModel requestModel) {
		super(requestModel);
	}

	private TbUser tbUser;

	private Integer parseLimit;

	private Integer token;

	private Long totalJob;

	private Long totalResume;

	private List<ViewDashJobFill> lstViewDashJobFill;

	private List<ViewDashJobCompletion> lstViewDashJobCompletion;

	public TbUser getTbUser() {
		return tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}

	public Integer getParseLimit() {
		return parseLimit;
	}

	public void setParseLimit(Integer parseLimit) {
		this.parseLimit = parseLimit;
	}

	public Integer getToken() {
		return token;
	}

	public void setToken(Integer token) {
		this.token = token;
	}

	public Long getTotalJob() {
		return totalJob;
	}

	public void setTotalJob(Long totalJob) {
		this.totalJob = totalJob;
	}

	public Long getTotalResume() {
		return totalResume;
	}

	public void setTotalResume(Long totalResume) {
		this.totalResume = totalResume;
	}

	public List<ViewDashJobFill> getLstViewDashJobFill() {
		return lstViewDashJobFill;
	}

	public void setLstViewDashJobFill(List<ViewDashJobFill> lstViewDashJobFill) {
		this.lstViewDashJobFill = lstViewDashJobFill;
	}

	public List<ViewDashJobCompletion> getLstViewDashJobCompletion() {
		return lstViewDashJobCompletion;
	}

	public void setLstViewDashJobCompletion(List<ViewDashJobCompletion> lstViewDashJobCompletion) {
		this.lstViewDashJobCompletion = lstViewDashJobCompletion;
	}
}
