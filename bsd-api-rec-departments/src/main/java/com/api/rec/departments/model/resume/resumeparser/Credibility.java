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
        "section_title_from_resume"
})
@Generated("jsonschema2pojo")
public class Credibility {

    @JsonProperty("section_title_from_resume")
    private String sectionTitleFromResume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("section_title_from_resume")
    public String getSectionTitleFromResume() {
        return sectionTitleFromResume;
    }

    @JsonProperty("section_title_from_resume")
    public void setSectionTitleFromResume(String sectionTitleFromResume) {
        this.sectionTitleFromResume = sectionTitleFromResume;
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