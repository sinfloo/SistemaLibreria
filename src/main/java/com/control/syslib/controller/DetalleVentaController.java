package com.control.syslib.controller;

import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.syslib.entity.DetalleVenta;
import com.control.syslib.service.DetalleVentaService;
import com.google.gson.Gson;

@Controller
public class DetalleVentaController {
	@Autowired
	DetalleVentaService dvss;
	Gson g = new Gson();
	
//	insertar detalle venta
	
	@RequestMapping(value="/insertar_detalle_venta", method=RequestMethod.POST)
	public @ResponseBody String imp(@RequestBody String listajson, HttpServletRequest request) {
		System.out.println("entra print controoler" + listajson);
		
		String array1[]= listajson.split("data");

		int size = array1.length -1;
		for (int i = 1; i < array1.length; i++) {
			System.out.println(array1[i]);
			
			if(i==size) {
								
				array1[i] = array1[i].substring(3, array1[i].length()-1);
			}else {
				array1[i] = array1[i].substring(3,array1[i].length()-2);
			}
			
			System.out.println(array1[i]);

			Gson newg = new Gson();
			DetalleVenta dvobj = newg.fromJson(array1[i], DetalleVenta.class);
			System.out.println(dvobj.getIdarticulo() + " , " +dvobj.getIdventa() + " , " + dvobj.getCantidad() + " , " + dvobj.getPreciounitario() + " , " + dvobj.getSubtotal() + " , " + dvobj.getDescuento());
			
			// llamar a nuestro procedimiento de add detalle venta
			
			dvss.create(new DetalleVenta(dvobj.getIdarticulo(),dvobj.getIdventa(),dvobj.getCantidad(),dvobj.getPreciounitario(),dvobj.getSubtotal(),dvobj.getDescuento()));
		}
	
	return "Exito en imprimir";
	}
	
}
