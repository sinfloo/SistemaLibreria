package com.control.syslib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.syslib.service.ClienteService;
import com.google.gson.Gson;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService css;
	Gson g = new Gson();
	
	@RequestMapping(value="/listar_fila_cliente", method=RequestMethod.POST)
	public @ResponseBody String ver_un_cliente(HttpServletRequest request) {
		int idc =Integer.parseInt(request.getParameter("idc"));
	return g.toJson(css.read_one_cliente(idc));
	}
}
