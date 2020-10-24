package com.unla.elDeporteOnline.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.elDeporteOnline.services.ICategoriaService;
import com.unla.elDeporteOnline.services.IMonedaService;
import com.unla.elDeporteOnline.services.IProductoService;
import com.unla.elDeporteOnline.services.ISubcategoriaService;
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
	@Qualifier("subcategoriaService")
	private ISubcategoriaService subcategoriaService;
	
	@Autowired
	@Qualifier("monedaService")
	private IMonedaService monedaService;
	
		
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
		mav.addObject("subcategoria", subcategoriaService.getAlls());
		mav.addObject("moneda", monedaService.getAlls());
		return mav;
	}
	
	/*
	@PostMapping("/create")	
	public RedirectView agregar(@ModelAttribute("producto") ProductoModel productoModel){		
		productoModel = productoService.insert(productoModel);		
		//productoModel.setSubcategoria(subcategoriaService.findByIdSubcategoria(productoModel.getSubcategoria().getIdSubcategoria())); 
		//productoModel.setMoneda(monedaService.findByIdMoneda(productoModel.getMoneda().getIdMoneda()));
		
		//productoModel = productoService.update(productoModel);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}*/	
	
	@PostMapping("/create")
	public RedirectView agregar (@ModelAttribute("producto") @RequestParam(name = "file", required = false) MultipartFile foto, ProductoModel productoModel,
			RedirectAttributes flash) {
		if(!foto.isEmpty()) {
			String ruta = "C://Temp//uploads";
			
		try {
			
			byte[] bytes = foto.getBytes();
			Path rutaAbsoluta = Paths.get(ruta + "//" + foto.getOriginalFilename());
			Files.write(rutaAbsoluta, bytes);
			productoModel.setFoto(foto.getOriginalFilename());
		
		}catch(Exception e) {
			
		}
		
		productoModel = productoService.insert(productoModel);
		flash.addFlashAttribute("success", "Producto guardado");
		}
		
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
		mav.addObject("subcategoria", subcategoriaService.getAlls());
		mav.addObject("moneda", monedaService.getAlls());
		return mav;
	}
	
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		productoService.remove(id);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}	
	
	
	
	@GetMapping("/allproductos")
	public String allproductos(Model model) {
		model.addAttribute("productos", productoService.getAll());
		return "allproductos";
	}
	
	
}
