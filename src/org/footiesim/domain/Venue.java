package org.footiesim.domain;

public enum Venue {
	
	HOME("Home team ground"), 
	NEUTRAL("Neutral ground");
	
	private String name;
	
	private Venue(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
