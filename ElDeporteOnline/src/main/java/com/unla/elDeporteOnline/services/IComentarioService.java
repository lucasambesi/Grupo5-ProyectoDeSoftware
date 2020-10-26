package com.unla.elDeporteOnline.services;

import java.util.List;

import com.unla.elDeporteOnline.models.ComentarioModel;


public interface IComentarioService {
	
	public List<ComentarioModel> getAll();

	public ComentarioModel insertOrUpdate(ComentarioModel comentario);

	public ComentarioModel listarId(int id);

    public String delete(int id);
    
    public List<ComentarioModel> getByProducto(int id);
}