package com.htw.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANTWORTEN")
public class Antworten {

	@Id
	@Column(name = "ANTWORTEN_ID")
	private int id;
	
	@Column(name = "Wert")
	private String wert;
	
	@OneToOne
	private Teilnehmer teilnehmer;
	
	@OneToOne
	private Frage fragen;
	
/*	@OneToOne
	private Typ typ;
	*/
	//######################################################################
    // GETTERS & SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWert() {
		return wert;
	}

	public void setWert(String wert) {
		this.wert = wert;
	}

	public Teilnehmer getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(Teilnehmer teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public Frage getFragen() {
		return fragen;
	}

	public void setFragen(Frage fragen) {
		this.fragen = fragen;
	}

/*	public Typ getTyp() {
		return typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}*/
	
}
