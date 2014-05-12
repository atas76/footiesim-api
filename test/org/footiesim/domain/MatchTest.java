package org.footiesim.domain;

import java.util.ArrayList;
import java.util.List;

import org.footiesim.dao.ScoreDAO;
import org.footiesim.dao.impl.ScoreDAOHardcodedImpl;
import org.footiesim.domain.exception.InvalidTeamRankingException;
import org.footiesim.kitchen.Score;
import org.footiesim.kitchen.ScoresSample;
import org.junit.Before;
import org.junit.Test;

public class MatchTest extends EnvironmentTest {
	
	private ScoreDAO scoreDAO;
	
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Override
	protected void setUpTechnicalData() {
		
		this.scoreDAO = new ScoreDAOHardcodedImpl();
		
		// Accumulate all scores between teams of the testing sample
		List<Score> scoresSample = new ArrayList<Score>();
		
		// Barcelona - Bayern 0-3
		scoresSample.add(new Score(1, 2, 0, 3));
		
		// Barcelona - Real Madrid 1-3
		scoresSample.add(new Score(1, 4, 1, 3));
		
		// Barcelona - Atletico Madrid 4-1
		scoresSample.add(new Score(1, 6, 4, 1));
		
		// Barcelona - Athletic Club 5-1
		scoresSample.add(new Score(1, 12, 5, 1));
		
		// Barcelona - Real Madrid 2-2
		scoresSample.add(new Score(1, 4, 2, 2));
		
		// Barcelona - Real Madrid 3-2
		scoresSample.add(new Score(1, 4, 3, 2));
		
		// Real Madrid - Dortmund 2-0
		scoresSample.add(new Score(4, 10, 2, 0));
		
		// Real Madrid - Barcelona 2-1
		scoresSample.add(new Score(4, 1, 2, 1));
		
		// Real Madrid - Barcelona 1-1
		scoresSample.add(new Score(4, 1, 1, 1));
		
		// Real Madrid - Atletico Madrid 2-0
		scoresSample.add(new Score(4, 6, 2, 0));
		
		// Real Madrid - Dortmund 2-2
		scoresSample.add(new Score(4, 10, 2, 2));
		
		// Real Madrid - Athletic Club 5-1
		scoresSample.add(new Score(4, 12, 5, 1));
		
		// Real Madrid - Barcelona 2-1
		scoresSample.add(new Score(4, 1, 2, 1));
		
		// Real Madrid - Manchester City 3-2
		scoresSample.add(new Score(4, 9, 3, 2));
		
		// Atletico Madrid - Barcelona 1-2
		scoresSample.add(new Score(6, 1, 1, 2));
		
		// Atletico Madrid - Real Madrid 1-2
		scoresSample.add(new Score(6, 4, 1, 2));
		
		// Atletico Madrid - Athletic Club 4-0
		scoresSample.add(new Score(6, 12, 4, 0));
		
		// Athletic Club - Real Madrid 0-3
		scoresSample.add(new Score(12, 4, 0, 3));
		
		// Athletic Club - Barcelona 2-2
		scoresSample.add(new Score(12, 1, 2, 2));
		
		// Athletic Club - Atletico Madrid 3-0
		scoresSample.add(new Score(12, 6, 3, 0));
		
		// Bayern - Dortmund 0-3
		scoresSample.add(new Score(2, 10, 0, 3));
		
		// Bayern - Schalke 5-1
		scoresSample.add(new Score(2, 7, 5, 1));
		
		// Bayern - Arsenal 1-1
		scoresSample.add(new Score(2, 5, 1, 1));
		
		// Bayern - Leverkusen 2-1
		scoresSample.add(new Score(2, 11, 2, 1));
		
		// Bayern - Manchester City 2-3
		scoresSample.add(new Score(2, 9, 2, 3));
		
		// Schalke - Real Madrid 1-6
		scoresSample.add(new Score(7, 4, 1, 6));
		
		// Schalke - Chelsea 0-3
		scoresSample.add(new Score(7, 3, 0, 3));
		
		// Schalke - Dortmund 1-3
		scoresSample.add(new Score(7, 10, 1, 3));
		
		// Schalke - Leverkusen 2-0
		scoresSample.add(new Score(7, 11, 2, 0));
		
		// Schalke - Bayern 0-4
		scoresSample.add(new Score(7, 2, 0, 4));
		
		// Dortmund - Real Madrid 2-0
		scoresSample.add(new Score(10, 4, 2, 0));
		
		// Dortmund - Schalke 0-0
		scoresSample.add(new Score(10, 7, 0, 0));
		
		// Dortmund - Arsenal 0-1
		scoresSample.add(new Score(10, 5, 0, 1));
		
		// Dortmund - Bayern 0-3
		scoresSample.add(new Score(10, 2, 0, 3));
		
		// Dortmund - Leverkusen 0-1
		scoresSample.add(new Score(10, 11, 0, 1));
		
		// Leverkusen - Dortmund 2-2
		scoresSample.add(new Score(11, 10, 2, 2));
		
		// Leverkusen - Schalke 1-2
		scoresSample.add(new Score(11, 7, 1, 2));
		
		// Leverkusen - Bayern 1-1
		scoresSample.add(new Score(11, 2, 1, 1));
		
		// Chelsea - Atletico Madrid 1-3
		scoresSample.add(new Score(3, 6, 1, 3));
		
		// Chelsea - Arsenal 6-0
		scoresSample.add(new Score(3, 5, 6, 0));
		
		// Chelsea - Liverpool 2-1
		scoresSample.add(new Score(3, 8, 2, 1));
		
		// Chelsea - Manchester City 2-1
		scoresSample.add(new Score(3, 9, 2, 1));
		
		// Arsenal - Manchester City 1-1
		scoresSample.add(new Score(5, 9, 1, 1));
		
		// Arsenal - Liverpool 2-1
		scoresSample.add(new Score(5, 8, 2, 1));
		
		// Arsenal - Bayern 0-2
		scoresSample.add(new Score(5, 2, 0, 2));
		
		// Arsenal - Chelsea 0-0
		scoresSample.add(new Score(5, 3, 0, 0));
		
		// Arsenal - Liverpool 2-0
		scoresSample.add(new Score(5, 8, 2, 0));
		
		// Arsenal - Dortmund 1-2
		scoresSample.add(new Score(5, 10, 1, 2));
		
		// Arsenal - Chelsea 0-2
		scoresSample.add(new Score(5, 3, 0, 2));
		
		// Liverpool - Manchester City 3-2
		scoresSample.add(new Score(8, 9, 3, 2));
		
		// Liverpool - Chelsea 0-2
		scoresSample.add(new Score(8, 3, 0, 2));
		
		// Liverpool - Arsenal 5-1
		scoresSample.add(new Score(8, 5, 5, 1));
		
		((ScoreDAOHardcodedImpl) this.scoreDAO).setScores(scoresSample);
	}
	
