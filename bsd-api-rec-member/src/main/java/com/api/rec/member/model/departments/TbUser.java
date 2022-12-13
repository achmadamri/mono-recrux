package com.api.rec.member.model.departments;

import java.io.Serializable;
import java.util.Date;


public class TbUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer tbuId;

	private Date tbuCreateDate;

	private Integer tbuCreateId;

	private Date tbuDateOfBirth;

	private String tbuEmail;

	private String tbuFirstname;

	private String tbuLastname;

	private String tbuMobilePhone;

	private String tbuPassword;

	private String tbuPhoto;

	private String tbuPlaceOfBirth;

	private String tbuStatus;

	private String tbuTokenSalt;

	private String tbuUid;

	private Date tbuUpdateDate;

	private Integer tbuUpdateId;
	
	private String tbuRole;

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

	public Date getTbuDateOfBirth() {
		return this.tbuDateOfBirth;
	}

	public void setTbuDateOfBirth(Date tbuDateOfBirth) {
		this.tbuDateOfBirth = tbuDateOfBirth;
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

	public String getTbuPlaceOfBirth() {
		return this.tbuPlaceOfBirth;
	}

	public void setTbuPlaceOfBirth(String tbuPlaceOfBirth) {
		this.tbuPlaceOfBirth = tbuPlaceOfBirth;
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

	public String getTbuRole() {
		return tbuRole;
	}

	public void setTbuRole(String tbuRole) {
		this.tbuRole = tbuRole;
	}

}