package com.control.syslib.serviceImp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.control.syslib.dao.ArticuloDao;
import com.control.syslib.entity.Articulos;
import com.control.syslib.service.ArticuloService;

@Service
public class ArticuloServiceImp implements ArticuloService {
	@Autowired
	private ArticuloDao ad;
	
	@Override
	public void create(Articulos a) {
		ad.create(a);
	}

	@Override
	public List<Map<String, Object>> readAll() {
		return ad.readAll();
	}

	@Override
	public List<Map<String, Object>> readdepartamentos() {
		return ad.readdepartamentos();
	}



}
