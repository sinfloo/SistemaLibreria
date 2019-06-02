package com.control.syslib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentaController {
	@GetMapping("/lista_venta")
	public String lista(Model model) {		
		return "articulo";
	}
}
