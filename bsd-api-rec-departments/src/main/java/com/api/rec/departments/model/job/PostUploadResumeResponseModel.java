package com.api.rec.departments.model.job;

import com.api.rec.departments.model.ResponseModel;

public class PostUploadResumeResponseModel extends ResponseModel {
	
	public PostUploadResumeResponseModel(PostUploadResumeRequestModel requestModel) {
		super(requestModel);
	}
	
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
