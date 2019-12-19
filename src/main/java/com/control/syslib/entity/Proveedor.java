package com.control.syslib.entity;

public class Proveedor {
 private int idproveedor;
 private String tipo;
 private String razonsocial;
 private double ruc;
 private String direccion;
 private int telefono;
 private int estado;
 
 
 
public Proveedor() {
	super();
}



public Proveedor(int idproveedor, String tipo, String razonsocial, double ruc, String direccion, int telefono,
		int estado) {
	super();
	this.idproveedor = idproveedor;
	this.tipo = tipo;
	this.razonsocial = razonsocial;
	this.ruc = ruc;
	this.direccion = direccion;
	this.telefono = telefono;
	this.estado = estado;
}



public Proveedor(String tipo, String razonsocial, double ruc, String direccion, int telefono, int estado) {
	super();
	this.tipo = tipo;
	this.razonsocial = razonsocial;
	this.ruc = ruc;
	this.direccion = direccion;
	this.telefono = telefono;
	this.estado = estado;
}



public int getIdproveedor() {
	return idproveedor;
}



public void setIdproveedor(int idproveedor) {
	this.idproveedor = idproveedor;
}



public String getTipo() {
	return tipo;
}



public void setTipo(String tipo) {
	this.tipo = tipo;
}



public String getRazonsocial() {
	return razonsocial;
}



public void setRazonsocial(String razonsocial) {
	this.razonsocial = razonsocial;
}



public double getRuc() {
	return ruc;
}



public void setRuc(double ruc) {
	this.ruc = ruc;
}



public String getDireccion() {
	return direccion;
}



public void setDireccion(String direccion) {
	this.direccion = direccion;
}



public int getTelefono() {
	return telefono;
}



public void setTelefono(int telefono) {
	this.telefono = telefono;
}



public int getEstado() {
	return estado;
}



public void setEstado(int estado) {
	this.estado = estado;
}


}
