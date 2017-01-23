package com.htw.test.model;


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
@Table(name = "umfrage")
public class Umfrage {

	
	@GeneratedValue
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
	
	@Id
	@Column(name = "link")
	private String link;
	
	@OneToMany(mappedBy = "umfrage", cascade = { CascadeType.ALL })
	private List<Gruppe> gruppen;
	
	/******************************************************************************************************
	 * 
	 */
	public Umfrage() {
		gruppen = new ArrayList<>();
	}
	
	/******************************************************************************************************
	 * @param umf
	 */
	public Umfrage(Umfrage umf){
		this.name = umf.name;
		this.beschr = umf.beschr;
		this.intro = umf.intro;
		this.startdat = umf.startdat;
		this.enddat = umf.enddat;
		this.link = umf.link;
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
	 */public String getLink() {
			return link;
		}
		
		/**********************************************************************************************
		 * 
		 * @param enddat
		 */
		public Umfrage setLink(String link) {
			this.link = link;
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
