package com.unla.elDeporteOnline.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.elDeporteOnline.entities.Subcategoria;

@Repository("subcategoriaRepository")
public interface ISubcategoriaRepository extends JpaRepository<Subcategoria, Serializable>{
	
	public abstract Subcategoria findByIdSubcategoria(long idSubcategoria);

}
