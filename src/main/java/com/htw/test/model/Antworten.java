package com.htw.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANTWORTEN")
public class Antworten {

	@Id
	@Column(name = "ANTWORTEN_ID")
	private int id;
	
	@Column(name = "WERT")
	private String wert;
	
	//######################################################################
    // GETTERS & SETTERS



}
