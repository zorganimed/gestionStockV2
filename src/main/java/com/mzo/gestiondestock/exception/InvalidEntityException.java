package com.mzo.gestiondestock.exception;

import java.util.List;

//import lombok.Getter;

public class InvalidEntityException extends RuntimeException{

	//@Getter
	private ErrorCodes errorCodes;
	//@Getter
	List<String> errors;
	
	public ErrorCodes getErrorCodes() {
		return errorCodes;
	}

	public List<String> getErrors() {
		return errors;
	}

	public InvalidEntityException(String message) {
		super(message);
	}
	
	public InvalidEntityException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes) {
		super(message,cause);
		this.errorCodes = errorCodes;
	}
	
	public InvalidEntityException(String message, ErrorCodes errorCodes) {
		super(message);
		this.errorCodes = errorCodes;
	}
	
	public InvalidEntityException(String message, ErrorCodes errorCodes, List<String> errors) {
		super(message);
		this.errorCodes = errorCodes;
		this.errors = errors;
	}
}
