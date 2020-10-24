package com.unla.elDeporteOnline.models;

import java.util.HashSet;
import java.util.Set;

import com.unla.elDeporteOnline.entities.Imagen;
import com.unla.elDeporteOnline.entities.Sku;

public class ProductoModel {
	private long idProducto;
	private String nombre;
	private String descripcionCorta;
	private String descripcionLarga;
	private SubcategoriaModel subcategoria;
	private Set<Imagen> listaImagenes = new HashSet<Imagen>();
	private boolean activo;
	private float precio;
	private MonedaModel moneda;
	private String foto;
	
	private Set<Sku> listaSkus = new HashSet<Sku>();
	//calificacion
	
	public ProductoModel() {
		super();
	}
	
	public ProductoModel(long idProducto, String nombre, String descripcionCorta, String descripcionLarga,
			SubcategoriaModel subcategoria, boolean activo, float precio, MonedaModel moneda, String foto) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcionCorta = descripcionCorta;
		this.descripcionLarga = descripcionLarga;
		this.subcategoria = subcategoria;
		this.activo = activo;
		this.precio = precio;
		this.moneda = moneda;
		this.foto = foto;
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
	
	public SubcategoriaModel getSubcategoria() {
		return subcategoria;
	}
	public void setSubcategoria(SubcategoriaModel subcategoria) {
		this.subcategoria = subcategoria;
	}
	
	public Set<Imagen> getListaImagenes() {
		return listaImagenes;
	}

	public void setListaImagenes(Set<Imagen> listaImagenes) {
		this.listaImagenes = listaImagenes;
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
	public MonedaModel getMoneda() {
		return moneda;
	}
	public void setMoneda(MonedaModel moneda) {
		this.moneda = moneda;
	}

	public Set<Sku> getListaSkus() {
		return listaSkus;
	}

	public void setListaSkus(Set<Sku> listaSkus) {
		this.listaSkus = listaSkus;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	

}