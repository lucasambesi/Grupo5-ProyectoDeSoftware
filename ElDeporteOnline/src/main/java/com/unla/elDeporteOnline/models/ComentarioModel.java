package com.unla.elDeporteOnline.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class ComentarioModel {
	private int id;
	private String comentario;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaComentario;
	private CheckoutModel checkout;
	private double valoracion;

	public ComentarioModel() {}
	
	public ComentarioModel(int id, String comentario, Date fechaComentario, CheckoutModel checkout, double valoracion) {
		super();
		this.id = id;
		this.comentario = comentario;
		this.fechaComentario = fechaComentario;
		this.checkout = checkout;
		this.valoracion = valoracion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Date getFechaComentario() {
		return fechaComentario;
	}
	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	public CheckoutModel getCheckout() {
		return checkout;
	}

	public void setCheckout(CheckoutModel checkout) {
		this.checkout = checkout;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

}
