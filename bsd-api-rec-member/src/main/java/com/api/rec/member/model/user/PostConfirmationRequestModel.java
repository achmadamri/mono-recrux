package com.api.rec.member.model.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.api.rec.member.model.RequestModel;

public class PostConfirmationRequestModel extends RequestModel {
	@NotEmpty(message = "Uid may not be empty")
	@Size(min = 1, max = 100, message = "Uid must be between 1 and 100 characters long")
	private String tbuUid;

	public String getTbuUid() {
		return tbuUid;
	}

	public void setTbuUid(String tbuUid) {
		this.tbuUid = tbuUid;
	}
}
