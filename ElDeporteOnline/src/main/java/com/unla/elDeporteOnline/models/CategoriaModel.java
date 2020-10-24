package com.unla.elDeporteOnline.models;

import java.util.HashSet;
import java.util.Set;
import com.unla.elDeporteOnline.entities.Categoria;
import com.unla.elDeporteOnline.entities.Producto;
import com.unla.elDeporteOnline.entities.Subcategoria;

public class CategoriaModel {

	private long idCategoria;
	private String nombre;
	private Set<Subcategoria> listaSubcategorias = new HashSet<Subcategoria>();
	
	public CategoriaModel() {
	}

	public CategoriaModel(long idCategoria, String nombre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}

	
	public CategoriaModel(long idCategoria, String nombre, Set<Subcategoria> listaSubcategorias) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.listaSubcategorias = listaSubcategorias;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Subcategoria> getListaSubcategorias() {
		return listaSubcategorias;
	}

	public void setListaSubcategorias(Set<Subcategoria> listaSubcategorias) {
		this.listaSubcategorias = listaSubcategorias;
	}

	
	
	
	
}