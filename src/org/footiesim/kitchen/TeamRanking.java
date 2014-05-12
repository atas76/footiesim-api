package org.footiesim.kitchen;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.footiesim.domain.Team;

public class TeamRanking {
	
	private Map<Integer, Team> ranking = new HashMap<Integer, Team>();
	
	private Map<String, Integer> inverseRanking = new HashMap<String, Integer>();

	public TeamRanking(List<Team> teams) {
		Collections.sort(teams);
		int count = 1;
		for (Team team: teams) {
			this.inverseRanking.put(team.getShortName(), count);
			this.ranking.put(count++, team);
		}
	}
	
	public Team getTeamByRanking(int ranking) {
		return this.ranking.get(ranking);
	}
	
	/**
	 * 
	 * @param shortName The team's short name will be used as identifier, where applicable
	 * @return -1 in case the team is not found in the ranking
	 */
	public int getRankingByTeam(String shortName) {
		if (this.inverseRanking.get(shortName) != null) {
			return this.inverseRanking.get(shortName);
		} else {
			return -1;
		}
	}
}
