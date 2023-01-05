package com.api.rec.departments.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the view_job_department database table.
 * 
 */
@Entity
@Table(name="view_job_department")
@NamedQuery(name="ViewJobDepartment.findAll", query="SELECT v FROM ViewJobDepartment v")
public class ViewJobDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbd_create_date")
	private Date tbdCreateDate;

	@Column(name="tbd_create_id")
	private Integer tbdCreateId;

	@Column(name="tbd_create_idc")
	private Integer tbdCreateIdc;

	@Column(name="tbd_id")
	private Integer tbdId;

	@Column(name="tbd_name")
	private String tbdName;

	@Column(name="tbd_status")
	private String tbdStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbd_update_date")
	private Date tbdUpdateDate;

	@Column(name="tbd_update_id")
	private Integer tbdUpdateId;

	@Column(name="tbd_uuid")
	private String tbdUuid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbj_create_date")
	private Date tbjCreateDate;

	@Column(name="tbj_create_id")
	private Integer tbjCreateId;

	@Column(name="tbj_create_idc")
	private Integer tbjCreateIdc;

	@Column(name="tbj_id")
	private Integer tbjId;

	@Column(name="tbj_name")
	private String tbjName;

	@Column(name="tbj_status")
	private String tbjStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbj_update_date")
	private Date tbjUpdateDate;

	@Column(name="tbj_update_id")
	private Integer tbjUpdateId;

	@Column(name="tbj_uuid")
	private String tbjUuid;

	@Id
	private String uuid;

	public ViewJobDepartment() {
	}

	public Date getTbdCreateDate() {
		return this.tbdCreateDate;
	}

	public void setTbdCreateDate(Date tbdCreateDate) {
		this.tbdCreateDate = tbdCreateDate;
	}

	public Integer getTbdCreateId() {
		return this.tbdCreateId;
	}

	public void setTbdCreateId(Integer tbdCreateId) {
		this.tbdCreateId = tbdCreateId;
	}

	public Integer getTbdCreateIdc() {
		return this.tbdCreateIdc;
	}

	public void setTbdCreateIdc(Integer tbdCreateIdc) {
		this.tbdCreateIdc = tbdCreateIdc;
	}

	public Integer getTbdId() {
		return this.tbdId;
	}

	public void setTbdId(Integer tbdId) {
		this.tbdId = tbdId;
	}

	public String getTbdName() {
		return this.tbdName;
	}

	public void setTbdName(String tbdName) {
		this.tbdName = tbdName;
	}

	public String getTbdStatus() {
		return this.tbdStatus;
	}

	public void setTbdStatus(String tbdStatus) {
		this.tbdStatus = tbdStatus;
	}

	public Date getTbdUpdateDate() {
		return this.tbdUpdateDate;
	}

	public void setTbdUpdateDate(Date tbdUpdateDate) {
		this.tbdUpdateDate = tbdUpdateDate;
	}

	public Integer getTbdUpdateId() {
		return this.tbdUpdateId;
	}

	public void setTbdUpdateId(Integer tbdUpdateId) {
		this.tbdUpdateId = tbdUpdateId;
	}

	public String getTbdUuid() {
		return this.tbdUuid;
	}

	public void setTbdUuid(String tbdUuid) {
		this.tbdUuid = tbdUuid;
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

	public Integer getTbjCreateIdc() {
		return this.tbjCreateIdc;
	}

	public void setTbjCreateIdc(Integer tbjCreateIdc) {
		this.tbjCreateIdc = tbjCreateIdc;
	}

	public Integer getTbjId() {
		return this.tbjId;
	}

	public void setTbjId(Integer tbjId) {
		this.tbjId = tbjId;
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

	public String getTbjUuid() {
		return this.tbjUuid;
	}

	public void setTbjUuid(String tbjUuid) {
		this.tbjUuid = tbjUuid;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}