package com.control.syslib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.syslib.entity.Departamento;
import com.control.syslib.service.DepartamentoService;
import com.google.gson.Gson;

@Controller
public class DepartamentoController {
	@Autowired
	private DepartamentoService as;
	Gson g = new Gson();
	
	@GetMapping("/lista_departamento")
	public String lista(Model model) {		
		return "departamento";
}
	@RequestMapping(value="/lista_todos_departamento", method=RequestMethod.POST)
	public @ResponseBody String vertodo_ar(HttpServletRequest request) {
	return g.toJson(as.readAll());
	}
	
	@GetMapping("/agregar_dep")
	public String lista_add(Model model) {		
		return "departamento_add";
}
	
	@RequestMapping(value="/Guardar_Departamento_U", method=RequestMethod.POST)
	public @ResponseBody String create_us(HttpServletRequest request) {
	String nombre=request.getParameter("nombre");
	String descri=request.getParameter("descri");
	int est=Integer.parseInt(request.getParameter("est"));
	as.create(new Departamento(nombre,descri,est));
	return "1";
	}
	
	@RequestMapping(value="/Delete_Departamento_U", method=RequestMethod.POST)
	public @ResponseBody String delete_us(HttpServletRequest request) {
	int iddep = Integer.parseInt(request.getParameter("iddep"));
	as.Delete(iddep);
	return "1";
	}
	
	@RequestMapping(value="/Fila_Departamento_U", method=RequestMethod.POST)
	public @ResponseBody String fila_us(HttpServletRequest request) {
	int iddep = Integer.parseInt(request.getParameter("iddep"));
	System.out.println(iddep);
	return g.toJson(as.read(iddep));
	}
	
	@RequestMapping(value="/Act_Departamento_U", method=RequestMethod.POST)
	public @ResponseBody String act_us(HttpServletRequest request) {
	String nombre=request.getParameter("nombre");
	String descri=request.getParameter("descri");
	int est=Integer.parseInt(request.getParameter("est"));
	int iddep = Integer.parseInt(request.getParameter("iddep"));
	System.out.println(nombre);
	System.out.println(descri);
	System.out.println(est);
	System.out.println(iddep);
	as.editar(new Departamento(iddep,nombre,descri,est));
	return "1";
	}
}

