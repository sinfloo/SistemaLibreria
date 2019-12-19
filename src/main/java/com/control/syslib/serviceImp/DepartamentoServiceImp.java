package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.DepartamentoDao;
import com.control.syslib.entity.Departamento;
import com.control.syslib.service.DepartamentoService;


@Service
public class DepartamentoServiceImp implements DepartamentoService{
	@Autowired
	private DepartamentoDao ad;

	@Override
	public void create(Departamento a) {
		ad.create(a);
		
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return ad.readAll();
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		ad.Delete(id);
	}

	@Override
	public void editar(Departamento a) {
		// TODO Auto-generated method stub
		 ad.editar(a);
		
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		return ad.read(id);
	}

	

}
