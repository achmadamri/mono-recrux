package com.api.rec.departments.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_department_job database table.
 * 
 */
@Entity
@Table(name="tb_department_job")
@NamedQuery(name="TbDepartmentJob.findAll", query="SELECT t FROM TbDepartmentJob t")
public class TbDepartmentJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbdj_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbdjId;

	@Column(name="tbd_id")
	private Integer tbdId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbdj_create_date")
	private Date tbdjCreateDate;

	@Column(name="tbdj_create_id")
	private Integer tbdjCreateId;

	@Column(name="tbdj_create_idc")
	private Integer tbdjCreateIdc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbdj_update_date")
	private Date tbdjUpdateDate;

	@Column(name="tbdj_update_id")
	private Integer tbdjUpdateId;

	@Column(name="tbj_id")
	private Integer tbjId;

	@Column(name="tbdj_status")
	private String tbdjStatus;

	@Column(name="tbdj_uuid")
	private String tbdjUuid;

	public TbDepartmentJob() {
	}

	public Integer getTbdjId() {
		return tbdjId;
	}

	public void setTbdjId(Integer tbdjId) {
		this.tbdjId = tbdjId;
	}

	public Integer getTbdId() {
		return tbdId;
	}

	public void setTbdId(Integer tbdId) {
		this.tbdId = tbdId;
	}

	public Date getTbdjCreateDate() {
		return tbdjCreateDate;
	}

	public void setTbdjCreateDate(Date tbdjCreateDate) {
		this.tbdjCreateDate = tbdjCreateDate;
	}

	public Integer getTbdjCreateId() {
		return tbdjCreateId;
	}

	public void setTbdjCreateId(Integer tbdjCreateId) {
		this.tbdjCreateId = tbdjCreateId;
	}

	public Integer getTbdjCreateIdc() {
		return tbdjCreateIdc;
	}

	public void setTbdjCreateIdc(Integer tbdjCreateIdc) {
		this.tbdjCreateIdc = tbdjCreateIdc;
	}

	public Date getTbdjUpdateDate() {
		return tbdjUpdateDate;
	}

	public void setTbdjUpdateDate(Date tbdjUpdateDate) {
		this.tbdjUpdateDate = tbdjUpdateDate;
	}

	public Integer getTbdjUpdateId() {
		return tbdjUpdateId;
	}

	public void setTbdjUpdateId(Integer tbdjUpdateId) {
		this.tbdjUpdateId = tbdjUpdateId;
	}

	public Integer getTbjId() {
		return tbjId;
	}

	public void setTbjId(Integer tbjId) {
		this.tbjId = tbjId;
	}

	public String getTbdjStatus() {
		return tbdjStatus;
	}

	public void setTbdjStatus(String tbdjStatus) {
		this.tbdjStatus = tbdjStatus;
	}

	public String getTbdjUuid() {
		return tbdjUuid;
	}

	public void setTbdjUuid(String tbdjUuid) {
		this.tbdjUuid = tbdjUuid;
	}

}