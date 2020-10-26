package com.unla.elDeporteOnline.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.elDeporteOnline.entities.Checkout;


@Repository("checkoutRepository")
public interface ICheckoutRepository extends  JpaRepository<Checkout, Serializable>{
    
    public abstract Checkout findById(int id);
    
    @Query(nativeQuery=true,value="Select * from pedido where producto_id=(:id)")
	public List<Checkout> findByProducto(int id);
}