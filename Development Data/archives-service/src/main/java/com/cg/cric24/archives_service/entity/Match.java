package com.cg.cric24.archives_service.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "match_master")
@SequenceGenerator(name = "mat_seq", sequenceName = "matches_sequence", allocationSize = 1)
public class Match {

	@Id
	@GeneratedValue(generator = "mat_seq")
	@Column(name = "match_id")
	private int matchID;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime matchSchedule;
	
	@OneToOne
	@JoinColumn(name = "stadium_id")
	private Stadium matchVenue;
	
	@Enumerated(EnumType.STRING)
	private MatchType matchType;
	
	@Columns(columns = {
			@Column(name = "team_one", nullable = false),
			@Column(name = "team_two", nullable = false)
	})
	private Team[] participants;
	
	private String matchLeague;
	
	/*
	 * Match entity is the parent.
	 * Cascade specifies that, any action on the Match entity
	 * shall be cascaded to the child ScoreCard.
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "score_card_id", referencedColumnName = "score_card_id")
	private ScoreCard matchScoreCard;
	
	@Enumerated(EnumType.STRING)
	private MatchStatus matchStatus;
	
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
	
	public MatchType getMatchType() {
		return matchType;
	}
	
	public void setMatchType(MatchType matchType) {
		this.matchType = matchType;
	}
	
	public Team[] getParticipants() {
		return participants;
	}
	
	public void setParticipants(Team[] participants) {
		this.participants = participants;
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
	
}
