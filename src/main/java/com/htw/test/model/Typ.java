package com.htw.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typ")
public class Typ {
	
	@Id
	@Column(name = "TYP_ID")
	private int id;
	
	@Column(name = "BEZEICHNUNG")
	private String bezeichnung;
	
	@Column(name = "FORMAT")
	private String format;
	
	@Column(name = "WERT1")
	private String wert1;
	
	@Column(name= "WERT2")
	private String wert2;
	
	
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

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getWert1() {
		return wert1;
	}

	public void setWert1(String wert1) {
		this.wert1 = wert1;
	}

	public String getWert2() {
		return wert2;
	}

	public void setWert2(String wert2) {
		this.wert2 = wert2;
	}
	
	
	
	
	

}
