package com.cg.Cric24.Player_Service.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
	private Set<Player> players = new HashSet<>();
	
	@Column(length = 20)
	private String format;
	
	@Column(length = 20)
	private String leagues;
	
	

}
