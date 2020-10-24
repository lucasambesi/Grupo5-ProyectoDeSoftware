package com.unla.elDeporteOnline.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.elDeporteOnline.entities.Producto;
import com.unla.elDeporteOnline.helpers.ViewRouteHelpers;
import com.unla.elDeporteOnline.models.ProductoModel;
import com.unla.elDeporteOnline.services.IProductoService;



@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	List<ProductoModel> lstProductos = new ArrayList<>(); 
	
	@GetMapping("")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.CARRITO_INDEX);
		
		
		return mav;
	}
	
	@PostMapping("/agregarCarrito/{id}")
	public RedirectView agregarCarrito(@PathVariable("id") long id) {
		System.out.println("Llegooooo");
		ProductoModel producto = productoService.findByIdProducto(id);
		lstProductos.add(producto);
		return new RedirectView(ViewRouteHelpers.ROUTE_INDEX);
		
	}
}
