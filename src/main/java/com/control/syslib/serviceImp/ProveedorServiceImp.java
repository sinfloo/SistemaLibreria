package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.ProveedorDao;
import com.control.syslib.entity.Proveedor;
import com.control.syslib.service.ProveedorService;

@Service
public class ProveedorServiceImp implements ProveedorService{
	@Autowired
	private ProveedorDao pd;

	@Override
	public void create(Proveedor p) {
		// TODO Auto-generated method stub
		pd.create(p);
	}

	@Override
	public void edit(Proveedor p) {
		pd.edit(p);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pd.delete(id);
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		return pd.read(id);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return pd.readAll();
	}

	@Override
	public List<Map<String, Object>> validar_proveedor_ruc(String rucc) {
		// TODO Auto-generated method stub
		return pd.validar_proveedor_ruc(rucc);
	}
}
