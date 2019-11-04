package com.cg.Cric24.Player_Service.entity;

public enum RoleType {

	WicketKeeper("Wicketkeeper"), Batsman("Batsman"), Bowler("Bowler");

	private String typeValue;

	private RoleType(String type) {
		typeValue = type;
	}
	
	public String getValue() {
		return typeValue;
	}

}
