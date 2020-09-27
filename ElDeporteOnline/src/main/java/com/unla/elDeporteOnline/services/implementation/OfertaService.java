package com.unla.elDeporteOnline.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.elDeporteOnline.converters.OfertaConverter;
import com.unla.elDeporteOnline.entities.Oferta;
import com.unla.elDeporteOnline.models.OfertaModel;
import com.unla.elDeporteOnline.repositories.IOfertaRepository;
import com.unla.elDeporteOnline.services.IOfertaService;
import com.unla.elDeporteOnline.services.IProductoService;

@Service("ofertaService")
public class OfertaService implements IOfertaService{

	@Autowired
	@Qualifier("ofertaRepository")
	private IOfertaRepository ofertaRepository;

	@Autowired
	@Qualifier("ofertaConverter")
	private OfertaConverter ofertaConverter;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;


	public List<Oferta> getAll() {
		return ofertaRepository.findAll();
	}

	public OfertaModel insert(OfertaModel ofertaModel) {
		Oferta oferta = ofertaRepository.save(ofertaConverter.modelToEntity(ofertaModel));
		return ofertaConverter.entityToModel(oferta);
	}

	public OfertaModel update(OfertaModel ofertaModel) {
		Oferta oferta = ofertaRepository.save(ofertaConverter.modelToEntity(ofertaModel));
		return ofertaConverter.entityToModel(oferta);
	}

	public boolean remove(long idOferta) {
		try {
			ofertaRepository.deleteById(idOferta);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public OfertaModel findByIdOferta(long idOferta) {
		return ofertaConverter.entityToModel(ofertaRepository.findByIdOferta(idOferta));
	}


	public List<OfertaModel> getAlls() {
		List<OfertaModel> models = new ArrayList<OfertaModel>();
		for (Oferta oferta : ofertaRepository.findAll()) {
			models.add(ofertaConverter.entityToModel(oferta));
		}
		return models;
	}

}