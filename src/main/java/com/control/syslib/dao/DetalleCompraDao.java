package com.control.syslib.dao;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.DetalleCompra;

public interface DetalleCompraDao {
	public void create (DetalleCompra dc);
	public List<Map<String, Object>> readAll();
}
