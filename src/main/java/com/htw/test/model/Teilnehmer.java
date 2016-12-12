package com.htw.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEILNEHMER")
public class Teilnehmer {

	@Id
	@Column (name = "TEILNEHMER_ID")
	private int id;

	@Column(name = "Mail")
	private String mail;

	@Column(name = "Status")
	private String status;

	@ManyToOne
	private Umfrage umfrage;


	//######################################################################
	// GETTERS & SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Umfrage getUmfrage() {
		return umfrage;
	}

	public void setUmfrage(Umfrage umfrage) {
		this.umfrage = umfrage;
	}




}
