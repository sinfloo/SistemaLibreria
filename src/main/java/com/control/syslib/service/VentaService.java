package com.control.syslib.service;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.Venta;

public interface VentaService {
	public List<Map<String, Object>> create (Venta v);
	public List<Map<String, Object>> create_second (Venta v);
	public List<Map<String, Object>> readAll();
	public List<Map<String, Object>> read_detalle_ventas(int id);
	public List<Map<String, Object>> read_clientes();
	public List<Map<String, Object>> read_articulos();
}
