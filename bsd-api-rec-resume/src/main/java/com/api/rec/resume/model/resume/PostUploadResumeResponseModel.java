package com.api.rec.resume.model.resume;

import org.json.simple.JSONObject;

import com.api.rec.resume.model.ResponseModel;

public class PostUploadResumeResponseModel extends ResponseModel {
	
	public PostUploadResumeResponseModel(PostUploadResumeRequestModel requestModel) {
		super(requestModel);
	}
	
	private JSONObject parsedJSON;

	public JSONObject getParsedJSON() {
		return parsedJSON;
	}

	public void setParsedJSON(JSONObject parsedJSON) {
		this.parsedJSON = parsedJSON;
	}
}
