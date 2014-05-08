package org.footiesim.kitchen;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.footiesim.domain.Team;

public class TeamRanking {
	
	private Map<Integer, Team> ranking = new HashMap<Integer, Team>();

	public TeamRanking(List<Team> teams) {
		Collections.sort(teams);
		int count = 1;
		for (Team team: teams) {
			this.ranking.put(count++, team);
		}
	}
	
	public Team getTeamByRanking(int ranking) {
		return this.ranking.get(ranking);
	}
}
