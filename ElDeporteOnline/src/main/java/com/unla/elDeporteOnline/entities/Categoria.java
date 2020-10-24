package com.unla.elDeporteOnline.entities;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.unla.elDeporteOnline.entities.Producto;


@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategoria;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	private Set<Subcategoria> listaSubcategorias = new HashSet<Subcategoria>();


	public Categoria() {

	}


	public Categoria(long idCategoria, String nombre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}


	public Categoria(long idCategoria, String nombre, Set<Subcategoria> listaSubcategorias) {
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