package com.cg.cric24.team_service.entity;
/**
 * This is the Team class for entity layer
 * All the variables are defined here with getters and setters
 * @author Pranav
 * @Version 1.0
 * 
 * */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@NamedQuery(name = "allteams", query = "SELECT t FROM Team t")
@NamedQuery(name = "teambyName", query = "SELECT t FROM Team t where t.teamName= :nam")
@SequenceGenerator(name = "teamseq", sequenceName = "team_seq", initialValue = 1, allocationSize = 1)
public class Team {

	@Id
	@GeneratedValue(generator = "teamseq")
	@Column(name = "team_id")
	private int teamId;

	@NotEmpty(message = "Team Name cannot be empty")
	@Column(length = 20)
	private String teamName;

	@Min(value = 1, message = "Ranking cannot be empty")
	@Column(length = 20)
	private int ranking;

	@ManyToMany(mappedBy = "teams", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Player> players = new ArrayList<Player>();


	@Enumerated(EnumType.STRING)
	private MatchFormat format;

	@NotEmpty(message = "Leagues cannot be empty")
	@Column(length = 20)
	private String leagues;

	public int getTeamId() {
		return teamId;
	}

	public void addToPlayers(Player newPlayer) {
		this.players.add(newPlayer);
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public MatchFormat getFormat() {
		return format;
	}

	public void setFormat(MatchFormat format) {
		this.format = format;
	}

	public String getLeagues() {
		return leagues;
	}

	public void setLeagues(String leagues) {
		this.leagues = leagues;
	}

}
