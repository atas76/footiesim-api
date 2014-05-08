package org.footiesim.dao.impl;

import java.util.List;

import org.footiesim.dao.LeagueDAO;
import org.footiesim.domain.League;

public class LeagueDAOHardcodedImpl implements LeagueDAO {
	
	private List<League> leagues;
	
	public LeagueDAOHardcodedImpl(List<League> leagues) {
		this.leagues = leagues;
	}
	
	@Override
	public List<League> getAllLeagues() {
		return this.leagues;
	}
}
