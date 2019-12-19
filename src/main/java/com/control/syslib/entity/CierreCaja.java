package com.control.syslib.entity;

public class CierreCaja {
private int idcierre;
private String fecha_cierre;
private double monto_total;
private String fecha_inicio;
private String fecha_fin;
private int estado;
private int idventa;
private int idusuario;
public CierreCaja() {
	super();
}
public CierreCaja(int idcierre, double monto_total, String fecha_inicio, String fecha_fin,
		int estado, int idventa, int idusuario) {
	super();
	this.idcierre = idcierre;
	this.monto_total = monto_total;
	this.fecha_inicio = fecha_inicio;
	this.fecha_fin = fecha_fin;
	this.estado = estado;
	this.idventa = idventa;
	this.idusuario = idusuario;
}
public CierreCaja(double monto_total, String fecha_inicio, String fecha_fin, int estado,
		int idusuario) {
	super();
	this.monto_total = monto_total;
	this.fecha_inicio = fecha_inicio;
	this.fecha_fin = fecha_fin;
	this.estado = estado;
	this.idusuario = idusuario;
}
public int getIdcierre() {
	return idcierre;
}
public void setIdcierre(int idcierre) {
	this.idcierre = idcierre;
}
public String getFecha_cierre() {
	return fecha_cierre;
}
public void setFecha_cierre(String fecha_cierre) {
	this.fecha_cierre = fecha_cierre;
}
public double getMonto_total() {
	return monto_total;
}
public void setMonto_total(double monto_total) {
	this.monto_total = monto_total;
}
public String getFecha_inicio() {
	return fecha_inicio;
}
public void setFecha_inicio(String fecha_inicio) {
	this.fecha_inicio = fecha_inicio;
}
public String getFecha_fin() {
	return fecha_fin;
}
public void setFecha_fin(String fecha_fin) {
	this.fecha_fin = fecha_fin;
}
public int getEstado() {
	return estado;
}
public void setEstado(int estado) {
	this.estado = estado;
}
public int getIdventa() {
	return idventa;
}
public void setIdventa(int idventa) {
	this.idventa = idventa;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}




}