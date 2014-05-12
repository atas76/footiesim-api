package org.footiesim.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.footiesim.dao.LeagueDAO;
import org.footiesim.dao.impl.LeagueDAOHardcodedImpl;
import org.footiesim.kitchen.TeamRanking;
import org.junit.Before;
import org.junit.Test;

public class EnvironmentTest {
	
	private final String reputationTitle = "UEFA Coefficients 2013";
	
	private Environment environment;

	private LeagueDAO leagueDAO;
	
	@Before
	public void setUp() {
		setUpBusinessData();
		setUpTechnicalData();
	}
	
	protected void setUpTechnicalData() {}

	protected void setUpBusinessData() {
		
		List<League> hardcodedLeagues = new ArrayList<League>();
		
		// Initialize teams
		League bundesliga = new League("Bundesliga");
		League premierLeague = new League("Premier League");
		League laLiga = new League("La Liga");
		
		// Load teams
		loadHardcodedTeamsToLeague(bundesliga, 
				new Team[] {
					new Team("Bayern", "Bayern Munich", new Double(146.922)), 
					new Team("Dortmund", "Borussia Dortmund", new Double(61.922)), 
					new Team("Schalke", "Schalke 04", new Double(84.922)), 
					new Team("Leverkusen", "Bayer Leverkusen", new Double(53.922))
				}, this.reputationTitle);
		
		loadHardcodedTeamsToLeague(premierLeague, 
				new Team[] {
					new Team("Manchester City", "Manchester City", new Double(70.592)), 
					new Team("Liverpool", "Liverpool", new Double(78.592)), 
					new Team("Chelsea", "Chelsea", new Double(137.592)), 
					new Team("Arsenal", "Arsenal", new Double(113.592))
				}, this.reputationTitle);
		
		loadHardcodedTeamsToLeague(laLiga, 
				new Team[] {
					new Team("Atletico Madrid", "Atletico Madrid", new Double(99.605)), 
					new Team("Barcelona", "Barcelona", new Double(157.605)), 
					new Team("Real Madrid", "Real Madrid", new Double(136.605)), 
					new Team("Athletic Club", "Athletic Club", new Double(52.605))
				}, this.reputationTitle);
		
		// Accumulate leagues
		hardcodedLeagues.add(bundesliga);
		hardcodedLeagues.add(premierLeague);
		hardcodedLeagues.add(laLiga);
		
		leagueDAO = new LeagueDAOHardcodedImpl(hardcodedLeagues);
	}

	private void loadHardcodedTeamsToLeague(League league, Team[] teamsArr, String reputationTitle) {
		
		List<Team> teamsList = Arrays.asList(teamsArr);
		
		for (Team team: teamsList) {
			team.setReputationTitle(reputationTitle);
		}
		
		league.setTeams(teamsList);
	}
	
	@Test
	public void testRankingGeneration() {
		
		// We don't care about score sample for now
		this.environment = new Environment(leagueDAO.getAllLeagues(), null);
		
		this.environment.generateDefaultRankings();
		
		TeamRanking germanRanking = this.environment.getRankingByLeague(new League("Bundesliga"));
		TeamRanking englishRanking = this.environment.getRankingByLeague(new League("Premier League"));
		TeamRanking spanishRanking = this.environment.getRankingByLeague(new League("La Liga"));
		
		TeamRanking universalRanking = this.environment.getUniversalRanking();
		
		assertEquals("Schalke", germanRanking.getTeamByRanking(2).getShortName());
		assertEquals("Dortmund", germanRanking.getTeamByRanking(3).getShortName());
		
		assertEquals("Arsenal", englishRanking.getTeamByRanking(2).getShortName());
		assertEquals("Manchester City", englishRanking.getTeamByRanking(4).getShortName());
		
		assertEquals("Barcelona", spanishRanking.getTeamByRanking(1).getShortName());
		assertEquals("Atletico Madrid", spanishRanking.getTeamByRanking(3).getShortName());
		assertEquals("Athletic Club", spanishRanking.getTeamByRanking(4).getShortName());
		
		assertEquals("Bayern", universalRanking.getTeamByRanking(2).getShortName());
		assertEquals("Dortmund", universalRanking.getTeamByRanking(10).getShortName());
		assertEquals("Leverkusen", universalRanking.getTeamByRanking(11).getShortName());
		assertEquals("Manchester City", universalRanking.getTeamByRanking(9).getShortName());
		assertEquals("Chelsea", universalRanking.getTeamByRanking(3).getShortName());
		assertEquals("Atletico Madrid", universalRanking.getTeamByRanking(6).getShortName());
		assertEquals("Athletic Club", universalRanking.getTeamByRanking(12).getShortName());
	}
}
