package com.unla.elDeporteOnline.entities;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.unla.elDeporteOnline.models.CategoriaModel;
import com.unla.elDeporteOnline.models.MonedaModel;
import com.unla.elDeporteOnline.models.SkuModel;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProducto;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcionCorta")
	private String descripcionCorta;
	
	@Column(name = "descripcionLarga")
	private String descripcionLarga;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria categoria;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	private Set<Imagen> listaImagenes = new HashSet<Imagen>();
	
	@Column(name = "activo")
	private boolean activo;
	
	@Column(name = "precio")
	private float precio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMoneda", nullable = false)
	private Moneda moneda;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	private Set<Sku> listaSku = new HashSet<Sku>();
	
	//calificacion

	public Producto() {
		super();
	}

	public Producto(long idProducto, String nombre, String descripcionCorta, String descripcionLarga, Categoria categoria, boolean activo, float precio, Moneda moneda) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcionCorta = descripcionCorta;
		this.descripcionLarga = descripcionLarga;
		this.categoria = categoria;
		this.activo = activo;
		this.precio = precio;
		this.moneda = moneda;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionLarga() {
		return descripcionLarga;
	}

	public void setDescripcionLarga(String descripcionLarga) {
		this.descripcionLarga = descripcionLarga;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Set<Imagen> getListaImagenes() {
		return listaImagenes;
	}

	public void setListaImagenes(Set<Imagen> listaImagenes) {
		this.listaImagenes = listaImagenes;
	}

	public Set<Sku> getListaSku() {
		return listaSku;
	}

	public void setListaSku(Set<Sku> listaSku) {
		this.listaSku = listaSku;
	}
	
	
	

}