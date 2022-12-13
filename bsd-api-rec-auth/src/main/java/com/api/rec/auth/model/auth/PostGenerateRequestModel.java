package com.api.rec.auth.model.auth;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.api.rec.auth.model.RequestModel;

public class PostGenerateRequestModel extends RequestModel {
	@NotEmpty(message = "Email may not be empty")
	@Size(min = 1, max = 255, message = "Email must be between 1 and 255 characters long")
	private String tbaEmail;

	@NotEmpty(message = "ID Login may not be empty")
	@Size(min = 1, max = 255, message = "ID Login must be between 1 and 255 characters long")
	private String tbaIdLogin;

	@NotEmpty(message = "Password may not be empty")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters long")
	private String tbaPassword;

	private String remember;

	public String getTbaEmail() {
		return tbaEmail;
	}

	public void setTbaEmail(String tbaEmail) {
		this.tbaEmail = tbaEmail;
	}

	public String getTbaIdLogin() {
		return tbaIdLogin;
	}

	public void setTbaIdLogin(String tbaIdLogin) {
		this.tbaIdLogin = tbaIdLogin;
	}

	public String getTbaPassword() {
		return tbaPassword;
	}

	public void setTbaPassword(String tbaPassword) {
		this.tbaPassword = tbaPassword;
	}

	public String getRemember() {
		return remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}
}
