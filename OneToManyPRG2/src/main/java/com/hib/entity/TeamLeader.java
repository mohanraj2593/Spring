package com.hib.entity;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.processing.Generated;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="TeamLeader")

public class TeamLeader {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tlid")
private int tlid;
	@Column(name="name")
private String name;
	@ManyToMany(cascade = CascadeType.ALL,
			fetch=FetchType.LAZY
			)
	@JoinTable(
			name="TeamLeder_Software",
	joinColumns=@JoinColumn(name="tlid"),
	inverseJoinColumns = @JoinColumn(name="sid")
	)
	private Set<Softwares> softwares = new HashSet<Softwares>();
public Set<Softwares> getSoftwares() {
		return softwares;
	}
	public void setSoftwares(Set<Softwares> softwares) {
		this.softwares = softwares;
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
public TeamLeader() {
	super();
}
public void addSoftwares(Softwares software)
{
softwares.add(software)	;
software.getLeaders().add(this);
}

}
