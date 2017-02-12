package com.htw.test.model;

public class ResAntwort {

	private long id;
	private String text;
	private int orderIndex;
	private long count;
	
	public ResAntwort( FrageOptionen fo, long count ) {
		
		this.id = fo.getId();
		this.text = fo.getText();
		this.orderIndex = fo.getOrderIndex();
		this.count = count;
	}

	public long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public long getCount() {
		return count;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	
	
}
