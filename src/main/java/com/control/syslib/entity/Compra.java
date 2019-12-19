package com.control.syslib.entity;

public class Compra {
private int idcompra;
private String fecha;
private double importeTotal;
private String tipoComprobante;
private int estado;
private int id_orden_c;
private int idusuario;
private int idproveedor;
public Compra() {
	super();
}






public Compra(String fecha, double importeTotal, String tipoComprobante, int estado, int idusuario, int idproveedor) {
	super();
	this.fecha = fecha;
	this.importeTotal = importeTotal;
	this.tipoComprobante = tipoComprobante;
	this.estado = estado;
	this.idusuario = idusuario;
	this.idproveedor = idproveedor;
}






public Compra(int idcompra, String fecha, double importeTotal, String tipoComprobante, int estado, int id_orden_c,
		int idusuario, int idproveedor) {
	super();
	this.idcompra = idcompra;
	this.fecha = fecha;
	this.importeTotal = importeTotal;
	this.tipoComprobante = tipoComprobante;
	this.estado = estado;
	this.id_orden_c = id_orden_c;
	this.idusuario = idusuario;
	this.idproveedor = idproveedor;
}
public Compra(String fecha, double importeTotal, String tipoComprobante, int estado, int id_orden_c, int idusuario,
		int idproveedor) {
	super();
	this.fecha = fecha;
	this.importeTotal = importeTotal;
	this.tipoComprobante = tipoComprobante;
	this.estado = estado;
	this.id_orden_c = id_orden_c;
	this.idusuario = idusuario;
	this.idproveedor = idproveedor;
}
public int getIdcompra() {
	return idcompra;
}
public void setIdcompra(int idcompra) {
	this.idcompra = idcompra;
}
public String getFecha() {
	return fecha;
}
public void setFecha(String fecha) {
	this.fecha = fecha;
}
public double getImporteTotal() {
	return importeTotal;
}
public void setImporteTotal(double importeTotal) {
	this.importeTotal = importeTotal;
}
public String getTipoComprobante() {
	return tipoComprobante;
}
public void setTipoComprobante(String tipoComprobante) {
	this.tipoComprobante = tipoComprobante;
}
public int getEstado() {
	return estado;
}
public void setEstado(int estado) {
	this.estado = estado;
}
public int getId_orden_c() {
	return id_orden_c;
}
public void setId_orden_c(int id_orden_c) {
	this.id_orden_c = id_orden_c;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public int getIdproveedor() {
	return idproveedor;
}
public void setIdproveedor(int idproveedor) {
	this.idproveedor = idproveedor;
}




}
