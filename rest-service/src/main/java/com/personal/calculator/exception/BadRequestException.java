package com.personal.calculator.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Error. Review your input and try again")
public class BadRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1487069155361689132L;

}
