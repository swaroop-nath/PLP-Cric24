package com.cg.cric24.team_service.entity;

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
