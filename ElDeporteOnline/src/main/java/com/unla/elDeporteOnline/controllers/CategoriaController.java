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
import com.unla.elDeporteOnline.models.CategoriaModel;
import com.unla.elDeporteOnline.services.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	@Qualifier("categoriaService")
	private ICategoriaService categoriaService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.CATEGORIA_INDEX);
		mAV.addObject("categoria", categoriaService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.CATEGORIA_NEW);
		mAV.addObject("categoria", new CategoriaModel());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("categoria") CategoriaModel categoriaModel) {
		categoriaService.insert(categoriaModel);
		return new RedirectView(ViewRouteHelpers.CATEGORIA_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idCategoria) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.CATEGORIA_UPDATE);
		mAV.addObject("categoria", categoriaService.findByIdCategoria(idCategoria));
		return mAV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("categoria") CategoriaModel categoriaModel) {
		categoriaService.update(categoriaModel);
		return new RedirectView(ViewRouteHelpers.CATEGORIA_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idCategoria) {
		categoriaService.remove(idCategoria);
		return new RedirectView(ViewRouteHelpers.CATEGORIA_ROOT);
	}

	@PostMapping("/back")
	public RedirectView back() {

		return new RedirectView(ViewRouteHelpers.CATEGORIA_ROOT);
	}
}