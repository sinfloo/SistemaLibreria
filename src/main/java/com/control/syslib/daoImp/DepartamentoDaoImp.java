package com.control.syslib.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.DepartamentoDao;
import com.control.syslib.entity.Departamento;

@Repository
public class DepartamentoDaoImp implements DepartamentoDao{
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void create(Departamento a) {
		String sql= "{CALL CREA_DEPARTAMENTO(?,?,?,?)}";
		jt.update(sql,a.getDep_nombre(), a.getDescripcion(), a.getEstado(), a.getIddepartamento());
	}

	@Override
	public List<Map<String, Object>> readAll() {
		String sql="{CALL RALL_Departamento()}";
		return jt.queryForList(sql);
	}

	@Override
	public void Delete(int id) {
		String sql="{CALL DELETE_DEPARTAMENTO(?)}";
		jt.update(sql,id);
		
	}

	@Override
	public void editar(Departamento a) {
		// TODO Auto-generated method stub
		String sql="{CALL EDITAR_DEPARTAMENTO(?,?,?,?)}";
		jt.update(sql, a.getIddepartamento(), a.getDep_nombre(), a.getDescripcion(), a.getEstado());
		
		
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		// TODO Auto-generated method stub
		String sql="{CALL READ_DEPARTAMENTO(?)}";
		return jt.queryForList(sql,id);
		
	}
}




