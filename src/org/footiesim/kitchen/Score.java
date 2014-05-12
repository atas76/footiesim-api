package org.footiesim.kitchen;

public class Score {

	private int homeTeamRanking;
	private int awayTeamRanking;
	private int homeScore;
	private int awayScore;
	
	private boolean neutral;
	
	public Score(int homeTeamRanking, int awayTeamRanking, int homeScore, int awayScore) {
		this.homeTeamRanking = homeTeamRanking;
		this.awayTeamRanking = awayTeamRanking;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.neutral = false;
	}
	
	public int getHomeTeamRanking() {
		return this.homeTeamRanking;
	}
	
	public int getAwayTeamRanking() {
		return this.awayTeamRanking;
	}
	
	public int getHomeScore() {
		return this.homeScore;
	}
	
	public int getAwayScore() {
		return this.awayScore;
	}
	
	public double getCapacityRatio() {
		return (double) this.homeTeamRanking / this.awayTeamRanking;
	}
}
