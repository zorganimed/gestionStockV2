package com.mzo.gestiondestock.handlers;

import java.util.ArrayList;
import java.util.List;

import com.mzo.gestiondestock.exception.ErrorCodes;

/*import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;*/

/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder*/
public class ErrorDto {
	
	private Integer httpCode;
	
	private ErrorCodes code;
	
	private String message;
	
	private List<String> errors = new ArrayList<>();

	public ErrorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDto(Integer httpCode, ErrorCodes code, String message, List<String> errors) {
		super();
		this.httpCode = httpCode;
		this.code = code;
		this.message = message;
		this.errors = errors;
	}

	public Integer getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}

	public ErrorCodes getCode() {
		return code;
	}

	public void setCode(ErrorCodes code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	

}
