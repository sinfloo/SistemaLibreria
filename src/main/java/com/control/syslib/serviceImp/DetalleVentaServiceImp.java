package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.DetalleVentaDao;
import com.control.syslib.entity.DetalleVenta;
import com.control.syslib.service.DetalleVentaService;

@Service
public class DetalleVentaServiceImp implements DetalleVentaService {
	
	@Autowired
	private DetalleVentaDao dvv;
	
	@Override
	public void create(DetalleVenta dv) {
		dvv.create(dv);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		return dvv.readAll();
	}

}
