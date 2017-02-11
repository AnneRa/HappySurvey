package com.htw.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teilnehmer")
public class Teilnehmer {

	@Id
	@GeneratedValue
	@Column (name = "teilnehmerId")
	private long id;

	@Column(name = "mail")
	private String mail;

	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private List<Antworten> antworten;
	
	public Teilnehmer(){
		super();
	}
	
	public Teilnehmer( String mail ) {
		super();
		this.mail = mail;
		this.antworten = new ArrayList<>();
	}

	//######################################################################
	// GETTERS & SETTERS

	public long getId() {
		return id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Antworten> getAntworten() {
		return antworten;
	}

	public void addAnswer( Antworten ans ) {
		this.antworten.add(ans);
	}
	
}
