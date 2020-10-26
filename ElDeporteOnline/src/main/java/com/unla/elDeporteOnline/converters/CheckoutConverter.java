package com.unla.elDeporteOnline.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.elDeporteOnline.entities.Checkout;
import com.unla.elDeporteOnline.models.CheckoutModel;


@Component("checkoutConverter")
public class CheckoutConverter {

	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;
	
	
	public CheckoutModel entityToModel(Checkout checkout) {
		return new CheckoutModel(checkout.getId(), productoConverter.entityToModel(checkout.getProducto()), checkout.getDireccion(), checkout.getCosto(), checkout.getCodigoPromocion(), 
				checkout.getMetodoDePago(), checkout.getAceptado(), checkout.getNombre_apellido(), checkout.getEmail());
	}
	
	public Checkout modelToEntity(CheckoutModel model) {
		return new Checkout(model.getId(), productoConverter.modelToEntity(model.getProducto()), model.getDireccion(), model.getCosto(), model.getCodigoPromocion(), 
		model.getMetodoDePago(), model.getNombre_apellido(), model.getEmail());
	}
}
