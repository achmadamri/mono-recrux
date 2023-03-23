package com.api.rec.resumescheduler.model.resume;

import com.api.rec.resumescheduler.db.entity.TbResume;
import com.api.rec.resumescheduler.model.ResponseModel;

public class PostUploadResumeResponseModel extends ResponseModel {
	
	public PostUploadResumeResponseModel(PostUploadResumeRequestModel requestModel) {
		super(requestModel);
	}
	
	private String fileName;
	
	private String fileNameOri;

	private TbResume tbResume;

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

	public TbResume getTbResume() {
		return tbResume;
	}

	public void setTbResume(TbResume tbResume) {
		this.tbResume = tbResume;
	}
}
