package com.control.syslib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Rol {

	@GetMapping("/lista_rol")
	public String lista(Model model) {		
		return "rol";
	}
	
}
