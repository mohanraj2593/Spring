package com.hib.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.FilterJoinTables;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TeamLeader")
public class TeamLeader {
	
@Id
@Column(name="tlid")
@GeneratedValue(strategy=GenerationType.AUTO)
	
private int tlid;

@Column(name="name")
private String name;

//@OneToMany(cascade = CascadeType.ALL)
private Set<TeamMember> members = new HashSet<TeamMember>();

@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
@JoinTable(
		name="teamLeader_softwares",
		joinColumns = @JoinColumn(name="tl_id"),
		inverseJoinColumns = @JoinColumn(name="sid")
		)
private Set<Softwares> softwares = new HashSet<Softwares>();



public Set<Softwares> getSoftwares() {
	return softwares;
}
public void setSoftwares(Set<Softwares> softwares) {
	this.softwares = softwares;
}
public Set<TeamMember> getMembers() {
	return members;
}
public void setMembers(Set<TeamMember> members) {
	this.members = members;
}
public int getTlid() {
	return tlid;
}
public void setTlid(int tlid) {
	this.tlid = tlid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public TeamLeader(int tlid, String name) {
	super();
	this.tlid = tlid;
	this.name = name;
}
public TeamLeader(String name) {
	super();
	this.name = name;
}
public void addMember(TeamMember member) {
	members.add(member);
	member.setTeamLeader(this);
}
public void addSoftwares(Softwares software) {
	softwares.add(software);
	software.getTeamLeader().add(this);
}


}
