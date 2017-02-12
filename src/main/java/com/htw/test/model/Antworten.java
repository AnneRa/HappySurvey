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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "antworten")
public class Antworten {

	@Id
	@GeneratedValue
	@Column(name = "antwortenId")
	private long id;
	
	@Column(name = "Wert")
	private String wert;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="teilnehmerId")
	private Teilnehmer teilnehmer;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="frageId")
	private Frage frage;
	
	@OneToMany(mappedBy = "frageOption", cascade = CascadeType.ALL)
	private List<MultipleChoiceAntworten> multipleChoiceAntworten;
	
	public Antworten() {
		super();
	}
	
	//######################################################################
    // GETTERS & SETTERS

	public Antworten(Teilnehmer tn, Frage newQuestion, Antworten ans) {
		this.teilnehmer = tn;
		this.frage = newQuestion;
		this.wert = ans.getWert();
		this.multipleChoiceAntworten = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public String getWert() {
		return wert;
	}

	public void setWert(String wert) {
		this.wert = wert;
	}

	public void setTeilnehmer(Teilnehmer teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	public Frage getFrage() {
		return frage;
	}

	public void setFrage(Frage frage) {
		this.frage = frage;
	}

	public List<MultipleChoiceAntworten> getMultipleChoiceAntworten() {
			return multipleChoiceAntworten;
	}

	public void addMultipleChoice ( MultipleChoiceAntworten mca ) {
		this.multipleChoiceAntworten.add(mca);
	}
	
}
