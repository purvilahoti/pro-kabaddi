package com.prokabaddi.persistence.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.prokabaddi.domain.common.Team;
import com.prokabaddi.persistence.TeamPersistence;

/**
 * @author purvi.manohar.lahoti this class generates team
 */
@Service
public class TeamPersistenceImpl implements TeamPersistence {

	private Map<Integer, Team> teamMap = new ConcurrentHashMap<Integer, Team>();

	public TeamPersistenceImpl() {
		teamMap.put(1, generateTeam(1, "Puneri - Paltan", "Pune"));
		teamMap.put(2, generateTeam(2, "Mumbai - Maratha", "Mumbai"));
		teamMap.put(3, generateTeam(3, "Dabang - Delhi", "Delhi"));
		teamMap.put(4, generateTeam(4, "Telugu - Titans", "Hyderabad"));
		teamMap.put(5, generateTeam(5, "Bengaluru - Bulls", "Bengaluru"));
	}

	public Team fetchTeam(int id) {
		Team team = teamMap.get(id);
		return team;
	}
	
	private Team generateTeam(int id, String name, String city) {
		Team team = new Team(id);
		team.setName(name);
		team.setCity(city);
		return team;
	}

}
