package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.VentaDao;
import com.control.syslib.entity.Venta;
import com.control.syslib.service.VentaService;

@Service
public class VentaServiceImp implements VentaService{
	
	@Autowired
	private VentaDao vd;
	@Override
	public List<Map<String, Object>> create(Venta v) {
	return vd.create(v);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		return vd.readAll();
	}

	@Override
	public List<Map<String, Object>> read_detalle_ventas(int id) {
		return vd.read_detalle_ventas(id);
	}

	@Override
	public List<Map<String, Object>> read_clientes() {
		return vd.read_clientes();
	}

	@Override
	public List<Map<String, Object>> read_articulos() {
		return vd.read_articulos();
	}

	@Override
	public List<Map<String, Object>> create_second(Venta v) {
		return vd.create_second(v);
	}

	
}
