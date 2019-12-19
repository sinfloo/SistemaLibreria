package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.RolDao;
import com.control.syslib.entity.Rol;
import com.control.syslib.service.RolService;

@Service
public class RolServiceImp implements RolService {
	@Autowired
	private RolDao rd;
	@Override
	public void create(Rol r) {
		rd.create(r);
	}

	@Override
	public void edit(Rol r) {
		rd.edit(r);
	}

	@Override
	public void delete(int id) {
		rd.delete(id);
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		return rd.read(id);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return rd.readAll();
	}

}
