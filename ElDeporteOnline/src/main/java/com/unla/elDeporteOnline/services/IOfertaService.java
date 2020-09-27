package com.unla.elDeporteOnline.services;

import java.time.LocalDate;
import java.util.List;

import com.unla.elDeporteOnline.entities.Oferta;
import com.unla.elDeporteOnline.models.OfertaModel;
import com.unla.elDeporteOnline.models.ProductoModel;


public interface IOfertaService{

	public List<Oferta> getAll();

	public List<OfertaModel> getAlls();

	public OfertaModel findByIdOferta(long idOferta);

	OfertaModel insert(OfertaModel ofertaModel);

	OfertaModel update(OfertaModel ofertaModel);

	public boolean remove(long idOferta);

}