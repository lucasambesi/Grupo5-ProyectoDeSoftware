package com.unla.elDeporteOnline.services;

import java.util.List;

import com.unla.elDeporteOnline.entities.Oferta;
import com.unla.elDeporteOnline.models.OfertaModel;


public interface IOfertaService{

	public List<Oferta> getAll();

	public List<OfertaModel> getAlls();

	public OfertaModel findByIdOferta(long idOferta);

	public OfertaModel insert(OfertaModel ofertaModel);

	public OfertaModel update(OfertaModel ofertaModel);

	public boolean remove(long idOferta);

}