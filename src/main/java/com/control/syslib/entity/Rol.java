package com.control.syslib.entity;

public class Rol {
 private int idusuario;
 private String nombre;
 private String descripcion;
 private int estado;
public Rol() {
	super();
}
public Rol(String nombre, String descripcion, int estado) {
	super();
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.estado = estado;
}
public Rol(int idusuario, String nombre, String descripcion, int estado) {
	super();
	this.idusuario = idusuario;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.estado = estado;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
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
