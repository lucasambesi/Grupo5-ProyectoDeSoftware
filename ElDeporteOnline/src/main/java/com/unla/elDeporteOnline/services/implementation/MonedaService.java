package com.unla.elDeporteOnline.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.elDeporteOnline.converters.MonedaConverter;
import com.unla.elDeporteOnline.entities.Moneda;
import com.unla.elDeporteOnline.models.MonedaModel;
import com.unla.elDeporteOnline.repositories.IMonedaRepository;
import com.unla.elDeporteOnline.services.IMonedaService;


@Service("monedaService")
public class MonedaService implements IMonedaService{

	@Autowired
	@Qualifier("monedaRepository")
	private IMonedaRepository monedaRepository;

	@Autowired
	@Qualifier("monedaConverter")
	private MonedaConverter monedaConverter;
	
	
	public List<Moneda> getAll() {
		return monedaRepository.findAll();
	}

	public MonedaModel insert(MonedaModel monedaModel) {
		Moneda moneda = monedaRepository.save(monedaConverter.modelToEntity(monedaModel));
		return monedaConverter.entityToModel(moneda);
	}

	public MonedaModel update(MonedaModel monedaModel) {
		Moneda moneda = monedaRepository.save(monedaConverter.modelToEntity(monedaModel));
		return monedaConverter.entityToModel(moneda);
	}

	public boolean remove(int idMoneda) {
		try {
			monedaRepository.deleteById(idMoneda);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public MonedaModel findByIdMoneda(int idMoneda) {
		return monedaConverter.entityToModel(monedaRepository.findByIdMoneda(idMoneda));
	}


	public List<MonedaModel> getAlls() {
		List<MonedaModel> models = new ArrayList<MonedaModel>();
		for (Moneda Moneda : monedaRepository.findAll()) {
			models.add(monedaConverter.entityToModel(Moneda));
		}
		return models;
	}

		

	
}




	

