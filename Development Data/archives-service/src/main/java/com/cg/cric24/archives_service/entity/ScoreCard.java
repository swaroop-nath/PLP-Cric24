package com.cg.cric24.archives_service.entity;

public class ScoreCard {
	
	private int scoreCardID;
	private Team[] participants;
	private int teamOneScore;
	private int teamOneWickets;
	private double teamOneOvers;
	private int teamTwoScore;
	private int teamTwoWickets;
	private double teamTwoOvers;
	private Player playerOfTheMatch;
	
	public int getScoreCardID() {
		return scoreCardID;
	}
	
	public void setScoreCardID(int scoreCardID) {
		this.scoreCardID = scoreCardID;
	}
	
	public Team[] getParticipants() {
		return participants;
	}
	
	public void setParticipants(Team[] participants) {
		this.participants = participants;
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
