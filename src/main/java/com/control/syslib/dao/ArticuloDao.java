package com.control.syslib.dao;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.Articulos;



public interface ArticuloDao {
	public void create (Articulos a);
	public List<Map<String, Object>> readAll();
	public List<Map<String, Object>> readdepartamentos(); 
	public List<Map<String, Object>> read_one_article(int ida);
}
