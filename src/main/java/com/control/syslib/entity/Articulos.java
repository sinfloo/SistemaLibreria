package com.control.syslib.entity;

public class Articulos {
private int idarticulos;
private String nombre;
private String descripcion;
private int estado;
private int stock;
private int stock_minimo;
private double precio_compra;
private double precio_venta;
private int iddepartamento;
public Articulos() {
	super();
}
public Articulos(String nombre, String descripcion, int estado, int stock, int stock_minimo, double precio_compra,
		double precio_venta, int iddepartamento) {
	super();
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.estado = estado;
	this.stock = stock;
	this.stock_minimo = stock_minimo;
	this.precio_compra = precio_compra;
	this.precio_venta = precio_venta;
	this.iddepartamento = iddepartamento;
}
public Articulos(int idarticulos, String nombre, String descripcion, int estado, int stock, int stock_minimo,
		double precio_compra, double precio_venta, int iddepartamento) {
	super();
	this.idarticulos = idarticulos;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.estado = estado;
	this.stock = stock;
	this.stock_minimo = stock_minimo;
	this.precio_compra = precio_compra;
	this.precio_venta = precio_venta;
	this.iddepartamento = iddepartamento;
}
public int getIdarticulos() {
	return idarticulos;
}
public void setIdarticulos(int idarticulos) {
	this.idarticulos = idarticulos;
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
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getStock_minimo() {
	return stock_minimo;
}
public void setStock_minimo(int stock_minimo) {
	this.stock_minimo = stock_minimo;
}
public double getPrecio_compra() {
	return precio_compra;
}
public void setPrecio_compra(double precio_compra) {
	this.precio_compra = precio_compra;
}
public double getPrecio_venta() {
	return precio_venta;
}
public void setPrecio_venta(double precio_venta) {
	this.precio_venta = precio_venta;
}
public int getIddepartamento() {
	return iddepartamento;
}
public void setIddepartamento(int iddepartamento) {
	this.iddepartamento = iddepartamento;
}


}