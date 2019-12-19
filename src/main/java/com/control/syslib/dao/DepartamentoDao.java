package com.control.syslib.dao;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.Departamento;

public interface DepartamentoDao {

	public void create (Departamento a);
	public List<Map<String, Object>> readAll();
	public void Delete(int id); 
	public void editar(Departamento a);
	public List<Map<String, Object>> read(int id);
	

}
