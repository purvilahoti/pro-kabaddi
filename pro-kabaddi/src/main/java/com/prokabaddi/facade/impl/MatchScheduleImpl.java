package com.prokabaddi.facade.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.prokabaddi.domain.common.Match;
import com.prokabaddi.domain.common.Team;
import com.prokabaddi.facade.MatchSchedule;
import com.prokabaddi.persistence.TeamPersistence;
import com.prokabaddi.persistence.impl.TeamPersistenceImpl;

@Service
public class MatchScheduleImpl implements MatchSchedule {

	public List<Match> generateMatchSchedule(Date startDate) {

		List<Match> matches = populateTeam();

		DateTime currentDate = new DateTime(startDate.getTime());

		while (isDateRemaining(matches)) {

			List<Integer> finalTeamListIds = finalTeamList(matches, currentDate.minus(Period.days(1)).toDate());

			for (Match match : matches) {
				if (null == match.getDate() && !finalTeamListIds.contains(match.getTeam1().getId())
						&& !finalTeamListIds.contains(match.getTeam2().getId())) {
					match.setDate(currentDate.toDate());
					finalTeamListIds.add(match.getTeam1().getId());
					finalTeamListIds.add(match.getTeam2().getId());
				}
			}

			currentDate = currentDate.plus(Period.days(2));
		}

		return matches;
	}

	/**
	 * Populate team
	 * 
	 * @return
	 */
	private List<Match> populateTeam() {
		TeamPersistence teamRepo = new TeamPersistenceImpl();
		List<Team> teamList = new ArrayList<Team>();
		teamList.add(teamRepo.fetchTeam(1));
		teamList.add(teamRepo.fetchTeam(2));
		teamList.add(teamRepo.fetchTeam(3));
		teamList.add(teamRepo.fetchTeam(4));
		teamList.add(teamRepo.fetchTeam(5));
		List<Match> matches = initializeMatchesWithCity(teamList);
		return matches;
	}

	/**
	 * Set 1 team match with other team in both cities
	 * 
	 * @param teams
	 * @return
	 */
	private List<Match> initializeMatchesWithCity(List<Team> teams) {
		List<Match> matches = new ArrayList<Match>();

		for (Team team1 : teams) {
			for (Team team2 : teams) {
				if (team1.getId() != team2.getId()) {
					Match match = new Match(team1, team2);
					match.setLocation(team1.getCity());

					matches.add(match);
				}
			}
		}

		return matches;
	}

	/**
	 * This method checks if we have set date for respective matches or not
	 * 
	 * @param matches
	 * @return
	 */
	private boolean isDateRemaining(List<Match> matches) {
		for (Match match : matches) {
			if (null == match.getDate()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param matches
	 * @param date
	 * @return This method checks whether date is assigned then add into prepared
	 *         list
	 */
	private List<Integer> finalTeamList(List<Match> matches, Date date) {
		List<Integer> teamIds = new ArrayList<Integer>();
		for (Match match : matches) {
			if (null != match.getDate()) {
				if (date.equals(match.getDate())) {
					teamIds.add(match.getTeam1().getId());
					teamIds.add(match.getTeam2().getId());
				}
			}
		}
		return teamIds;
	}

}
