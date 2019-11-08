package com.cg.Cric24.exception;

public class UserNotFoundException extends Exception {
	private String uriDetails;

	public String getUriDetails() {
	
		return uriDetails;
	}

	public void setUriDetails(String uriDetails) {
		this.uriDetails = uriDetails;
	}

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}

}
