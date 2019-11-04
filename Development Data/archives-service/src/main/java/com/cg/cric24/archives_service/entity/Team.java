package com.cg.cric24.archives_service.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "teamseq", sequenceName = "team_seq", initialValue = 1, allocationSize = 1)
public class Team {

	@Id
	@GeneratedValue(generator = "teamseq")
	private int teamId;
	
	@Column(length = 20)
	private String teamName;
	
	@Column(length = 20)
	private int ranking;
	
	@ManyToMany(mappedBy = "teams")
	private Set<Player> players = new HashSet()<Player>();
	
	@Column(length = 20)
	private String format;
	
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

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLeagues() {
		return leagues;
	}

	public void setLeagues(String leagues) {
		this.leagues = leagues;
	}

}	
