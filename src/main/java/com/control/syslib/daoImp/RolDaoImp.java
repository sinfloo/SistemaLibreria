package com.control.syslib.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.RolDao;
import com.control.syslib.entity.Rol;

@Repository
public class RolDaoImp implements RolDao {
	@Autowired
	private JdbcTemplate jt;

	@Override
	public void create(Rol r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void edit(Rol r) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> readAll() {
		String sql="{CALL RALL_ROL()}";
		return jt.queryForList(sql);
	}
	
}
