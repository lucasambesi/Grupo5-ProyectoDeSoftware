package com.unla.elDeporteOnline.models;

import java.util.HashSet;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.unla.elDeporteOnline.entities.Sku;

public class ProductoModel {
	private long idProducto;
	private String nombre;
	private String descripcionCorta;
	private String descripcionLarga;
	private SubcategoriaModel subcategoria;
	//private Set<Imagen> listaImagenes = new HashSet<Imagen>();
	private String urlImagen;
	private boolean activo;
	private float precio;
	private MonedaModel moneda;
	private MultipartFile file;
	//private String foto;
	
	private Set<Sku> listaSkus = new HashSet<Sku>();
	//calificacion
	
	public ProductoModel() {
		super();
	}
	
	public ProductoModel(long idProducto, String nombre, String descripcionCorta, String descripcionLarga,
			SubcategoriaModel subcategoria, String urlImagen, boolean activo, float precio, MonedaModel moneda) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcionCorta = descripcionCorta;
		this.descripcionLarga = descripcionLarga;
		this.subcategoria = subcategoria;
		this.urlImagen = urlImagen;
		this.activo = activo;
		this.precio = precio;
		this.moneda = moneda;
		//this.foto = foto;
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

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	
	

}