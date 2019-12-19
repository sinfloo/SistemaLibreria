package com.control.syslib.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.CierreCajaDao;
import com.control.syslib.entity.CierreCaja;


@Repository
public class CierreCajaDaoImp implements CierreCajaDao {
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void create(CierreCaja cc) {
		String sql="{CALL CREAR_CIERRE_CAJA(?,?,?,?,?)}";
		jt.update(sql, cc.getMonto_total(), cc.getFecha_inicio(), cc.getFecha_fin(), cc.getEstado(), cc.getIdusuario());
	}

	@Override
	public List<Map<String, Object>> readAll() {
		String sql="{CALL LISTA_CIERRE()}";
		return jt.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> read_monto_cierre(String a, String b) {
		String sql="{CALL CALCULAR_MONTO_CIERRE(?,?)}";
		return jt.queryForList(sql, a, b);
	}

}
