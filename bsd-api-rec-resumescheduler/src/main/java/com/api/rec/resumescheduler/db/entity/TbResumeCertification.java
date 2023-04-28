package com.api.rec.resumescheduler.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_resume_certification database table.
 * 
 */
@Entity
@Table(name="tb_resume_certification")
@NamedQuery(name="TbResumeCertification.findAll", query="SELECT t FROM TbResumeCertification t")
public class TbResumeCertification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tbrc_id")
	private Integer tbrcId;

	@Column(name="tbr_id")
	private Integer tbrId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbrc_create_date")
	private Date tbrcCreateDate;

	@Column(name="tbrc_create_id")
	private Integer tbrcCreateId;

	@Column(name="tbrc_create_idc")
	private Integer tbrcCreateIdc;

	@Column(name="tbrc_name")
	private String tbrcName;

	@Column(name="tbrc_status")
	private String tbrcStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbrc_update_date")
	private Date tbrcUpdateDate;

	@Column(name="tbrc_update_id")
	private Integer tbrcUpdateId;

	@Column(name="tbrc_uuid")
	private String tbrcUuid;

	public TbResumeCertification() {
	}

	public Integer getTbrcId() {
		return this.tbrcId;
	}

	public void setTbrcId(Integer tbrcId) {
		this.tbrcId = tbrcId;
	}

	public Integer getTbrId() {
		return this.tbrId;
	}

	public void setTbrId(Integer tbrId) {
		this.tbrId = tbrId;
	}

	public Date getTbrcCreateDate() {
		return this.tbrcCreateDate;
	}

	public void setTbrcCreateDate(Date tbrcCreateDate) {
		this.tbrcCreateDate = tbrcCreateDate;
	}

	public Integer getTbrcCreateId() {
		return this.tbrcCreateId;
	}

	public void setTbrcCreateId(Integer tbrcCreateId) {
		this.tbrcCreateId = tbrcCreateId;
	}

	public Integer getTbrcCreateIdc() {
		return this.tbrcCreateIdc;
	}

	public void setTbrcCreateIdc(Integer tbrcCreateIdc) {
		this.tbrcCreateIdc = tbrcCreateIdc;
	}

	public String getTbrcName() {
		return this.tbrcName;
	}

	public void setTbrcName(String tbrcName) {
		this.tbrcName = tbrcName;
	}

	public String getTbrcStatus() {
		return this.tbrcStatus;
	}

	public void setTbrcStatus(String tbrcStatus) {
		this.tbrcStatus = tbrcStatus;
	}

	public Date getTbrcUpdateDate() {
		return this.tbrcUpdateDate;
	}

	public void setTbrcUpdateDate(Date tbrcUpdateDate) {
		this.tbrcUpdateDate = tbrcUpdateDate;
	}

	public Integer getTbrcUpdateId() {
		return this.tbrcUpdateId;
	}

	public void setTbrcUpdateId(Integer tbrcUpdateId) {
		this.tbrcUpdateId = tbrcUpdateId;
	}

	public String getTbrcUuid() {
		return this.tbrcUuid;
	}

	public void setTbrcUuid(String tbrcUuid) {
		this.tbrcUuid = tbrcUuid;
	}

}