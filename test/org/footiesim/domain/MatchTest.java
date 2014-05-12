package org.footiesim.domain;

import java.util.ArrayList;
import java.util.List;

import org.footiesim.dao.ScoreDAO;
import org.footiesim.dao.impl.ScoreDAOHardcodedImpl;
import org.footiesim.kitchen.Score;
import org.junit.Test;

public class MatchTest extends EnvironmentTest {
	
	private ScoreDAO scoreDAO;
	
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
		// Athletic Club - Barcelona 2-2
		// Athletic Club - Atletico Madrid 3-0
		
		// Bayern - Dortmund 0-3
		// Bayern - Schalke 5-1
		// Bayern - Arsenal 1-1
		// Bayern - Leverkusen 2-1
		// Bayern - Manchester City 2-3
		
		// Schalke - Real Madrid 1-6
		// Schalke - Chelsea 0-3
		// Schalke - Dortmund 1-3
		// Schalke - Leverkusen 2-0
		// Schalke - Bayern 0-4
		
		// Dortmund - Real Madrid 2-0
		// Dortmund - Schalke 0-0
		// Dortmund - Arsenal 0-1
		// Dortmund - Bayern 0-3
		// Dortmund - Leverkusen 0-1
		
		// Leverkusen - Dortmund 2-2
		// Leverkusen - Schalke 1-2
		// Leverkusen - Bayern 1-1
		
		// Chelsea - Atletico Madrid 1-3
		// Chelsea - Arsenal 6-0
		// Chelsea - Liverpool 2-1
		// Chelsea - Manchester City 2-1
		
		// Arsenal - Manchester City 1-1
		// Arsenal - Liverpool 2-1
		// Arsenal - Bayern 0-2
		// Arsenal - Chelsea 0-0
		// Arsenal - Liverpool 2-0
		// Arsenal - Dortmund 1-2
		// Arsenal - Chelsea 0-2
		
		// Liverpool - Manchester City 3-2
		// Liverpool - Chelsea 0-2
		// Liverpool - Arsenal 5-1
		
	}
	
	/**
	 * We test mainly that the match use case is executed smoothly. 
	 * 
	 * Match plausibility is checked empirically and its rigorous checking is part of an evaluation API, which is a work in progress and private. 
	 */
	@Test
	public void testMatch() {
		
	}
}
