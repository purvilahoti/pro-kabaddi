package com.prokabaddi.facade;

import java.util.Date;
import java.util.List;

import com.prokabaddi.domain.common.Match;
import com.prokabaddi.domain.common.Team;

/**
 * @author purvi.manohar.lahoti
 *
 */
public interface MatchSchedule {

	/**
	 * @param startDate
	 * @return
	 * This method generates match schedule
	 */
	List<Match> generateMatchSchedule(Date startDate);

}
