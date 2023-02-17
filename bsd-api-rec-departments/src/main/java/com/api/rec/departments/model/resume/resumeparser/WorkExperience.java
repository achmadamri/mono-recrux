package com.api.rec.departments.model.resume.resumeparser;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date_start",
        "jobtitle",
        "organization",
        "date_end",
        "text",
        "section_title"
})
@Generated("jsonschema2pojo")
public class WorkExperience {

    @JsonProperty("date_start")
    private String dateStart;
    @JsonProperty("jobtitle")
    private String jobtitle;
    @JsonProperty("organization")
    private String organization;
    @JsonProperty("date_end")
    private String dateEnd;
    @JsonProperty("text")
    private String text;
    @JsonProperty("section_title")
    private String sectionTitle;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("date_start")
    public String getDateStart() {
        return dateStart;
    }

    @JsonProperty("date_start")
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    @JsonProperty("jobtitle")
    public String getJobtitle() {
        return jobtitle;
    }

    @JsonProperty("jobtitle")
    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    @JsonProperty("organization")
    public String getOrganization() {
        return organization;
    }

    @JsonProperty("organization")
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @JsonProperty("date_end")
    public String getDateEnd() {
        return dateEnd;
    }

    @JsonProperty("date_end")
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("section_title")
    public String getSectionTitle() {
        return sectionTitle;
    }

    @JsonProperty("section_title")
    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}