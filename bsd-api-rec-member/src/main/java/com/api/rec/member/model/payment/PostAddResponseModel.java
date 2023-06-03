package com.api.rec.member.model.payment;

import com.api.rec.member.db.entity.TbPayment;
import com.api.rec.member.model.ResponseModel;

public class PostAddResponseModel extends ResponseModel {

	public PostAddResponseModel(PostAddRequestModel requestModel) {
		super(requestModel);
	}

	private TbPayment tbPayment;

	public TbPayment getTbPayment() {
		return tbPayment;
	}

	public void setTbPayment(TbPayment tbPayment) {
		this.tbPayment = tbPayment;
	}
}
