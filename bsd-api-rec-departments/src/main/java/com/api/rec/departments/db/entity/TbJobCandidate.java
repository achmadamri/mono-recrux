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
 * The persistent class for the tb_job_candidate database table.
 * 
 */
@Entity
@Table(name="tb_job_candidate")
@NamedQuery(name="TbJobCandidate.findAll", query="SELECT t FROM TbJobCandidate t")
public class TbJobCandidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbjc_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbjcId;

	@Column(name="tbc_id")
	private Integer tbcId;

	@Column(name="tbj_id")
	private Integer tbjId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbjc_create_date")
	private Date tbjcCreateDate;

	@Column(name="tbjc_create_id")
	private Integer tbjcCreateId;

	@Column(name="tbjc_status")
	private String tbjcStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbjc_update_date")
	private Date tbjcUpdateDate;

	@Column(name="tbjc_update_id")
	private Integer tbjcUpdateId;

	public TbJobCandidate() {
	}

	public Integer getTbjcId() {
		return this.tbjcId;
	}

	public void setTbjcId(Integer tbjcId) {
		this.tbjcId = tbjcId;
	}

	public Integer getTbcId() {
		return this.tbcId;
	}

	public void setTbcId(Integer tbcId) {
		this.tbcId = tbcId;
	}

	public Integer getTbjId() {
		return this.tbjId;
	}

	public void setTbjId(Integer tbjId) {
		this.tbjId = tbjId;
	}

	public Date getTbjcCreateDate() {
		return this.tbjcCreateDate;
	}

	public void setTbjcCreateDate(Date tbjcCreateDate) {
		this.tbjcCreateDate = tbjcCreateDate;
	}

	public Integer getTbjcCreateId() {
		return this.tbjcCreateId;
	}

	public void setTbjcCreateId(Integer tbjcCreateId) {
		this.tbjcCreateId = tbjcCreateId;
	}

	public String getTbjcStatus() {
		return this.tbjcStatus;
	}

	public void setTbjcStatus(String tbjcStatus) {
		this.tbjcStatus = tbjcStatus;
	}

	public Date getTbjcUpdateDate() {
		return this.tbjcUpdateDate;
	}

	public void setTbjcUpdateDate(Date tbjcUpdateDate) {
		this.tbjcUpdateDate = tbjcUpdateDate;
	}

	public Integer getTbjcUpdateId() {
		return this.tbjcUpdateId;
	}

	public void setTbjcUpdateId(Integer tbjcUpdateId) {
		this.tbjcUpdateId = tbjcUpdateId;
	}

}