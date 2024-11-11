package com.tap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	@Column(name="uid")
	@GeneratedValue(strategy = GenerationType.AUTO)
private int uid;
	@Column(name="uname")
private String uname;
	@Column(name="uemail")
private String uemail;
	@Column(name="passowrd")
private String password;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUemail() {
	return uemail;
}
public void setUemail(String uemail) {
	this.uemail = uemail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User(int uid, String uname, String uemail, String password) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.uemail = uemail;
	this.password = password;
}
public User(String uname, String uemail, String password) {
	super();
	this.uname = uname;
	this.uemail = uemail;
	this.password = password;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}

}
