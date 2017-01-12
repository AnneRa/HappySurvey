package com.htw.test.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private  String startdat;

	@Column(name = "enddat")
	private String enddat;
	
	@OneToMany(mappedBy = "umfrage", cascade = { CascadeType.ALL })
	private List<Gruppe> gruppen;
	
	/******************************************************************************************************
	 * 
	 */
	public Umfrage() {
		gruppen = new ArrayList<>();
	}
	
	/******************************************************************************************************
	 * @param id
	 * @param name
	 * @param beschr
	 * @param intro
	 * @param startdat
	 * @param enddat
	 */
	public Umfrage(Integer id, String name, String beschr, String intro, String startdat, String enddat){
		this();
		this.id = id;
		this.name = name;
		this.beschr = beschr;
		this.intro = intro;
		this.startdat = startdat;
		this.enddat = enddat;
	}
	
	/*****************************************************************************************************
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/***************************************************************************************************
	 * 
	 * @param id
	 */
	public Umfrage setId(int id) {
		this.id = id;
		return this;
	}
	
	/***************************************************************************************************
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**************************************************************************************************
	 * 
	 * @param name
	 */
	public Umfrage setName(String name) {
		this.name = name;
		return this;
	}
	
	/**************************************************************************************************
	 * 
	 * @return
	 */
	public String getBeschr() {
		return beschr;
	}
	
	/************************************************************************************************
	 * 
	 * @param beschr
	 */
	public Umfrage setBeschr(String beschr) {
		this.beschr = beschr;
		return this;
	}

	/************************************************************************************************
	 * 
	 * @return
	 */
	public String getIntro() {
		return intro;
	}
	
	/************************************************************************************************
	 * 
	 * @param intro
	 */
	public Umfrage setIntro(String intro) {
		this.intro = intro;
		return this;
	}

	/************************************************************************************************
	 * 
	 * @return
	 */
	public String getStartdat() {
		return startdat;
	}
	
	/***********************************************************************************************
	 * 
	 * @param startdat
	 */
	public Umfrage setStartdat(String startdat) {
		this.startdat = startdat;
		return this;
	}
	
	/**********************************************************************************************
	 * 
	 * @return
	 */
	public String getEnddat() {
		return enddat;
	}
	
	/**********************************************************************************************
	 * 
	 * @param enddat
	 */
	public Umfrage setEnddat(String enddat) {
		this.enddat = enddat;
		return this;
	}
	
	/**********************************************************************************************
	 * 
	 * @return
	 */
	public List<Gruppe> getGruppen(){
		return gruppen;
	}
	
	/*********************************************************************************************
	 * 
	 * @param gruppen
	 */
	public Umfrage setGruppen(List<Gruppe> gruppen){
		this.gruppen = gruppen;
		return this;
	}
	
	/*********************************************************************************************
	 * 
	 * @param gruppe
	 */
	public Umfrage addGruppe(Gruppe gruppe){
		if (!gruppen.contains(gruppe)){
			gruppen.add(gruppe);
		}
		
		if (gruppe != null && gruppe.getUmfrage() != this){
			gruppe.setUmfrage(this);
		}
		return this;
	}

}
