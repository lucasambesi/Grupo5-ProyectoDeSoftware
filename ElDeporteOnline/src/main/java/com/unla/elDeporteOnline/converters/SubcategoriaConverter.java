package com.unla.elDeporteOnline.converters;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.elDeporteOnline.entities.Subcategoria;
import com.unla.elDeporteOnline.models.SubcategoriaModel;


@Component("subcategoriaConverter")
public class SubcategoriaConverter {
	
	@Autowired
	@Qualifier("subcategoriaConverter")
	private SubcategoriaConverter subcategoriaConverter;
	
	@Autowired
	@Qualifier("categoriaConverter")
	private CategoriaConverter categoriaConverter;
	
	public SubcategoriaModel entityToModel(Subcategoria subcategoria) {
		return new SubcategoriaModel(subcategoria.getIdSubcategoria(), subcategoria.getNombre(), categoriaConverter.entityToModel(subcategoria.getCategoria()));
	}
	public Subcategoria modelToEntity(SubcategoriaModel subcategoriaModel) {
		return new Subcategoria(subcategoriaModel.getIdSubcategoria(),subcategoriaModel.getNombre(), categoriaConverter.modelToEntity(subcategoriaModel.getCategoria()));
	}

}
