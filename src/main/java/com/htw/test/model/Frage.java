package com.htw.test.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "frage")
public class Frage {

	@Id
	@Column(name = "frageId")
	private int id;

	@Column(name = "text")
	private String text;
	
	@Column(name = "umfrage")
	private int umfrageNr;

	@OneToOne
	private Typ typ;
	
	@ManyToOne
	private Gruppe gruppe;
	
	/****************************************************************************************************
	 * 
	 */
	public Frage(){
		
	}
	
	/***************************************************************************************************
	 * 
	 * @param frageid
	 * @param text
	 */
	
	public Frage(Integer id, String text, Typ typ, Integer umfrageNr){
		this();
		this.id = id;
		this.text = text;
		this.typ = typ;
		this.umfrageNr = umfrageNr;
	}
	
	/*************************************************************************************************
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/************************************************************************************************
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/************************************************************************************************
	 * 
	 * @return
	 */
	public String getText() {
		return text;
	}
	
	/***********************************************************************************************
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**********************************************************************************************
	 * 
	 * @return
	 */
	public Typ getTyp() {
		return typ;
	}

	/**********************************************************************************************
	 * 
	 * @param typ
	 */
	public void setTyp(Typ typ) {
		this.typ = typ;
	}
	
	/**********************************************************************************************
	 * 
	 * @return
	 */
	public int getUmfrageNr() {
		return umfrageNr;
	}

	/**********************************************************************************************
	 * 
	 * @param umfrageNr
	 */
	public void setUmfrageNr(int umfrageNr) {
		this.umfrageNr = umfrageNr;
	}
	
	
	
	public Gruppe getGruppe(){
		return gruppe;
	}
	
	public void setGruppe(Gruppe gruppe){
		this.gruppe = gruppe;
		if (gruppe != null && !gruppe.getFragen().contains(this)){
			gruppe.addFrage(this);
		}
	}
	
	

}
