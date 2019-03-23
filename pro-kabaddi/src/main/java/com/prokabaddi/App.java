package com.prokabaddi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prokabaddi.domain.common.Match;
import com.prokabaddi.domain.common.Team;
import com.prokabaddi.facade.MatchSchedule;
import com.prokabaddi.facade.impl.MatchScheduleImpl;
import com.prokabaddi.persistence.TeamPersistence;
import com.prokabaddi.persistence.impl.TeamPersistenceImpl;


/**
 * @author purvi.manohar.lahoti
 * This is the main class
 */
public class App 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	
	public static void main(String[] args) {
		MatchSchedule matchSchedule = new MatchScheduleImpl();
		
		List<Match> matches = matchSchedule.generateMatchSchedule(new Date());
		LOGGER.debug(" --------------------------------------------------------------------------------------------------------------------------------------------");
		LOGGER.debug(" |{}|{}|{}|{}|", formatString("TEAM-A"), formatString("TEAM-B"), formatString("Location"), formatString("Date"));
		LOGGER.debug(" --------------------------------------------------------------------------------------------------------------------------------------------");
		for (Match match : matches) {
			LOGGER.debug(" |{}|{}|{}|{}|", formatString(match.getTeam1().getName()), formatString(match.getTeam2().getName()), formatString(match.getLocation()), formatString(formatDate(match.getDate())));
		}
		LOGGER.debug(" --------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * @param actualDate
	 * @return
	 * This method converts date format
	 */
	private static String formatDate(Date actualDate) {
		return new SimpleDateFormat("dd-MM-yyyy").format(actualDate);
	}
	
	/**
	 * @param actualString
	 * @return
	 *  This method add space for displaying
	 */
	private static String formatString(String actualString) {
		return StringUtils.rightPad(actualString, 20, "");
	}

}
