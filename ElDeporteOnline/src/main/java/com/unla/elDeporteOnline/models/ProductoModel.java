package com.unla.elDeporteOnline.models;

import java.util.HashSet;
import java.util.Set;

import com.unla.elDeporteOnline.entities.Categoria;
import com.unla.elDeporteOnline.entities.Imagen;
import com.unla.elDeporteOnline.entities.Moneda;

public class ProductoModel {
	private long idProducto;
	private String nombre;
	private String descripcionCorta;
	private String descripcionLarga;
	private CategoriaModel categoria;
	private Set<Imagen> listaImagenes = new HashSet<Imagen>();
	private boolean activo;
	private float precio;
	private MonedaModel moneda;
	private SkuModel sku;
	//calificacion
	
	public ProductoModel() {
		super();
	}
	
	public ProductoModel(long idProducto, String nombre, String descripcionCorta, String descripcionLarga,
			CategoriaModel categoria, boolean activo, float precio, MonedaModel moneda) {
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
	
	public CategoriaModel getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
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

	
}