package com.htw.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class ResGruppe {

	private long id;
	private String name;
	private ArrayList<ResFrage> fragen;
	
	public ResGruppe( Gruppe grp ) {
		
		this.id = grp.getId();
		this.name = grp.getName();
		this.fragen = new ArrayList<>();
	}
	
	public void appendQuestion( ResFrage resFra ) {
		this.fragen.add(resFra);
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<ResFrage> getFragen() {
		return fragen;
	}

}
