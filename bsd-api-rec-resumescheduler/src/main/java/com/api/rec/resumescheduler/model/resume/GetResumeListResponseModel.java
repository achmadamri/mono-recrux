package com.api.rec.resumescheduler.model.resume;

import java.util.List;

import com.api.rec.resumescheduler.db.entity.TbResume;
import com.api.rec.resumescheduler.model.ResponseModel;

public class GetResumeListResponseModel extends ResponseModel {
	
	public GetResumeListResponseModel(GetResumeListRequestModel requestModel) {
		super(requestModel);
	}
	
	private List<TbResume> lstTbResume;
	
	private Long length;

	public List<TbResume> getLstTbResume() {
		return lstTbResume;
	}

	public void setLstTbResume(List<TbResume> lstTbResume) {
		this.lstTbResume = lstTbResume;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
}
