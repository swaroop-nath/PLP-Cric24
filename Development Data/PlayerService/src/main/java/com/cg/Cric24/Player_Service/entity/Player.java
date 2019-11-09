package com.cg.Cric24.Player_Service.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * This is the entity for player
 * 
 * @author Akash Sarkar
 *
 */
@Entity
@NamedQuery(name = "allPlayers", query = "SELECT p FROM Player p")
@NamedQuery(name = "byName", query = "SELECT p FROM Player p WHERE p.name=:nam")
@SequenceGenerator(name = "playseq", sequenceName = "play_seq", initialValue = 1, allocationSize = 1)
public class Player {

	@Id
	@GeneratedValue(generator = "playseq")
	@Column(name = "player_id")
	private int playerId;

	@NotEmpty(message = "Player name cannot be empty")
	@Column(length = 20)
	private String name;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "player_team_master", joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "player_id"), inverseJoinColumns = @JoinColumn(name = "team_id", referencedColumnName = "team_id"))

	private List<Team> teams = new ArrayList<Team>();

	@Min(value = 10, message = "Age should not be less than 18")
	@Max(value = 1000, message = "Age should not be greater than 100")
	@Column(length = 5)
	private int age;

	@NotEmpty(message = "Player nationality cannot be empty")
	@Column(length = 20)
	private String nationality;

	@Min(value = 10, message = "Rating should not be less than 100")
	@Max(value = 1000, message = "Rating should not be greater than 1000")
	@Column(length = 5)
	private int rating;

	@Min(value = 10)
	@Column(length = 7)
	private int runs;

	@Min(value = 0)
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
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
