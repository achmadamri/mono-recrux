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
 * The persistent class for the tb_user database table.
 * 
 */
@Entity
@Table(name="tb_user")
@NamedQuery(name="TbUser.findAll", query="SELECT t FROM TbUser t")
public class TbUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tbu_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tbuId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbu_create_date")
	private Date tbuCreateDate;

	@Column(name="tbu_create_id")
	private Integer tbuCreateId;

	@Column(name="tbu_email")
	private String tbuEmail;

	@Column(name="tbu_firstname")
	private String tbuFirstname;

	@Column(name="tbu_lastname")
	private String tbuLastname;

	@Column(name="tbu_mobile_phone")
	private String tbuMobilePhone;

	@Column(name="tbu_password")
	private String tbuPassword;

	@Column(name="tbu_photo")
	private String tbuPhoto;

	@Column(name="tbu_status")
	private String tbuStatus;

	@Column(name="tbu_token_salt")
	private String tbuTokenSalt;

	@Column(name="tbu_uid")
	private String tbuUid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbu_update_date")
	private Date tbuUpdateDate;

	@Column(name="tbu_update_id")
	private Integer tbuUpdateId;

	@Column(name="tbu_type")
	private String tbuType;

	@Column(name="tbu_expired")
	private Date tbuExpired;

	@Column(name="tbu_create_idc")
	private Integer tbuCreateIdc;

	public TbUser() {
	}

	public Integer getTbuId() {
		return this.tbuId;
	}

	public void setTbuId(Integer tbuId) {
		this.tbuId = tbuId;
	}

	public Date getTbuCreateDate() {
		return this.tbuCreateDate;
	}

	public void setTbuCreateDate(Date tbuCreateDate) {
		this.tbuCreateDate = tbuCreateDate;
	}

	public Integer getTbuCreateId() {
		return this.tbuCreateId;
	}

	public void setTbuCreateId(Integer tbuCreateId) {
		this.tbuCreateId = tbuCreateId;
	}

	public String getTbuEmail() {
		return this.tbuEmail;
	}

	public void setTbuEmail(String tbuEmail) {
		this.tbuEmail = tbuEmail;
	}

	public String getTbuFirstname() {
		return this.tbuFirstname;
	}

	public void setTbuFirstname(String tbuFirstname) {
		this.tbuFirstname = tbuFirstname;
	}

	public String getTbuLastname() {
		return this.tbuLastname;
	}

	public void setTbuLastname(String tbuLastname) {
		this.tbuLastname = tbuLastname;
	}

	public String getTbuMobilePhone() {
		return this.tbuMobilePhone;
	}

	public void setTbuMobilePhone(String tbuMobilePhone) {
		this.tbuMobilePhone = tbuMobilePhone;
	}

	public String getTbuPassword() {
		return this.tbuPassword;
	}

	public void setTbuPassword(String tbuPassword) {
		this.tbuPassword = tbuPassword;
	}

	public String getTbuPhoto() {
		return this.tbuPhoto;
	}

	public void setTbuPhoto(String tbuPhoto) {
		this.tbuPhoto = tbuPhoto;
	}

	public String getTbuStatus() {
		return this.tbuStatus;
	}

	public void setTbuStatus(String tbuStatus) {
		this.tbuStatus = tbuStatus;
	}

	public String getTbuTokenSalt() {
		return this.tbuTokenSalt;
	}

	public void setTbuTokenSalt(String tbuTokenSalt) {
		this.tbuTokenSalt = tbuTokenSalt;
	}

	public String getTbuUid() {
		return this.tbuUid;
	}

	public void setTbuUid(String tbuUid) {
		this.tbuUid = tbuUid;
	}

	public Date getTbuUpdateDate() {
		return this.tbuUpdateDate;
	}

	public void setTbuUpdateDate(Date tbuUpdateDate) {
		this.tbuUpdateDate = tbuUpdateDate;
	}

	public Integer getTbuUpdateId() {
		return this.tbuUpdateId;
	}

	public void setTbuUpdateId(Integer tbuUpdateId) {
		this.tbuUpdateId = tbuUpdateId;
	}

	public String getTbuType() {
		return tbuType;
	}

	public void setTbuType(String tbuType) {
		this.tbuType = tbuType;
	}

	public Date getTbuExpired() {
		return tbuExpired;
	}

	public void setTbuExpired(Date tbuExpired) {
		this.tbuExpired = tbuExpired;
	}

	public Integer getTbuCreateIdc() {
		return tbuCreateIdc;
	}

	public void setTbuCreateIdc(Integer tbuCreateIdc) {
		this.tbuCreateIdc = tbuCreateIdc;
	}

}