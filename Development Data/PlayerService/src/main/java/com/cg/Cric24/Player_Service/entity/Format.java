package com.cg.Cric24.Player_Service.entity;

public enum Format {
	
	ODI("ODI"), TESTS("Tests"), T20("T20");
	
	private String typeValue;
	
	private Format(String type) {
		typeValue = type;
	}
	
	public String getValue() {
		return typeValue;
	}

}
