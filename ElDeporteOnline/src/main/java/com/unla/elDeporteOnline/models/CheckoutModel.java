package com.unla.elDeporteOnline.models;


public class CheckoutModel {
	
	private int id;
	private ProductoModel producto;
	private String nombre_apellido;
	private String email;
	private String direccion;
	private double costo;
	private String codigoPromocion;
	private String metodoDePago;
	private Boolean aceptado;
	//private EmbalajeModel embalaje;
	
	private String zona;

	public CheckoutModel() {
	}

	public CheckoutModel(int id, ProductoModel producto, String direccion, double costo, String codigoPromocion,
			String metodoDePago, Boolean aceptado, String nombre_apellido, String email) {
		super();
		this.id = id;
		this.producto = producto;
		this.direccion = direccion;
		setCosto(costo);
		this.codigoPromocion = codigoPromocion;
		this.metodoDePago = metodoDePago;
		this.aceptado = aceptado;
		//this.embalaje = embalaje;
		this.nombre_apellido = nombre_apellido;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getCodigoPromocion() {
		return codigoPromocion;
	}

	public void setCodigoPromocion(String codigoPromocion) {
		this.codigoPromocion = codigoPromocion;
	}

	public String getMetodoDePago() {
		return metodoDePago;
	}

	public void setMetodoDePago(String metodoDePago) {
		this.metodoDePago = metodoDePago;
	}

	public Boolean getAceptado() {
		return aceptado;
	}

	public void setAceptado(Boolean aceptado) {
		this.aceptado = aceptado;
	}

	/*public EmbalajeModel getEmbalaje() {
		return embalaje;
	}

	public void setEmbalaje(EmbalajeModel embalaje) {
		this.embalaje = embalaje;
	}*/
	
	public String getNombre_apellido() {
		return nombre_apellido;
	}

	public void setNombre_apellido(String nombre_apellido) {
		this.nombre_apellido = nombre_apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

}
