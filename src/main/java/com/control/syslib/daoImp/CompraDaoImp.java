package com.control.syslib.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.CompraDao;
import com.control.syslib.entity.Compra;

@Repository
public class CompraDaoImp implements CompraDao{
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<Map<String, Object>> readAll() {
		String sql = "{CALL LISTA_COMPRA()}";
		return jt.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> create(Compra c) {
		String sql="{CALL CREAR_COMPRA(?,?,?,?,?,?)}";
		return jt.queryForList(sql,c.getFecha(), c.getImporteTotal(),
				c.getTipoComprobante(),c.getEstado(),c.getIdusuario(), 
				c.getIdproveedor());
	
	}

}
