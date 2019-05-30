package com.control.syslib.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	
		@GetMapping("/")
		public String index(Model model) {
			System.out.println("HOLA soy el ENRUTADOR de LOGIN");
		        return "login";
		}	
}
