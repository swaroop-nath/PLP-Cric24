package com.cg.cric24.archives_service.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "match_master")
@SequenceGenerator(name = "mat_seq", sequenceName = "matches_sequence", allocationSize = 1)
public class Match {

	@Id
	@GeneratedValue(generator = "mat_seq")
	@Column(name = "match_id")
	private int matchID;
	private LocalDateTime matchSchedule;
	private Stadium matchVenue;
	private MatchType matchType;
	private Team[] participants;
	private String matchLeague;
	private ScoreCard matchScoreCard;
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
