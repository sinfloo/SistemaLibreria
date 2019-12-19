package com.control.syslib.entity;

public class Departamento {
	private int iddepartamento;
	private String dep_nombre;
	private String descripcion;
	private int estado;
	public Departamento() {
		super();
	}
	public Departamento(String dep_nombre, String descripcion, int estado) {
		super();
		this.dep_nombre = dep_nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	public Departamento(int iddepartamento, String dep_nombre, String descripcion, int estado) {
		super();
		this.iddepartamento = iddepartamento;
		this.dep_nombre = dep_nombre;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	public int getIddepartamento() {
		return iddepartamento;
	}
	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}
	public String getDep_nombre() {
		return dep_nombre;
	}
	public void setDep_nombre(String dep_nombre) {
		this.dep_nombre = dep_nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	

}
