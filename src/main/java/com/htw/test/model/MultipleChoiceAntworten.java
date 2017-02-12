package com.htw.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "multipleChoiceAntworten")
public class MultipleChoiceAntworten {

	@Id
	@GeneratedValue
	@Column(name = "multipleChoiceAntwortId")
	private long id;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="antwortenId")
	private Antworten antwort;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="frageOptionId")
	private FrageOptionen frageOption;
	
	public MultipleChoiceAntworten() {
		super();
	}

	public MultipleChoiceAntworten( FrageOptionen fo ) {
		super();
		this.frageOption = fo;
	}
	
	public MultipleChoiceAntworten( FrageOptionen fo, Antworten ans ) {
		super();
		this.frageOption = fo;
		this.antwort = ans;
	}
	
	public FrageOptionen getFrageOption() {
		return frageOption;
	}
	
	
}
