package com.cg.cric24.archives_service.entity;

public enum MatchType {

	T20 ("T-20"),
	ODI ("ODI"),
	TEST ("TEST");
	
	private String typeValue;
	
	private MatchType(String type) {
		typeValue = type;
	}
	
	public String getValue() {
		return typeValue;
	}
}
