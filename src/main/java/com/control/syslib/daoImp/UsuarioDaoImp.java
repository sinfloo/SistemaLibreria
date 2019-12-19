package com.control.syslib.daoImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.control.syslib.dao.UsuarioDao;
import com.control.syslib.entity.Usuario;

@Repository
public class UsuarioDaoImp implements UsuarioDao {
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void create(Usuario u) {
		String sql="{CALL CREA_USUARIO(?,?,?,?)}";
		jt.update(sql,u.getUsuario(), u.getPassword(), u.getEstado(), u.getIdpersona());
	}

	@Override
	public List<Map<String, Object>> read(int id) {
		String sql="{CALL REA_USUARIO(?)}";
		return jt.queryForList(sql,id);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		String sql="{CALL RALL_USUARIO()}";
		return jt.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> validar_inicio_sesion(String a, String b) {
		String sql="{CALL VALIDAR_SESION_US(?,?)}";
		return jt.queryForList(sql, a,b);
	}

	@Override
	public Map<String, Object> Validar_Mapeo_dat(String User, String Pass) {
		String sql="{CALL VALIDAR_SESION_US(?,?)}";
		return jt.queryForMap(sql, User, Pass);
	}

	@Override
	public void edit(Usuario u) {
		String sql="{CALL UPDATE_USUARIO(?,?,?,?)}";
		jt.update(sql,u.getIdusuario(),u.getUsuario(), u.getPassword(), u.getEstado());
		
	}

	@Override
	public void delete(int id) {
		String sql="{CALL DEL_USUARIO(?)}";
		jt.update(sql,id);
		
	}

	@Override
	public List<Map<String, Object>> read_persona() {
		// TODO Auto-generated method stub
		String sql="{CALL RALL_P()}";
		return jt.queryForList(sql);
	}
}
