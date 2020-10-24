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

import com.unla.elDeporteOnline.entities.Categoria;
import com.unla.elDeporteOnline.entities.Subcategoria;
import com.unla.elDeporteOnline.helpers.ViewRouteHelpers;
import com.unla.elDeporteOnline.models.CategoriaModel;
import com.unla.elDeporteOnline.models.SubcategoriaModel;
import com.unla.elDeporteOnline.services.ICategoriaService;
import com.unla.elDeporteOnline.services.ISubcategoriaService;


@Controller
@RequestMapping("/subcategoria")
public class SubcategoriaController {
	
	@Autowired
	@Qualifier("subcategoriaService")
	private ISubcategoriaService subcategoriaService;
	
	@Autowired
	@Qualifier("categoriaService")
	private ICategoriaService categoriaService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SUBCATEGORIA_INDEX);
		mAV.addObject("subcategoria", new Subcategoria());
		mAV.addObject("subcategorias", subcategoriaService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SUBCATEGORIA_NEW);
		mAV.addObject("subcategoria", new SubcategoriaModel());
		mAV.addObject("categoria", categoriaService.getAlls());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("subcategoria") SubcategoriaModel subcategoriaModel) {
		subcategoriaService.insert(subcategoriaModel);
		return new RedirectView(ViewRouteHelpers.SUBCATEGORIA_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idSubcategoria) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SUBCATEGORIA_UPDATE);
		mAV.addObject("subcategoria", subcategoriaService.findByIdSubcategoria(idSubcategoria));
		return mAV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("subcategoria") SubcategoriaModel subcategoriaModel) {
		subcategoriaService.update(subcategoriaModel);
		return new RedirectView(ViewRouteHelpers.SUBCATEGORIA_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idSubcategoria) {
		subcategoriaService.remove(idSubcategoria);
		return new RedirectView(ViewRouteHelpers.SUBCATEGORIA_ROOT);
	}

	@PostMapping("/back")
	public RedirectView back() {

		return new RedirectView(ViewRouteHelpers.SUBCATEGORIA_ROOT);
	}

}
