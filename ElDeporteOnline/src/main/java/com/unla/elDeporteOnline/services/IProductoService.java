package com.unla.elDeporteOnline.services;

import java.util.List;

import com.unla.elDeporteOnline.entities.Producto;
import com.unla.elDeporteOnline.models.ProductoModel;


public interface IProductoService {
	
	public List<Producto> getAll();

	public List<ProductoModel> getAlls();
	
	public ProductoModel findByIdProducto(long idProducto);

	public ProductoModel findByNombre(String nombre);

	public ProductoModel insert(ProductoModel productoModel);

	public ProductoModel update(ProductoModel productoModel);

	public boolean remove(long idProducto);

}
