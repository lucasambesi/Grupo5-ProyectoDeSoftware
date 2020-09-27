package com.unla.elDeporteOnline.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.elDeporteOnline.entities.Categoria;
import com.unla.elDeporteOnline.models.CategoriaModel;


@Component("categoriaConverter")
public class CategoriaConverter {

	@Autowired
	@Qualifier("categoriaConverter")
	private CategoriaConverter categoriaConverter;
	
	public CategoriaModel entityToModel(Categoria categoria) {
		return new CategoriaModel(categoria.getIdCategoria(),categoria.getNombre(),categoria.getIdCategoriaPadre());
	}
	public Categoria modelToEntity(CategoriaModel categoriaModel) {
		return new Categoria(categoriaModel.getIdCategoria(),categoriaModel.getNombre(),categoriaModel.getIdCategoriaPadre());
	}
}