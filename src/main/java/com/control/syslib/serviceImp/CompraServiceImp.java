package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.CompraDao;
import com.control.syslib.entity.Compra;
import com.control.syslib.service.CompraService;

@Service
public class CompraServiceImp implements CompraService {
	@Autowired
	private CompraDao cds;
	@Override
	public List<Map<String, Object>> readAll() {
		return cds.readAll();
	}
	@Override
	public List<Map<String, Object>> create(Compra c) {
		// TODO Auto-generated method stub
		return cds.create(c);
	}

}
