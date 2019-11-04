package com.cg.cric24.team_service.entity;

public enum RoleType {

	WICKET_KEEPER("Wicketkeeper"), BATSMAN("Batsman"), BOWLER("Bowler");

	private String typeValue;

	private RoleType(String type) {
		typeValue = type;
	}

	public String getValue() {
		return typeValue;
	}
}
