package com.control.syslib.entity;

public class Usuario {
private int idusuario;
private String usuario;
private String password;
private int estado;
private int idpersona;
public Usuario() {
	super();
}
public Usuario(String usuario, String password, int estado, int idpersona) {
	super();
	this.usuario = usuario;
	this.password = password;
	this.estado = estado;
	this.idpersona = idpersona;
}
public Usuario(int idusuario, String usuario, String password, int estado, int idpersona) {
	super();
	this.idusuario = idusuario;
	this.usuario = usuario;
	this.password = password;
	this.estado = estado;
	this.idpersona = idpersona;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public String getUsuario() {
	return usuario;
}
public void setUsuario(String usuario) {
	this.usuario = usuario;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getEstado() {
	return estado;
}
public void setEstado(int estado) {
	this.estado = estado;
}
public int getIdpersona() {
	return idpersona;
}
public void setIdpersona(int idpersona) {
	this.idpersona = idpersona;
}



}


