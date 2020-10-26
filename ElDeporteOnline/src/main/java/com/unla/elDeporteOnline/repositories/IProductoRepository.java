package com.unla.elDeporteOnline.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.elDeporteOnline.entities.Producto;

@Repository("productoRepository")
public interface IProductoRepository extends JpaRepository<Producto, Serializable> {
	
	public abstract Producto findByIdProducto(long idProducto);

	public abstract Producto findByNombre(String nombre);
	
	public  List<Producto> findBydescripcionCortaContainingIgnoreCase(String producto);
	
	@Query(nativeQuery=true,value="select * from producto where activo = true")
	public List<Producto> findDestacados();

}
