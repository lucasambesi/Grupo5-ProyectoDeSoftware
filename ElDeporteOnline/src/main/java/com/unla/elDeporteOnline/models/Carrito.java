package com.unla.elDeporteOnline.models;

public class Carrito {
	private int item;
	private int idProducto;
	private String nombres;
	private String descripcion;
	private int cantidad;
	private float precioCompra;
	private float subTotal;
	
	public Carrito(int item, int idProducto, String nombres, String descripcion, int cantidad, float precioCompra,
			float subTotal) {
		super();
		this.item = item;
		this.idProducto = idProducto;
		this.nombres = nombres;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precioCompra = precioCompra;
		this.subTotal = subTotal;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	
}
