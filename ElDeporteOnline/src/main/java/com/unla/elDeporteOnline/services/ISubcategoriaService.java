package com.unla.elDeporteOnline.services;

import java.util.List;

import com.unla.elDeporteOnline.entities.Subcategoria;
import com.unla.elDeporteOnline.models.SubcategoriaModel;

public interface ISubcategoriaService {

	public List<Subcategoria> getAll();

	public List<SubcategoriaModel> getAlls();

	public SubcategoriaModel findByIdSubcategoria(long idSubcategoria);

	SubcategoriaModel insert(SubcategoriaModel subcategoriaModel);

	SubcategoriaModel update(SubcategoriaModel subcategoriaModel);

	public boolean remove(long idSubcategoria);
}
