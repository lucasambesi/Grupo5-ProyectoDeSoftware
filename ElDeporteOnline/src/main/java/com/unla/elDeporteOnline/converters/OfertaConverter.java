package com.unla.elDeporteOnline.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.elDeporteOnline.entities.Oferta;
import com.unla.elDeporteOnline.models.OfertaModel;
import com.unla.elDeporteOnline.converters.ProductoConverter;


@Component ("ofertaConverter")
public class OfertaConverter {

	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	
	public OfertaModel entityToModel(Oferta oferta) {
		return new OfertaModel (oferta.getIdOferta(), oferta.getPorcentaje(), productoConverter.entityToModel(oferta.getProducto()));
	}
	
	
	public Oferta modelToEntity(OfertaModel ofertaModel) {
		return new Oferta (ofertaModel.getIdOferta(), ofertaModel.getPorcentaje(), productoConverter.modelToEntity(ofertaModel.getProducto()));
	}
}