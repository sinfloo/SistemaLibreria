package com.control.syslib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.syslib.service.RolService;
import com.google.gson.Gson;


@Controller
public class RolController {
	@Autowired
	private RolService rs;
	Gson g = new Gson();
	
	@GetMapping("/lista_rol")
	public String lista(Model model) {		
		return "rol";
	}
	@RequestMapping(value="/lista_todo_roles", method=RequestMethod.POST)
	public @ResponseBody String vertodo_r(HttpServletRequest request) {
	return g.toJson(rs.readAll());
	}
}
