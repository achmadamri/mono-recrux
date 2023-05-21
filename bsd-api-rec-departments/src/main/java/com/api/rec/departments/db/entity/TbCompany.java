package com.api.rec.departments.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tb_company database table.
 * 
 */
@Entity
@Table(name="tb_company")
@NamedQuery(name="TbCompany.findAll", query="SELECT t FROM TbCompany t")
public class TbCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbc_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbcId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbc_create_date")
	private Date tbcCreateDate;

	@Column(name="tbc_create_id")
	private Integer tbcCreateId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbc_update_date")
	private Date tbcUpdateDate;

	@Column(name="tbc_update_id")
	private Integer tbcUpdateId;

	@Column(name="tbc_name")
	private String tbcName;

	@Column(name="tbc_parse")
	private Integer tbcParse;

	@Column(name="tbc_token")
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