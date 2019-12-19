package com.control.syslib.service;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.Rol;

public interface RolService {
	public void create (Rol r);
	public void edit (Rol r);
	public void delete(int id);
	public List<Map<String, Object>>  read (int id);
	public List<Map<String, Object>> readAll();
}
