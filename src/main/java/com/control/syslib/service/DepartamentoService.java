package com.control.syslib.service;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.Departamento;



public interface DepartamentoService {
	public void create (Departamento a);
	public List<Map<String, Object>> readAll();
	public void Delete(int id);
	public void editar(Departamento a);
	public List<Map<String, Object>> read(int id);

}
