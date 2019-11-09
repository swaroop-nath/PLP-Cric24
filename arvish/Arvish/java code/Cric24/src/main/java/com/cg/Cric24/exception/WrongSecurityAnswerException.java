package com.cg.Cric24.exception;

public class WrongSecurityAnswerException extends Exception {
	private String uriDetails;

	public String getUriDetails() {

		return uriDetails;
	}

	public void setUriDetails(String uriDetails) {
		this.uriDetails = uriDetails;
	}

	public WrongSecurityAnswerException() {
		super();
	}

	public WrongSecurityAnswerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WrongSecurityAnswerException(String message, Throwable cause) {
		super(message, cause);
	}

	public WrongSecurityAnswerException(String message) {
		super(message);
	}

	public WrongSecurityAnswerException(Throwable cause) {
		super(cause);
	}

}
