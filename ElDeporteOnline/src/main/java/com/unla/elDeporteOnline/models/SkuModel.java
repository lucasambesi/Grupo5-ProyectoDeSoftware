package com.unla.elDeporteOnline.models;

public class SkuModel {
    private long idSku;
    private String descripcion;
    private String codigo;
    private ProductoModel producto;

    public SkuModel() {
        super();
    }

    public SkuModel(long idSku, String descripcion, String codigo, ProductoModel producto) {
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

	public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }




}
