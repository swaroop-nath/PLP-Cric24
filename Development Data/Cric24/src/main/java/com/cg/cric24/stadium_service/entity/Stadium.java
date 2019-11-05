package com.cg.cric24.stadium_service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "stadiumseq" , sequenceName = "seq_stadium", allocationSize = 1)
@Table(name = "stadium")
@NamedQuery(name = "findAll",query = "SELECT stadium FROM Stadium stadium")
@NamedQuery(name = "byName" ,query = "SELECT stadium FROM Stadium stadium WHERE stadium.stadiumName=:name")
@NamedQuery(name = "byCountry" ,query = "SELECT stadium FROM Stadium stadium WHERE stadium.country=:country")
public class Stadium {

	@Id
	@GeneratedValue(generator = "stadiumseq")
	private int stadiumId;
	@Column(length = 30, name = "stadium_name", nullable=false)
	private String stadiumName;
	@Column(name = "location", length = 50)
	private String location;
	@Column(name = "country")
	private String country;
	@Column(name = "capacity")
	private int capacity;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(int stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
