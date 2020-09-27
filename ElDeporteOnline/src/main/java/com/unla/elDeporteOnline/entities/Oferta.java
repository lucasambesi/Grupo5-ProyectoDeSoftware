package com.unla.elDeporteOnline.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.unla.elDeporteOnline.entities.Producto;

@Entity
@Table(name = "oferta")
public class Oferta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOferta;

	@Column(name = "porcentaje")
	private float porcentaje;

	@OneToOne(cascade = CascadeType.MERGE)
	private Producto producto;

	public Oferta() {
		super();
	}

	public Oferta(long idOferta, float porcentaje, Producto producto) {
		super();
		this.idOferta = idOferta;
		this.porcentaje = porcentaje;
		this.producto = producto;
	}

	public long getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(long idOferta) {
		this.idOferta = idOferta;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
}