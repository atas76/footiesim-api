package org.footiesim.domain;

import java.util.List;
import java.util.Random;

import org.footiesim.domain.exception.InvalidTeamRankingException;
import org.footiesim.kitchen.Score;
import org.footiesim.kitchen.TeamRanking;

public class Match {
	
	private Environment environment;
	
	private String label;
	
	private Team homeTeam;
	private Team awayTeam;
	
	private Venue venue;
	
	private int homeTeamScore = 0;
	private int awayTeamScore = 0;
	
	private int homeTeamScoreAET;
	private int awayTeamScoreAET;
	
	private int homeTeamPenaltyShootOutScore = 0;
	private int awayTeamPenaltyShootOutScore = 0;
	
	private boolean extraTimePlayed;
	private boolean penaltyShootOutPlayed;
	
	private boolean matchPlayed;
	
	private static Random rnd = new Random();
	
	public Match(Team homeTeam, Team awayTeam, Venue venue, String label, Environment environment) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.venue = venue;
		this.label = label;
		this.environment = environment;
	}
	
	public Team getHomeTeam() {
		return this.homeTeam;
	}
	
	public Team getAwayTeam() {
		return this.awayTeam;
	}
	
	public Venue getVenue() {
		return this.venue;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public int getHomeTeamScore() {
		return this.homeTeamScore;
	}
	
	public int getAwayTeamScore() {
		return this.awayTeamScore;
	}
	
	public int getHomeTeamScoreAET() {
		return this.homeTeamScoreAET;
	}
	
	public int getAwayTeamScoreAET() {
		return this.awayTeamScoreAET;
	}
	
	public int getHomeTeamPenaltyShootOutScore() {
		return this.homeTeamPenaltyShootOutScore;
	}
	
	public int getAwayTeamPenaltyShootOutScore() {
		return this.awayTeamPenaltyShootOutScore;
	}
	
	public String getFixture() {
		return this.homeTeam.getFullName() + " - " + this.awayTeam.getFullName();
	}
	
	public String getResult() {
		
		String opponents = this.homeTeam.getFullName() + " - " + this.awayTeam.getFullName();
		String result =  homeTeamScore + "-" + awayTeamScore;
		
		if (this.extraTimePlayed) {
			String normalTimeResult = result;
			result = homeTeamScoreAET + " - " + awayTeamScoreAET + " (aet)" + ", Normal time: " + normalTimeResult;
		}
		
		if (this.penaltyShootOutPlayed) {
			String playingTimeResult = result;
			result = homeTeamPenaltyShootOutScore + " - " + awayTeamPenaltyShootOutScore + " (pens)" + ", " + playingTimeResult; 
		}
		
		return (opponents +  "   " + result);
	}
	
	@Override
	public String toString() {
		if (!this.matchPlayed) {
			return this.getFixture();
		} else {
			return this.getResult();
		}
	}
	
	public boolean hasCompleteDetails() {
		return (this.homeTeam != null && this.awayTeam != null);
	}
	
	@Override
	public boolean equals(Object object) {
		
		Match matchObject = (Match) object;
		
		// More criteria will be added as the library becomes more sophisticated. Short name will be the identifier for all teams.
		return 
			this.homeTeam.getShortName().equals(matchObject.getHomeTeam().getShortName()) && this.awayTeam.getShortName().equals(matchObject.getAwayTeam().getShortName());
	}
	
	@Override
	public int hashCode() {
		return this.homeTeam.getShortName().hashCode() * 2 + this.awayTeam.getShortName().hashCode();
	}
	
	private void shootPenalty(Team team) {
		
		double successFactor = 0.8; // A lot more work has been put into determining this than it seems :-)
		
		double outcome = rnd.nextDouble();
		
		if (outcome <= successFactor) {
			if (team.equals(this.homeTeam)) {
				this.homeTeamPenaltyShootOutScore++;
			}
			if (team.equals(this.awayTeam)) {
				this.awayTeamPenaltyShootOutScore++;
			}
		}
	}
	
	private boolean isPenaltyShootOutWinner(int currentTeamOrder, int penaltyOrder) {
		
		int difference = this.homeTeamPenaltyShootOutScore - this.awayTeamPenaltyShootOutScore;
		
		int homeTeamPenaltiesLeft = 5 - penaltyOrder;
		int awayTeamPenaltiesLeft = (currentTeamOrder == 2)?(5 - penaltyOrder):(5 - penaltyOrder + 1);
		
		if (difference > 0 && difference > awayTeamPenaltiesLeft) {
			return true;
		}
		if (difference < 0 && Math.abs(difference) > homeTeamPenaltiesLeft) {
			return true;
		}
		return false;
	}
	
	/**
	 * Calculate the outcome of the penalty shootout of a match. Use the 'universal competition' statistics for the time being.
	 */
	public void penaltyShootOut() {
		
		// Although it is not currently needed, we will carry on a full simulation of the penalty shoot-out
		// Let's make the home team shoot first for simplicity
		
		for (int i = 0; i < 5; i++) {
			shootPenalty(this.homeTeam);
			if (isPenaltyShootOutWinner(1, i + 1)) {
				this.penaltyShootOutPlayed = true;
				return;
			}
			shootPenalty(this.awayTeam);
			if (isPenaltyShootOutWinner(2, i + 1)) {
				this.penaltyShootOutPlayed = true;
				return;
			}
		}
		
		// 5 penalties shoot-out completed. Check if we have a winner and if not, go to tie breaker
		while (this.homeTeamPenaltyShootOutScore == this.awayTeamPenaltyShootOutScore) {
			shootPenalty(this.homeTeam);
			shootPenalty(this.awayTeam);
		}
		this.penaltyShootOutPlayed = true;
	}
	
	public void calculateResult() throws InvalidTeamRankingException {
		
		// The actual ranking used will be decided externally
		TeamRanking teamRanking = this.environment.getCurrentRanking();
		
		int homeTeamRanking = teamRanking.getRankingByTeam(this.homeTeam.getShortName());
		int awayTeamRanking = teamRanking.getRankingByTeam(this.awayTeam.getShortName());
		
		if (homeTeamRanking < 1 || awayTeamRanking < 1) {
			throw new InvalidTeamRankingException();
		}
		
		double capacityRatio = (double) homeTeamRanking / (double) awayTeamRanking;
		
		List<Score> sampleScores = this.environment.getScoreSample().filterByCapacity(capacityRatio).getScores();
		
		// Pick one random score from the sample and we are done
		
		Random rnd = new Random();
		
		Score matchedScore = sampleScores.get(rnd.nextInt(sampleScores.size()));
		
		this.homeTeamScore = matchedScore.getHomeScore();
		this.awayTeamScore = matchedScore.getAwayScore();
		
		// Now for the interesting part: neutral ground filtering
		double homeGoalsAverageFactor = 1;
		double awayGoalsAverageFactor = 1;
		
		if (this.venue != null && this.venue.equals(Venue.NEUTRAL)) {
			
			double reverseCapacityRatio = 1 / capacityRatio;
			
			List<Score> reverseSampleScores = this.environment.getScoreSample().filterByCapacity(reverseCapacityRatio).getScores();
			
			Score complementScore = reverseSampleScores.get(rnd.nextInt(reverseSampleScores.size()));
			
			this.homeTeamScore += complementScore.getAwayScore();
			this.awayTeamScore += complementScore.getHomeScore();
			
			homeGoalsAverageFactor = 0.5;
			awayGoalsAverageFactor = 0.5; 
		} 
		
		this.homeTeamScore *= homeGoalsAverageFactor;
		this.awayTeamScore *= awayGoalsAverageFactor;
		
		this.matchPlayed = true;
	}
	
	public void playExtraTime() {
		
		// Create a copy of the match and calculate the result
		Match extraTimeMatch = new Match(this.homeTeam, this.awayTeam, this.venue, "Extra time", this.environment);
		
		try {
			
			extraTimeMatch.calculateResult();
			
			// Extra time duration is 1/3 of the normal time match
			int homeTeamExtraTimeScore = extraTimeMatch.homeTeamScore / 3;
			int awayTeamExtraTimeScore = extraTimeMatch.awayTeamScore / 3;
			
			this.homeTeamScoreAET = this.homeTeamScore + homeTeamExtraTimeScore;
			this.awayTeamScoreAET = this.awayTeamScore + awayTeamExtraTimeScore;
			
			this.extraTimePlayed = true;
			
		} catch (Exception ex) {
			// And yet an exception is thrown (normally it shouldn't in production, as the match parameters are the same). Print stack trace for debugging purposes.
            ex.printStackTrace();
		}
	}
}
