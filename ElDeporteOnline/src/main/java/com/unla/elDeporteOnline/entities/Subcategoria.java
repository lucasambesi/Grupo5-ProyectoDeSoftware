package com.unla.elDeporteOnline.entities;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "subcategoria")
public class Subcategoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSubcategoria;

	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subcategoria")
	private Set<Producto> listaProductos = new HashSet<Producto>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria categoria;

	public Subcategoria() {
		super();
	}



	public Subcategoria(long idSubcategoria, String nombre, Categoria categoria) {
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

	

}
