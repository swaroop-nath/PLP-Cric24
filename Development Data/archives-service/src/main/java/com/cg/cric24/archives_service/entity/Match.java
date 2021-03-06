package com.cg.cric24.archives_service.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "match_master")
@SequenceGenerator(name = "mat_seq", sequenceName = "matches_sequence", allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "all_matches", query = "from Match where matchStatus = :status_concluded or matchStatus = :status_cancelled or matchStatus = :status_forfeited"),
	@NamedQuery(name = "all_matches_for_team", query = "select m from Match m where m.teamOne = :team or m.teamTwo = :team")
})
public class Match {

	@Id
	@GeneratedValue(generator = "mat_seq")
	@Column(name = "match_id")
	private int matchID;
	
	private LocalDateTime matchSchedule;
	
	@OneToOne
	@JoinColumn(name = "stadium_id", nullable = false)
	private Stadium matchVenue;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "match_type", nullable = false)
	private MatchFormat matchFormat;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(referencedColumnName = "team_id")
	private Team teamOne;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(referencedColumnName = "team_id")
	private Team teamTwo;
	
	@Column(name = "match_league", nullable = false)
	private String matchLeague;
	
	/*
	 * Match entity is the parent.
	 * Cascade specifies that, any action on the Match entity
	 * shall be cascaded to the child ScoreCard.
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "score_card_id", referencedColumnName = "score_card_id")
	private ScoreCard matchScoreCard;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "match_status", nullable = false)
	private MatchStatus matchStatus;
	
	@OneToOne
	@JoinColumn(name = "winning_team", referencedColumnName = "team_id")
	private Team winningTeam;
	
	public int getMatchID() {
		return matchID;
	}
	
	public void setMatchID(int matchID) {
		this.matchID = matchID;
	}
	
	public LocalDateTime getMatchSchedule() {
		return matchSchedule;
	}
	
	public void setMatchSchedule(LocalDateTime matchSchedule) {
		this.matchSchedule = matchSchedule;
	}
	
	public Stadium getMatchVenue() {
		return matchVenue;
	}
	
	public void setMatchVenue(Stadium matchVenue) {
		this.matchVenue = matchVenue;
	}
	
	public MatchFormat getMatchFormat() {
		return matchFormat;
	}
	
	public void setMatchFormat(MatchFormat matchFormat) {
		this.matchFormat = matchFormat;
	}

	public Team getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(Team teamOne) {
		this.teamOne = teamOne;
	}

	public Team getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(Team teamTwo) {
		this.teamTwo = teamTwo;
	}

	public String getMatchLeague() {
		return matchLeague;
	}
	
	public void setMatchLeague(String matchLeague) {
		this.matchLeague = matchLeague;
	}
	
	public ScoreCard getMatchScoreCard() {
		return matchScoreCard;
	}
	
	public void setMatchScoreCard(ScoreCard matchScoreCard) {
		this.matchScoreCard = matchScoreCard;
	}
	
	public MatchStatus getMatchStatus() {
		return matchStatus;
	}
	
	public void setMatchStatus(MatchStatus matchStatus) {
		this.matchStatus = matchStatus;
	}

	public Team getWinningTeam() {
		return winningTeam;
	}

	public void setWinningTeam(Team winningTeam) {
		this.winningTeam = winningTeam;
	}
	
}
