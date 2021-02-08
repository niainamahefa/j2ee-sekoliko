package com.ecole.model;

public class Professeur {
	
	private int prof_id;
	private String prof_nom;
	private String prof_prenom;
	private String cls_nom;
	private String mat_nom;
	
	
	
	

	public String getCls_nom() {
		return cls_nom;
	}



	public void setCls_nom(String cls_nom) {
		this.cls_nom = cls_nom;
	}



	public String getMat_nom() {
		return mat_nom;
	}



	public void setMat_nom(String mat_nom) {
		this.mat_nom = mat_nom;
	}



	public Professeur(int prof_id, String prof_nom, String prof_prenom, String cls_nom, String mat_nom) {
		super();
		this.prof_id = prof_id;
		this.prof_nom = prof_nom;
		this.prof_prenom = prof_prenom;
		this.cls_nom = cls_nom;
		this.mat_nom = mat_nom;
	}
	
	
	
	public Professeur(String prof_nom, String prof_prenom, String cls_nom, String mat_nom) {
		super();
		this.prof_nom = prof_nom;
		this.prof_prenom = prof_prenom;
		this.cls_nom = cls_nom;
		this.mat_nom = mat_nom;
	}



	public int getProf_id() {
		return prof_id;
	}
	public void setProf_id(int prof_id) {
		this.prof_id = prof_id;
	}
	public String getProf_nom() {
		return prof_nom;
	}
	public void setProf_nom(String prof_nom) {
		this.prof_nom = prof_nom;
	}
	public String getProf_prenom() {
		return prof_prenom;
	}
	public void setProf_prenom(String prof_prenom) {
		this.prof_prenom = prof_prenom;
	}
	
	
	
}