package com.unla.elDeporteOnline.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.elDeporteOnline.entities.Producto;
import com.unla.elDeporteOnline.helpers.ViewRouteHelpers;
import com.unla.elDeporteOnline.models.CategoriaModel;
import com.unla.elDeporteOnline.models.ProductoModel;
import com.unla.elDeporteOnline.models.SubcategoriaModel;
import com.unla.elDeporteOnline.services.ICategoriaService;
import com.unla.elDeporteOnline.services.IProductoService;
import com.unla.elDeporteOnline.services.ISubcategoriaService;



@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("categoriaService")
	private ICategoriaService categoriaService;
	
	@Autowired
	@Qualifier("subcategoriaService")
	private ISubcategoriaService subcategoriaService;

	// GET Example: SERVER/index
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.INDEX);
		/*mav.addObject("productos", productoService.getAll());
		mav.addObject("categorias", categoriaService.getAll());
		mav.addObject("subcategorias", subcategoriaService.getAll());*/
		
		List<ProductoModel> productos = productoService.findDestacados();
		if(productos!= null){
			mav.addObject("productos", productos);
		}
		
		List<CategoriaModel> categorias = categoriaService.getAlls();
		if (categorias != null) {
			mav.addObject("categorias", categorias);
		}
		
		List<SubcategoriaModel> subCategorias = subcategoriaService.getAlls();
		if (subCategorias != null) {
			mav.addObject("subcategorias", subCategorias);
		}

		return mav;
	}
	
	@GetMapping("/allproductos")
	public ModelAndView allproductos() {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.ALLPRODUCTOS);
		mav.addObject("productos", productoService.getAlls());
		/*mav.addObject("categorias", categoriaService.getAll());
		mav.addObject("subcategorias", subcategoriaService.getAll());*/
		
		
		List<CategoriaModel> categorias = categoriaService.getAlls();
		if (categorias != null) {
			mav.addObject("categorias", categorias);
		}
		
		List<SubcategoriaModel> subCategorias = subcategoriaService.getAlls();
		if (subCategorias != null) {
			mav.addObject("subcategorias", subCategorias);
		}

		return mav;
	}

	@GetMapping("/empleado")
	public ModelAndView emp() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelpers.EMP);

		return modelAndView;
	}
	
	@GetMapping("/formulariocontacto")
	public ModelAndView formcont() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelpers.FORMCONT);

		return modelAndView;
	}
	
	@GetMapping("/nosotros")
	public ModelAndView institucional() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelpers.INSTITUCIONAL);

		return modelAndView;
	}
	
		
	// GET Example: SERVER/hello?name=someName
	@GetMapping("/hello")
	public ModelAndView helloParams1(
			@RequestParam(name = "name", required = false, defaultValue = "null") String name) {
		ModelAndView maV = new ModelAndView(ViewRouteHelpers.HELLO);
		maV.addObject("name", name);
		return maV;
	}

	// GET Example: SERVER/hello/someName
	@GetMapping("/hello/{name}")
	public ModelAndView helloParams2(@PathVariable("name") String name) {
		ModelAndView maV = new ModelAndView(ViewRouteHelpers.HELLO);
		maV.addObject("name", name);
		return maV;
	}

	@GetMapping("/")
	public RedirectView redirectToHomeIndex() {
		return new RedirectView(ViewRouteHelpers.ROUTE);
	}
	
    @RequestMapping(value = "productoSearch", method = RequestMethod.GET)
	public ModelAndView search(@Param("productoSearch") String productoSearch) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.INDEX);

		List<ProductoModel> productos = productoService.searchByProducto(productoSearch);
		if(productos!= null){
			mAV.addObject("productos", productos);
		}

		return mAV;
	}
    
	
}
