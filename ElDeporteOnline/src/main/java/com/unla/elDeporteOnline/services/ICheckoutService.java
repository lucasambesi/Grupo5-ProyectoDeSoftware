package com.unla.elDeporteOnline.services;

import java.util.List;

import com.unla.elDeporteOnline.models.CheckoutModel;


public interface ICheckoutService {

	  public List<CheckoutModel> getAll();

		public CheckoutModel insertOrUpdate(CheckoutModel checkoutModel);

		public CheckoutModel listarId(int id);

		public String delete(int id);


		public List<CheckoutModel> getByProducto(int id); 
	 
	}
