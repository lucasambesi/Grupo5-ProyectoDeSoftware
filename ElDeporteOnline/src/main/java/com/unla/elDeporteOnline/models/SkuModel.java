package com.unla.elDeporteOnline.models;

public class SkuModel {
    private int idSku;
    private String descripcion;
    private ProductoModel producto;

    public SkuModel() {
        super();
    }

    public SkuModel(int idSku, String descripcion, ProductoModel producto) {
        super();
        this.idSku = idSku;
        this.descripcion = descripcion;
        this.producto = producto;
    }

    public int getIdSku() {
        return idSku;
    }

    public void setIdSku(int idSku) {
        this.idSku = idSku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }




}
