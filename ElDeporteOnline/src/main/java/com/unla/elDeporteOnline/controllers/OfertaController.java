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
import com.unla.elDeporteOnline.models.OfertaModel;
import com.unla.elDeporteOnline.services.IOfertaService;

@Controller
@RequestMapping("/oferta")

public class OfertaController {

	@Autowired
	@Qualifier("ofertaService")
	private IOfertaService ofertaService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.OFERTA_INDEX);
		mAV.addObject("oferta", ofertaService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.OFERTA_NEW);
		mAV.addObject("oferta", new OfertaModel());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("oferta") OfertaModel ofertaModel) {
		ofertaService.insert(ofertaModel);
		return new RedirectView(ViewRouteHelpers.OFERTA_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idOferta) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.OFERTA_UPDATE);
		mAV.addObject("oferta", ofertaService.findByIdOferta(idOferta));
		return mAV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("oferta") OfertaModel ofertaModel) {
		ofertaService.update(ofertaModel);
		return new RedirectView(ViewRouteHelpers.OFERTA_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idOferta) {
		ofertaService.remove(idOferta);
		return new RedirectView(ViewRouteHelpers.OFERTA_ROOT);
	}

	@PostMapping("/back")
	public RedirectView back() {

		return new RedirectView(ViewRouteHelpers.OFERTA_ROOT);
	}
}