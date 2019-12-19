package com.control.syslib.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.VentaDao;
import com.control.syslib.entity.Venta;
@Repository
public class VentaDaoImp implements VentaDao {
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<Map<String, Object>> create(Venta v) {
		String sql="{CALL CREA_VENTA(?,?,?,?,?)}";
		return jt.queryForList(sql,v.getMontototal(),v.getFecha(), v.getEstado(), v.getIdusuario(), v.getIdcliente());
	}

	@Override
	public List<Map<String, Object>> readAll() {
		String sql="{CALL LISTA_VENTAS()}";
		return jt.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> read_detalle_ventas(int id) {
		String sql="{CALL LISTA_DETALLES_VENTA(?)}";
		return jt.queryForList(sql,id);
	}

	@Override
	public List<Map<String, Object>> read_clientes() {
		String sql="{CALL LISTAR_CLIENTES()}";
		return jt.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> read_articulos() {
		String sql="{CALL LISTAR_ARTICULOS_ACTIVOS()}";
		return jt.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> create_second(Venta v) {
		String sql="{CALL CREA_VENTA_DOS(?,?,?,?)}";
		return jt.queryForList(sql,v.getMontototal(),v.getFecha(), v.getEstado(), v.getIdusuario());
	}

}
