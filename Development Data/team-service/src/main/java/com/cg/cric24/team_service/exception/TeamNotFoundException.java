package com.cg.cric24.team_service.exception;
/**
 * THis is the exception layer for team not found comprising of all the fields along with their respective getters and setters
 * @author Pranav 
 * @version 1.0
 */
public class TeamNotFoundException extends Exception {
	private String uriDetails;

	public String getUriDetails() {

		return uriDetails;
	}

	public void setUriDetails(String uriDetails) {
		this.uriDetails = uriDetails;
	}


	public TeamNotFoundException() {
		super();
		
	}

	public TeamNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
			}

	public TeamNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
			}

	public TeamNotFoundException(String arg0) {
		super(arg0);
		
	}

	public TeamNotFoundException(Throwable arg0) {
		super(arg0);
		
	}

}
