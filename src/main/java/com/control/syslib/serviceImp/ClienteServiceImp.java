package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.ClienteDao;
import com.control.syslib.entity.Cliente;
import com.control.syslib.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService{
	@Autowired
	private ClienteDao cdo;
	
	@Override
	public void create(Cliente a) {
		cdo.create(a);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return cdo.readAll();
	}

	@Override
	public List<Map<String, Object>> listaPersona() {
		// TODO Auto-generated method stub
		return cdo.listaPersona();
	}

	@Override
	public List<Map<String, Object>> read_one_cliente(int ida) {
		// TODO Auto-generated method stub
		return cdo.read_one_cliente(ida);
	}

}
