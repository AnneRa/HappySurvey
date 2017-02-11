package com.htw.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "antworten")
public class Antworten {

	@Id
	@GeneratedValue
	@Column(name = "antwortenId")
	private long id;
	
	@Column(name = "Wert")
	private String wert;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="teilnehmerId")
	private Teilnehmer teilnehmer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="frageId")
	private Frage frage;
	
	public Antworten() {
		super();
	}
	
	//######################################################################
    // GETTERS & SETTERS

	public Antworten(Teilnehmer tn, Frage newQuestion, String wert2) {
		this.teilnehmer = tn;
		this.frage = newQuestion;
		this.wert = wert2;
	}

	public long getId() {
		return id;
	}

	public String getWert() {
		return wert;
	}

	public void setWert(String wert) {
		this.wert = wert;
	}

	public void setTeilnehmer(Teilnehmer teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public Frage getFrage() {
		return frage;
	}

	public void setFrage(Frage frage) {
		this.frage = frage;
	}


/*	public Typ getTyp() {
		return typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}*/
	
}
