package com.control.syslib.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.ArticuloDao;
import com.control.syslib.entity.Articulos;

@Repository
public class ArticuloDaoImp implements ArticuloDao{
	@Autowired
	private JdbcTemplate jt;

	@Override
	public void create(Articulos a) {
		String sql="{CALL CREA_ARTICULO(?,?,?,?,?,?,?,?)}";
		jt.update(sql,a.getNombre(), a.getDescripcion(), a.getEstado(), a.getIddepartamento(), a.getStock(), a.getStock_minimo(), a.getPrecio_compra(), a.getPrecio_venta());
	}

	@Override
	public List<Map<String, Object>> readAll() {
		String sql="{CALL RALL_ARTICULO()}";
		return jt.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> readdepartamentos() {
		String sql="{CALL RALL_DEPARTAMENTO()}";
		return jt.queryForList(sql);
	}


}
