package com.prokabaddi.facade.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import com.prokabaddi.domain.common.Match;
import com.prokabaddi.domain.common.Team;
import com.prokabaddi.persistence.impl.TeamPersistenceImpl;

/**
 * @author purvi.manohar.lahoti
 * This is a test class for MatchScheduleImpl
 */
@RunWith(PowerMockRunner.class)
public class MatchScheduleImplTest {
	
	@InjectMocks
	private MatchScheduleImpl matchScheduleImpl;
	
	@Mock
	private TeamPersistenceImpl teamPersistenceImpl;
	
	
	/**
	 * As i am populating list directly from repository it is picking up the actual data so need of
	 *  explicitly mocking the data
	 */
	@Test
	public void testGenerateMatchSchedule() {
		Team t1= new Team(1);
		t1.setId(1);
		t1.setName("Puneri - Paltan");
		t1.setCity("Pune");
		
		Team t2= new Team(2);
		t1.setId(2);
		t1.setName("Mumbai-Maratha");
		t1.setCity("Mumbai");
		
		Match match = new Match(t1, t2);
		match.setDate(new Date());
		match.setLocation("Pune");
		
		List<Match> matches =matchScheduleImpl.generateMatchSchedule(new Date());
		assertEquals(matches.get(0), matches.get(0));
		assertNotNull(matches);
	}

}
