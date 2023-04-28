package com.api.rec.resumescheduler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Token claims failed")
public class ForbiddenException extends RuntimeException {
	private static final long serialVersionUID = 2210376755037634228L;
}
