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

import com.unla.elDeporteOnline.helpers.ViewRouteHelpers;
import com.unla.elDeporteOnline.entities.Sku;
import com.unla.elDeporteOnline.models.SkuModel;
import com.unla.elDeporteOnline.models.SubcategoriaModel;
import com.unla.elDeporteOnline.models.CategoriaModel;
import com.unla.elDeporteOnline.models.ProductoModel;
import com.unla.elDeporteOnline.services.ISkuService;
import com.unla.elDeporteOnline.services.IProductoService;

@Controller
@RequestMapping("/sku")
public class SkuController {

	@Autowired
	@Qualifier("skuService")
	private ISkuService skuService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.SKU_INDEX);
		mav.addObject("sku", new Sku());
		mav.addObject("skus", skuService.getAll());		
		return mav;
	}		
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("sku") SkuModel skuModel) {
		skuService.update(skuModel);
		return new RedirectView(ViewRouteHelpers.SKU_ROOT);
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.SKU_NEW);
		mav.addObject("sku", new SkuModel());
		mav.addObject("producto", productoService.getAlls());
		return mav;
	}
	
	@PostMapping("/create")	
	public RedirectView create(@ModelAttribute("sku") SkuModel skuModel){
		skuService.insert(skuModel);
		/*skuModel = skuService.insert(skuModel);		
		skuModel.setProducto(productoService.findByIdProducto(skuModel.getProducto().getIdProducto()));
		skuModel = skuService.update(skuModel);*/
		return new RedirectView(ViewRouteHelpers.SKU_ROOT);
	}	
	

//	 @GetMapping("/update/{id}")
//	public ModelAndView update(@PathVariable("id") int id) {
//		ModelAndView mav = new ModelAndView(ViewRouteHelpers.SKU_NEW);
//		mav.addObject("Sku", SkuService.findByIdSku(id));		
//		return mav;		
//	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idSku) {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.SKU_UPDATE);
		mav.addObject("sku", skuService.findByIdSku(idSku));		
		return mav;
	}
	
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		skuService.remove(id);
		return new RedirectView(ViewRouteHelpers.SKU_ROOT);
	}
}
