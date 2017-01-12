package com.htw.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "gruppe")
public class Gruppe {

	@Id
	@Column(name = "GruppenId")
	private int id;

	@Column(name = "GruppenName")
	private String name;

	@ManyToOne
	private Umfrage umfrage;

	@OneToMany(mappedBy = "gruppe", cascade = CascadeType.ALL)
	private List<Frage> fragen;

	/*********************************************************************************************************
	 * 
	 * 
	 */
	public Gruppe(){
		fragen = new ArrayList<>();
	}

	/**********************************************************************************************************
	 * 
	 * @param name
	 * @param id
	 */
	public Gruppe(String name, Integer id){
		this();
		this.name = name;
		this.id = id;
	}

	/**********************************************************************************************************
	 * 
	 * @return
	 */
	public Integer getId(){
		return id;
	}

	/*********************************************************************************************************
	 * 
	 * @param id
	 */
	public void setId(int id){
		this.id = id;
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
	public Umfrage getUmfrage() {
		return umfrage;
	}
	
	/*****************************************************************************************************
	 * 
	 * @param umfrage
	 */
	public void setUmfrage(Umfrage umfrage) {
		this.umfrage = umfrage;
		if (umfrage != null && !umfrage.getGruppen().contains(this)){
			umfrage.addGruppe(this);
		}
	}

	/*****************************************************************************************************
	 * 
	 * @return
	 */
	public List<Frage> getFragen(){
		return fragen;
	}
	
	/*****************************************************************************************************
	 * 
	 * @param fragen
	 */
	public void setFragen(List<Frage> fragen){
		this.fragen = fragen;
	}
	
	/*****************************************************************************************************
	 * 
	 * @param frage
	 */
	public void addFrage(Frage frage){
		if(!fragen.contains(frage)){
			fragen.add(frage);
		}
		
		if(frage != null && frage.getGruppe() != this){
			frage.setGruppe(this);
		}
	}
	



}
