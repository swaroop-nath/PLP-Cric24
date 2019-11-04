package com.cg.cric24.team_service.entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@NamedQuery(name = "allteams", query = "SELECT t FROM Team t")
@NamedQuery(name = "teambyName", query = "SELECT t FROM Team t where t.teamName= :nam")
@SequenceGenerator(name = "teamseq", sequenceName = "team_seq", initialValue = 1, allocationSize = 1)
public class Team {

	@Id
	@GeneratedValue(generator = "teamseq")
	private int teamId;

	@Column(length = 20)
	private String teamName;

	@Column(length = 20)
	private int ranking;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "player_team_master", joinColumns = @JoinColumn(name = "team_id", referencedColumnName = "teamId"), inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "playerId"))
	private List<Player> players = new ArrayList<Player>();

	@Enumerated(EnumType.STRING)
	private Format format;

	@Column(length = 20)
	private String leagues;

	public int getTeamId() {
		return teamId;
	}
	public void addToPlayers (Player newPlayer)
	{
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

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public String getLeagues() {
		return leagues;
	}

	public void setLeagues(String leagues) {
		this.leagues = leagues;
	}

}




