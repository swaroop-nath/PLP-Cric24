package com.cg.cric24.archives_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "score_card_master")
@SequenceGenerator(name = "score_seq", sequenceName = "score_card_sequence", allocationSize = 1)
public class ScoreCard {
	
	@Id
	@GeneratedValue(generator = "score_seq")
	@Column(name = "score_card_id")
	private int scoreCardID;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "team_id")
	private Team teamOne;

	@OneToOne
	@JoinColumn(referencedColumnName = "team_id")
	private Team teamTwo;
	
	private int teamOneScore;
	
	private int teamOneWickets;
	
	private double teamOneOvers;
	
	private int teamTwoScore;
	
	private int teamTwoWickets;
	
	private double teamTwoOvers;
	
	@OneToOne
	@JoinColumn(name = "player_id", referencedColumnName = "player_id")
	private Player playerOfTheMatch;
	
	public int getScoreCardID() {
		return scoreCardID;
	}
	
	public void setScoreCardID(int scoreCardID) {
		this.scoreCardID = scoreCardID;
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
	
	public int getTeamOneScore() {
		return teamOneScore;
	}
	
	public void setTeamOneScore(int teamOneScore) {
		this.teamOneScore = teamOneScore;
	}
	
	public int getTeamOneWickets() {
		return teamOneWickets;
	}
	
	public void setTeamOneWickets(int teamOneWickets) {
		this.teamOneWickets = teamOneWickets;
	}
	
	public double getTeamOneOvers() {
		return teamOneOvers;
	}
	
	public void setTeamOneOvers(double teamOneOvers) {
		this.teamOneOvers = teamOneOvers;
	}
	
	public int getTeamTwoScore() {
		return teamTwoScore;
	}
	
	public void setTeamTwoScore(int teamTwoScore) {
		this.teamTwoScore = teamTwoScore;
	}
	
	public int getTeamTwoWickets() {
		return teamTwoWickets;
	}
	
	public void setTeamTwoWickets(int teamTwoWickets) {
		this.teamTwoWickets = teamTwoWickets;
	}
	
	public double getTeamTwoOvers() {
		return teamTwoOvers;
	}
	
	public void setTeamTwoOvers(double teamTwoOvers) {
		this.teamTwoOvers = teamTwoOvers;
	}
	
	public Player getPlayerOfTheMatch() {
		return playerOfTheMatch;
	}
	
	public void setPlayerOfTheMatch(Player playerOfTheMatch) {
		this.playerOfTheMatch = playerOfTheMatch;
	}
	
}
