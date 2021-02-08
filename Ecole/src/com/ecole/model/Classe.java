package com.ecole.model;

public class Classe {
	
	private int cls_id;
	private String cls_nom;
	
	public Classe( String cls_nom) {
		super();
		this.cls_nom = cls_nom;
	}

	public Classe(int cls_id, String cls_nom) {
		super();
		this.cls_id = cls_id;
		this.cls_nom = cls_nom;
	}

	public int getCls_id() {
		return cls_id;
	}

	public void setCls_id(int cls_id) {
		this.cls_id = cls_id;
	}

	public String getCls_nom() {
		return cls_nom;
	}

	public void setCls_nom(String cls_nom) {
		this.cls_nom = cls_nom;
	}
	
	
	
}
