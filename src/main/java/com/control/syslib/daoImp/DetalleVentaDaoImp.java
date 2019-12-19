package com.control.syslib.daoImp;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.DetalleVentaDao;
import com.control.syslib.entity.DetalleVenta;
@Repository
public class DetalleVentaDaoImp implements DetalleVentaDao{
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void create(DetalleVenta dv) {
		String sql="{CALL CREA_DETALLE_VENTA(?,?,?,?,?,?)}";
		jt.update(sql,dv.getIdarticulo(), dv.getIdventa(),dv.getCantidad(), dv.getPreciounitario(), dv.getSubtotal(), dv.getDescuento());
	}

	@Override
	public List<Map<String, Object>> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
