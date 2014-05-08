package org.footiesim.domain;

public class Team implements Comparable {
	
	private String shortName;
	private String reputationTitle;
	private Double reputation;
	
	public Team(String shortName, Double reputation) {
		this.shortName = shortName;
		this.reputation = reputation;
	}
	
	public void setReputationTitle(String reputationTitle) {
		this.reputationTitle = reputationTitle;
	}
	
	public Double getReputation() {
		return this.reputation;
	}
	
	public int compareTo(Object teamObj) {
		if (this.reputation < ((Team) teamObj).reputation) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public String getShortName() {
		return this.shortName;
	}
}
