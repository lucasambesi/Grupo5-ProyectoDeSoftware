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
import javax.persistence.Table;

import com.unla.elDeporteOnline.entities.Producto;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategoria;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "idCategoriaPadre")
	private long idCategoriaPadre;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	private Set<Producto> listaProductos = new HashSet<Producto>();


	public Categoria() {

	}


	public Categoria(long idCategoria, String nombre, long idCategoriaPadre) {
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