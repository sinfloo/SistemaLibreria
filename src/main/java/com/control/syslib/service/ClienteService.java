package com.control.syslib.service;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.Cliente;

public interface ClienteService {
	public void create (Cliente a);
	public List<Map<String, Object>> readAll();
	public List<Map<String, Object>> listaPersona(); 
	public List<Map<String, Object>> read_one_cliente(int ida);
}
