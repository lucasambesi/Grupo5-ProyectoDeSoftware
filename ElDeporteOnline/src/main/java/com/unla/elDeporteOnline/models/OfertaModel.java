package com.unla.elDeporteOnline.models;

public class OfertaModel {
	private long idOferta;
	private float porcentaje;
	private ProductoModel producto;
	
	public OfertaModel() {
		super();
	}

	public OfertaModel(long idOferta, float porcentaje, ProductoModel producto) {
		super();
		this.idOferta = idOferta;
		this.porcentaje = porcentaje;
		this.producto = producto;
	}

	public long getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(long idOferta) {
		this.idOferta = idOferta;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}
	
	
}