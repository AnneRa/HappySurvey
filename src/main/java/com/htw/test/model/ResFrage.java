package com.htw.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class ResFrage {

	private long id;
	private String text;
	private String info;
	private boolean optional;
	private byte type;
	private float averageValue;
	private String[] freeTextEntries;
	private ArrayList<ResAntwort> predefinedAnswers;

	public ResFrage( Frage fra ) {
		
		this.id = fra.getId();
		this.text = fra.getText();
		this.info = fra.getInfo();
		this.optional = fra.isOptional();
		this.type = fra.getType();
		this.averageValue = -1;
		this.freeTextEntries = null;
		this.predefinedAnswers = new ArrayList<>();
	}

	public void appendPredefinedAnswer ( ResAntwort resAns ) {
		this.predefinedAnswers.add(resAns);
	}
	
	public long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getInfo() {
		return info;
	}

	public boolean isOptional() {
		return optional;
	}

	public byte getType() {
		return type;
	}

	public float getAverageValue() {
		return averageValue;
	}

	public void setAverageValue(float averageValue) {
		this.averageValue = averageValue;
	}

	public String[] getFreeTextEntries() {
		return freeTextEntries;
	}

	public void setFreeTextEntries(String[] freeTextEntries) {
		this.freeTextEntries = freeTextEntries;
	}

	public ArrayList<ResAntwort> getPredefinedAnswers() {
		return predefinedAnswers;
	}



}
