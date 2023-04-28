package com.api.rec.resume.model.resume;

import org.json.simple.JSONObject;

import com.api.rec.resume.model.ResponseModel;

public class PostUploadResumeResponseModel extends ResponseModel {
	
	public PostUploadResumeResponseModel(PostUploadResumeRequestModel requestModel) {
		super(requestModel);
	}
	
	private JSONObject json;

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}	
}
