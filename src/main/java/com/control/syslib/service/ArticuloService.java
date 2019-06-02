package com.control.syslib.service;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.Articulos;

public interface ArticuloService {
	public void create (Articulos a);
	public List<Map<String, Object>> readAll();
	public List<Map<String, Object>> readdepartamentos(); 
}
