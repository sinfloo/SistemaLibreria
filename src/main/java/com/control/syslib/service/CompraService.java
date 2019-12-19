package com.control.syslib.service;

import java.util.List;
import java.util.Map;

import com.control.syslib.entity.Compra;

public interface CompraService {
	public List<Map<String, Object>> readAll();
	public List<Map<String, Object>> create(Compra c);
}
