package com.cg.cric24.archives_service.entity;

public enum MatchStatus {

	Concluded ("Concluded"),
	Forfeited ("Forfeited"),
	Cancelled ("Cancelled"),
	Scheduled ("Scheduled");
	
	private String statusValue;
	
	private MatchStatus(String value) {
		this.statusValue = value;
	}
	
	public String getValue() {
		return statusValue;
	}
}
