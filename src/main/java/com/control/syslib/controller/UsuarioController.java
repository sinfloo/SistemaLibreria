package com.control.syslib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

	@GetMapping("/lista_usuario")
	public String lista(Model model) {		
		return "usuario";
	}
	
}
