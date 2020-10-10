package com.unla.elDeporteOnline.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.elDeporteOnline.entities.Moneda;

@Repository("monedaRepository")
public interface IMonedaRepository extends JpaRepository<Moneda, Serializable>{

	public abstract Moneda findByIdMoneda(int idMoneda);

}