package com.api.rec.departments.model.resume;

import com.api.rec.departments.model.ResponseModel;

public class PostUploadResumeResponseModel extends ResponseModel {
	
	public PostUploadResumeResponseModel(PostUploadResumeRequestModel requestModel) {
		super(requestModel);
	}
	
	private String fileName;
	
	private String fileNameOri;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileNameOri() {
		return fileNameOri;
	}

	public void setFileNameOri(String fileNameOri) {
		this.fileNameOri = fileNameOri;
	}
}
