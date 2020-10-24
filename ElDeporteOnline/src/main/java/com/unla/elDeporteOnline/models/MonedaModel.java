package com.unla.elDeporteOnline.models;

public class MonedaModel {
	private long idMoneda;
	private String nombre;
	
	public MonedaModel() {
		super();
	}

	public MonedaModel(long idMoneda, String nombre) {
		super();
		this.idMoneda = idMoneda;
		this.nombre = nombre;
	}

	public long getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(long idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}