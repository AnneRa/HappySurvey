package com.htw.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class ResUmfrage {

	private long id;
	private String name;
	private String beschr;
	private String intro;
	private String startdat;
	private String enddat;
	private ArrayList<ResGruppe> gruppen;

	public ResUmfrage( Umfrage umf ) {
		
		this.id = umf.getId();
		this.name = umf.getName();
		this.beschr = umf.getBeschr();
		this.intro = umf.getIntro();
		this.startdat = umf.getStartdat();
		this.enddat = umf.getEnddat();
		this.gruppen = new ArrayList<>();
		
	}
	
	public void appendGroup( ResGruppe grp ) {
		this.gruppen.add(grp);
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBeschr() {
		return beschr;
	}

	public String getIntro() {
		return intro;
	}

	public String getStartdat() {
		return startdat;
	}

	public String getEnddat() {
		return enddat;
	}

	public ArrayList<ResGruppe> getGruppen() {
		return gruppen;
	}
	
}
