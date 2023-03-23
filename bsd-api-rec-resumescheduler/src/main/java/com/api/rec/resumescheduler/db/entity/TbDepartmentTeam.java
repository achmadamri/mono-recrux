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
 * The persistent class for the tb_department_team database table.
 * 
 */
@Entity
@Table(name="tb_department_team")
@NamedQuery(name="TbDepartmentTeam.findAll", query="SELECT t FROM TbDepartmentTeam t")
public class TbDepartmentTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbdt_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbdtId;

	@Column(name="tbd_id")
	private Integer tbdId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbdt_create_date")
	private Date tbdtCreateDate;

	@Column(name="tbdt_create_id")
	private Integer tbdtCreateId;

	@Column(name="tbdt_status")
	private String tbdtStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbdt_update_date")
	private Date tbdtUpdateDate;

	@Column(name="tbdt_update_id")
	private Integer tbdtUpdateId;

	@Column(name="tbu_id")
	private Integer tbuId;

	public TbDepartmentTeam() {
	}

	public Integer getTbdtId() {
		return this.tbdtId;
	}

	public void setTbdtId(Integer tbdtId) {
		this.tbdtId = tbdtId;
	}

	public Integer getTbdId() {
		return this.tbdId;
	}

	public void setTbdId(Integer tbdId) {
		this.tbdId = tbdId;
	}

	public Date getTbdtCreateDate() {
		return this.tbdtCreateDate;
	}

	public void setTbdtCreateDate(Date tbdtCreateDate) {
		this.tbdtCreateDate = tbdtCreateDate;
	}

	public Integer getTbdtCreateId() {
		return this.tbdtCreateId;
	}

	public void setTbdtCreateId(Integer tbdtCreateId) {
		this.tbdtCreateId = tbdtCreateId;
	}

	public String getTbdtStatus() {
		return this.tbdtStatus;
	}

	public void setTbdtStatus(String tbdtStatus) {
		this.tbdtStatus = tbdtStatus;
	}

	public Date getTbdtUpdateDate() {
		return this.tbdtUpdateDate;
	}

	public void setTbdtUpdateDate(Date tbdtUpdateDate) {
		this.tbdtUpdateDate = tbdtUpdateDate;
	}

	public Integer getTbdtUpdateId() {
		return this.tbdtUpdateId;
	}

	public void setTbdtUpdateId(Integer tbdtUpdateId) {
		this.tbdtUpdateId = tbdtUpdateId;
	}

	public Integer getTbuId() {
		return this.tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

}