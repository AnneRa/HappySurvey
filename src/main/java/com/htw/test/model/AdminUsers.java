package com.htw.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adminUsers")
public class AdminUsers {
	
	@Id
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "hash")
	private String hash;

	
	/*#######################################################################################################*/
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}



}




