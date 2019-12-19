package com.control.syslib.entity;




public class Venta {
private int idventa;
private double montototal;
private String fecha;
private int estado;
private int idusuario;
private int idcliente;
public Venta() {
	super();
}

public Venta(double montototal, String fecha, int estado, int idusuario, int idcliente) {
	super();
	this.montototal = montototal;
	this.fecha = fecha;
	this.estado = estado;
	this.idusuario = idusuario;
	this.idcliente = idcliente;
}

public Venta(double montototal, String fecha, int estado, int idusuario) {
	super();
	this.montototal = montototal;
	this.fecha = fecha;
	this.estado = estado;
	this.idusuario = idusuario;
}

public Venta(int idventa, double montototal, String fecha, int estado, int idusuario, int idcliente) {
	super();
	this.idventa = idventa;
	this.montototal = montototal;
	this.fecha = fecha;
	this.estado = estado;
	this.idusuario = idusuario;
	this.idcliente = idcliente;
}
public int getIdventa() {
	return idventa;
}
public void setIdventa(int idventa) {
	this.idventa = idventa;
}
public double getMontototal() {
	return montototal;
}
public void setMontototal(double montototal) {
	this.montototal = montototal;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public int getEstado() {
	return estado;
}
public void setEstado(int estado) {
	this.estado = estado;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public int getIdcliente() {
	return idcliente;
}
public void setIdcliente(int idcliente) {
	this.idcliente = idcliente;
}


}
