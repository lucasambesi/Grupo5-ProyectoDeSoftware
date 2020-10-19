package com.unla.elDeporteOnline.entities;

import java.util.HashSet;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Sku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSku;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "codigo")
    private String codigo;
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProducto", nullable = false)
    private Producto producto;

    public Sku() {
        super();
    }

    public Sku(long idSku, String descripcion, String codigo, Producto producto) {
        super();
        this.idSku = idSku;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.producto = producto;
    }

    public long getIdSku() {
        return idSku;
    }

    public void setIdSku(long idSku) {
        this.idSku = idSku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }



}