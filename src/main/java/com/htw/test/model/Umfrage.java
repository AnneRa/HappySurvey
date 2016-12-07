package com.htw.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "umfrage")
public class Umfrage {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "beschr")
	private String beschr;

	@Column(name = "intro")
	private String intro;

	@Column(name = "stardat")
	private long startdat;

	@Column(name = "enddat")
	private long enddat;

	@Column(name = "logo")
	private char logo;

	public Umfrage() {

	}

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

	public long getStartdat() {
		return startdat;
	}

	public void setStartdat(long startdat) {
		this.startdat = startdat;
	}

	public long getEnddat() {
		return enddat;
	}

	public void setEnddat(long enddat) {
		this.enddat = enddat;
	}

	public char getLogo() {
		return logo;
	}

	public void setLogo(char ologo) {
		logo = ologo;
	}

}
