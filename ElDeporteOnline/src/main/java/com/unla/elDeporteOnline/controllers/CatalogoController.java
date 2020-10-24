package com.unla.elDeporteOnline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.elDeporteOnline.helpers.ViewRouteHelpers;

@Controller
@RequestMapping("/catalogo")
public class CatalogoController {
	
	@GetMapping("")
	public ModelAndView index() {
		
		ModelAndView mav = new ModelAndView(ViewRouteHelpers.CATALOGO_INDEX);
		
		
		return mav;
	}
}