	/**
	 * We test mainly that the match use case is executed smoothly. 
	 * 
	 * Match plausibility is checked empirically and its rigorous checking is part of an evaluation API, which is a work in progress and private. 
	 */
	@Test
	public void testMatch() throws InvalidTeamRankingException {
		
		this.environment = new Environment(leagueDAO.getAllLeagues(), new ScoresSample(this.scoreDAO.getSampleScores()));
		this.environment.generateDefaultRankings();
		
		Match spanishSemi1Leg1 = 
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Athletic Club"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Barcelona"),
					Venue.HOME,
					"Friendy",
					this.environment
				);
		
		Match spanishSemi1Leg2 = 
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Barcelona"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Athletic Club"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match spanishSemi2Leg1 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Atletico Madrid"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Real Madrid"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match spanishSemi2Leg2 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Real Madrid"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Atletico Madrid"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match spanishFinal =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Barcelona"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Real Madrid"),
					Venue.NEUTRAL,
					"Friendly",
					this.environment
				);
		
		Match germanSemi1Leg1 = 
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Leverkusen"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Bayern"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match germanSemi1Leg2 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Bayern"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Leverkusen"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match germanSemi2Leg1 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Dortmund"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Schalke"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match germanSemi2Leg2 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Schalke"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Dortmund"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match germanFinal =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Bayern"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Schalke"),
					Venue.NEUTRAL,
					"Friendly",
					this.environment
				);
		
		Match englishSemi1Leg1 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Manchester City"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Chelsea"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match englishSemi1Leg2 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Chelsea"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Manchester City"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match englishSemi2Leg1 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Liverpool"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Arsenal"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match englishSemi2Leg2 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Arsenal"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Liverpool"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match englishFinal =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Chelsea"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Arsenal"),
					Venue.NEUTRAL,
					"Friendly",
					this.environment
				);
		
		Match clSemi1Leg1 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Real Madrid"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Barcelona"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match clSemi1Leg2 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Barcelona"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Real Madrid"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match clSemi2Leg1 = 
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Chelsea"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Bayern"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match clSemi2Leg2 =
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Bayern"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.PREMIER_LEAGUE, "Chelsea"),
					Venue.HOME,
					"Friendly",
					this.environment
				);
		
		Match clFinal = 
				new Match(
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.LA_LIGA, "Barcelona"),
					this.environment.getTeamByLeagueAndShortName(EnvironmentTest.BUNDESLIGA, "Bayern"),
					Venue.NEUTRAL,
					"Friendly",
					this.environment
				);
		
		Match [] spanishMatches = new Match[] {spanishSemi1Leg1, spanishSemi1Leg2, spanishSemi2Leg1, spanishSemi2Leg2, spanishFinal};
		Match [] germanMatches = new Match [] {germanSemi1Leg1, germanSemi1Leg2, germanSemi2Leg1, germanSemi2Leg2, germanFinal};
		Match [] englishMatches = new Match [] {englishSemi1Leg1, englishSemi1Leg2, englishSemi2Leg1, englishSemi2Leg2, englishFinal};
		Match [] clMatches = new Match [] {clSemi1Leg1, clSemi1Leg2, clSemi2Leg1, clSemi2Leg2, clFinal};
		
		for (Match match:spanishMatches) {
			match.calculateResult();
			System.out.println(match);
		}
		
		for (Match match:germanMatches) {
			match.calculateResult();
			System.out.println(match);
		}
		
		for (Match match:englishMatches) {
			match.calculateResult();
			System.out.println(match);
		}
		
		for (Match match:clMatches) {
			match.calculateResult();
			System.out.println(match);
		}
	}
}
