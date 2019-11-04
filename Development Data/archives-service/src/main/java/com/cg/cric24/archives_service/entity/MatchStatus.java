package com.cg.cric24.archives_service.entity;

public enum MatchStatus {

	CONCLUDED ("Concluded"),
	FORFEITED ("Forfeited"),
	CANCELLED ("Cancelled"),
	SCHEDULED ("Scheduled");
	
	private String statusValue;
	
	private MatchStatus(String value) {
		this.statusValue = value;
	}
	
	public String getValue() {
		return statusValue;
	}
}
