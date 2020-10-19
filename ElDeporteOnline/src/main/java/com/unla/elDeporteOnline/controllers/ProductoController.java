package com.unla.elDeporteOnline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.unla.elDeporteOnline.services.ICategoriaService;
//import com.unla.elDeporteOnline.services.IMonedaService;
import com.unla.elDeporteOnline.services.IProductoService;
import com.unla.elDeporteOnline.entities.Producto;
import com.unla.elDeporteOnline.helpers.ViewRouteHelpers;
import com.unla.elDeporteOnline.models.CategoriaModel;
import com.unla.elDeporteOnline.models.MonedaModel;
import com.unla.elDeporteOnline.models.ProductoModel;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("categoriaService")
	private ICategoriaService categoriaService;
	
	@Autowired
	@Qualifier("monedaService")
	//private IMonedaService monedaService;
	
		
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.PRODUCTO_INDEX);
		mav.addObject("producto", new Producto());
		mav.addObject("productos", productoService.getAll());
		
		return mav;
	}		
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("producto") ProductoModel productoModel) {
		productoService.update(productoModel);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.PRODUCTO_NEW);
		mav.addObject("producto", new ProductoModel());
		mav.addObject("categoria", new CategoriaModel());
		mav.addObject("moneda", new MonedaModel());
		return mav;
	}
	
	@PostMapping("/create")	
	public RedirectView agregar(@ModelAttribute("producto") ProductoModel productoModel){		
		productoModel = productoService.insert(productoModel);		
		productoModel.setCategoria(categoriaService.findByIdCategoria(productoModel.getCategoria().getIdCategoria())); 
		//productoModel.setMoneda(monedaService.findByIdMoneda(productoModel.getMoneda().getIdMoneda()));
		
		productoModel = productoService.update(productoModel);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}	

//	 @GetMapping("/update/{id}")
//	public ModelAndView update(@PathVariable("id") int id) {
//		ModelAndView mav = new ModelAndView(ViewRouteHelpers.PRODUCTO_NEW);
//		mav.addObject("producto", productoService.findByIdProducto(id));		
//		return mav;		
//	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.PRODUCTO_UPDATE);
		mav.addObject("producto", productoService.findByIdProducto(id));		
		return mav;
	}
	
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		productoService.remove(id);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}	
	
	
}
