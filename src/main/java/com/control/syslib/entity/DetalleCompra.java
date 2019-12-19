package com.control.syslib.entity;

public class DetalleCompra {
private int iddetalleCompra;
private int cantidad;
private double precio_unitario;
private double sub_total;
private int idcompra;
private int idarticulo;
public DetalleCompra(int iddetalleCompra, int cantidad, double precio_unitario, double sub_total, int idcompra,
		int idarticulo) {
	super();
	this.iddetalleCompra = iddetalleCompra;
	this.cantidad = cantidad;
	this.precio_unitario = precio_unitario;
	this.sub_total = sub_total;
	this.idcompra = idcompra;
	this.idarticulo = idarticulo;
}
public DetalleCompra(int cantidad, double precio_unitario, double sub_total, int idcompra, int idarticulo) {
	super();
	this.cantidad = cantidad;
	this.precio_unitario = precio_unitario;
	this.sub_total = sub_total;
	this.idcompra = idcompra;
	this.idarticulo = idarticulo;
}
public int getIddetalleCompra() {
	return iddetalleCompra;
}
public void setIddetalleCompra(int iddetalleCompra) {
	this.iddetalleCompra = iddetalleCompra;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public double getPrecio_unitario() {
	return precio_unitario;
}
public void setPrecio_unitario(double precio_unitario) {
	this.precio_unitario = precio_unitario;
}
public double getSub_total() {
	return sub_total;
}
public void setSub_total(double sub_total) {
	this.sub_total = sub_total;
}
public int getIdcompra() {
	return idcompra;
}
public void setIdcompra(int idcompra) {
	this.idcompra = idcompra;
}
public int getIdarticulo() {
	return idarticulo;
}
public void setIdarticulo(int idarticulo) {
	this.idarticulo = idarticulo;
}




}
