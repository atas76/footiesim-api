package org.footiesim.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.footiesim.kitchen.ScoresSample;
import org.footiesim.kitchen.TeamRanking;

/**
 * 
 * A container for all data related to a football match simulation and its overall context (tournaments, seasons, etc.)
 * 
 * We distinguish between business-related data and internal technical data.
 * Examples of business data are the team and player details, while technical data are, for example, statistical data used in match results calculations.
 * 
 * @author Andreas Tasoulas
 *
 */
public class Environment {

	private List<League> leagues;
	
	private TeamRanking currentRanking;
	private TeamRanking universalRanking;
	private Map<League, TeamRanking> leagueRankings = new HashMap<League, TeamRanking>();
	
	private ScoresSample scoresSample;
	
	public Environment(List<League> leagues, ScoresSample scoreSamples) {
		this.leagues = leagues;
		this.scoresSample = scoreSamples;
	}
	
	/**
	 * Rankings generated are a universal one and one per league, as well as per criterion attribute
	 */
	public void generateDefaultRankings() {
		
		List<Team> universalTeamsList = new ArrayList<Team>();
		
		for (League league: this.leagues) {
			universalTeamsList.addAll(league.getTeams());
			leagueRankings.put(league, new TeamRanking(league.getTeams()));
		}
		
		// Now generate the universal ranking, as well
		this.universalRanking = new TeamRanking(universalTeamsList);
	}
	
	public TeamRanking getRankingByLeague(League league) {
		return this.leagueRankings.get(league);
	}
	
	public TeamRanking getUniversalRanking() {
		return this.universalRanking;
	}
	
	public List<League> getLeagues() {
		return this.leagues;
	}
	
	public void setCurrentRanking(League league) {
		if (league != null && this.leagueRankings.containsKey(league)) {
			this.currentRanking = this.leagueRankings.get(league);
		} else {
			this.currentRanking = this.universalRanking;
		}
	}
	
	public TeamRanking getCurrentRanking() {
		
		if (this.currentRanking == null) {
			return this.universalRanking;
		}
		
		return this.currentRanking;
	}
	
	public ScoresSample getScoreSample() {
		return this.scoresSample;
	}
}
