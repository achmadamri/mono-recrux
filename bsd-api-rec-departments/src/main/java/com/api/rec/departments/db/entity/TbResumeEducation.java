package com.api.rec.departments.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_resume_education database table.
 * 
 */
@Entity
@Table(name="tb_resume_education")
@NamedQuery(name="TbResumeEducation.findAll", query="SELECT t FROM TbResumeEducation t")
public class TbResumeEducation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tbre_id")
	private Integer tbreId;

	@Column(name="tbr_id")
	private Integer tbrId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbre_completion_date")
	private Date tbreCompletionDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbre_create_date")
	private Date tbreCreateDate;

	@Column(name="tbre_create_id")
	private Integer tbreCreateId;

	@Column(name="tbre_create_idc")
	private Integer tbreCreateIdc;

	@Column(name="tbre_education")
	private String tbreEducation;

	@Column(name="tbre_education_level")
	private String tbreEducationLevel;

	@Column(name="tbre_grade_metric")
	private String tbreGradeMetric;

	@Column(name="tbre_grade_raw")
	private String tbreGradeRaw;

	@Column(name="tbre_grade_value")
	private String tbreGradeValue;

	@Column(name="tbre_input_str")
	private String tbreInputStr;
	
	@Column(name="tbre_is_current")
	private String tbreIsCurrent;

	@Column(name="tbre_location_city")
	private String tbreLocationCity;

	@Column(name="tbre_location_country")
	private String tbreLocationCountry;

	@Column(name="tbre_location_country_code")
	private String tbreLocationCountryCode;

	@Column(name="tbre_location_formatted")
	private String tbreLocationFormatted;

	@Column(name="tbre_location_latitude")
	private String tbreLocationLatitude;

	@Column(name="tbre_location_longitude")
	private String tbreLocationLongitude;

	@Column(name="tbre_location_raw_input")
	private String tbreLocationRawInput;

	@Column(name="tbre_location_state")
	private String tbreLocationState;

	@Column(name="tbre_match_str")
	private String tbreMatchStr;

	@Column(name="tbre_organization")
	private String tbreOrganization;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbre_start_date")
	private Date tbreStartDate;

	@Column(name="tbre_status")
	private String tbreStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbre_update_date")
	private Date tbreUpdateDate;

	@Column(name="tbre_update_id")
	private Integer tbreUpdateId;

	@Column(name="tbre_uuid")
	private String tbreUuid;

	public TbResumeEducation() {
	}

	public Integer getTbreId() {
		return tbreId;
	}

	public void setTbreId(Integer tbreId) {
		this.tbreId = tbreId;
	}

	public Integer getTbrId() {
		return tbrId;
	}

	public void setTbrId(Integer tbrId) {
		this.tbrId = tbrId;
	}

	public Date getTbreCompletionDate() {
		return tbreCompletionDate;
	}

	public void setTbreCompletionDate(Date tbreCompletionDate) {
		this.tbreCompletionDate = tbreCompletionDate;
	}

	public Date getTbreCreateDate() {
		return tbreCreateDate;
	}

	public void setTbreCreateDate(Date tbreCreateDate) {
		this.tbreCreateDate = tbreCreateDate;
	}

	public Integer getTbreCreateId() {
		return tbreCreateId;
	}

	public void setTbreCreateId(Integer tbreCreateId) {
		this.tbreCreateId = tbreCreateId;
	}

	public Integer getTbreCreateIdc() {
		return tbreCreateIdc;
	}

	public void setTbreCreateIdc(Integer tbreCreateIdc) {
		this.tbreCreateIdc = tbreCreateIdc;
	}

	public String getTbreEducation() {
		return tbreEducation;
	}

	public void setTbreEducation(String tbreEducation) {
		this.tbreEducation = tbreEducation;
	}

	public String getTbreEducationLevel() {
		return tbreEducationLevel;
	}

	public void setTbreEducationLevel(String tbreEducationLevel) {
		this.tbreEducationLevel = tbreEducationLevel;
	}

	public String getTbreGradeMetric() {
		return tbreGradeMetric;
	}

	public void setTbreGradeMetric(String tbreGradeMetric) {
		this.tbreGradeMetric = tbreGradeMetric;
	}

	public String getTbreGradeRaw() {
		return tbreGradeRaw;
	}

	public void setTbreGradeRaw(String tbreGradeRaw) {
		this.tbreGradeRaw = tbreGradeRaw;
	}

	public String getTbreGradeValue() {
		return tbreGradeValue;
	}

	public void setTbreGradeValue(String tbreGradeValue) {
		this.tbreGradeValue = tbreGradeValue;
	}

	public String getTbreInputStr() {
		return tbreInputStr;
	}

	public void setTbreInputStr(String tbreInputStr) {
		this.tbreInputStr = tbreInputStr;
	}

	public String getTbreIsCurrent() {
		return tbreIsCurrent;
	}

	public void setTbreIsCurrent(String tbreIsCurrent) {
		this.tbreIsCurrent = tbreIsCurrent;
	}

	public String getTbreLocationCity() {
		return tbreLocationCity;
	}

	public void setTbreLocationCity(String tbreLocationCity) {
		this.tbreLocationCity = tbreLocationCity;
	}

	public String getTbreLocationCountry() {
		return tbreLocationCountry;
	}

	public void setTbreLocationCountry(String tbreLocationCountry) {
		this.tbreLocationCountry = tbreLocationCountry;
	}

	public String getTbreLocationCountryCode() {
		return tbreLocationCountryCode;
	}

	public void setTbreLocationCountryCode(String tbreLocationCountryCode) {
		this.tbreLocationCountryCode = tbreLocationCountryCode;
	}

	public String getTbreLocationFormatted() {
		return tbreLocationFormatted;
	}

	public void setTbreLocationFormatted(String tbreLocationFormatted) {
		this.tbreLocationFormatted = tbreLocationFormatted;
	}

	public String getTbreLocationLatitude() {
		return tbreLocationLatitude;
	}

	public void setTbreLocationLatitude(String tbreLocationLatitude) {
		this.tbreLocationLatitude = tbreLocationLatitude;
	}

	public String getTbreLocationLongitude() {
		return tbreLocationLongitude;
	}

	public void setTbreLocationLongitude(String tbreLocationLongitude) {
		this.tbreLocationLongitude = tbreLocationLongitude;
	}

	public String getTbreLocationRawInput() {
		return tbreLocationRawInput;
	}

	public void setTbreLocationRawInput(String tbreLocationRawInput) {
		this.tbreLocationRawInput = tbreLocationRawInput;
	}

	public String getTbreLocationState() {
		return tbreLocationState;
	}

	public void setTbreLocationState(String tbreLocationState) {
		this.tbreLocationState = tbreLocationState;
	}

	public String getTbreMatchStr() {
		return tbreMatchStr;
	}

	public void setTbreMatchStr(String tbreMatchStr) {
		this.tbreMatchStr = tbreMatchStr;
	}

	public String getTbreOrganization() {
		return tbreOrganization;
	}

	public void setTbreOrganization(String tbreOrganization) {
		this.tbreOrganization = tbreOrganization;
	}

	public Date getTbreStartDate() {
		return tbreStartDate;
	}

	public void setTbreStartDate(Date tbreStartDate) {
		this.tbreStartDate = tbreStartDate;
	}

	public String getTbreStatus() {
		return tbreStatus;
	}

	public void setTbreStatus(String tbreStatus) {
		this.tbreStatus = tbreStatus;
	}

	public Date getTbreUpdateDate() {
		return tbreUpdateDate;
	}

	public void setTbreUpdateDate(Date tbreUpdateDate) {
		this.tbreUpdateDate = tbreUpdateDate;
	}

	public Integer getTbreUpdateId() {
		return tbreUpdateId;
	}

	public void setTbreUpdateId(Integer tbreUpdateId) {
		this.tbreUpdateId = tbreUpdateId;
	}

	public String getTbreUuid() {
		return tbreUuid;
	}

	public void setTbreUuid(String tbreUuid) {
		this.tbreUuid = tbreUuid;
	}	

}