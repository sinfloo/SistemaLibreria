package com.control.syslib.entity;

public class Cliente {
private int idcliente;
private int estado;
private int idpersona;
public Cliente() {
	super();
}
public Cliente(int estado, int idpersona) {
	super();
	this.estado = estado;
	this.idpersona = idpersona;
}
public Cliente(int idcliente, int estado, int idpersona) {
	super();
	this.idcliente = idcliente;
	this.estado = estado;
	this.idpersona = idpersona;
}
public int getIdcliente() {
	return idcliente;
}
public void setIdcliente(int idcliente) {
	this.idcliente = idcliente;
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
