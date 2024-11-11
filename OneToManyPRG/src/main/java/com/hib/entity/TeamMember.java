package com.hib.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="TeamMember")

public class TeamMember {
@Id
@Column(name="tmid")
@GeneratedValue(strategy=GenerationType.AUTO)

private int tmid;

@Column(name="name")
private String name;

@Column(name="role")
private String role;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="tl_id")
private TeamLeader teamLeader;


public TeamLeader getTeamLeader() {
	return teamLeader;
}
public void setTeamLeader(TeamLeader teamLeader) {
	this.teamLeader = teamLeader;
}
public int getTmid() {
	return tmid;
}
public void setTmid(int tmid) {
	this.tmid = tmid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
//public int getTl_id() {
//	return tl_id;
//}
//public void setTl_id(int tl_id) {
//	this.tl_id = tl_id;
//}
public TeamMember(int tmid, String name, String role) {
	super();
	this.tmid = tmid;
	this.name = name;
	this.role = role;
//	this.tl_id = tl_id;
}
public TeamMember(String name, String role) {
	super();
	this.name = name;
	this.role = role;
//	this.tl_id = tl_id;
}
public TeamMember() {
	super();
	// TODO Auto-generated constructor stub
}


}
