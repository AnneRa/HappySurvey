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

@Table(name = "frage")
public class Frage {

	@Id
	@GeneratedValue
	@Column(name = "FrageId")
	private long id;

	@Column(name = "text")
	private String text;

	@Column(name = "info")
	private String info;
	
	@Column(name = "optional")
	private boolean optional;
	
	@Column(name = "questionType")
	private byte type;
	
	@OneToMany(mappedBy = "frage", cascade = CascadeType.ALL)
	private List<FrageOptionen> optionen;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GruppenId")
	private Gruppe gruppe;
	
	public Frage() {
		super();
	}
	
	public Frage(Gruppe gruppe, Frage frage) {
		this.gruppe = gruppe;
		this.info = frage.info;
		this.text = frage.text;
		this.type = frage.type;
		this.optional = frage.optional;
		this.optionen = new ArrayList<>();;
	}

	public long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public List<FrageOptionen> getOptionen() {
		return optionen;
	}

	public void setOptionen(List<FrageOptionen> optionen) {
		this.optionen = optionen;
	}
	
	public void addOption(FrageOptionen option) {
		this.optionen.add(option);
	}

	public boolean isOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public String getGroupName() {
		return this.gruppe.getName();
	}
	
	public long getGroupId() {
		return this.gruppe.getId();
	}
	
	public void clearOptions(){
		this.optionen.clear();
	}
	
}
