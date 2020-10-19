package com.unla.elDeporteOnline.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.elDeporteOnline.entities.Sku;

@Repository ("skuRepository")
public interface ISkuRepository extends JpaRepository<Sku, Serializable>{

	public abstract Sku findByIdSku (long idSku);

}
