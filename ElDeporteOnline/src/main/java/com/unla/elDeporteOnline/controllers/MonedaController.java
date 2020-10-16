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

import com.unla.elDeporteOnline.entities.Moneda;
import com.unla.elDeporteOnline.helpers.ViewRouteHelpers;
import com.unla.elDeporteOnline.models.MonedaModel;
import com.unla.elDeporteOnline.services.IMonedaService;


@Controller
@RequestMapping("/moneda")
public class MonedaController {
	@Autowired
	@Qualifier("monedaService")
	private IMonedaService monedaService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.MONEDA_INDEX);
		mav.addObject("moneda", new Moneda());
		mav.addObject("monedas", monedaService.getAll());		
		return mav;
	}		
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("moneda") MonedaModel monedaModel) {
		monedaService.update(monedaModel);
		return new RedirectView(ViewRouteHelpers.MONEDA_ROOT);
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.MONEDA_NEW);
		mav.addObject("moneda", new MonedaModel());
		return mav;
	}
	
	@PostMapping("/create")	
	public RedirectView agregar(@ModelAttribute("moneda") MonedaModel monedaModel){		
		monedaModel = monedaService.insert(monedaModel);		
		
		return new RedirectView(ViewRouteHelpers.MONEDA_ROOT);
	}	

//	 @GetMapping("/update/{id}")
//	public ModelAndView update(@PathVariable("id") int id) {
//		ModelAndView mav = new ModelAndView(ViewRouteHelpers.Moneda_NEW);
//		mav.addObject("Moneda", MonedaService.findByIdMoneda(id));		
//		return mav;		
//	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int idMoneda) {
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.MONEDA_UPDATE);
		mav.addObject("moneda", monedaService.findByIdMoneda(idMoneda));		
		return mav;
	}
	
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		monedaService.remove(id);
		return new RedirectView(ViewRouteHelpers.MONEDA_ROOT);
	}	
}
