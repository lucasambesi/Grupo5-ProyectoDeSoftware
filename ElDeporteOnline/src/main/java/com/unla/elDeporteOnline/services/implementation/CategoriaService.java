package com.unla.elDeporteOnline.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.elDeporteOnline.converters.CategoriaConverter;
import com.unla.elDeporteOnline.entities.Categoria;
import com.unla.elDeporteOnline.models.CategoriaModel;
import com.unla.elDeporteOnline.repositories.ICategoriaRepository;
import com.unla.elDeporteOnline.services.ICategoriaService;


@Service("categoriaService")
public class CategoriaService implements ICategoriaService{
	
	@Autowired
	@Qualifier("categoriaRepository")
	private ICategoriaRepository categoriaRepository;

	@Autowired
	@Qualifier("categoriaConverter")
	private CategoriaConverter categoriaConverter;

	@Override
	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public CategoriaModel insert(CategoriaModel categoriaModel) {
		Categoria categoria = categoriaRepository.save(categoriaConverter.modelToEntity(categoriaModel));
		return categoriaConverter.entityToModel(categoria);
	}

	@Override
	public CategoriaModel update(CategoriaModel categoriaModel) {
		Categoria categoria = categoriaRepository.save(categoriaConverter.modelToEntity(categoriaModel));
		return categoriaConverter.entityToModel(categoria);
	}

	@Override
	public boolean remove(long idCategoria) {
		try {
			categoriaRepository.deleteById(idCategoria);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public CategoriaModel findByIdCategoria(long idCategoria) {
		return categoriaConverter.entityToModel(categoriaRepository.findByIdCategoria(idCategoria));
	}

	@Override
	public List<CategoriaModel> getAlls() {
		List<CategoriaModel> models = new ArrayList<CategoriaModel>();
		for (Categoria categoria : categoriaRepository.findAll()) {
			models.add(categoriaConverter.entityToModel(categoria));
		}
		return models;
	}

}