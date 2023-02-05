package com.api.rec.departments.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the view_job_resume database table.
 * 
 */
@Entity
@Table(name="view_job_resume")
@NamedQuery(name="ViewJobResume.findAll", query="SELECT v FROM ViewJobResume v")
public class ViewJobResume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbj_create_date")
	private Date tbjCreateDate;

	@Column(name="tbj_create_id")
	private Integer tbjCreateId;

	@Column(name="tbj_create_idc")
	private Integer tbjCreateIdc;

	@Column(name="tbj_id")
	private Integer tbjId;

	@Column(name="tbj_name")
	private String tbjName;

	@Column(name="tbj_status")
	private String tbjStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbj_update_date")
	private Date tbjUpdateDate;

	@Column(name="tbj_update_id")
	private Integer tbjUpdateId;

	@Column(name="tbj_uuid")
	private String tbjUuid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbr_create_date")
	private Date tbrCreateDate;

	@Column(name="tbr_create_id")
	private Integer tbrCreateId;

	@Column(name="tbr_create_idc")
	private Integer tbrCreateIdc;

	@Lob
	@Column(name="tbr_data_certifications")
	private String tbrDataCertifications;

	@Lob
	@Column(name="tbr_data_date_of_birth")
	private String tbrDataDateOfBirth;

	@Lob
	@Column(name="tbr_data_education")
	private String tbrDataEducation;

	@Lob
	@Column(name="tbr_data_emails")
	private String tbrDataEmails;

	@Lob
	@Column(name="tbr_data_head_shot")
	private String tbrDataHeadShot;

	@Column(name="tbr_data_is_resume_probability")
	private Integer tbrDataIsResumeProbability;

	@Lob
	@Column(name="tbr_data_language_codes")
	private String tbrDataLanguageCodes;

	@Lob
	@Column(name="tbr_data_languages")
	private String tbrDataLanguages;

	@Lob
	@Column(name="tbr_data_linkedin")
	private String tbrDataLinkedin;

	@Lob
	@Column(name="tbr_data_location_apartment_number")
	private String tbrDataLocationApartmentNumber;

	@Lob
	@Column(name="tbr_data_location_city")
	private String tbrDataLocationCity;

	@Lob
	@Column(name="tbr_data_location_country")
	private String tbrDataLocationCountry;

	@Lob
	@Column(name="tbr_data_location_country_code")
	private String tbrDataLocationCountryCode;

	@Lob
	@Column(name="tbr_data_location_formatted")
	private String tbrDataLocationFormatted;

	@Lob
	@Column(name="tbr_data_location_postal_code")
	private String tbrDataLocationPostalCode;

	@Lob
	@Column(name="tbr_data_location_raw_input")
	private String tbrDataLocationRawInput;

	@Lob
	@Column(name="tbr_data_location_state")
	private String tbrDataLocationState;

	@Lob
	@Column(name="tbr_data_location_street")
	private String tbrDataLocationStreet;

	@Lob
	@Column(name="tbr_data_location_street_number")
	private String tbrDataLocationStreetNumber;

	@Lob
	@Column(name="tbr_data_name_first")
	private String tbrDataNameFirst;

	@Lob
	@Column(name="tbr_data_name_last")
	private String tbrDataNameLast;

	@Lob
	@Column(name="tbr_data_name_middle")
	private String tbrDataNameMiddle;

	@Lob
	@Column(name="tbr_data_name_raw")
	private String tbrDataNameRaw;

	@Lob
	@Column(name="tbr_data_name_title")
	private String tbrDataNameTitle;

	@Lob
	@Column(name="tbr_data_objective")
	private String tbrDataObjective;

	@Lob
	@Column(name="tbr_data_phone_numbers")
	private String tbrDataPhoneNumbers;

	@Lob
	@Column(name="tbr_data_profession")
	private String tbrDataProfession;

	@Lob
	@Column(name="tbr_data_publications")
	private String tbrDataPublications;

	@Lob
	@Column(name="tbr_data_raw_text")
	private String tbrDataRawText;

	@Lob
	@Column(name="tbr_data_referees")
	private String tbrDataReferees;

	@Lob
	@Column(name="tbr_data_sections")
	private String tbrDataSections;

	@Lob
	@Column(name="tbr_data_skills")
	private String tbrDataSkills;

	@Lob
	@Column(name="tbr_data_summary")
	private String tbrDataSummary;

	@Column(name="tbr_data_total_years_experience")
	private Integer tbrDataTotalYearsExperience;

	@Lob
	@Column(name="tbr_data_websites")
	private String tbrDataWebsites;

	@Lob
	@Column(name="tbr_data_work_experience")
	private String tbrDataWorkExperience;

	@Lob
	@Column(name="tbr_error_error_code")
	private String tbrErrorErrorCode;

	@Lob
	@Column(name="tbr_error_error_detail")
	private String tbrErrorErrorDetail;

	@Column(name="tbr_id")
	private Integer tbrId;

	@Lob
	@Column(name="tbr_meta_child_documents")
	private String tbrMetaChildDocuments;

	@Lob
	@Column(name="tbr_meta_expiry_time")
	private String tbrMetaExpiryTime;

	@Column(name="tbr_meta_failed")
	private Integer tbrMetaFailed;

	@Lob
	@Column(name="tbr_meta_file_name")
	private String tbrMetaFileName;

	@Lob
	@Column(name="tbr_meta_identifier")
	private String tbrMetaIdentifier;

	@Column(name="tbr_meta_is_verified")
	private Integer tbrMetaIsVerified;

	@Lob
	@Column(name="tbr_meta_language")
	private String tbrMetaLanguage;

	@Column(name="tbr_meta_ocr_confidence")
	private double tbrMetaOcrConfidence;

	@Lob
	@Column(name="tbr_meta_pages")
	private String tbrMetaPages;

	@Lob
	@Column(name="tbr_meta_parent_document_identifier")
	private String tbrMetaParentDocumentIdentifier;

	@Lob
	@Column(name="tbr_meta_pdf")
	private String tbrMetaPdf;

	@Column(name="tbr_meta_ready")
	private Integer tbrMetaReady;

	@Lob
	@Column(name="tbr_meta_ready_dt")
	private String tbrMetaReadyDt;

	@Lob
	@Column(name="tbr_meta_review_url")
	private String tbrMetaReviewUrl;

	@Column(name="tbr_status")
	private String tbrStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbr_update_date")
	private Date tbrUpdateDate;

	@Column(name="tbr_update_id")
	private Integer tbrUpdateId;

	@Column(name="tbr_uuid")
	private String tbrUuid;

	private String uuid;

	public ViewJobResume() {
	}

	public Date getTbjCreateDate() {
		return this.tbjCreateDate;
	}

	public void setTbjCreateDate(Date tbjCreateDate) {
		this.tbjCreateDate = tbjCreateDate;
	}

	public Integer getTbjCreateId() {
		return this.tbjCreateId;
	}

	public void setTbjCreateId(Integer tbjCreateId) {
		this.tbjCreateId = tbjCreateId;
	}

	public Integer getTbjCreateIdc() {
		return this.tbjCreateIdc;
	}

	public void setTbjCreateIdc(Integer tbjCreateIdc) {
		this.tbjCreateIdc = tbjCreateIdc;
	}

	public Integer getTbjId() {
		return this.tbjId;
	}

	public void setTbjId(Integer tbjId) {
		this.tbjId = tbjId;
	}

	public String getTbjName() {
		return this.tbjName;
	}

	public void setTbjName(String tbjName) {
		this.tbjName = tbjName;
	}

	public String getTbjStatus() {
		return this.tbjStatus;
	}

	public void setTbjStatus(String tbjStatus) {
		this.tbjStatus = tbjStatus;
	}

	public Date getTbjUpdateDate() {
		return this.tbjUpdateDate;
	}

	public void setTbjUpdateDate(Date tbjUpdateDate) {
		this.tbjUpdateDate = tbjUpdateDate;
	}

	public Integer getTbjUpdateId() {
		return this.tbjUpdateId;
	}

	public void setTbjUpdateId(Integer tbjUpdateId) {
		this.tbjUpdateId = tbjUpdateId;
	}

	public String getTbjUuid() {
		return this.tbjUuid;
	}

	public void setTbjUuid(String tbjUuid) {
		this.tbjUuid = tbjUuid;
	}

	public Date getTbrCreateDate() {
		return this.tbrCreateDate;
	}

	public void setTbrCreateDate(Date tbrCreateDate) {
		this.tbrCreateDate = tbrCreateDate;
	}

	public Integer getTbrCreateId() {
		return this.tbrCreateId;
	}

	public void setTbrCreateId(Integer tbrCreateId) {
		this.tbrCreateId = tbrCreateId;
	}

	public Integer getTbrCreateIdc() {
		return this.tbrCreateIdc;
	}

	public void setTbrCreateIdc(Integer tbrCreateIdc) {
		this.tbrCreateIdc = tbrCreateIdc;
	}

	public String getTbrDataCertifications() {
		return this.tbrDataCertifications;
	}

	public void setTbrDataCertifications(String tbrDataCertifications) {
		this.tbrDataCertifications = tbrDataCertifications;
	}

	public String getTbrDataDateOfBirth() {
		return this.tbrDataDateOfBirth;
	}

	public void setTbrDataDateOfBirth(String tbrDataDateOfBirth) {
		this.tbrDataDateOfBirth = tbrDataDateOfBirth;
	}

	public String getTbrDataEducation() {
		return this.tbrDataEducation;
	}

	public void setTbrDataEducation(String tbrDataEducation) {
		this.tbrDataEducation = tbrDataEducation;
	}

	public String getTbrDataEmails() {
		return this.tbrDataEmails;
	}

	public void setTbrDataEmails(String tbrDataEmails) {
		this.tbrDataEmails = tbrDataEmails;
	}

	public String getTbrDataHeadShot() {
		return this.tbrDataHeadShot;
	}

	public void setTbrDataHeadShot(String tbrDataHeadShot) {
		this.tbrDataHeadShot = tbrDataHeadShot;
	}

	public Integer getTbrDataIsResumeProbability() {
		return this.tbrDataIsResumeProbability;
	}

	public void setTbrDataIsResumeProbability(Integer tbrDataIsResumeProbability) {
		this.tbrDataIsResumeProbability = tbrDataIsResumeProbability;
	}

	public String getTbrDataLanguageCodes() {
		return this.tbrDataLanguageCodes;
	}

	public void setTbrDataLanguageCodes(String tbrDataLanguageCodes) {
		this.tbrDataLanguageCodes = tbrDataLanguageCodes;
	}

	public String getTbrDataLanguages() {
		return this.tbrDataLanguages;
	}

	public void setTbrDataLanguages(String tbrDataLanguages) {
		this.tbrDataLanguages = tbrDataLanguages;
	}

	public String getTbrDataLinkedin() {
		return this.tbrDataLinkedin;
	}

	public void setTbrDataLinkedin(String tbrDataLinkedin) {
		this.tbrDataLinkedin = tbrDataLinkedin;
	}

	public String getTbrDataLocationApartmentNumber() {
		return this.tbrDataLocationApartmentNumber;
	}

	public void setTbrDataLocationApartmentNumber(String tbrDataLocationApartmentNumber) {
		this.tbrDataLocationApartmentNumber = tbrDataLocationApartmentNumber;
	}

	public String getTbrDataLocationCity() {
		return this.tbrDataLocationCity;
	}

	public void setTbrDataLocationCity(String tbrDataLocationCity) {
		this.tbrDataLocationCity = tbrDataLocationCity;
	}

	public String getTbrDataLocationCountry() {
		return this.tbrDataLocationCountry;
	}

	public void setTbrDataLocationCountry(String tbrDataLocationCountry) {
		this.tbrDataLocationCountry = tbrDataLocationCountry;
	}

	public String getTbrDataLocationCountryCode() {
		return this.tbrDataLocationCountryCode;
	}

	public void setTbrDataLocationCountryCode(String tbrDataLocationCountryCode) {
		this.tbrDataLocationCountryCode = tbrDataLocationCountryCode;
	}

	public String getTbrDataLocationFormatted() {
		return this.tbrDataLocationFormatted;
	}

	public void setTbrDataLocationFormatted(String tbrDataLocationFormatted) {
		this.tbrDataLocationFormatted = tbrDataLocationFormatted;
	}

	public String getTbrDataLocationPostalCode() {
		return this.tbrDataLocationPostalCode;
	}

	public void setTbrDataLocationPostalCode(String tbrDataLocationPostalCode) {
		this.tbrDataLocationPostalCode = tbrDataLocationPostalCode;
	}

	public String getTbrDataLocationRawInput() {
		return this.tbrDataLocationRawInput;
	}

	public void setTbrDataLocationRawInput(String tbrDataLocationRawInput) {
		this.tbrDataLocationRawInput = tbrDataLocationRawInput;
	}

	public String getTbrDataLocationState() {
		return this.tbrDataLocationState;
	}

	public void setTbrDataLocationState(String tbrDataLocationState) {
		this.tbrDataLocationState = tbrDataLocationState;
	}

	public String getTbrDataLocationStreet() {
		return this.tbrDataLocationStreet;
	}

	public void setTbrDataLocationStreet(String tbrDataLocationStreet) {
		this.tbrDataLocationStreet = tbrDataLocationStreet;
	}

	public String getTbrDataLocationStreetNumber() {
		return this.tbrDataLocationStreetNumber;
	}

	public void setTbrDataLocationStreetNumber(String tbrDataLocationStreetNumber) {
		this.tbrDataLocationStreetNumber = tbrDataLocationStreetNumber;
	}

	public String getTbrDataNameFirst() {
		return this.tbrDataNameFirst;
	}

	public void setTbrDataNameFirst(String tbrDataNameFirst) {
		this.tbrDataNameFirst = tbrDataNameFirst;
	}

	public String getTbrDataNameLast() {
		return this.tbrDataNameLast;
	}

	public void setTbrDataNameLast(String tbrDataNameLast) {
		this.tbrDataNameLast = tbrDataNameLast;
	}

	public String getTbrDataNameMiddle() {
		return this.tbrDataNameMiddle;
	}

	public void setTbrDataNameMiddle(String tbrDataNameMiddle) {
		this.tbrDataNameMiddle = tbrDataNameMiddle;
	}

	public String getTbrDataNameRaw() {
		return this.tbrDataNameRaw;
	}

	public void setTbrDataNameRaw(String tbrDataNameRaw) {
		this.tbrDataNameRaw = tbrDataNameRaw;
	}

	public String getTbrDataNameTitle() {
		return this.tbrDataNameTitle;
	}

	public void setTbrDataNameTitle(String tbrDataNameTitle) {
		this.tbrDataNameTitle = tbrDataNameTitle;
	}

	public String getTbrDataObjective() {
		return this.tbrDataObjective;
	}

	public void setTbrDataObjective(String tbrDataObjective) {
		this.tbrDataObjective = tbrDataObjective;
	}

	public String getTbrDataPhoneNumbers() {
		return this.tbrDataPhoneNumbers;
	}

	public void setTbrDataPhoneNumbers(String tbrDataPhoneNumbers) {
		this.tbrDataPhoneNumbers = tbrDataPhoneNumbers;
	}

	public String getTbrDataProfession() {
		return this.tbrDataProfession;
	}

	public void setTbrDataProfession(String tbrDataProfession) {
		this.tbrDataProfession = tbrDataProfession;
	}

	public String getTbrDataPublications() {
		return this.tbrDataPublications;
	}

	public void setTbrDataPublications(String tbrDataPublications) {
		this.tbrDataPublications = tbrDataPublications;
	}

	public String getTbrDataRawText() {
		return this.tbrDataRawText;
	}

	public void setTbrDataRawText(String tbrDataRawText) {
		this.tbrDataRawText = tbrDataRawText;
	}

	public String getTbrDataReferees() {
		return this.tbrDataReferees;
	}

	public void setTbrDataReferees(String tbrDataReferees) {
		this.tbrDataReferees = tbrDataReferees;
	}

	public String getTbrDataSections() {
		return this.tbrDataSections;
	}

	public void setTbrDataSections(String tbrDataSections) {
		this.tbrDataSections = tbrDataSections;
	}

	public String getTbrDataSkills() {
		return this.tbrDataSkills;
	}

	public void setTbrDataSkills(String tbrDataSkills) {
		this.tbrDataSkills = tbrDataSkills;
	}

	public String getTbrDataSummary() {
		return this.tbrDataSummary;
	}

	public void setTbrDataSummary(String tbrDataSummary) {
		this.tbrDataSummary = tbrDataSummary;
	}

	public Integer getTbrDataTotalYearsExperience() {
		return this.tbrDataTotalYearsExperience;
	}

	public void setTbrDataTotalYearsExperience(Integer tbrDataTotalYearsExperience) {
		this.tbrDataTotalYearsExperience = tbrDataTotalYearsExperience;
	}

	public String getTbrDataWebsites() {
		return this.tbrDataWebsites;
	}

	public void setTbrDataWebsites(String tbrDataWebsites) {
		this.tbrDataWebsites = tbrDataWebsites;
	}

	public String getTbrDataWorkExperience() {
		return this.tbrDataWorkExperience;
	}

	public void setTbrDataWorkExperience(String tbrDataWorkExperience) {
		this.tbrDataWorkExperience = tbrDataWorkExperience;
	}

	public String getTbrErrorErrorCode() {
		return this.tbrErrorErrorCode;
	}

	public void setTbrErrorErrorCode(String tbrErrorErrorCode) {
		this.tbrErrorErrorCode = tbrErrorErrorCode;
	}

	public String getTbrErrorErrorDetail() {
		return this.tbrErrorErrorDetail;
	}

	public void setTbrErrorErrorDetail(String tbrErrorErrorDetail) {
		this.tbrErrorErrorDetail = tbrErrorErrorDetail;
	}

	public Integer getTbrId() {
		return this.tbrId;
	}

	public void setTbrId(Integer tbrId) {
		this.tbrId = tbrId;
	}

	public String getTbrMetaChildDocuments() {
		return this.tbrMetaChildDocuments;
	}

	public void setTbrMetaChildDocuments(String tbrMetaChildDocuments) {
		this.tbrMetaChildDocuments = tbrMetaChildDocuments;
	}

	public String getTbrMetaExpiryTime() {
		return this.tbrMetaExpiryTime;
	}

	public void setTbrMetaExpiryTime(String tbrMetaExpiryTime) {
		this.tbrMetaExpiryTime = tbrMetaExpiryTime;
	}

	public Integer getTbrMetaFailed() {
		return this.tbrMetaFailed;
	}

	public void setTbrMetaFailed(Integer tbrMetaFailed) {
		this.tbrMetaFailed = tbrMetaFailed;
	}

	public String getTbrMetaFileName() {
		return this.tbrMetaFileName;
	}

	public void setTbrMetaFileName(String tbrMetaFileName) {
		this.tbrMetaFileName = tbrMetaFileName;
	}

	public String getTbrMetaIdentifier() {
		return this.tbrMetaIdentifier;
	}

	public void setTbrMetaIdentifier(String tbrMetaIdentifier) {
		this.tbrMetaIdentifier = tbrMetaIdentifier;
	}

	public Integer getTbrMetaIsVerified() {
		return this.tbrMetaIsVerified;
	}

	public void setTbrMetaIsVerified(Integer tbrMetaIsVerified) {
		this.tbrMetaIsVerified = tbrMetaIsVerified;
	}

	public String getTbrMetaLanguage() {
		return this.tbrMetaLanguage;
	}

	public void setTbrMetaLanguage(String tbrMetaLanguage) {
		this.tbrMetaLanguage = tbrMetaLanguage;
	}

	public double getTbrMetaOcrConfidence() {
		return this.tbrMetaOcrConfidence;
	}

	public void setTbrMetaOcrConfidence(double tbrMetaOcrConfidence) {
		this.tbrMetaOcrConfidence = tbrMetaOcrConfidence;
	}

	public String getTbrMetaPages() {
		return this.tbrMetaPages;
	}

	public void setTbrMetaPages(String tbrMetaPages) {
		this.tbrMetaPages = tbrMetaPages;
	}

	public String getTbrMetaParentDocumentIdentifier() {
		return this.tbrMetaParentDocumentIdentifier;
	}

	public void setTbrMetaParentDocumentIdentifier(String tbrMetaParentDocumentIdentifier) {
		this.tbrMetaParentDocumentIdentifier = tbrMetaParentDocumentIdentifier;
	}

	public String getTbrMetaPdf() {
		return this.tbrMetaPdf;
	}

	public void setTbrMetaPdf(String tbrMetaPdf) {
		this.tbrMetaPdf = tbrMetaPdf;
	}

	public Integer getTbrMetaReady() {
		return this.tbrMetaReady;
	}

	public void setTbrMetaReady(Integer tbrMetaReady) {
		this.tbrMetaReady = tbrMetaReady;
	}

	public String getTbrMetaReadyDt() {
		return this.tbrMetaReadyDt;
	}

	public void setTbrMetaReadyDt(String tbrMetaReadyDt) {
		this.tbrMetaReadyDt = tbrMetaReadyDt;
	}

	public String getTbrMetaReviewUrl() {
		return this.tbrMetaReviewUrl;
	}

	public void setTbrMetaReviewUrl(String tbrMetaReviewUrl) {
		this.tbrMetaReviewUrl = tbrMetaReviewUrl;
	}

	public String getTbrStatus() {
		return this.tbrStatus;
	}

	public void setTbrStatus(String tbrStatus) {
		this.tbrStatus = tbrStatus;
	}

	public Date getTbrUpdateDate() {
		return this.tbrUpdateDate;
	}

	public void setTbrUpdateDate(Date tbrUpdateDate) {
		this.tbrUpdateDate = tbrUpdateDate;
	}

	public Integer getTbrUpdateId() {
		return this.tbrUpdateId;
	}

	public void setTbrUpdateId(Integer tbrUpdateId) {
		this.tbrUpdateId = tbrUpdateId;
	}

	public String getTbrUuid() {
		return this.tbrUuid;
	}

	public void setTbrUuid(String tbrUuid) {
		this.tbrUuid = tbrUuid;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}