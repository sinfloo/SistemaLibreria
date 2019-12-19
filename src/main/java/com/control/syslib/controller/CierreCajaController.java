package com.control.syslib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.syslib.entity.CierreCaja;
import com.control.syslib.service.CierreCajaService;
import com.google.gson.Gson;

@Controller
public class CierreCajaController {
	@Autowired
	private CierreCajaService ccss;
	Gson g = new Gson();
	
	@GetMapping("/cierre_caja")
	public String redirect(Model model) {		
		return "caja";
	}
	
	@RequestMapping(value="/lista_cierre_caja", method=RequestMethod.POST)
	public @ResponseBody String list_cierre(HttpServletRequest request) {
	return g.toJson(ccss.readAll());
	}
	
	@GetMapping("/agregar_cierre")
	public String redir(Model model) {		
		return "caja_add";
	}
	
	@GetMapping("/quieroMontoFechas")
	public @ResponseBody String lista_monto_ci(HttpServletRequest request) {
		return g.toJson(ccss.read_monto_cierre(
				request.getParameter("fecha_init"),
				request.getParameter("fecha_fin")
				));

	}
	
	@PostMapping("/quieroCerrar")
	public @ResponseBody String guardar_cierre(HttpServletRequest request) {
		double monto = Double.parseDouble(request.getParameter("monto"));
		String fec_inicio = request.getParameter("f1");
		String fec_fin= request.getParameter("f2");
		int est = Integer.parseInt(request.getParameter("estado"));
	    int us = Integer.parseInt(request.getParameter("us"));
		ccss.create(new CierreCaja(monto, fec_inicio, fec_fin, est, us));
		
		return "1";

	}
}
