package com.cg.cric24.schedules_service.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;

@Entity
@SequenceGenerator(name = "playseq", sequenceName = "play_seq", initialValue = 1001, allocationSize = 1)
public class Player {

	@Id
	@GeneratedValue(generator = "playseq")
	@Column(name = "player_id")
	private int playerId;
	
	@Column(length = 20)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "player_team_master", 
	joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "player_id"), 
	inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "team_id"))
	private Set<Team> teams;

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

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

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
}