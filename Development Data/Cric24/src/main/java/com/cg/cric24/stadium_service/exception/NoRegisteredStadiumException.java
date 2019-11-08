package com.cg.cric24.stadium_service.exception;

public class NoRegisteredStadiumException extends Exception {

	
	private String uriDetails;

	public String getUriDetails() {
	
		return uriDetails;
	}

	public void setUriDetails(String uriDetails) {
		this.uriDetails = uriDetails;
	}
	public NoRegisteredStadiumException() {
		super();
	}

	public NoRegisteredStadiumException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoRegisteredStadiumException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoRegisteredStadiumException(String message) {
		super(message);
	}

	public NoRegisteredStadiumException(Throwable cause) {
		super(cause);
	}

	
}
