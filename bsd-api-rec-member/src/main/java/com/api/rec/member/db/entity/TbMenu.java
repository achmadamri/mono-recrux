package com.api.rec.member.db.entity;

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
 * The persistent class for the tb_menu database table.
 * 
 */
@Entity
@Table(name="tb_menu")
@NamedQuery(name="TbMenu.findAll", query="SELECT t FROM TbMenu t")
public class TbMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbm_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbmId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbm_create_date")
	private Date tbmCreateDate;

	@Column(name="tbm_create_id")
	private Integer tbmCreateId;

	@Column(name="tbm_name")
	private String tbmName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbm_update_date")
	private Date tbmUpdateDate;

	@Column(name="tbm_update_id")
	private Integer tbmUpdateId;

	public TbMenu() {
	}

	public Integer getTbmId() {
		return this.tbmId;
	}

	public void setTbmId(Integer tbmId) {
		this.tbmId = tbmId;
	}

	public Date getTbmCreateDate() {
		return this.tbmCreateDate;
	}

	public void setTbmCreateDate(Date tbmCreateDate) {
		this.tbmCreateDate = tbmCreateDate;
	}

	public Integer getTbmCreateId() {
		return this.tbmCreateId;
	}

	public void setTbmCreateId(Integer tbmCreateId) {
		this.tbmCreateId = tbmCreateId;
	}

	public String getTbmName() {
		return this.tbmName;
	}

	public void setTbmName(String tbmName) {
		this.tbmName = tbmName;
	}

	public Date getTbmUpdateDate() {
		return this.tbmUpdateDate;
	}

	public void setTbmUpdateDate(Date tbmUpdateDate) {
		this.tbmUpdateDate = tbmUpdateDate;
	}

	public Integer getTbmUpdateId() {
		return this.tbmUpdateId;
	}

	public void setTbmUpdateId(Integer tbmUpdateId) {
		this.tbmUpdateId = tbmUpdateId;
	}

}