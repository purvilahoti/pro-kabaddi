package com.prokabaddi.domain.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author purvi.manohar.lahoti
 * This is a POJO for match
 */
public class Match implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Team team1;
	private final Team team2;
	private String city;
	private Date date;

	public Match(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
	}

	public String getLocation() {
		return city;
	}

	public void setLocation(String location) {
		this.city = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Team getTeam1() {
		return team1;
	}

	public Team getTeam2() {
		return team2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Match [team1=");
		builder.append(team1);
		builder.append(", team2=");
		builder.append(team2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}

}
