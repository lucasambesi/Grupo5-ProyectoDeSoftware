package com.unla.elDeporteOnline.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.elDeporteOnline.converters.CheckoutConverter;
import com.unla.elDeporteOnline.entities.Checkout;
import com.unla.elDeporteOnline.models.CheckoutModel;
import com.unla.elDeporteOnline.repositories.ICheckoutRepository;
import com.unla.elDeporteOnline.services.ICheckoutService;


@Service("checkoutService")
public class CheckoutService implements ICheckoutService {
	
	@Autowired
	private ICheckoutRepository checkoutRepository;
	
	@Autowired
	@Qualifier("checkoutConverter")
	private CheckoutConverter checkoutConverter;

	@Override
	public List<CheckoutModel> getAll() {
		List<CheckoutModel> checkouts = new ArrayList<CheckoutModel>();
		List<Checkout> ch= checkoutRepository.findAll();
		for(Checkout c: ch) {
			checkouts.add(checkoutConverter.entityToModel(c));
		}
		return checkouts;
	}

	@Override
	public CheckoutModel insertOrUpdate(CheckoutModel checkoutModel) {
		Checkout checkout= checkoutRepository.save(checkoutConverter.modelToEntity(checkoutModel));
		
		return checkoutConverter.entityToModel(checkout);
	}

	@Override
	public CheckoutModel listarId(int id) {
		Checkout checkout = checkoutRepository.findById(id);
		if(checkout == null){
			return null;
		}
		return checkoutConverter.entityToModel(checkout);
		
	}

	@Override
	public String delete(int id) {
		checkoutRepository.deleteById(id);	
		return "pedido eliminado";}


	@Override
	public List<CheckoutModel> getByProducto(int id) {
		List <CheckoutModel> cM = new ArrayList<CheckoutModel>();
		List<Checkout> c = checkoutRepository.findByProducto(id);
		for(Checkout checkout : c) {
			cM.add(checkoutConverter.entityToModel(checkout));
		}
		
		return cM;
	}

}
