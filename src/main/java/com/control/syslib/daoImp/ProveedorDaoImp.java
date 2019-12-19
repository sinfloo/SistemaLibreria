package com.control.syslib.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.ProveedorDao;
import com.control.syslib.entity.Proveedor;

@Repository
public class ProveedorDaoImp implements ProveedorDao{

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void create(Proveedor p) {
		// TODO Auto-generated method stub
		String sql="{CALL CREATE_PROVEEDOR(?,?,?,?,?,?)}";
		jt.update(sql,p.getTipo(), p.getRazonsocial(), p.getRuc(), p.getDireccion(), p.getTelefono() , p.getEstado());
	}

	@Override
	public void edit(Proveedor p) {
		String sql="{CALL UPDATE_PROVEEDOR(?,?,?,?,?,?,?)}";
		jt.update(sql, p.getIdproveedor(), p.getTipo(), p.getRazonsocial(), p.getRuc(), p.getDireccion(), p.getTelefono(), p.getEstado());
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="{CALL DELETE_PROVEEDOR(?)}";
		jt.update(sql,id);
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		String sql="{CALL READ_PROVEEDOR(?)}";
		return jt.queryForList(sql,id);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		String sql="{CALL RALL_PROVEEDOR()}";
		return jt.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> validar_proveedor_ruc(String rucc) {
		String sql="{CALL VALIDAR_PROVEEDOR(?)}";
		return jt.queryForList(sql,rucc);
	}
	
}
