package com.cg.cric24.team_service.entity;
/**
 * This is the enumeration for RoleType for entity layer
 * 
 * @author Pranav
 * @Version 1.0
 * 
 * */

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
