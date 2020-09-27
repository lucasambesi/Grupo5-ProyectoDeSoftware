package com.unla.elDeporteOnline.models;

public class ImagenModel {
	private int idImagen;
	private String url;
	
	public ImagenModel() {
		super();
	}

	public ImagenModel(int idImagen, String url) {
		super();
		this.idImagen = idImagen;
		this.url = url;
	}

	public int getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
