package com.unla.elDeporteOnline.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.elDeporteOnline.converters.SkuConverter;
import com.unla.elDeporteOnline.entities.Sku;
import com.unla.elDeporteOnline.models.SkuModel;
import com.unla.elDeporteOnline.repositories.ISkuRepository;
import com.unla.elDeporteOnline.services.ISkuService;
import com.unla.elDeporteOnline.services.IProductoService;

@Service ("skuService")
public class SkuService implements ISkuService {

	@Autowired
	@Qualifier("skuRepository")
	private ISkuRepository skuRepository;

	@Autowired
	@Qualifier("skuConverter")
	private SkuConverter skuConverter;
	
	@Autowired
	@Qualifier("productoService")
	private ProductoService productoService;
	
	public List<Sku> getAll() {
		return skuRepository.findAll();
	}

	public SkuModel insert(SkuModel skuModel) {
		skuModel.setProducto(productoService.findByIdProducto(skuModel.getProducto().getIdProducto()));
		Sku sku = skuRepository.save(skuConverter.modelToEntity(skuModel));
		return skuConverter.entityToModel(sku);
	}

	public SkuModel update(SkuModel skuModel) {
		skuModel.setProducto(productoService.findByIdProducto(skuModel.getProducto().getIdProducto()));
		Sku sku = skuRepository.save(skuConverter.modelToEntity(skuModel));
		return skuConverter.entityToModel(sku);
	}

	public boolean remove(long idSku) {
		try {
			skuRepository.deleteById(idSku);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public SkuModel findByIdSku(long idSku) {
		return skuConverter.entityToModel(skuRepository.findByIdSku(idSku));
	}


	public List<SkuModel> getAlls() {
		List<SkuModel> models = new ArrayList<SkuModel>();
		for (Sku Sku : skuRepository.findAll()) {
			models.add(skuConverter.entityToModel(Sku));
		}
		return models;
	}

}
