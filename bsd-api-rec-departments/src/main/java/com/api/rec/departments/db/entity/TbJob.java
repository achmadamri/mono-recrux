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
 * The persistent class for the tb_job database table.
 * 
 */
@Entity
@Table(name="tb_job")
@NamedQuery(name="TbJob.findAll", query="SELECT t FROM TbJob t")
public class TbJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbj_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbjId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbj_create_date")
	private Date tbjCreateDate;

	@Column(name="tbj_create_id")
	private Integer tbjCreateId;

	@Column(name="tbj_name")
	private String tbjName;

	@Column(name="tbj_status")
	private String tbjStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbj_update_date")
	private Date tbjUpdateDate;

	@Column(name="tbj_update_id")
	private Integer tbjUpdateId;

	public TbJob() {
	}

	public Integer getTbjId() {
		return this.tbjId;
	}

	public void setTbjId(Integer tbjId) {
		this.tbjId = tbjId;
	}

	public Date getTbjCreateDate() {
		return this.tbjCreateDate;
	}

	public void setTbjCreateDate(Date tbjCreateDate) {
		this.tbjCreateDate = tbjCreateDate;
	}

	public Integer getTbjCreateId() {
		return this.tbjCreateId;
	}

	public void setTbjCreateId(Integer tbjCreateId) {
		this.tbjCreateId = tbjCreateId;
	}

	public String getTbjName() {
		return this.tbjName;
	}

	public void setTbjName(String tbjName) {
		this.tbjName = tbjName;
	}

	public String getTbjStatus() {
		return this.tbjStatus;
	}

	public void setTbjStatus(String tbjStatus) {
		this.tbjStatus = tbjStatus;
	}

	public Date getTbjUpdateDate() {
		return this.tbjUpdateDate;
	}

	public void setTbjUpdateDate(Date tbjUpdateDate) {
		this.tbjUpdateDate = tbjUpdateDate;
	}

	public Integer getTbjUpdateId() {
		return this.tbjUpdateId;
	}

	public void setTbjUpdateId(Integer tbjUpdateId) {
		this.tbjUpdateId = tbjUpdateId;
	}

}