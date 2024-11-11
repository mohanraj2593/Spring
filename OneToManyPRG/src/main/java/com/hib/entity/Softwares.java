package com.hib.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Softwares")
public class Softwares {
	
	@Id
	@Column(name="sid")
	@GeneratedValue(strategy = GenerationType.AUTO)
private int sid;
	@Column(name="name")
private String name;
	
	@ManyToMany(mappedBy = "softwares",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<TeamLeader> teamLeader = new HashSet<TeamLeader>();
	
	
	public Set<TeamLeader> getTeamLeader() {
		return teamLeader;
	}
	public void setTeamLeader(Set<TeamLeader> teamLeader) {
		this.teamLeader = teamLeader;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Softwares(int sid, String name) {
		super();
		this.sid = sid;
		this.name = name;
	}
	public Softwares(String name) {
		super();
		this.name = name;
	}
	public Softwares() {
		super();
		
	}
	public void addTeamLeader(TeamLeader leader){
		teamLeader.add(leader);
		leader.getSoftwares().add(this);
	}
	
}
