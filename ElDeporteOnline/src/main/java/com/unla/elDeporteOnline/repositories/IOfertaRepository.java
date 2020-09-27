package com.unla.elDeporteOnline.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.elDeporteOnline.entities.Oferta;

@Repository("ofertaRepository")
public interface IOfertaRepository extends JpaRepository<Oferta, Serializable>{

	public abstract Oferta findByIdOferta(long idOferta);

}