package com.unla.elDeporteOnline.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.elDeporteOnline.entities.Comentario;


@Repository("comentarioRepository")
public interface IComentarioRepository extends  JpaRepository<Comentario, Serializable> {
	
	public abstract Comentario findById(int id);
	
	@Query(nativeQuery=true,value="select * from comentario c where c.pedido_id in (select pedido_id from pedido p where p.producto_id = (:id))")
	public List<Comentario> findByProducto(int id);
}