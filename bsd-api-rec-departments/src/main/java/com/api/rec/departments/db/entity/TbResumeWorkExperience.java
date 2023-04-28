package com.api.rec.departments.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tb_resume_work_experience database table.
 * 
 */
@Entity
@Table(name="tb_resume_work_experience")
@NamedQuery(name="TbResumeWorkExperience.findAll", query="SELECT t FROM TbResumeWorkExperience t")
public class TbResumeWorkExperience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tbrwe_id")
	private Integer tbrweId;

	@Column(name="tbr_id")
	private Integer tbrId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbrwe_create_date")
	private Date tbrweCreateDate;

	@Column(name="tbrwe_create_id")
	private Integer tbrweCreateId;

	@Column(name="tbrwe_create_idc")
	private Integer tbrweCreateIdc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbrwe_end_date")
	private Date tbrweEndDate;

	@Column(name="tbrwe_is_current")
	private String tbrweIsCurrent;

	@Column(name="tbrwe_job_description")
	private String tbrweJobDescription;

	@Column(name="tbrwe_job_title")
	private String tbrweJobTitle;

	@Column(name="tbrwe_job_title_normalized")
	private String tbrweJobTitleNormalized;

	@Column(name="tbrwe_management_level")
	private String tbrweManagementLevel;

	@Column(name="tbrwe_minor_group")
	private String tbrweMinorGroup;

	@Column(name="tbrwe_major_group")
	private String tbrweMajorGroup;

	@Column(name="tbrwe_months_in_position")
	private Integer tbrweMonthsInPosition;

	@Column(name="tbrwe_organization")
	private String tbrweOrganization;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbrwe_start_date")
	private Date tbrweStartDate;

	@Column(name="tbrwe_status")
	private String tbrweStatus;

	@Column(name="tbrwe_sub_major_group")
	private String tbrweSubMajorGroup;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbrwe_update_date")
	private Date tbrweUpdateDate;

	@Column(name="tbrwe_update_id")
	private Integer tbrweUpdateId;

	@Column(name="tbrwe_uuid")
	private String tbrweUuid;

	@Lob
	@Column(columnDefinition = "text", name="tbrwe_text")
	private String tbrweText;

	@Column(name="tbrwe_start")
	private String tbrweStart;

	@Column(name="tbrwe_end")
	private String tbrweEnd;

	public TbResumeWorkExperience() {
	}

	public Integer getTbrweId() {
		return tbrweId;
	}

	public void setTbrweId(Integer tbrweId) {
		this.tbrweId = tbrweId;
	}

	public Integer getTbrId() {
		return tbrId;
	}

	public void setTbrId(Integer tbrId) {
		this.tbrId = tbrId;
	}

	public Date getTbrweCreateDate() {
		return tbrweCreateDate;
	}

	public void setTbrweCreateDate(Date tbrweCreateDate) {
		this.tbrweCreateDate = tbrweCreateDate;
	}

	public Integer getTbrweCreateId() {
		return tbrweCreateId;
	}

	public void setTbrweCreateId(Integer tbrweCreateId) {
		this.tbrweCreateId = tbrweCreateId;
	}

	public Integer getTbrweCreateIdc() {
		return tbrweCreateIdc;
	}

	public void setTbrweCreateIdc(Integer tbrweCreateIdc) {
		this.tbrweCreateIdc = tbrweCreateIdc;
	}

	public Date getTbrweEndDate() {
		return tbrweEndDate;
	}

	public void setTbrweEndDate(Date tbrweEndDate) {
		this.tbrweEndDate = tbrweEndDate;
	}

	public String getTbrweIsCurrent() {
		return tbrweIsCurrent;
	}

	public void setTbrweIsCurrent(String tbrweIsCurrent) {
		this.tbrweIsCurrent = tbrweIsCurrent;
	}

	public String getTbrweJobDescription() {
		return tbrweJobDescription;
	}

	public void setTbrweJobDescription(String tbrweJobDescription) {
		this.tbrweJobDescription = tbrweJobDescription;
	}

	public String getTbrweJobTitle() {
		return tbrweJobTitle;
	}

	public void setTbrweJobTitle(String tbrweJobTitle) {
		this.tbrweJobTitle = tbrweJobTitle;
	}

	public String getTbrweJobTitleNormalized() {
		return tbrweJobTitleNormalized;
	}

	public void setTbrweJobTitleNormalized(String tbrweJobTitleNormalized) {
		this.tbrweJobTitleNormalized = tbrweJobTitleNormalized;
	}

	public String getTbrweManagementLevel() {
		return tbrweManagementLevel;
	}

	public void setTbrweManagementLevel(String tbrweManagementLevel) {
		this.tbrweManagementLevel = tbrweManagementLevel;
	}

	public String getTbrweMinorGroup() {
		return tbrweMinorGroup;
	}

	public void setTbrweMinorGroup(String tbrweMinorGroup) {
		this.tbrweMinorGroup = tbrweMinorGroup;
	}

	public String getTbrweMajorGroup() {
		return tbrweMajorGroup;
	}

	public void setTbrweMajorGroup(String tbrweMajorGroup) {
		this.tbrweMajorGroup = tbrweMajorGroup;
	}

	public Integer getTbrweMonthsInPosition() {
		return tbrweMonthsInPosition;
	}

	public void setTbrweMonthsInPosition(Integer tbrweMonthsInPosition) {
		this.tbrweMonthsInPosition = tbrweMonthsInPosition;
	}

	public String getTbrweOrganization() {
		return tbrweOrganization;
	}

	public void setTbrweOrganization(String tbrweOrganization) {
		this.tbrweOrganization = tbrweOrganization;
	}

	public Date getTbrweStartDate() {
		return tbrweStartDate;
	}

	public void setTbrweStartDate(Date tbrweStartDate) {
		this.tbrweStartDate = tbrweStartDate;
	}

	public String getTbrweStatus() {
		return tbrweStatus;
	}

	public void setTbrweStatus(String tbrweStatus) {
		this.tbrweStatus = tbrweStatus;
	}

	public String getTbrweSubMajorGroup() {
		return tbrweSubMajorGroup;
	}

	public void setTbrweSubMajorGroup(String tbrweSubMajorGroup) {
		this.tbrweSubMajorGroup = tbrweSubMajorGroup;
	}

	public Date getTbrweUpdateDate() {
		return tbrweUpdateDate;
	}

	public void setTbrweUpdateDate(Date tbrweUpdateDate) {
		this.tbrweUpdateDate = tbrweUpdateDate;
	}

	public Integer getTbrweUpdateId() {
		return tbrweUpdateId;
	}

	public void setTbrweUpdateId(Integer tbrweUpdateId) {
		this.tbrweUpdateId = tbrweUpdateId;
	}

	public String getTbrweUuid() {
		return tbrweUuid;
	}

	public void setTbrweUuid(String tbrweUuid) {
		this.tbrweUuid = tbrweUuid;
	}

	public String getTbrweText() {
		return tbrweText;
	}

	public void setTbrweText(String tbrweText) {
		this.tbrweText = tbrweText;
	}

	public String getTbrweStart() {
		return tbrweStart;
	}

	public void setTbrweStart(String tbrweStart) {
		this.tbrweStart = tbrweStart;
	}

	public String getTbrweEnd() {
		return tbrweEnd;
	}

	public void setTbrweEnd(String tbrweEnd) {
		this.tbrweEnd = tbrweEnd;
	}

}