package com.htw.test.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "umfrage")
public class Umfrage {

	@Id
	@Column(name = "Umfrage_ID")
	private int id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Beschr")
	private String beschr;

	@Column(name = "Intro")
	private String intro;

	@Column(name = "Stardat")
	private  String startdat;

	@Column(name = "Enddat")
	private String enddat;
	
	/*#### LOGO ####*/

	/*@Column(name = "logo")
	private char logo;*/

	public Umfrage() {

	}
	
	//######################################################################
    // GETTERS & SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschr() {
		return beschr;
	}

	public void setBeschr(String beschr) {
		this.beschr = beschr;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getStartdat() {
		return startdat;
	}

	public void setStartdat(String startdat) {
		this.startdat = startdat;
	}

	public String getEnddat() {
		return enddat;
	}

	public void setEnddat(String enddat) {
		this.enddat = enddat;
	}
	
	/*#### LOGO ####*/

	/*public char getLogo() {
		return logo;
	}

	public void setLogo(char ologo) {
		logo = ologo;
	}*/

}
