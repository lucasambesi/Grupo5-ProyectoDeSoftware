package com.unla.elDeporteOnline.models;

public class MonedaModel {
	private int idMoneda;
	private String nombre;
	
	public MonedaModel() {
		super();
	}

	public MonedaModel(int idMoneda, String nombre) {
		super();
		this.idMoneda = idMoneda;
		this.nombre = nombre;
	}

	public int getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}