package com.api.rec.resumescheduler.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_resume_skill database table.
 * 
 */
@Entity
@Table(name="tb_resume_skill")
@NamedQuery(name="TbResumeSkill.findAll", query="SELECT t FROM TbResumeSkill t")
public class TbResumeSkill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tbrs_id")
	private Integer tbrsId;

	@Column(name="tbr_id")
	private Integer tbrId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbrs_create_date")
	private Date tbrsCreateDate;

	@Column(name="tbrs_create_id")
	private Integer tbrsCreateId;

	@Column(name="tbrs_create_idc")
	private Integer tbrsCreateIdc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbrs_last_used")
	private Date tbrsLastUsed;

	@Column(name="tbrs_name")
	private String tbrsName;

	@Column(name="tbrs_number_of_months")
	private Integer tbrsNumberOfMonths;

	@Column(name="tbrs_status")
	private String tbrsStatus;

	@Column(name="tbrs_type")
	private String tbrsType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbrs_update_date")
	private Date tbrsUpdateDate;

	@Column(name="tbrs_update_id")
	private Integer tbrsUpdateId;

	@Column(name="tbrs_uuid")
	private String tbrsUuid;

	public TbResumeSkill() {
	}

	public Integer getTbrsId() {
		return this.tbrsId;
	}

	public void setTbrsId(Integer tbrsId) {
		this.tbrsId = tbrsId;
	}

	public Integer getTbrId() {
		return this.tbrId;
	}

	public void setTbrId(Integer tbrId) {
		this.tbrId = tbrId;
	}

	public Date getTbrsCreateDate() {
		return this.tbrsCreateDate;
	}

	public void setTbrsCreateDate(Date tbrsCreateDate) {
		this.tbrsCreateDate = tbrsCreateDate;
	}

	public Integer getTbrsCreateId() {
		return this.tbrsCreateId;
	}

	public void setTbrsCreateId(Integer tbrsCreateId) {
		this.tbrsCreateId = tbrsCreateId;
	}

	public Integer getTbrsCreateIdc() {
		return this.tbrsCreateIdc;
	}

	public void setTbrsCreateIdc(Integer tbrsCreateIdc) {
		this.tbrsCreateIdc = tbrsCreateIdc;
	}

	public Date getTbrsLastUsed() {
		return this.tbrsLastUsed;
	}

	public void setTbrsLastUsed(Date tbrsLastUsed) {
		this.tbrsLastUsed = tbrsLastUsed;
	}

	public String getTbrsName() {
		return this.tbrsName;
	}

	public void setTbrsName(String tbrsName) {
		this.tbrsName = tbrsName;
	}

	public Integer getTbrsNumberOfMonths() {
		return this.tbrsNumberOfMonths;
	}

	public void setTbrsNumberOfMonths(Integer tbrsNumberOfMonths) {
		this.tbrsNumberOfMonths = tbrsNumberOfMonths;
	}

	public String getTbrsStatus() {
		return this.tbrsStatus;
	}

	public void setTbrsStatus(String tbrsStatus) {
		this.tbrsStatus = tbrsStatus;
	}

	public String getTbrsType() {
		return this.tbrsType;
	}

	public void setTbrsType(String tbrsType) {
		this.tbrsType = tbrsType;
	}

	public Date getTbrsUpdateDate() {
		return this.tbrsUpdateDate;
	}

	public void setTbrsUpdateDate(Date tbrsUpdateDate) {
		this.tbrsUpdateDate = tbrsUpdateDate;
	}

	public Integer getTbrsUpdateId() {
		return this.tbrsUpdateId;
	}

	public void setTbrsUpdateId(Integer tbrsUpdateId) {
		this.tbrsUpdateId = tbrsUpdateId;
	}

	public String getTbrsUuid() {
		return this.tbrsUuid;
	}

	public void setTbrsUuid(String tbrsUuid) {
		this.tbrsUuid = tbrsUuid;
	}

}