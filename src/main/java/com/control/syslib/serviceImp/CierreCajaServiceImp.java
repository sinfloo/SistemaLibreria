package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.CierreCajaDao;
import com.control.syslib.entity.CierreCaja;
import com.control.syslib.service.CierreCajaService;


@Service
public class CierreCajaServiceImp implements CierreCajaService{
	@Autowired
	private CierreCajaDao ccd;
	
	@Override
	public void create(CierreCaja cc) {
		ccd.create(cc);
	}
		
	@Override
	public List<Map<String, Object>> readAll() {
		return ccd.readAll();
	}

	@Override
	public List<Map<String, Object>> read_monto_cierre(String a, String b) {
		return ccd.read_monto_cierre(a, b);
	}

}
