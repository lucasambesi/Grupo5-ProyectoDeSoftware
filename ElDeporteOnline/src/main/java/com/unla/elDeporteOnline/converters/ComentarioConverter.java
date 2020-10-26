package com.unla.elDeporteOnline.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.elDeporteOnline.entities.Comentario;
import com.unla.elDeporteOnline.models.ComentarioModel;


@Component("comentarioConverter")
public class ComentarioConverter {
	
	@Autowired
	@Qualifier("checkoutConverter")
	private CheckoutConverter checkoutConverter;
	
	public ComentarioModel entityToModel(Comentario comentario) {
		return new ComentarioModel(comentario.getId(), comentario.getComentario(), comentario.getFechaComentario(), checkoutConverter.entityToModel(comentario.getCheckout()), comentario.getValoracion());
	}
	
	public Comentario modelToEntity(ComentarioModel model) {
		return new Comentario(model.getId(), model.getComentario(), model.getFechaComentario(), checkoutConverter.modelToEntity(model.getCheckout()), model.getValoracion());
	}
}