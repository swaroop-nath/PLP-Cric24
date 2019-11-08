package com.cg.cric24.stadium_service.entity;
import java.util.Date;
/**
 * THis is a user defined exception layer comprising of all the fields along with their respective getters and setters
 * @author Pranav 
 * @version 1.0
 */

public class UDEDetails {
	
	private Date timestamp;
	
	private String message;
	
	private String details;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date date) {
		this.timestamp = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
