package com.laptrinhjavaweb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int uID;
	
	@Column(name = "user", nullable = false)
	private String user;
	
	@Column(name = "pass", nullable = false)
	private String password;
	
	@Column(name = "isWriter", nullable = false)
	private int isWriter;
	
	@Column(name = "isAdmin", nullable = false)
	private int isAdmin;

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsWriter() {
		return isWriter;
	}

	public void setIsWriter(int isWriter) {
		this.isWriter = isWriter;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "AccountEntity [uID=" + uID + ", user=" + user + ", password=" + password + ", isWriter=" + isWriter
				+ ", isAdmin=" + isAdmin + "]";
	}
	
	
}
