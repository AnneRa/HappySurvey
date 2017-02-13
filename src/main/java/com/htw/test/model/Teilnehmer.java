package com.htw.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="umfrageId")
	private Umfrage umf;

	@OneToMany(mappedBy = "teilnehmer", cascade = CascadeType.ALL)
	private List<Antworten> antworten;
	
	public Teilnehmer(){
		super();
	}
	
	public Teilnehmer( String mail, Umfrage umf ) {
		super();
		this.mail = mail;
		this.umf = umf;
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
