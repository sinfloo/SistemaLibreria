package com.control.syslib.service;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.DetalleCompra;

public interface DetalleCompraService {
	public void create (DetalleCompra dc);
	public List<Map<String, Object>> readAll();
}
