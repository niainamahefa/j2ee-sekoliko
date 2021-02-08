package com.ecole.model;

public class Matiere {
	
	private int mat_id;
	private String mat_nom;

	public Matiere(String mat_nom) {
		super();
		this.mat_nom = mat_nom;
	}
	
	public Matiere(int mat_id, String mat_nom) {
		super();
		this.mat_id = mat_id;
		this.mat_nom = mat_nom;
	}
	
	public int getMat_id() {
		return mat_id;
	}
	public void setMat_id(int mat_id) {
		this.mat_id = mat_id;
	}
	public String getMat_nom() {
		return mat_nom;
	}
	public void setMat_nom(String mat_nom) {
		this.mat_nom = mat_nom;
	}
	
	
}
