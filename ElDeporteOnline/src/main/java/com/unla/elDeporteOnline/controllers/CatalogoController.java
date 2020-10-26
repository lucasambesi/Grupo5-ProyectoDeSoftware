package com.unla.elDeporteOnline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.elDeporteOnline.helpers.ViewRouteHelpers;
import com.unla.elDeporteOnline.services.ICategoriaService;
import com.unla.elDeporteOnline.services.IProductoService;
import com.unla.elDeporteOnline.services.ISubcategoriaService;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("categoriaService")
	private ICategoriaService categoriaService;
	
	@Autowired
	@Qualifier("subcategoriaService")
	private ISubcategoriaService subcategoriaService;
	
	@GetMapping("")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.CATALOGO_INDEX);
		mav.addObject("productos", productoService.getAll());
		mav.addObject("categorias", categoriaService.getAll());
		mav.addObject("subcategorias", subcategoriaService.getAll());
		
		return mav;
	}
}
