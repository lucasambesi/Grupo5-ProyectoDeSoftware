package com.unla.elDeporteOnline.converters;

import org.springframework.stereotype.Component;

import com.unla.elDeporteOnline.entities.Moneda;
import com.unla.elDeporteOnline.models.MonedaModel;

@Component("monedaConverter")
public class MonedaConverter {

	public MonedaModel entityToModel(Moneda moneda) {
		return new MonedaModel(moneda.getIdMoneda(), moneda.getNombre());
	}

	public Moneda modelToEntity(MonedaModel monedaModel) {
		return new Moneda(monedaModel.getIdMoneda(), monedaModel.getNombre());
	}

	
	
	
}
