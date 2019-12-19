package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.DetalleCompraDao;
import com.control.syslib.entity.DetalleCompra;
import com.control.syslib.service.DetalleCompraService;
@Service
public class DetalleCompraServiceImp implements DetalleCompraService {
	@Autowired
	private DetalleCompraDao dcdd;
	@Override
	public void create(DetalleCompra dc) {
		
		dcdd.create(dc);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
