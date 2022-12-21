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
 * The persistent class for the tb_department database table.
 * 
 */
@Entity
@Table(name="tb_department")
@NamedQuery(name="TbDepartment.findAll", query="SELECT t FROM TbDepartment t")
public class TbDepartment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbd_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbdId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbd_create_date")
	private Date tbdCreateDate;

	@Column(name="tbd_create_id")
	private Integer tbdCreateId;

	@Column(name="tbd_name")
	private String tbdName;

	@Column(name="tbd_status")
	private String tbdStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbd_update_date")
	private Date tbdUpdateDate;

	@Column(name="tbd_update_id")
	private Integer tbdUpdateId;

	@Column(name="tbd_create_idc")
	private Integer tbdCreateIdc;

	@Column(name="tbd_uuid")
	private String tbdUuid;

	public TbDepartment() {
	}

	public Integer getTbdId() {
		return this.tbdId;
	}

	public void setTbdId(Integer tbdId) {
		this.tbdId = tbdId;
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

	public Integer getTbdCreateIdc() {
		return tbdCreateIdc;
	}

	public void setTbdCreateIdc(Integer tbdCreateIdc) {
		this.tbdCreateIdc = tbdCreateIdc;
	}

	public String getTbdUuid() {
		return tbdUuid;
	}

	public void setTbdUuid(String tbdUuid) {
		this.tbdUuid = tbdUuid;
	}

}