package org.footiesim.dao.impl;

import java.util.List;

import org.footiesim.dao.ScoreDAO;
import org.footiesim.kitchen.Score;

public class ScoreDAOHardcodedImpl implements ScoreDAO {
	
	private List<Score> scores;
	
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	@Override
	public List<Score> getSampleScores() {
		return this.scores;
	}
}
