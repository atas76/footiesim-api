package org.footiesim.domain;

import java.util.List;

public class League {
	
	private String name;
	private List<Team> teams;
	
	public League(String name) {
		this.name = name;
	}
	
	public List<Team> getTeams() {
		return this.teams;
	}
	
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Team getTeamByShortName(String shortName) {
		for (Team team:teams) {
			if (team.getShortName().equals(shortName)) {
				return team;
			}
		}
		return null;
	}
	
	@Override
	public boolean equals(Object leagueObj) {
		
		if (!(leagueObj instanceof League)) {
			return false;
		}
		
		if (this.name == null) {
			return false;
		}
		
		return this.name.equals(((League) leagueObj).name);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
