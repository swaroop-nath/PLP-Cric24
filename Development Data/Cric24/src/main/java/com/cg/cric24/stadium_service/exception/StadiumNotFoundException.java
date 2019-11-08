package com.cg.cric24.stadium_service.exception;

public class StadiumNotFoundException extends Exception {
	private String uriDetails;

	public String getUriDetails() {
	
		return uriDetails;
	}

	public void setUriDetails(String uriDetails) {
		this.uriDetails = uriDetails;
	}

	public StadiumNotFoundException() {
		super();
	}

	public StadiumNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public StadiumNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public StadiumNotFoundException(String arg0) {
		super(arg0);
	}

	public StadiumNotFoundException(Throwable arg0) {
		super(arg0);
	}

	
}
