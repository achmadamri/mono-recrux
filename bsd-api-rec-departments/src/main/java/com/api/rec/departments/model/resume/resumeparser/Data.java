package com.api.rec.departments.model.resume.resumeparser;

import java.util.LinkedHashMap;
import java.util.List;
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
        "title",
        "gender",
        "name",
        "email",
        "address",
        "phone",
        "url",
        "work_experience",
        "skills",
        "education_and_training",
        "accomplishments",
        "awards",
        "credibility",
        "extracurricular",
        "misc"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("title")
    private String title;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("email")
    private List<Object> email;
    @JsonProperty("address")
    private List<Object> address;
    @JsonProperty("phone")
    private List<Object> phone;
    @JsonProperty("url")
    private List<Object> url;
    @JsonProperty("work_experience")
    private List<WorkExperience> workExperience;
    @JsonProperty("skills")
    private List<Skill> skills;
    @JsonProperty("education_and_training")
    private List<EducationAndTraining> educationAndTraining;
    @JsonProperty("accomplishments")
    private List<Accomplishment> accomplishments;
    @JsonProperty("awards")
    private List<Award> awards;
    @JsonProperty("credibility")
    private List<Credibility> credibility;
    @JsonProperty("extracurricular")
    private List<Extracurricular> extracurricular;
    @JsonProperty("misc")
    private List<Misc> misc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("name")
    public Name getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty("email")
    public List<Object> getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(List<Object> email) {
        this.email = email;
    }

    @JsonProperty("address")
    public List<Object> getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(List<Object> address) {
        this.address = address;
    }

    @JsonProperty("phone")
    public List<Object> getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(List<Object> phone) {
        this.phone = phone;
    }

    @JsonProperty("url")
    public List<Object> getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(List<Object> url) {
        this.url = url;
    }

    @JsonProperty("work_experience")
    public List<WorkExperience> getWorkExperience() {
        return workExperience;
    }

    @JsonProperty("work_experience")
    public void setWorkExperience(List<WorkExperience> workExperience) {
        this.workExperience = workExperience;
    }

    @JsonProperty("skills")
    public List<Skill> getSkills() {
        return skills;
    }

    @JsonProperty("skills")
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @JsonProperty("education_and_training")
    public List<EducationAndTraining> getEducationAndTraining() {
        return educationAndTraining;
    }

    @JsonProperty("education_and_training")
    public void setEducationAndTraining(List<EducationAndTraining> educationAndTraining) {
        this.educationAndTraining = educationAndTraining;
    }

    @JsonProperty("accomplishments")
    public List<Accomplishment> getAccomplishments() {
        return accomplishments;
    }

    @JsonProperty("accomplishments")
    public void setAccomplishments(List<Accomplishment> accomplishments) {
        this.accomplishments = accomplishments;
    }

    @JsonProperty("awards")
    public List<Award> getAwards() {
        return awards;
    }

    @JsonProperty("awards")
    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }

    @JsonProperty("credibility")
    public List<Credibility> getCredibility() {
        return credibility;
    }

    @JsonProperty("credibility")
    public void setCredibility(List<Credibility> credibility) {
        this.credibility = credibility;
    }

    @JsonProperty("extracurricular")
    public List<Extracurricular> getExtracurricular() {
        return extracurricular;
    }

    @JsonProperty("extracurricular")
    public void setExtracurricular(List<Extracurricular> extracurricular) {
        this.extracurricular = extracurricular;
    }

    @JsonProperty("misc")
    public List<Misc> getMisc() {
        return misc;
    }

    @JsonProperty("misc")
    public void setMisc(List<Misc> misc) {
        this.misc = misc;
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