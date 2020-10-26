package com.unla.elDeporteOnline.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.elDeporteOnline.converters.ComentarioConverter;
import com.unla.elDeporteOnline.entities.Comentario;
import com.unla.elDeporteOnline.models.ComentarioModel;
import com.unla.elDeporteOnline.repositories.IComentarioRepository;
import com.unla.elDeporteOnline.services.IComentarioService;


@Service("comentarioService")
public class ComentarioService implements IComentarioService {
	
	@Autowired
	private IComentarioRepository comentarioRepository;
	
	@Autowired
	@Qualifier("comentarioConverter")
	private ComentarioConverter comentarioConverter;

	@Override
	public List<ComentarioModel> getAll() {
		List<ComentarioModel> comentarios = new ArrayList<ComentarioModel>();
		List<Comentario> pe= comentarioRepository.findAll();
		for(Comentario p: pe) {
			comentarios.add(comentarioConverter.entityToModel(p));
		}
		return comentarios;
	}

	@Override
	public ComentarioModel insertOrUpdate(ComentarioModel comentarioModel) {
		Comentario comentario= comentarioRepository.save(comentarioConverter.modelToEntity(comentarioModel));
		
		return comentarioConverter.entityToModel(comentario);
	}

	@Override
	public ComentarioModel listarId(int id) {
		return comentarioConverter.entityToModel(comentarioRepository.findById(id));
		
	}

	@Override
	public String delete(int id) {
        comentarioRepository.deleteById(id);	
        return "comentario eliminado";
    }


	@Override
	public List<ComentarioModel> getByProducto(int id) {
		List <ComentarioModel> cM = new ArrayList<ComentarioModel>();
		List<Comentario> c = comentarioRepository.findByProducto(id);
		for(Comentario comentario : c) {
			cM.add(comentarioConverter.entityToModel(comentario));
		}
		
		return cM;
	}

}
