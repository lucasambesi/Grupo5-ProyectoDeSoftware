package com.unla.elDeporteOnline.models;

import java.util.HashSet;

import java.util.Set;

import com.unla.elDeporteOnline.entities.Categoria;
import com.unla.elDeporteOnline.entities.Producto;


public class SubcategoriaModel {
	private long idSubcategoria;
	private String nombre;
	private Set<Producto> listaProductos = new HashSet<Producto>();
	private CategoriaModel categoria;
	
	public SubcategoriaModel() {
		super();
	}


	public SubcategoriaModel(long idSubcategoria, String nombre, CategoriaModel categoria) {
		super();
		this.idSubcategoria = idSubcategoria;
		this.nombre = nombre;
		this.categoria = categoria;
	}



	public long getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(long idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Set<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}


	public CategoriaModel getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
	

}
