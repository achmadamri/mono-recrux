package com.api.rec.departments.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_job_resume database table.
 * 
 */
@Entity
@Table(name="tb_job_resume")
@NamedQuery(name="TbJobResume.findAll", query="SELECT t FROM TbJobResume t")
public class TbJobResume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbjr_id")
	private Integer tbjrId;

	@Column(name="tbj_id")
	private Integer tbjId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbjr_create_date")
	private Date tbjrCreateDate;

	@Column(name="tbjr_create_id")
	private Integer tbjrCreateId;

	@Column(name="tbjr_create_idc")
	private Integer tbjrCreateIdc;

	@Column(name="tbjr_status")
	private String tbjrStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbjr_update_date")
	private Date tbjrUpdateDate;

	@Column(name="tbjr_update_id")
	private Integer tbjrUpdateId;

	@Column(name="tbjr_uuid")
	private String tbjrUuid;

	@Column(name="tbr_id")
	private Integer tbrId;

	public TbJobResume() {
	}

	public Integer getTbjrId() {
		return this.tbjrId;
	}

	public void setTbjrId(Integer tbjrId) {
		this.tbjrId = tbjrId;
	}

	public Integer getTbjId() {
		return this.tbjId;
	}

	public void setTbjId(Integer tbjId) {
		this.tbjId = tbjId;
	}

	public Date getTbjrCreateDate() {
		return this.tbjrCreateDate;
	}

	public void setTbjrCreateDate(Date tbjrCreateDate) {
		this.tbjrCreateDate = tbjrCreateDate;
	}

	public Integer getTbjrCreateId() {
		return this.tbjrCreateId;
	}

	public void setTbjrCreateId(Integer tbjrCreateId) {
		this.tbjrCreateId = tbjrCreateId;
	}

	public Integer getTbjrCreateIdc() {
		return this.tbjrCreateIdc;
	}

	public void setTbjrCreateIdc(Integer tbjrCreateIdc) {
		this.tbjrCreateIdc = tbjrCreateIdc;
	}

	public String getTbjrStatus() {
		return this.tbjrStatus;
	}

	public void setTbjrStatus(String tbjrStatus) {
		this.tbjrStatus = tbjrStatus;
	}

	public Date getTbjrUpdateDate() {
		return this.tbjrUpdateDate;
	}

	public void setTbjrUpdateDate(Date tbjrUpdateDate) {
		this.tbjrUpdateDate = tbjrUpdateDate;
	}

	public Integer getTbjrUpdateId() {
		return this.tbjrUpdateId;
	}

	public void setTbjrUpdateId(Integer tbjrUpdateId) {
		this.tbjrUpdateId = tbjrUpdateId;
	}

	public String getTbjrUuid() {
		return this.tbjrUuid;
	}

	public void setTbjrUuid(String tbjrUuid) {
		this.tbjrUuid = tbjrUuid;
	}

	public Integer getTbrId() {
		return this.tbrId;
	}

	public void setTbrId(Integer tbrId) {
		this.tbrId = tbrId;
	}

}