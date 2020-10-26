package com.unla.elDeporteOnline.controllers;

import java.io.File;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import com.unla.elDeporteOnline.models.CheckoutModel;
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
	
	/*@PostMapping("/create")
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
	}*/
	
	@PostMapping("/create")
	public RedirectView agregar(@Valid @ModelAttribute("producto") ProductoModel productoModel,
			@RequestParam(name = "file", required = false) MultipartFile foto, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);

		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(Paths.get("")
        .toAbsolutePath()
        .toString());
		stringBuilder.append(File.separator);		
		stringBuilder.append("src");
		stringBuilder.append(File.separator);
		stringBuilder.append("main");
		stringBuilder.append(File.separator);
		stringBuilder.append("resources");
		stringBuilder.append(File.separator);
		stringBuilder.append("static");
		stringBuilder.append(File.separator);
		stringBuilder.append("images");
		stringBuilder.append(File.separator);
		stringBuilder.append(foto.getOriginalFilename());

		byte[] bytes = null;
		try {
			bytes = foto.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Path path = Paths.get(stringBuilder.toString());
		try {
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		productoModel.setUrlImagen("/images/" + foto.getOriginalFilename());
		/*// TODO Codigo SKU
		productoModel.setSubCategoria(subcategoriaService.listarId(productoModel.getSubcategoria().getIdSubcategoria()));
		ProductoModel pM=	productoService.insertOrUpdate(productoModel);
		if(pM!=null) {	
		return "redirect:/productos/newAtributo/" + pM.getId();
		}else {
		redirect.addAttribute("message", "error al agregar el producto");	
		return	"redirect:/productos/newProducto/"+productoModel.getSubCategoria().getId();
		
		}*/
		productoModel = productoService.insert(productoModel);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}

//	 @GetMapping("/update/{id}")
//	public ModelAndView update(@PathVariable("id") int id) {
//		ModelAndView mav = new ModelAndView(ViewRouteHelpers.PRODUCTO_NEW);
//		mav.addObject("producto", productoService.findByIdProducto(id));		
//		return mav;		
//	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
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
	
	@GetMapping("/pedido/{id}")
	public ModelAndView pedidoProducto(@PathVariable("id") long idProducto) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PEDIDOPRODUCTO);
		ProductoModel pedido = productoService.findByIdProducto(idProducto);
		mAV.addObject("producto", pedido);
		
		List<ProductoModel> productos = productoService.findDestacados();
		if(productos!= null){
			mAV.addObject("productos", productos);
		}
		
		//List<ProductoModel> relacionados = productoService.findBySubCategoria(articulo.getSubCategoriaModel().getId());
		
		/*List<ProductoModel> relacionados = productoService.findRelacionados(articulo.getId(),articulo.getSubCategoria().getId());
		mAV.addObject("relacionados", relacionados);
		ComentarioModel comentarioModel = new ComentarioModel();
		mAV.addObject("comentario", comentarioModel);

		List<ComentarioModel> comentarios = comentarioService.getByProducto(id);
		mAV.addObject("comentarios", comentarios);*/

		return mAV;
	}
	
	@GetMapping("/pedido/{id}/checkout")
	public ModelAndView productoCompra(@PathVariable("id") long idProducto) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.CHECKOUTPRODUCTO);

		int codigo=0;
		ProductoModel pedido = productoService.findByIdProducto(idProducto);
		mAV.addObject("codigo", codigo);
		mAV.addObject("prodId", pedido.getIdProducto());
		
		mAV.addObject("producto", pedido);
		CheckoutModel checkout = new CheckoutModel();
		//EmbalajeModel embalaje = new EmbalajeModel();
		//pedido.setEmbalaje(embalaje);
		mAV.addObject("checkout", checkout);

		//List<EmbalajeModel> embalajes = embalajeService.getAll();

		//mAV.addObject("embalajes", embalajes);

		return mAV;
	}
	
	@GetMapping("/allproductos")
	public String allproductos(Model model) {
		model.addAttribute("productos", productoService.getAll());
		return "allproductos";
	}
	
	
}
