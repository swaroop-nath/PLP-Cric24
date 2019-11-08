package com.cg.Cric24.Player_Service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
/**
 * This is the entity for team
 * @author Akash Sarkar
 *
 */
@Entity
@SequenceGenerator(name = "teamseq", sequenceName = "team_seq", initialValue = 1, allocationSize = 1)
public class Team {

	@Id
	@GeneratedValue(generator = "teamseq")
	@Column(name = "team_id")
	private int teamId;
	
	@NotEmpty(message = "Team name cannot be empty")
	@Column(length = 20)
	private String teamName;

	@NotEmpty(message = "Ranking name cannot be empty")
	@Column(length = 20)
	private int ranking;
	
	@NotEmpty(message = "Leagues cannot be empty")
	@Column(length = 20)
	private String leagues;

	@ManyToMany(mappedBy = "teams", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Player> players = new ArrayList<Player>();

	@Enumerated(EnumType.STRING)
	private MatchFormat format;

	public int getTeamId() {
		return teamId;
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

//	public List<Player> getPlayers() {
//		return players;
//	}

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
