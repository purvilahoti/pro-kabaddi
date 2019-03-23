package com.prokabaddi.persistence.impl;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import com.prokabaddi.domain.common.Team;

/**
 * @author purvi.manohar.lahoti
 * This is a test class for TeamPersistenceImpl
 */
@RunWith(PowerMockRunner.class)
public class TeamPersistenceImplTest {
	
	@InjectMocks
	private TeamPersistenceImpl teamPersistenceImpl;
	
	/**
	 * Test class for fetching teams on basis of Id's
	 */
	@Test
	public void testFetchTeam() {
		 Map<Integer, Team> teamMap = new ConcurrentHashMap<Integer, Team>();
		Team team = new Team(1);
		team.setName("Puneri - Paltan");
		team.setCity("Pune");
		Team team1 = new Team(2);
		team1.setName("Mumbai-Maratha");
		team1.setCity("Mumbai");
		teamMap.put(1, team);
		teamMap.put(2, team);
		Team fetchTeam=teamPersistenceImpl.fetchTeam(1);
		assertEquals(fetchTeam.getName(),team.getName());
		assertEquals(fetchTeam.getCity(),team.getCity());
		assertEquals(fetchTeam.getId(),team.getId());
	}

}
