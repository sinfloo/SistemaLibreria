package com.control.syslib.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.DetalleCompraDao;
import com.control.syslib.entity.DetalleCompra;

@Repository
public class DetalleCompraDaoImp implements DetalleCompraDao {
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void create(DetalleCompra dc) {
		String sql="{CALL CREA_DETALLE_COMPRA(?,?,?,?,?)}";
		jt.update(sql,dc.getCantidad(), dc.getPrecio_unitario(), dc.getSub_total(), dc.getIdcompra(),dc.getIdarticulo());
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
