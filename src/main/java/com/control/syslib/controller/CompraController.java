package com.control.syslib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.syslib.entity.Compra;
import com.control.syslib.entity.Venta;
import com.control.syslib.service.CompraService;
import com.google.gson.Gson;
@Controller
public class CompraController {
	
	@Autowired
	private CompraService csc;
	Gson g = new Gson();
	
	@RequestMapping(value="/ver_compra", method=RequestMethod.GET)
	public String lista(Model model) {		
		return "compras";
	}
	
	@RequestMapping(value="/lista_todas_compras", method=RequestMethod.POST)
	public @ResponseBody String vertodo_compras(HttpServletRequest request) {
	return g.toJson(csc.readAll());
	}
	
	@RequestMapping(value="/agregar_compra", method=RequestMethod.GET)
	public String nueva_compra() {
		return "add_compra";
	}
	
//	Este método nos permitirá obtener el valor del id
	@RequestMapping(value="/registrar_compra_nueva", method=RequestMethod.POST)
	public @ResponseBody String save(HttpServletRequest request) {
		String fechaa=request.getParameter("fecha_compra");
		String tipo=request.getParameter("tipo");
		int estado=Integer.parseInt(request.getParameter("estado_compra"));
		int idu=Integer.parseInt(request.getParameter("usu"));
		int idp=Integer.parseInt(request.getParameter("idpp"));
		double mont = Double.parseDouble(request.getParameter("monto_total"));
		System.out.println("dentro del controller registrar/nuev/venta "+idp+" "+idu);
		return g.toJson(csc.create(new Compra(fechaa,mont,tipo,estado,idu,idp)));
	}
	
}
