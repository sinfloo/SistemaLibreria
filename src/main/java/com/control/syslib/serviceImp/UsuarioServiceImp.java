package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.UsuarioDao;
import com.control.syslib.entity.Usuario;
import com.control.syslib.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService{
@Autowired
private UsuarioDao ud;
	@Override
	public void create(Usuario u) {
	ud.create(u);
	}

	@Override
	public List<Map<String, Object>> read(int id) {
	return ud.read(id);
	}

	@Override
	public List<Map<String, Object>> readAll() {
	return ud.readAll();
	}

	@Override
	public List<Map<String, Object>> validar_inicio_sesion(String a, String b) {
		return ud.validar_inicio_sesion(a, b);
	}

	@Override
	public Map<String, Object> Validar_Mapeo_dat(String User, String Pass) {
		return ud.Validar_Mapeo_dat(User, Pass);
	}

}
