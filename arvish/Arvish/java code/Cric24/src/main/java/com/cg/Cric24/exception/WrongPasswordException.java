package com.cg.Cric24.exception;

public class WrongPasswordException extends Exception {
	
	private String uriDetails;

	public String getUriDetails() {
	
		return uriDetails;
	}

	public void setUriDetails(String uriDetails) {
		this.uriDetails = uriDetails;
	}
	
	public WrongPasswordException() {
		super();
	}

	public WrongPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WrongPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongPasswordException(String message) {
		super(message);
	}

	public WrongPasswordException(Throwable cause) {
		super(cause);
	}

}
