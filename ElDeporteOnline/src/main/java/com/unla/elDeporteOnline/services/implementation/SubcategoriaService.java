package com.unla.elDeporteOnline.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.elDeporteOnline.converters.SubcategoriaConverter;
import com.unla.elDeporteOnline.entities.Subcategoria;
import com.unla.elDeporteOnline.models.SubcategoriaModel;
import com.unla.elDeporteOnline.repositories.ISubcategoriaRepository;
import com.unla.elDeporteOnline.services.ISubcategoriaService;

@Service("subcategoriaService")
public class SubcategoriaService implements ISubcategoriaService{

	@Autowired
	@Qualifier("subcategoriaRepository")
	private ISubcategoriaRepository subcategoriaRepository;

	@Autowired
	@Qualifier("subcategoriaConverter")
	private SubcategoriaConverter subcategoriaConverter;

	@Override
	public List<Subcategoria> getAll() {
		return subcategoriaRepository.findAll();
	}

	@Override
	public SubcategoriaModel insert(SubcategoriaModel subcategoriaModel) {
		Subcategoria subcategoria = subcategoriaRepository.save(subcategoriaConverter.modelToEntity(subcategoriaModel));
		return subcategoriaConverter.entityToModel(subcategoria);
	}

	@Override
	public SubcategoriaModel update(SubcategoriaModel subcategoriaModel) {
		Subcategoria subcategoria = subcategoriaRepository.save(subcategoriaConverter.modelToEntity(subcategoriaModel));
		return subcategoriaConverter.entityToModel(subcategoria);
	}

	@Override
	public boolean remove(long idSubcategoria) {
		try {
			subcategoriaRepository.deleteById(idSubcategoria);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public SubcategoriaModel findByIdSubcategoria(long idSubcategoria) {
		return subcategoriaConverter.entityToModel(subcategoriaRepository.findByIdSubcategoria(idSubcategoria));
	}

	@Override
	public List<SubcategoriaModel> getAlls() {
		List<SubcategoriaModel> models = new ArrayList<SubcategoriaModel>();
		for (Subcategoria subcategoria : subcategoriaRepository.findAll()) {
			models.add(subcategoriaConverter.entityToModel(subcategoria));
		}
		return models;
	}
}
