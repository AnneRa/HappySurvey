package com.htw.test.model;

import java.util.ArrayList;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "typ")
public class Typ {
	
	@Id
	@GeneratedValue
	@Column(name = "TypId")
	private int id;
	
	@Column(name = "BEZEICHNUNG")
	private String bezeichnung;
	
	@Column(name = "FORMAT")
	private String format;
	
	@Column(name = "WERT1")
	private String wert1;
	
	@Column(name= "WERT2")
	private String wert2;

	/****************************************************************************************************
	 * 
	 */
	public Typ(){
	
	}
	/******************************************************************************************************
	 * @param t
	 */
	public Typ(Typ t){
	    this.id = t.id;
		this.bezeichnung = t.bezeichnung;
		this.format = t.format;
		this.wert1 = t.wert1;
		this.wert2 = t.wert2;
	
	}
	
	
	//######################################################################
    // GETTERS & SETTERS
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public Typ setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
		return this;
	}

	public String getFormat() {
		return format;
	}

	public Typ setFormat(String format) {
		this.format = format;
		return this;
	}

	public String getWert1() {
		return wert1;
	}

	public Typ setWert1(String wert1) {
		this.wert1 = wert1;
		return this;
	}

	public String getWert2() {
		return wert2;
	}

	public Typ setWert2(String wert2) {
		this.wert2 = wert2;
		return this;
	}
	
	
	
	
	

}
