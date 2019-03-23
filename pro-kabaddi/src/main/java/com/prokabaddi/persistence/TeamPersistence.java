package com.prokabaddi.persistence;

import com.prokabaddi.domain.common.Team;

/**
 * @author purvi.manohar.lahoti
 *
 */
public interface TeamPersistence {
	
	/**
	 * @param id
	 * @return
	 * This method fetchTeam on basis of id
	 */
	Team fetchTeam(int id);
}
