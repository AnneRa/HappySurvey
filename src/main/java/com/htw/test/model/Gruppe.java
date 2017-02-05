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
import javax.persistence.Table;

@Entity
@Table (name = "gruppe")
public class Gruppe {

	@Id
	@GeneratedValue
	@Column(name = "GruppeId")
	private long id;

	@Column(name = "GruppenName")
	private String name;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UmfrageId")
	private Umfrage umfrage;

	@OneToMany(mappedBy = "gruppe", cascade = CascadeType.ALL)
	private List<Frage> fragen;

	/*********************************************************************************************************
	 * 
	 * 
	 */
	public Gruppe(){
		super();
		fragen = new ArrayList<>();
	}
	/**********************************************************************************************************
	 * 
	 * @param gru
	 */
	public Gruppe(Gruppe gru){
		this.name = gru.name;
		this.umfrage = gru.umfrage;
	}
	
	public Gruppe(Umfrage umf){
		this.name = "Standard Gruppe";
		this.umfrage = umf;
	}
	
	/**********************************************************************************************************
	 * 
	 * @return
	 */
	public long getId(){
		return id;
	}

	/********************************************************************************************************
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/*******************************************************************************************************
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/******************************************************************************************************
	 * 
	 * @return
	 */
/*	public Umfrage getUmfrage() {
		return umfrage;
	}*/
	
	/*****************************************************************************************************
	 * 
	 * @param umfrage
	 */
	public void setUmfrage(Umfrage umfrage) {
		this.umfrage = umfrage;
	}

	/*****************************************************************************************************
	 * 
	 * @return
	 */
	public List<Frage> getFragen(){
		return fragen;
	}

}
