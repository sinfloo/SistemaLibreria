package com.control.syslib.entity;

public class DetalleVenta {
private int iddetalleventa;
private int cantidad;
private double preciounitario;
private double subtotal;
private double descuento;
private int idventa;
private int idarticulo;
private int idunidadmedida;
public DetalleVenta() {
	super();
}
public DetalleVenta(int iddetalleventa, int cantidad, double preciounitario, double subtotal, double descuento,
		int idventa, int idarticulo, int idunidadmedida) {
	super();
	this.iddetalleventa = iddetalleventa;
	this.cantidad = cantidad;
	this.preciounitario = preciounitario;
	this.subtotal = subtotal;
	this.descuento = descuento;
	this.idventa = idventa;
	this.idarticulo = idarticulo;
	this.idunidadmedida = idunidadmedida;
}
public DetalleVenta(int cantidad, double preciounitario, double subtotal, double descuento, int idventa,
		int idarticulo) {
	super();
	this.cantidad = cantidad;
	this.preciounitario = preciounitario;
	this.subtotal = subtotal;
	this.descuento = descuento;
	this.idventa = idventa;
	this.idarticulo = idarticulo;
}
public DetalleVenta(int idarticulo, int idventa, int cantidad, double preciounitario, double subtotal, double descuento) {
	super();
	this.cantidad = cantidad;
	this.idventa = idventa;
	this.preciounitario = preciounitario;
	this.subtotal = subtotal;
	this.descuento = descuento;
	this.idarticulo = idarticulo;
}
public int getIddetalleventa() {
	return iddetalleventa;
}
public void setIddetalleventa(int iddetalleventa) {
	this.iddetalleventa = iddetalleventa;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
public double getPreciounitario() {
	return preciounitario;
}
public void setPreciounitario(double preciounitario) {
	this.preciounitario = preciounitario;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
public double getDescuento() {
	return descuento;
}
public void setDescuento(double descuento) {
	this.descuento = descuento;
}
public int getIdventa() {
	return idventa;
}
public void setIdventa(int idventa) {
	this.idventa = idventa;
}
public int getIdarticulo() {
	return idarticulo;
}
public void setIdarticulo(int idarticulo) {
	this.idarticulo = idarticulo;
}
public int getIdunidadmedida() {
	return idunidadmedida;
}
public void setIdunidadmedida(int idunidadmedida) {
	this.idunidadmedida = idunidadmedida;
}




}
