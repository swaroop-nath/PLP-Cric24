package com.cg.cric24.schedules_service.entity;

public enum MatchStatus {

	CONCLUDED ("CONCLUDED"),
	FORFEITED ("FORFEITED"),
	CANCELLED ("CANCELLED"),
	SCHEDULED ("SCHEDULED");
	
	private String statusValue;
	
	private MatchStatus(String value) {
		this.statusValue = value;
	}
	
	public String getValue() {
		return statusValue;
	}
}