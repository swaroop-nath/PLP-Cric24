package com.cg.cric24.team_service.entity;

public enum RoleType {

	WICKET_KEEPER("WICKET_KEEPER"), BATSMAN("BATSMAN"), BOWLER("BOWLER");

	private String typeValue;

	private RoleType(String type) {
		typeValue = type;
	}

	public String getValue() {
		return typeValue;
	}
}
