package com.cg.cric24.archives_service.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	@Column(length = 20)
	private String leagues;
	
	@ManyToMany(mappedBy = "teams", cascade = CascadeType.ALL)
	
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
