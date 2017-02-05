package com.htw.test.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "frageOptionen")
public class FrageOptionen {

	@Id
	@GeneratedValue
	@Column(name = "FrageOptionId")
	private long id;
	
	@Column(name = "orderIndex")
	private int orderIndex;
	
	@Column(name = "wert")
	private String text;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FragenId")
	private Frage frage;
	
	public FrageOptionen() {
		super();
	}
	
	public FrageOptionen(String text){
		this.text = text;
	}
	
	public FrageOptionen(int orderIndex, String value, Frage frage) {
		
		this.orderIndex = orderIndex;
		this.text = value;
		this.frage = frage;
		
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrder(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setFrage(Frage frage) {
		this.frage = frage;
	}

}
