package com.unla.elDeporteOnline.services.implementation;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.elDeporteOnline.converters.ProductoConverter;
import com.unla.elDeporteOnline.entities.Producto;
import com.unla.elDeporteOnline.models.ProductoModel;
import com.unla.elDeporteOnline.repositories.IProductoRepository;
import com.unla.elDeporteOnline.services.IProductoService;

@Service("productoService")
public class ProductoService implements IProductoService{
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Override
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}
	
	@Override
	public List<ProductoModel> getAlls() {
		List<ProductoModel> em = new ArrayList<ProductoModel>();
		for (Producto producto : productoRepository.findAll()) {
			em.add(productoConverter.entityToModel(producto));
		}
		return em;
	}
	
	@Override
	public ProductoModel findByIdProducto(long idProducto) {
		return productoConverter.entityToModel(productoRepository.findByIdProducto(idProducto));
	}

	@Override
	public ProductoModel findByNombre(String nombre) {
		return productoConverter.entityToModel(productoRepository.findByNombre(nombre));
	}

	@Override
	public ProductoModel insert(ProductoModel productoModel) {
		Producto producto = productoRepository.save(productoConverter.modelToEntity(productoModel));
		return productoConverter.entityToModel(producto);
	}

	@Override
	public ProductoModel update(ProductoModel productoModel) {
		Producto producto = productoRepository.save(productoConverter.modelToEntity(productoModel));
		return productoConverter.entityToModel(producto);
	}

	@Override
	public boolean remove(long idProducto) {

		try {
			productoRepository.deleteById(idProducto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
