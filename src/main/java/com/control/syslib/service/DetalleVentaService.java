package com.control.syslib.service;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.DetalleVenta;

public interface DetalleVentaService {
	public void create (DetalleVenta dv);
	public List<Map<String, Object>> readAll();
}
