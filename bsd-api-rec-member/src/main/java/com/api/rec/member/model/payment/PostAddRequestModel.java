package com.api.rec.member.model.payment;

import com.api.rec.member.db.entity.TbPayment;
import com.api.rec.member.model.RequestModel;

public class PostAddRequestModel extends RequestModel {
	private TbPayment tbPayment;

	public TbPayment getTbPayment() {
		return tbPayment;
	}

	public void setTbPayment(TbPayment tbPayment) {
		this.tbPayment = tbPayment;
	}
}
