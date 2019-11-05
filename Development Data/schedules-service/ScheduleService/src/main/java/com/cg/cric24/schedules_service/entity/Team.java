package com.cg.cric24.schedules_service.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "allTeams", query = "SELECT t FROM Team t")
@SequenceGenerator(name = "teamseq", sequenceName = "team_seq", initialValue = 1, allocationSize = 1)
public class Team {

	@Id
	@GeneratedValue(generator = "teamseq")
	@Column(name = "team_id")
	private int teamId;
	
	@Column(length = 20)
	private String teamName;
	
	@Column(length = 20)
	private int ranking;
	
	@ManyToMany(mappedBy = "teams", cascade = CascadeType.MERGE)
	private Set<Player> players = new HashSet<Player>();
	
	@Enumerated(EnumType.STRING)
	private MatchFormat format;
	
	@Column(length = 20)
	private String leagues;

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

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
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