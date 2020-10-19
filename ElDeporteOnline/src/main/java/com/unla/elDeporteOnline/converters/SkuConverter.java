package com.unla.elDeporteOnline.converters;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.unla.elDeporteOnline.entities.Sku;
import com.unla.elDeporteOnline.models.SkuModel;


@Component ("skuConverter")
public class SkuConverter {

	@Autowired
    @Qualifier("productoConverter")
    private ProductoConverter productoConverter;
	
	
	public SkuModel entityToModel (Sku sku) {
		return new SkuModel (sku.getIdSku(),sku.getDescripcion(),sku.getCodigo(),productoConverter.entityToModel(sku.getProducto()));
	}
	
	public Sku modelToEntity (SkuModel skuModel) {
		return new Sku (skuModel.getIdSku(), skuModel.getDescripcion(), skuModel.getCodigo(), productoConverter.modelToEntity(skuModel.getProducto()));
	}
}
