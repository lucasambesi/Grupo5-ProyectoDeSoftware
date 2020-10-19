package com.unla.elDeporteOnline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.elDeporteOnline.helpers.ViewRouteHelpers;

@Controller
@RequestMapping("/")
public class HomeController {

	// GET Example: SERVER/index
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelpers.INDEX);

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
}
