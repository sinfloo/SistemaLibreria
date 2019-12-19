package com.control.syslib.service;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.Usuario;

public interface UsuarioService {
	public void create (Usuario u);
	public void edit (Usuario u);
	public void delete(int id);
	public List<Map<String, Object>>  read (int id);
	public List<Map<String, Object>> readAll();
	public List<Map<String, Object>> read_persona();
	public List<Map<String, Object>> validar_inicio_sesion(String a, String b);
	public Map<String,Object> Validar_Mapeo_dat(String User, String Pass);
}
