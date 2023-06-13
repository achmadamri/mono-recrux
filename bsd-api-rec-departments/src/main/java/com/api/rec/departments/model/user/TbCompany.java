package com.api.rec.departments.model.user;

import java.io.Serializable;
import java.util.Date;

public class TbCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tbcId;

	private Date tbcCreateDate;

	private Integer tbcCreateId;

	private Date tbcUpdateDate;

	private Integer tbcUpdateId;

	private String tbcName;

	private Integer tbcParse;

	private Integer tbcToken;

	public TbCompany() {
	}

	public Integer getTbcId() {
		return tbcId;
	}

	public void setTbcId(Integer tbcId) {
		this.tbcId = tbcId;
	}

	public Date getTbcCreateDate() {
		return tbcCreateDate;
	}

	public void setTbcCreateDate(Date tbcCreateDate) {
		this.tbcCreateDate = tbcCreateDate;
	}

	public Integer getTbcCreateId() {
		return tbcCreateId;
	}

	public void setTbcCreateId(Integer tbcCreateId) {
		this.tbcCreateId = tbcCreateId;
	}

	public Date getTbcUpdateDate() {
		return tbcUpdateDate;
	}

	public void setTbcUpdateDate(Date tbcUpdateDate) {
		this.tbcUpdateDate = tbcUpdateDate;
	}

	public Integer getTbcUpdateId() {
		return tbcUpdateId;
	}

	public void setTbcUpdateId(Integer tbcUpdateId) {
		this.tbcUpdateId = tbcUpdateId;
	}

	public String getTbcName() {
		return tbcName;
	}

	public void setTbcName(String tbcName) {
		this.tbcName = tbcName;
	}

	public Integer getTbcParse() {
		return tbcParse;
	}

	public void setTbcParse(Integer tbcParse) {
		this.tbcParse = tbcParse;
	}

	public Integer getTbcToken() {
		return tbcToken;
	}

	public void setTbcToken(Integer tbcToken) {
		this.tbcToken = tbcToken;
	}
}