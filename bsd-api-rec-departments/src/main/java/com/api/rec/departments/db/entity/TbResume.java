package com.api.rec.departments.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_resume database table.
 * 
 */
@Entity
@Table(name="tb_resume")
@NamedQuery(name="TbResume.findAll", query="SELECT t FROM TbResume t")
public class TbResume implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tbr_id")
	private Integer tbrId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbr_create_date")
	private Date tbrCreateDate;

	@Column(name="tbr_create_id")
	private Integer tbrCreateId;

	@Column(name="tbr_create_idc")
	private Integer tbrCreateIdc;

	@Column(name="tbj_id")
	private Integer tbjId;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_certifications")
	private String tbrDataCertifications;
	
	@Lob
	@Column(columnDefinition = "text", name="tbr_data_date_of_birth")
	private String tbrDataDateOfBirth;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_education")
	private String tbrDataEducation;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_emails")
	private String tbrDataEmails;

	@Column(columnDefinition = "text", name="tbr_data_head_shot")
	private String tbrDataHeadShot;

	@Column(name="tbr_data_is_resume_probability")
	private Integer tbrDataIsResumeProbability;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_language_codes")
	private String tbrDataLanguageCodes;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_languages")
	private String tbrDataLanguages;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_linkedin")
	private String tbrDataLinkedin;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_location_apartment_number")
	private String tbrDataLocationApartmentNumber;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_location_city")
	private String tbrDataLocationCity;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_location_country")
	private String tbrDataLocationCountry;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_location_country_code")
	private String tbrDataLocationCountryCode;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_location_formatted")
	private String tbrDataLocationFormatted;
	
	@Lob
	@Column(columnDefinition = "text", name="tbr_data_location_postal_code")
	private String tbrDataLocationPostalCode;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_location_raw_input")
	private String tbrDataLocationRawInput;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_location_state")
	private String tbrDataLocationState;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_location_street")
	private String tbrDataLocationStreet;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_location_street_number")
	private String tbrDataLocationStreetNumber;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_name_first")
	private String tbrDataNameFirst;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_name_last")
	private String tbrDataNameLast;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_name_middle")
	private String tbrDataNameMiddle;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_name_raw")
	private String tbrDataNameRaw;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_name_title")
	private String tbrDataNameTitle;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_objective")
	private String tbrDataObjective;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_phone_numbers")
	private String tbrDataPhoneNumbers;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_profession")
	private String tbrDataProfession;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_publications")
	private String tbrDataPublications;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_raw_text")
	private String tbrDataRawText;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_referees")
	private String tbrDataReferees;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_sections")
	private String tbrDataSections;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_skills")
	private String tbrDataSkills;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_summary")
	private String tbrDataSummary;

	@Column(name="tbr_data_total_years_experience")
	private Integer tbrDataTotalYearsExperience;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_websites")
	private String tbrDataWebsites;

	@Lob
	@Column(columnDefinition = "text", name="tbr_data_work_experience")
	private String tbrDataWorkExperience;

	@Lob
	@Column(columnDefinition = "text", name="tbr_error_error_code")
	private String tbrErrorErrorCode;

	@Lob
	@Column(columnDefinition = "text", name="tbr_error_error_detail")
	private String tbrErrorErrorDetail;

	@Lob
	@Column(columnDefinition = "text", name="tbr_meta_child_documents")
	private String tbrMetaChildDocuments;

	@Lob
	@Column(columnDefinition = "text", name="tbr_meta_expiry_time")
	private String tbrMetaExpiryTime;

	@Column(name="tbr_meta_failed")
	private Integer tbrMetaFailed;

	@Lob
	@Column(columnDefinition = "text", name="tbr_meta_file_name")
	private String tbrMetaFileName;

	@Lob
	@Column(columnDefinition = "text", name="tbr_meta_identifier")
	private String tbrMetaIdentifier;

	@Column(name="tbr_meta_is_verified")
	private Integer tbrMetaIsVerified;

	@Lob
	@Column(columnDefinition = "text", name="tbr_meta_language")
	private String tbrMetaLanguage;

	@Column(name="tbr_meta_ocr_confidence")
	private Double tbrMetaOcrConfidence;

	@Lob
	@Column(columnDefinition = "text", name="tbr_meta_pages")
	private String tbrMetaPages;

	@Lob
	@Column(columnDefinition = "text", name="tbr_meta_parent_document_identifier")
	private String tbrMetaParentDocumentIdentifier;

	@Lob
	@Column(columnDefinition = "text", name="tbr_meta_pdf")
	private String tbrMetaPdf;

	@Column(name="tbr_meta_ready")
	private Integer tbrMetaReady;

	@Lob
	@Column(columnDefinition = "text", name="tbr_meta_ready_dt")
	private String tbrMetaReadyDt;

	@Lob
	@Column(columnDefinition = "text", name="tbr_meta_review_url")
	private String tbrMetaReviewUrl;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbr_update_date")
	private Date tbrUpdateDate;

	@Column(name="tbr_update_id")
	private Integer tbrUpdateId;

	@Column(name="tbr_status")
	private String tbrStatus;

	@Column(name="tbr_assigned")
	private String tbrAssigned;

	@Column(name="tbr_uuid")
	private String tbrUuid;

	@Column(name="tbr_score")
	private Integer tbrScore;

	@Column(name="tbr_star")
	private Integer tbrStar;

	@Lob
	@Column(columnDefinition = "text", name="tbr_note")
	private String tbrNote;	

	@Column(name="tbr_resume_status")
	private String tbrResumeStatus;

	public TbResume() {
	}

	public Integer getTbrId() {
		return tbrId;
	}

	public void setTbrId(Integer tbrId) {
		this.tbrId = tbrId;
	}

	public Date getTbrCreateDate() {
		return tbrCreateDate;
	}

	public void setTbrCreateDate(Date tbrCreateDate) {
		this.tbrCreateDate = tbrCreateDate;
	}

	public Integer getTbrCreateId() {
		return tbrCreateId;
	}

	public void setTbrCreateId(Integer tbrCreateId) {
		this.tbrCreateId = tbrCreateId;
	}

	public Integer getTbrCreateIdc() {
		return tbrCreateIdc;
	}

	public void setTbrCreateIdc(Integer tbrCreateIdc) {
		this.tbrCreateIdc = tbrCreateIdc;
	}

	public Integer getTbjId() {
		return tbjId;
	}

	public void setTbjId(Integer tbjId) {
		this.tbjId = tbjId;
	}

	public String getTbrDataCertifications() {
		return tbrDataCertifications;
	}

	public void setTbrDataCertifications(String tbrDataCertifications) {
		this.tbrDataCertifications = tbrDataCertifications;
	}

	public String getTbrDataDateOfBirth() {
		return tbrDataDateOfBirth;
	}

	public void setTbrDataDateOfBirth(String tbrDataDateOfBirth) {
		this.tbrDataDateOfBirth = tbrDataDateOfBirth;
	}

	public String getTbrDataEducation() {
		return tbrDataEducation;
	}

	public void setTbrDataEducation(String tbrDataEducation) {
		this.tbrDataEducation = tbrDataEducation;
	}

	public String getTbrDataEmails() {
		return tbrDataEmails;
	}

	public void setTbrDataEmails(String tbrDataEmails) {
		this.tbrDataEmails = tbrDataEmails;
	}

	public String getTbrDataHeadShot() {
		return tbrDataHeadShot;
	}

	public void setTbrDataHeadShot(String tbrDataHeadShot) {
		this.tbrDataHeadShot = tbrDataHeadShot;
	}

	public Integer getTbrDataIsResumeProbability() {
		return tbrDataIsResumeProbability;
	}

	public void setTbrDataIsResumeProbability(Integer tbrDataIsResumeProbability) {
		this.tbrDataIsResumeProbability = tbrDataIsResumeProbability;
	}

	public String getTbrDataLanguageCodes() {
		return tbrDataLanguageCodes;
	}

	public void setTbrDataLanguageCodes(String tbrDataLanguageCodes) {
		this.tbrDataLanguageCodes = tbrDataLanguageCodes;
	}

	public String getTbrDataLanguages() {
		return tbrDataLanguages;
	}

	public void setTbrDataLanguages(String tbrDataLanguages) {
		this.tbrDataLanguages = tbrDataLanguages;
	}

	public String getTbrDataLinkedin() {
		return tbrDataLinkedin;
	}

	public void setTbrDataLinkedin(String tbrDataLinkedin) {
		this.tbrDataLinkedin = tbrDataLinkedin;
	}

	public String getTbrDataLocationApartmentNumber() {
		return tbrDataLocationApartmentNumber;
	}

	public void setTbrDataLocationApartmentNumber(String tbrDataLocationApartmentNumber) {
		this.tbrDataLocationApartmentNumber = tbrDataLocationApartmentNumber;
	}

	public String getTbrDataLocationCity() {
		return tbrDataLocationCity;
	}

	public void setTbrDataLocationCity(String tbrDataLocationCity) {
		this.tbrDataLocationCity = tbrDataLocationCity;
	}

	public String getTbrDataLocationCountry() {
		return tbrDataLocationCountry;
	}

	public void setTbrDataLocationCountry(String tbrDataLocationCountry) {
		this.tbrDataLocationCountry = tbrDataLocationCountry;
	}

	public String getTbrDataLocationCountryCode() {
		return tbrDataLocationCountryCode;
	}

	public void setTbrDataLocationCountryCode(String tbrDataLocationCountryCode) {
		this.tbrDataLocationCountryCode = tbrDataLocationCountryCode;
	}

	public String getTbrDataLocationFormatted() {
		return tbrDataLocationFormatted;
	}

	public void setTbrDataLocationFormatted(String tbrDataLocationFormatted) {
		this.tbrDataLocationFormatted = tbrDataLocationFormatted;
	}

	public String getTbrDataLocationPostalCode() {
		return tbrDataLocationPostalCode;
	}

	public void setTbrDataLocationPostalCode(String tbrDataLocationPostalCode) {
		this.tbrDataLocationPostalCode = tbrDataLocationPostalCode;
	}

	public String getTbrDataLocationRawInput() {
		return tbrDataLocationRawInput;
	}

	public void setTbrDataLocationRawInput(String tbrDataLocationRawInput) {
		this.tbrDataLocationRawInput = tbrDataLocationRawInput;
	}

	public String getTbrDataLocationState() {
		return tbrDataLocationState;
	}

	public void setTbrDataLocationState(String tbrDataLocationState) {
		this.tbrDataLocationState = tbrDataLocationState;
	}

	public String getTbrDataLocationStreet() {
		return tbrDataLocationStreet;
	}

	public void setTbrDataLocationStreet(String tbrDataLocationStreet) {
		this.tbrDataLocationStreet = tbrDataLocationStreet;
	}

	public String getTbrDataLocationStreetNumber() {
		return tbrDataLocationStreetNumber;
	}

	public void setTbrDataLocationStreetNumber(String tbrDataLocationStreetNumber) {
		this.tbrDataLocationStreetNumber = tbrDataLocationStreetNumber;
	}

	public String getTbrDataNameFirst() {
		return tbrDataNameFirst;
	}

	public void setTbrDataNameFirst(String tbrDataNameFirst) {
		this.tbrDataNameFirst = tbrDataNameFirst;
	}

	public String getTbrDataNameLast() {
		return tbrDataNameLast;
	}

	public void setTbrDataNameLast(String tbrDataNameLast) {
		this.tbrDataNameLast = tbrDataNameLast;
	}

	public String getTbrDataNameMiddle() {
		return tbrDataNameMiddle;
	}

	public void setTbrDataNameMiddle(String tbrDataNameMiddle) {
		this.tbrDataNameMiddle = tbrDataNameMiddle;
	}

	public String getTbrDataNameRaw() {
		return tbrDataNameRaw;
	}

	public void setTbrDataNameRaw(String tbrDataNameRaw) {
		this.tbrDataNameRaw = tbrDataNameRaw;
	}

	public String getTbrDataNameTitle() {
		return tbrDataNameTitle;
	}

	public void setTbrDataNameTitle(String tbrDataNameTitle) {
		this.tbrDataNameTitle = tbrDataNameTitle;
	}

	public String getTbrDataObjective() {
		return tbrDataObjective;
	}

	public void setTbrDataObjective(String tbrDataObjective) {
		this.tbrDataObjective = tbrDataObjective;
	}

	public String getTbrDataPhoneNumbers() {
		return tbrDataPhoneNumbers;
	}

	public void setTbrDataPhoneNumbers(String tbrDataPhoneNumbers) {
		this.tbrDataPhoneNumbers = tbrDataPhoneNumbers;
	}

	public String getTbrDataProfession() {
		return tbrDataProfession;
	}

	public void setTbrDataProfession(String tbrDataProfession) {
		this.tbrDataProfession = tbrDataProfession;
	}

	public String getTbrDataPublications() {
		return tbrDataPublications;
	}

	public void setTbrDataPublications(String tbrDataPublications) {
		this.tbrDataPublications = tbrDataPublications;
	}

	public String getTbrDataRawText() {
		return tbrDataRawText;
	}

	public void setTbrDataRawText(String tbrDataRawText) {
		this.tbrDataRawText = tbrDataRawText;
	}

	public String getTbrDataReferees() {
		return tbrDataReferees;
	}

	public void setTbrDataReferees(String tbrDataReferees) {
		this.tbrDataReferees = tbrDataReferees;
	}

	public String getTbrDataSections() {
		return tbrDataSections;
	}

	public void setTbrDataSections(String tbrDataSections) {
		this.tbrDataSections = tbrDataSections;
	}

	public String getTbrDataSkills() {
		return tbrDataSkills;
	}

	public void setTbrDataSkills(String tbrDataSkills) {
		this.tbrDataSkills = tbrDataSkills;
	}

	public String getTbrDataSummary() {
		return tbrDataSummary;
	}

	public void setTbrDataSummary(String tbrDataSummary) {
		this.tbrDataSummary = tbrDataSummary;
	}

	public Integer getTbrDataTotalYearsExperience() {
		return tbrDataTotalYearsExperience;
	}

	public void setTbrDataTotalYearsExperience(Integer tbrDataTotalYearsExperience) {
		this.tbrDataTotalYearsExperience = tbrDataTotalYearsExperience;
	}

	public String getTbrDataWebsites() {
		return tbrDataWebsites;
	}

	public void setTbrDataWebsites(String tbrDataWebsites) {
		this.tbrDataWebsites = tbrDataWebsites;
	}

	public String getTbrDataWorkExperience() {
		return tbrDataWorkExperience;
	}

	public void setTbrDataWorkExperience(String tbrDataWorkExperience) {
		this.tbrDataWorkExperience = tbrDataWorkExperience;
	}

	public String getTbrErrorErrorCode() {
		return tbrErrorErrorCode;
	}

	public void setTbrErrorErrorCode(String tbrErrorErrorCode) {
		this.tbrErrorErrorCode = tbrErrorErrorCode;
	}

	public String getTbrErrorErrorDetail() {
		return tbrErrorErrorDetail;
	}

	public void setTbrErrorErrorDetail(String tbrErrorErrorDetail) {
		this.tbrErrorErrorDetail = tbrErrorErrorDetail;
	}

	public String getTbrMetaChildDocuments() {
		return tbrMetaChildDocuments;
	}

	public void setTbrMetaChildDocuments(String tbrMetaChildDocuments) {
		this.tbrMetaChildDocuments = tbrMetaChildDocuments;
	}

	public String getTbrMetaExpiryTime() {
		return tbrMetaExpiryTime;
	}

	public void setTbrMetaExpiryTime(String tbrMetaExpiryTime) {
		this.tbrMetaExpiryTime = tbrMetaExpiryTime;
	}

	public Integer getTbrMetaFailed() {
		return tbrMetaFailed;
	}

	public void setTbrMetaFailed(Integer tbrMetaFailed) {
		this.tbrMetaFailed = tbrMetaFailed;
	}

	public String getTbrMetaFileName() {
		return tbrMetaFileName;
	}

	public void setTbrMetaFileName(String tbrMetaFileName) {
		this.tbrMetaFileName = tbrMetaFileName;
	}

	public String getTbrMetaIdentifier() {
		return tbrMetaIdentifier;
	}

	public void setTbrMetaIdentifier(String tbrMetaIdentifier) {
		this.tbrMetaIdentifier = tbrMetaIdentifier;
	}

	public Integer getTbrMetaIsVerified() {
		return tbrMetaIsVerified;
	}

	public void setTbrMetaIsVerified(Integer tbrMetaIsVerified) {
		this.tbrMetaIsVerified = tbrMetaIsVerified;
	}

	public String getTbrMetaLanguage() {
		return tbrMetaLanguage;
	}

	public void setTbrMetaLanguage(String tbrMetaLanguage) {
		this.tbrMetaLanguage = tbrMetaLanguage;
	}

	public Double getTbrMetaOcrConfidence() {
		return tbrMetaOcrConfidence;
	}

	public void setTbrMetaOcrConfidence(Double tbrMetaOcrConfidence) {
		this.tbrMetaOcrConfidence = tbrMetaOcrConfidence;
	}

	public String getTbrMetaPages() {
		return tbrMetaPages;
	}

	public void setTbrMetaPages(String tbrMetaPages) {
		this.tbrMetaPages = tbrMetaPages;
	}

	public String getTbrMetaParentDocumentIdentifier() {
		return tbrMetaParentDocumentIdentifier;
	}

	public void setTbrMetaParentDocumentIdentifier(String tbrMetaParentDocumentIdentifier) {
		this.tbrMetaParentDocumentIdentifier = tbrMetaParentDocumentIdentifier;
	}

	public String getTbrMetaPdf() {
		return tbrMetaPdf;
	}

	public void setTbrMetaPdf(String tbrMetaPdf) {
		this.tbrMetaPdf = tbrMetaPdf;
	}

	public Integer getTbrMetaReady() {
		return tbrMetaReady;
	}

	public void setTbrMetaReady(Integer tbrMetaReady) {
		this.tbrMetaReady = tbrMetaReady;
	}

	public String getTbrMetaReadyDt() {
		return tbrMetaReadyDt;
	}

	public void setTbrMetaReadyDt(String tbrMetaReadyDt) {
		this.tbrMetaReadyDt = tbrMetaReadyDt;
	}

	public String getTbrMetaReviewUrl() {
		return tbrMetaReviewUrl;
	}

	public void setTbrMetaReviewUrl(String tbrMetaReviewUrl) {
		this.tbrMetaReviewUrl = tbrMetaReviewUrl;
	}

	public Date getTbrUpdateDate() {
		return tbrUpdateDate;
	}

	public void setTbrUpdateDate(Date tbrUpdateDate) {
		this.tbrUpdateDate = tbrUpdateDate;
	}

	public Integer getTbrUpdateId() {
		return tbrUpdateId;
	}

	public void setTbrUpdateId(Integer tbrUpdateId) {
		this.tbrUpdateId = tbrUpdateId;
	}

	public String getTbrStatus() {
		return tbrStatus;
	}

	public void setTbrStatus(String tbrStatus) {
		this.tbrStatus = tbrStatus;
	}

	public String getTbrAssigned() {
		return tbrAssigned;
	}

	public void setTbrAssigned(String tbrAssigned) {
		this.tbrAssigned = tbrAssigned;
	}

	public String getTbrUuid() {
		return tbrUuid;
	}

	public void setTbrUuid(String tbrUuid) {
		this.tbrUuid = tbrUuid;
	}

	public Integer getTbrScore() {
		return tbrScore;
	}

	public void setTbrScore(Integer tbrScore) {
		this.tbrScore = tbrScore;
	}

	public Integer getTbrStar() {
		return tbrStar;
	}

	public void setTbrStar(Integer tbrStar) {
		this.tbrStar = tbrStar;
	}

	public String getTbrNote() {
		return tbrNote;
	}

	public void setTbrNote(String tbrNote) {
		this.tbrNote = tbrNote;
	}

	public String getTbrResumeStatus() {
		return tbrResumeStatus;
	}

	public void setTbrResumeStatus(String tbrResumeStatus) {
		this.tbrResumeStatus = tbrResumeStatus;
	}

}