 package com.cg.cric24.schedules_service.entity;

public enum MatchFormat {

	T20 ("T20"),
	ODI ("ODI"),
	TEST ("TEST");
	
	private String typeValue;
	
	private MatchFormat(String type) {
		typeValue = type;
	}
	
	public String getValue() {
		return typeValue;
	}
}