package com.htw.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "FRAGEN")
public class Fragen {

	@Id
	@Column(name = "FRAGE_ID")
	private int id;

	@Column(name = "FRAGE_TEXT")
	private String text;

	@OneToOne
	private Typ typ;
	
	//######################################################################
    // GETTERS & SETTERS

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Typ getTyp() {
		return this.typ;
	}

	public void setTyp(Typ typ) {
		this.typ = typ;
	}
	
	

}
