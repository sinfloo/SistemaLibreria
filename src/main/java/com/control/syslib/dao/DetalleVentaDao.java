package com.control.syslib.dao;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.DetalleVenta;

public interface DetalleVentaDao {
	public void create (DetalleVenta dv);
	public List<Map<String, Object>> readAll();
}
