package com.cg.cric24.team_service.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "playseq", sequenceName = "play_seq", initialValue = 1001, allocationSize = 1)
public class Player {

	@Id
	@GeneratedValue(generator = "playseq")
	private int playerId;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	@Column(length = 20)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "player_team_master", joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "playerId"), inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "teamId"))
	private List<Team> teams = new ArrayList<Team>();

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

	@Enumerated(EnumType.STRING)
	private RoleType roleType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public void addToTeams(Team newTeam) {
		this.teams.add(newTeam);
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}