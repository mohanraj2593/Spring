package com.hib.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<TeamLeader> leaders = new HashSet<TeamLeader>();
	
public Set<TeamLeader> getLeaders() {
		return leaders;
	}
	public void setLeaders(Set<TeamLeader> leaders) {
		this.leaders = leaders;
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
public void  getTeamLeader(TeamLeader leader) {
	leaders.add(leader);
	leader.getSoftwares().add(this);
	}

}
