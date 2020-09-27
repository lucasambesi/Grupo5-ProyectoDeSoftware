package com.unla.elDeporteOnline.models;

import java.util.HashSet;
import java.util.Set;
import com.unla.elDeporteOnline.entities.Categoria;
import com.unla.elDeporteOnline.entities.Producto;

public class CategoriaModel {

	private long idCategoria;
	private String nombre;
	private long idCategoriaPadre;
	private Set<Producto> listaProductos = new HashSet<Producto>();
	
	public CategoriaModel() {
	}

	public CategoriaModel(long idCategoria, String nombre, long idCategoriaPadre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.idCategoriaPadre = idCategoriaPadre;
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

	public long getIdCategoriaPadre() {
		return idCategoriaPadre;
	}

	public void setIdCategoriaPadre(long idCategoriaPadre) {
		this.idCategoriaPadre = idCategoriaPadre;
	}

	public Set<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Set<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
	
}