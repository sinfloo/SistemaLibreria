package com.control.syslib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.syslib.entity.Proveedor;
import com.control.syslib.entity.Usuario;
import com.control.syslib.service.ProveedorService;
import com.google.gson.Gson;

@Controller
public class ProveedorController {

	
	@Autowired
	private ProveedorService up;
	Gson g = new Gson();
	
	@GetMapping("/lista_proveedor")
	public String lista(Model model) {		
		return "proveedor";
	}
	@RequestMapping(value="/ListarTodo_Proveedores_Pro", method=RequestMethod.POST)
	public @ResponseBody String vertodo_u(HttpServletRequest request) {
	return g.toJson(up.readAll());
	}
	
	@GetMapping("/agregar_pro")
	public String add_pro(Model model) {
		return "proveedor_add";
	}
	
	@GetMapping("/validar_prov")
	public String validar_prov(Model model) {
		return "validar_proveedor";
	}
	
	@RequestMapping(value="/guardar_proveedor_nuevo", method=RequestMethod.POST)
	public @ResponseBody String create_us(HttpServletRequest request) {
		String respuesta="";
		try {
			String tipo=request.getParameter("tipo");
			String razonso=request.getParameter("razonso");
			double ruc=Double.parseDouble(request.getParameter("ruc"));
			String direc=request.getParameter("direc");
			int telefono = Integer.parseInt(request.getParameter("telefono"));
			int est = Integer.parseInt(request.getParameter("est"));
			up.create(new Proveedor(tipo,razonso,ruc,direc,telefono,est));
			respuesta = "1";
				
		} catch (Exception e) {
			System.out.println("Ha surgido un error "+e);
			respuesta = "error en el controlador";
		}
		return respuesta;
	}
	
//	validar proveedor 
	@RequestMapping(value="/validar_proveedor_ruc", method=RequestMethod.POST)
	public @ResponseBody String val_proveedor(HttpServletRequest request) {
	String ruc = request.getParameter("ruc");
	System.out.println("este es el ruc "+ruc);
	return g.toJson(up.validar_proveedor_ruc(ruc));
	}
	
	@RequestMapping(value="/Delete_Proveedor_Pro", method=RequestMethod.POST)
	public @ResponseBody String deletee_pro(HttpServletRequest request) {
	int ip = Integer.parseInt(request.getParameter("ip"));
	up.delete(ip);
	return "1";
	}
	
	@RequestMapping(value="/Fila_Proveedor_Pro", method=RequestMethod.POST)
	public @ResponseBody String fila_us(HttpServletRequest request) {
	int ip = Integer.parseInt(request.getParameter("ip"));
	System.out.println(ip);
	return g.toJson(up.read(ip));
	}
	
	@RequestMapping(value="/Act_Proveedor_pro", method=RequestMethod.POST)
	public @ResponseBody String act_us(HttpServletRequest request) {
	int id=Integer.parseInt(request.getParameter("id"));
	String tipo=request.getParameter("tipo");
	String razonso=request.getParameter("razonso");
	int ruc=Integer.parseInt(request.getParameter("ruc"));
	String direc=request.getParameter("direc");
	int telefono = Integer.parseInt(request.getParameter("telefono"));
	int est = Integer.parseInt(request.getParameter("est"));
	System.out.println(id);
	System.out.println(tipo);
	System.out.println(razonso);
	System.out.println(ruc);
	System.out.println(direc);
	System.out.println(telefono);
	System.out.println(est);
	up.edit(new Proveedor (id,tipo,razonso,ruc,direc,telefono,est));
		return "1";
	}
}
