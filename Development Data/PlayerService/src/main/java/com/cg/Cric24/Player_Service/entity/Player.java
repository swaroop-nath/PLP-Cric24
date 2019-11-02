package com.cg.Cric24.Player_Service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "playseq", sequenceName = "play_seq", initialValue = 1001, allocationSize = 1)
@NamedQuery(name = "byName", query = "SELECT p FROM Player p WHERE p.name=:nam")
public class Player {

	@Id
	@GeneratedValue(generator = "playseq")
	private int playerId;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String team;
	@Column(length = 5)
	private int age;
	@Column(length = 20)
	private String nationality;
	@Column(length = 5)
	private float rating;
	@Column(length = 7)
	private double runs;
	@Column(length = 5)
	private int wickets;
	@Column(length = 20)
	private String role;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public double getRuns() {
		return runs;
	}

	public void setRuns(double runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
