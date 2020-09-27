package com.unla.elDeporteOnline.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Moneda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMoneda;
	
	@Column(name = "nombre")
	private String nombre;

	public Moneda() {
		super();
	}

	public Moneda(int idMoneda, String nombre) {
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
