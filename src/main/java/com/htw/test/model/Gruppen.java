package com.htw.test.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "GRUPPEN")
public class Gruppen {

	@Id
	@Column(name = "Gruppen_ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne
	private Umfrage umfrage;
	
	@OneToMany
	private List<Fragen> fragen;
	
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

	public Umfrage getUmfrage() {
		return umfrage;
	}

	public void setUmfrage(Umfrage umfrage) {
		this.umfrage = umfrage;
	}




}
