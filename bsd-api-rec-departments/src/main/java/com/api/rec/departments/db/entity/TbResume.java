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
	@Column(name="tbr_id")
	private int tbrId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbr_create_date")
	private Date tbrCreateDate;

	@Column(name="tbr_create_id")
	private int tbrCreateId;

	@Column(name="tbr_create_idc")
	private int tbrCreateIdc;

	@Lob
	@Column(columnDefinition = "LONGTEXT", name="tbr_data_certifications")
	private Object tbrDataCertifications;
	
	@Column(name="tbr_data_date_of_birth")
	private String tbrDataDateOfBirth;

	@Lob
	@Column(columnDefinition = "LONGTEXT", name="tbr_data_education")
	private Object tbrDataEducation;

	@Lob
	@Column(columnDefinition = "LONGTEXT", name="tbr_data_emails")
	private Object tbrDataEmails;

	@Column(name="tbr_data_head_shot")
	private String tbrDataHeadShot;

	@Column(name="tbr_data_is_resume_probability")
	private int tbrDataIsResumeProbability;

	@Lob
	@Column(name="tbr_data_language_codes")
	private String tbrDataLanguageCodes;

	@Lob
	@Column(columnDefinition = "LONGTEXT", name="tbr_data_languages")
	private Object tbrDataLanguages;

	@Column(name="tbr_data_linkedin")
	private String tbrDataLinkedin;

	@Column(name="tbr_data_location_apartment_number")
	private String tbrDataLocationApartmentNumber;

	@Column(name="tbr_data_location_city")
	private String tbrDataLocationCity;

	@Column(name="tbr_data_location_country")
	private String tbrDataLocationCountry;

	@Column(name="tbr_data_location_country_code")
	private String tbrDataLocationCountryCode;

	@Column(name="tbr_data_location_formatted")
	private String tbrDataLocationFormatted;
	
	@Column(name="tbr_data_location_postal_code")
	private String tbrDataLocationPostalCode;

	@Column(name="tbr_data_location_raw_input")
	private String tbrDataLocationRawInput;

	@Column(name="tbr_data_location_state")
	private String tbrDataLocationState;

	@Column(name="tbr_data_location_street")
	private String tbrDataLocationStreet;

	@Column(name="tbr_data_location_street_number")
	private String tbrDataLocationStreetNumber;

	@Column(name="tbr_data_name_first")
	private String tbrDataNameFirst;

	@Column(name="tbr_data_name_last")
	private String tbrDataNameLast;

	@Column(name="tbr_data_name_middle")
	private String tbrDataNameMiddle;

	@Column(name="tbr_data_name_raw")
	private String tbrDataNameRaw;

	@Column(name="tbr_data_name_title")
	private String tbrDataNameTitle;

	@Column(name="tbr_data_objective")
	private String tbrDataObjective;

	@Lob
	@Column(name="tbr_data_phone_numbers")
	private String tbrDataPhoneNumbers;

	@Column(name="tbr_data_profession")
	private String tbrDataProfession;

	@Lob
	@Column(columnDefinition = "LONGTEXT", name="tbr_data_publications")
	private Object tbrDataPublications;

	@Column(name="tbr_data_raw_text")
	private String tbrDataRawText;

	@Lob
	@Column(columnDefinition = "LONGTEXT", name="tbr_data_referees")
	private Object tbrDataReferees;

	@Lob
	@Column(columnDefinition = "LONGTEXT", name="tbr_data_sections")
	private Object tbrDataSections;

	@Lob
	@Column(columnDefinition = "LONGTEXT", name="tbr_data_skills")
	private Object tbrDataSkills;

	@Column(name="tbr_data_summary")
	private String tbrDataSummary;

	@Column(name="tbr_data_total_years_experience")
	private int tbrDataTotalYearsExperience;

	@Lob
	@Column(columnDefinition = "LONGTEXT", name="tbr_data_websites")
	private Object tbrDataWebsites;

	@Lob
	@Column(name="tbr_data_work_experience")
	private String tbrDataWorkExperience;

	@Column(name="tbr_error_error_code")
	private String tbrErrorErrorCode;

	@Column(name="tbr_error_error_detail")
	private String tbrErrorErrorDetail;

	@Lob
	@Column(name="tbr_meta_child_documents")
	private String tbrMetaChildDocuments;

	@Column(name="tbr_meta_expiry_time")
	private String tbrMetaExpiryTime;

	@Column(name="tbr_meta_failed")
	private int tbrMetaFailed;

	@Column(name="tbr_meta_file_name")
	private String tbrMetaFileName;

	@Column(name="tbr_meta_identifier")
	private String tbrMetaIdentifier;

	@Column(name="tbr_meta_is_verified")
	private int tbrMetaIsVerified;

	@Column(name="tbr_meta_language")
	private String tbrMetaLanguage;

	@Column(name="tbr_meta_ocr_confidence")
	private double tbrMetaOcrConfidence;

	@Lob
	@Column(columnDefinition = "LONGTEXT", name="tbr_meta_pages")
	private Object tbrMetaPages;

	@Column(name="tbr_meta_parent_document_identifier")
	private String tbrMetaParentDocumentIdentifier;

	@Column(name="tbr_meta_pdf")
	private String tbrMetaPdf;

	@Column(name="tbr_meta_ready")
	private int tbrMetaReady;

	@Column(name="tbr_meta_ready_dt")
	private String tbrMetaReadyDt;

	@Column(name="tbr_meta_review_url")
	private String tbrMetaReviewUrl;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="tbr_update_date")
	private Date tbrUpdateDate;

	@Column(name="tbr_update_id")
	private int tbrUpdateId;

	public TbResume() {
	}

	public int getTbrId() {
		return tbrId;
	}

	public void setTbrId(int tbrId) {
		this.tbrId = tbrId;
	}

	public Date getTbrCreateDate() {
		return tbrCreateDate;
	}

	public void setTbrCreateDate(Date tbrCreateDate) {
		this.tbrCreateDate = tbrCreateDate;
	}

	public int getTbrCreateId() {
		return tbrCreateId;
	}

	public void setTbrCreateId(int tbrCreateId) {
		this.tbrCreateId = tbrCreateId;
	}

	public int getTbrCreateIdc() {
		return tbrCreateIdc;
	}

	public void setTbrCreateIdc(int tbrCreateIdc) {
		this.tbrCreateIdc = tbrCreateIdc;
	}

	public Object getTbrDataCertifications() {
		return tbrDataCertifications;
	}

	public void setTbrDataCertifications(Object tbrDataCertifications) {
		this.tbrDataCertifications = tbrDataCertifications;
	}

	public String getTbrDataDateOfBirth() {
		return tbrDataDateOfBirth;
	}

	public void setTbrDataDateOfBirth(String tbrDataDateOfBirth) {
		this.tbrDataDateOfBirth = tbrDataDateOfBirth;
	}

	public Object getTbrDataEducation() {
		return tbrDataEducation;
	}

	public void setTbrDataEducation(Object tbrDataEducation) {
		this.tbrDataEducation = tbrDataEducation;
	}

	public Object getTbrDataEmails() {
		return tbrDataEmails;
	}

	public void setTbrDataEmails(Object tbrDataEmails) {
		this.tbrDataEmails = tbrDataEmails;
	}

	public String getTbrDataHeadShot() {
		return tbrDataHeadShot;
	}

	public void setTbrDataHeadShot(String tbrDataHeadShot) {
		this.tbrDataHeadShot = tbrDataHeadShot;
	}

	public int getTbrDataIsResumeProbability() {
		return tbrDataIsResumeProbability;
	}

	public void setTbrDataIsResumeProbability(int tbrDataIsResumeProbability) {
		this.tbrDataIsResumeProbability = tbrDataIsResumeProbability;
	}

	public String getTbrDataLanguageCodes() {
		return tbrDataLanguageCodes;
	}

	public void setTbrDataLanguageCodes(String tbrDataLanguageCodes) {
		this.tbrDataLanguageCodes = tbrDataLanguageCodes;
	}

	public Object getTbrDataLanguages() {
		return tbrDataLanguages;
	}

	public void setTbrDataLanguages(Object tbrDataLanguages) {
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

	public Object getTbrDataPublications() {
		return tbrDataPublications;
	}

	public void setTbrDataPublications(Object tbrDataPublications) {
		this.tbrDataPublications = tbrDataPublications;
	}

	public String getTbrDataRawText() {
		return tbrDataRawText;
	}

	public void setTbrDataRawText(String tbrDataRawText) {
		this.tbrDataRawText = tbrDataRawText;
	}

	public Object getTbrDataReferees() {
		return tbrDataReferees;
	}

	public void setTbrDataReferees(Object tbrDataReferees) {
		this.tbrDataReferees = tbrDataReferees;
	}

	public Object getTbrDataSections() {
		return tbrDataSections;
	}

	public void setTbrDataSections(Object tbrDataSections) {
		this.tbrDataSections = tbrDataSections;
	}

	public Object getTbrDataSkills() {
		return tbrDataSkills;
	}

	public void setTbrDataSkills(Object tbrDataSkills) {
		this.tbrDataSkills = tbrDataSkills;
	}

	public String getTbrDataSummary() {
		return tbrDataSummary;
	}

	public void setTbrDataSummary(String tbrDataSummary) {
		this.tbrDataSummary = tbrDataSummary;
	}

	public int getTbrDataTotalYearsExperience() {
		return tbrDataTotalYearsExperience;
	}

	public void setTbrDataTotalYearsExperience(int tbrDataTotalYearsExperience) {
		this.tbrDataTotalYearsExperience = tbrDataTotalYearsExperience;
	}

	public Object getTbrDataWebsites() {
		return tbrDataWebsites;
	}

	public void setTbrDataWebsites(Object tbrDataWebsites) {
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

	public int getTbrMetaFailed() {
		return tbrMetaFailed;
	}

	public void setTbrMetaFailed(int tbrMetaFailed) {
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

	public int getTbrMetaIsVerified() {
		return tbrMetaIsVerified;
	}

	public void setTbrMetaIsVerified(int tbrMetaIsVerified) {
		this.tbrMetaIsVerified = tbrMetaIsVerified;
	}

	public String getTbrMetaLanguage() {
		return tbrMetaLanguage;
	}

	public void setTbrMetaLanguage(String tbrMetaLanguage) {
		this.tbrMetaLanguage = tbrMetaLanguage;
	}

	public double getTbrMetaOcrConfidence() {
		return tbrMetaOcrConfidence;
	}

	public void setTbrMetaOcrConfidence(double tbrMetaOcrConfidence) {
		this.tbrMetaOcrConfidence = tbrMetaOcrConfidence;
	}

	public Object getTbrMetaPages() {
		return tbrMetaPages;
	}

	public void setTbrMetaPages(Object tbrMetaPages) {
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

	public int getTbrMetaReady() {
		return tbrMetaReady;
	}

	public void setTbrMetaReady(int tbrMetaReady) {
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

	public int getTbrUpdateId() {
		return tbrUpdateId;
	}

	public void setTbrUpdateId(int tbrUpdateId) {
		this.tbrUpdateId = tbrUpdateId;
	}

}