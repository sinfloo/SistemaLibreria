package com.control.syslib.dao;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.CierreCaja;

public interface CierreCajaDao {
	public void create (CierreCaja cc);
	public List<Map<String, Object>> readAll();
	public List<Map<String, Object>> read_monto_cierre(String a, String b);
}
