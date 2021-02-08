package com.ecole.model;

public class Eleve {
	
	private int elv_id;
	private String elv_nom;
	private String elv_prenom;
	private int elv_cls_k;

	public Eleve(String elv_nom, String elv_prenom, int elv_cls_k) {
		super();
		this.elv_nom = elv_nom;
		this.elv_prenom = elv_prenom;
		this.elv_cls_k = elv_cls_k;
	}
	
	public Eleve(int elv_id, String elv_nom, String elv_prenom, int elv_cls_k) {
		super();
		this.elv_id = elv_id;
		this.elv_nom = elv_nom;
		this.elv_prenom = elv_prenom;
		this.elv_cls_k = elv_cls_k;
	}



	public int getElv_id() {
		return elv_id;
	}

	public void setElv_id(int elv_id) {
		this.elv_id = elv_id;
	}

	public String getElv_nom() {
		return elv_nom;
	}

	public void setElv_nom(String elv_nom) {
		this.elv_nom = elv_nom;
	}

	public String getElv_prenom() {
		return elv_prenom;
	}

	public void setElv_prenom(String elv_prenom) {
		this.elv_prenom = elv_prenom;
	}
	
	public int getElv_cls_k() {
		return elv_cls_k;
	}

	public void setElv_cls_k(int elv_cls_k) {
		this.elv_cls_k = elv_cls_k;
	}

	
	
	
}
