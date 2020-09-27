package com.unla.elDeporteOnline.services;

import java.time.LocalDate;
import java.util.List;

import com.unla.elDeporteOnline.entities.Categoria;
import com.unla.elDeporteOnline.models.CategoriaModel;
import com.unla.elDeporteOnline.models.ProductoModel;

public interface ICategoriaService {

	public List<Categoria> getAll();

	public List<CategoriaModel> getAlls();

	public CategoriaModel findByIdCategoria(long idCategoria);

	CategoriaModel insert(CategoriaModel categoriaModel);

	CategoriaModel update(CategoriaModel categoriaModel);

	public boolean remove(long idCategoria);

}