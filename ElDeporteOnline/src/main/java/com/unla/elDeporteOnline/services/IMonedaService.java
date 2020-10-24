package com.unla.elDeporteOnline.services;

import java.util.List;

import com.unla.elDeporteOnline.entities.Moneda;
import com.unla.elDeporteOnline.models.MonedaModel;



public interface IMonedaService {
	public List<Moneda> getAll();

	public List<MonedaModel> getAlls();

	public MonedaModel findByIdMoneda(long idMoneda);

	public MonedaModel insert(MonedaModel monedaModel);

	public MonedaModel update(MonedaModel monedaModel);

	public boolean remove(int idMoneda);
}
