package com.prokabaddi.domain.common;

import java.io.Serializable;

/**
 * @author purvi.manohar.lahoti This is POJO for Team
 */
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String city;

	public Team(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Team [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}

}
