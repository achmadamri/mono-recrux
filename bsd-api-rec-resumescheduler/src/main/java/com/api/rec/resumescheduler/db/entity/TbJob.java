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

	@Column(name="tbj_create_idc")
	private Integer tbjCreateIdc;

	@Column(name="tbj_uuid")
	private String tbjUuid;

	@Column(name="tbd_id")
	private Integer tbdId;

	@Column(name="tbj_assigned")
	private String tbjAssigned;

	public TbJob() {
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

	public String getTbjName() {
		return tbjName;
	}

	public void setTbjName(String tbjName) {
		this.tbjName = tbjName;
	}

	public String getTbjStatus() {
		return tbjStatus;
	}

	public void setTbjStatus(String tbjStatus) {
		this.tbjStatus = tbjStatus;
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

	public Integer getTbjCreateIdc() {
		return tbjCreateIdc;
	}

	public void setTbjCreateIdc(Integer tbjCreateIdc) {
		this.tbjCreateIdc = tbjCreateIdc;
	}

	public String getTbjUuid() {
		return tbjUuid;
	}

	public void setTbjUuid(String tbjUuid) {
		this.tbjUuid = tbjUuid;
	}

	public Integer getTbdId() {
		return tbdId;
	}

	public void setTbdId(Integer tbdId) {
		this.tbdId = tbdId;
	}

	public String getTbjAssigned() {
		return tbjAssigned;
	}

	public void setTbjAssigned(String tbjAssigned) {
		this.tbjAssigned = tbjAssigned;
	}

}