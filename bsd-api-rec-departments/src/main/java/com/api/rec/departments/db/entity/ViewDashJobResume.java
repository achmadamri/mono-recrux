package com.api.rec.departments.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the view_dash_job_resume database table.
 * 
 */
@Entity
@Table(name="view_dash_job_resume")
@NamedQuery(name="ViewDashJobResume.findAll", query="SELECT t FROM ViewDashJobResume t")
public class ViewDashJobResume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String uuid;

	@Column(name="tbj_id")
	private Integer tbjId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbj_create_date")
	private Date tbjCreateDate;

	@Column(name="tbj_create_id")
	private Integer tbjCreateId;

	@Column(name="tbj_create_idc")
	private Integer tbjCreateIdc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbj_update_date")
	private Date tbjUpdateDate;

	@Column(name="tbj_update_id")
	private Integer tbjUpdateId;

	@Column(name="tbj_name")
	private String tbjName;

	@Column(name="tbj_uuid")
	private String tbjUuid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="first_tbr_create_date")
	private Date firstTbrCreateDate;

	@Column(columnDefinition = "bigint", name="tbr_create_date_count")
	private Integer tbrCreateDateCount;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getTbjId() {
		return tbjId;
	}

	public void setTbjId(Integer tbjId) {
		this.tbjId = tbjId;
	}

	public Date getTbjCreateDate() {
		return tbjCreateDate;
	}

	public void setTbjCreateDate(Date tbjCreateDate) {
		this.tbjCreateDate = tbjCreateDate;
	}

	public Integer getTbjCreateId() {
		return tbjCreateId;
	}

	public void setTbjCreateId(Integer tbjCreateId) {
		this.tbjCreateId = tbjCreateId;
	}

	public Integer getTbjCreateIdc() {
		return tbjCreateIdc;
	}

	public void setTbjCreateIdc(Integer tbjCreateIdc) {
		this.tbjCreateIdc = tbjCreateIdc;
	}

	public Date getTbjUpdateDate() {
		return tbjUpdateDate;
	}

	public void setTbjUpdateDate(Date tbjUpdateDate) {
		this.tbjUpdateDate = tbjUpdateDate;
	}

	public Integer getTbjUpdateId() {
		return tbjUpdateId;
	}

	public void setTbjUpdateId(Integer tbjUpdateId) {
		this.tbjUpdateId = tbjUpdateId;
	}

	public String getTbjName() {
		return tbjName;
	}

	public void setTbjName(String tbjName) {
		this.tbjName = tbjName;
	}

	public String getTbjUuid() {
		return tbjUuid;
	}

	public void setTbjUuid(String tbjUuid) {
		this.tbjUuid = tbjUuid;
	}

	public Date getFirstTbrCreateDate() {
		return firstTbrCreateDate;
	}

	public void setFirstTbrCreateDate(Date firstTbrCreateDate) {
		this.firstTbrCreateDate = firstTbrCreateDate;
	}

	public Integer getTbrCreateDateCount() {
		return tbrCreateDateCount;
	}

	public void setTbrCreateDateCount(Integer tbrCreateDateCount) {
		this.tbrCreateDateCount = tbrCreateDateCount;
	}
}