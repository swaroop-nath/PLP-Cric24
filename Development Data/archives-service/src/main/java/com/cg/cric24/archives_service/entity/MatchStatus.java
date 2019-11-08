package com.cg.cric24.archives_service.entity;

public enum MatchStatus {

	CONCLUDED ("CONCLUDED"),
	FORFEITED ("FORFEITED"),
	CANCELLED ("CANCELLED"),
	SCHEDULED ("SCHEDULED"),
	ONGOING ("ONGOING");
	
	private String statusValue;
	
	private MatchStatus(String value) {
		this.statusValue = value;
	}
	
	public String getValue() {
		return statusValue;
	}
}
