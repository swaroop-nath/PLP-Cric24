package com.cg.cric24.team_service.entity;
/**
 * This is the enumeration of MatchFormat for entity layer
 * 
 * @author Pranav
 * @Version 1.0
 * 
 * */

public enum MatchFormat {

	ODI("ODI"), TESTS("TESTS"), T20("T20");

	private String typeValue;

	private MatchFormat(String type) {
		typeValue = type;

	}

	public String getValue() {
		return typeValue;
	}
}
