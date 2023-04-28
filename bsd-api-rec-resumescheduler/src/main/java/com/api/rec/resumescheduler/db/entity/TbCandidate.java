package com.api.rec.resumescheduler.db.entity;

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
 * The persistent class for the tb_candidate database table.
 * 
 */
@Entity
@Table(name="tb_candidate")
@NamedQuery(name="TbCandidate.findAll", query="SELECT t FROM TbCandidate t")
public class TbCandidate implements Serializable {
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

	@Column(name="tbc_name")
	private String tbcName;

	@Column(name="tbc_status")
	private String tbcStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbc_update_date")
	private Date tbcUpdateDate;

	@Column(name="tbc_update_id")
	private Integer tbcUpdateId;

	public TbCandidate() {
	}

	public Integer getTbcId() {
		return this.tbcId;
	}

	public void setTbcId(Integer tbcId) {
		this.tbcId = tbcId;
	}

	public Date getTbcCreateDate() {
		return this.tbcCreateDate;
	}

	public void setTbcCreateDate(Date tbcCreateDate) {
		this.tbcCreateDate = tbcCreateDate;
	}

	public Integer getTbcCreateId() {
		return this.tbcCreateId;
	}

	public void setTbcCreateId(Integer tbcCreateId) {
		this.tbcCreateId = tbcCreateId;
	}

	public String getTbcName() {
		return this.tbcName;
	}

	public void setTbcName(String tbcName) {
		this.tbcName = tbcName;
	}

	public String getTbcStatus() {
		return this.tbcStatus;
	}

	public void setTbcStatus(String tbcStatus) {
		this.tbcStatus = tbcStatus;
	}

	public Date getTbcUpdateDate() {
		return this.tbcUpdateDate;
	}

	public void setTbcUpdateDate(Date tbcUpdateDate) {
		this.tbcUpdateDate = tbcUpdateDate;
	}

	public Integer getTbcUpdateId() {
		return this.tbcUpdateId;
	}

	public void setTbcUpdateId(Integer tbcUpdateId) {
		this.tbcUpdateId = tbcUpdateId;
	}

}