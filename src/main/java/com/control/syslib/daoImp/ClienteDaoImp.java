package com.control.syslib.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.ClienteDao;
import com.control.syslib.entity.Cliente;

@Repository
public class ClienteDaoImp implements ClienteDao {
	@Autowired
	private JdbcTemplate jt;
	@Override
	public void create(Cliente a) {
		String sql= "{CALL CREA_CLIENTE(?,?,?)}";
		jt.update(sql,a.getIdcliente(), a.getEstado(), a.getIdpersona());
	
	}

	@Override
	public List<Map<String, Object>> readAll() {
		String sql="{CALL LISTAR_CLIENTES()}";
		return jt.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> listaPersona() {
		String sql="{CALL LISTAR_PERSONA()}";
		return jt.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> read_one_cliente(int ida) {
		// TODO Auto-generated method stub
				String sql="{CALL LISTAR_FILA_CLIENTE(?)}";
				return jt.queryForList(sql,ida);
	}

}
