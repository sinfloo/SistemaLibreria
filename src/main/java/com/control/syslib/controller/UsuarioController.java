package com.control.syslib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.syslib.entity.Usuario;
import com.control.syslib.service.UsuarioService;
import com.google.gson.Gson;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService ud;
	Gson g = new Gson();
	
	@GetMapping("/lista_usuario")
	public String lista(Model model) {		
		return "usuario";
	}
	
	@RequestMapping(value="/ListarTodo_Usuario_Us", method=RequestMethod.POST)
	public @ResponseBody String vertodo_u(HttpServletRequest request) {
	return g.toJson(ud.readAll());
	}
	@GetMapping("/agregar_us")
	public String add_use(Model model) {
	//	model.addAttribute("per",ud.read_persona());
		return "us_add";
	}
	
	@RequestMapping(value="/Guardar_Usuario_Us", method=RequestMethod.POST)
	public @ResponseBody String create_us(HttpServletRequest request) {
	String user=request.getParameter("user");
	String pass=request.getParameter("pass");
	int est=Integer.parseInt(request.getParameter("est"));
	int idp = Integer.parseInt(request.getParameter("idp"));
	ud.create(new Usuario(user,pass,est,idp));
		return "1";
	}
	
	@RequestMapping(value="/Delete_Usuario_Us", method=RequestMethod.POST)
	public @ResponseBody String deletee_us(HttpServletRequest request) {
	int idu = Integer.parseInt(request.getParameter("idu"));
	ud.delete(idu);
	return "1";
	}
	
	@RequestMapping(value="/listar_personas", method=RequestMethod.POST)
	public @ResponseBody String ver_personas(HttpServletRequest request) {
	return g.toJson(ud.read_persona());
	}
	@RequestMapping(value="/Fila_Usuario_Us", method=RequestMethod.POST)
	public @ResponseBody String fila_us(HttpServletRequest request) {
	int idu = Integer.parseInt(request.getParameter("idu"));
	System.out.println(idu);
	return g.toJson(ud.read(idu));
	}
	
	@RequestMapping(value="/Act_Usuario_Us", method=RequestMethod.POST)
	public @ResponseBody String act_us(HttpServletRequest request) {
	String user=request.getParameter("user");
	String pass=request.getParameter("pass");
	int est=Integer.parseInt(request.getParameter("est"));
	int idu = Integer.parseInt(request.getParameter("idu"));
//	System.out.println(user);
//	System.out.println(pass);
//	System.out.println(est);
//	System.out.println(idu);
	ud.edit(new Usuario (idu, user, pass, est));
		return "1";
	}
}
