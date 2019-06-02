package com.control.syslib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.syslib.entity.Articulos;
import com.control.syslib.service.ArticuloService;
import com.google.gson.Gson;


@Controller
public class ArticuloController {
	@Autowired
	private ArticuloService as;
	Gson g = new Gson();
	
	@GetMapping("/lista_articulo")
	public String lista(Model model) {		
		return "articulo";
	}
	
	@RequestMapping(value="/lista_todos_articulos", method=RequestMethod.POST)
	public @ResponseBody String vertodo_ar(HttpServletRequest request) {
	return g.toJson(as.readAll());
	}
	@GetMapping("/agregar_articulo")
	public String agregar_art(Model model) {	
		model.addAttribute("departamento",as.readdepartamentos());
		return "articulo_add";
	}
	
	@RequestMapping(value="/guardar_articulo_nuevo", method=RequestMethod.POST)
	public @ResponseBody String save_articulo_new(HttpServletRequest request){
		System.out.println("dentro del controller de articulo");
		String nom = request.getParameter("nom_art");
		String des = request.getParameter("des_art");
		int est = Integer.parseInt(request.getParameter("est_art"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int stock_min = Integer.parseInt(request.getParameter("stock_minimo"));
		double precio_compra = Double.parseDouble(request.getParameter("precio_compra"));
		double precio_venta= Double.parseDouble(request.getParameter("precio_venta"));
		int idd = Integer.parseInt(request.getParameter("idd"));
				
		System.out.println(nom);
		System.out.println(des);
		System.out.println(est);
		System.out.println(stock);
		System.out.println(stock_min);
		System.out.println(precio_compra);
		System.out.println(precio_venta);
		System.out.println(idd);

		as.create(new Articulos(
				nom, des, est, stock, stock_min, precio_compra, precio_venta,idd));
		
		return "1";
	}
}
