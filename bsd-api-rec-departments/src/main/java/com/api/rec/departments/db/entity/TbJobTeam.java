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
 * The persistent class for the tb_job_team database table.
 * 
 */
@Entity
@Table(name="tb_job_team")
@NamedQuery(name="TbJobTeam.findAll", query="SELECT t FROM TbJobTeam t")
public class TbJobTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbjt_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbjtId;

	@Column(name="tbj_id")
	private Integer tbjId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbjt_create_date")
	private Date tbjtCreateDate;

	@Column(name="tbjt_create_id")
	private Integer tbjtCreateId;

	@Column(name="tbjt_status")
	private String tbjtStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbjt_update_date")
	private Date tbjtUpdateDate;

	@Column(name="tbjt_update_id")
	private Integer tbjtUpdateId;

	@Column(name="tbu_id")
	private Integer tbuId;

	public TbJobTeam() {
	}

	public Integer getTbjtId() {
		return this.tbjtId;
	}

	public void setTbjtId(Integer tbjtId) {
		this.tbjtId = tbjtId;
	}

	public Integer getTbjId() {
		return this.tbjId;
	}

	public void setTbjId(Integer tbjId) {
		this.tbjId = tbjId;
	}

	public Date getTbjtCreateDate() {
		return this.tbjtCreateDate;
	}

	public void setTbjtCreateDate(Date tbjtCreateDate) {
		this.tbjtCreateDate = tbjtCreateDate;
	}

	public Integer getTbjtCreateId() {
		return this.tbjtCreateId;
	}

	public void setTbjtCreateId(Integer tbjtCreateId) {
		this.tbjtCreateId = tbjtCreateId;
	}

	public String getTbjtStatus() {
		return this.tbjtStatus;
	}

	public void setTbjtStatus(String tbjtStatus) {
		this.tbjtStatus = tbjtStatus;
	}

	public Date getTbjtUpdateDate() {
		return this.tbjtUpdateDate;
	}

	public void setTbjtUpdateDate(Date tbjtUpdateDate) {
		this.tbjtUpdateDate = tbjtUpdateDate;
	}

	public Integer getTbjtUpdateId() {
		return this.tbjtUpdateId;
	}

	public void setTbjtUpdateId(Integer tbjtUpdateId) {
		this.tbjtUpdateId = tbjtUpdateId;
	}

	public Integer getTbuId() {
		return this.tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

}