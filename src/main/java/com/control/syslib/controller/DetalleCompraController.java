package com.control.syslib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.control.syslib.entity.DetalleCompra;
import com.control.syslib.service.DetalleCompraService;
import com.google.gson.Gson;

@Controller
public class DetalleCompraController {
	@Autowired
	private DetalleCompraService dcsv;
	//	insertar detalle compra
	
	@RequestMapping(value="/insertar_detalle_compra", method=RequestMethod.POST)
	public @ResponseBody String imp(@RequestBody String listajson, HttpServletRequest request) {
		System.out.println("entrando en el controller detalle compra nueva" + listajson);
		
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
			DetalleCompra dvobj = newg.fromJson(array1[i], DetalleCompra.class);
			System.out.println(dvobj.getIdarticulo() + " , " +dvobj.getIdcompra() + " , " + dvobj.getCantidad() + " , " + dvobj.getPrecio_unitario() + " , " + dvobj.getSub_total() );
			
			// llamar a nuestro procedimiento de add detalle venta
			
			dcsv.create(new DetalleCompra(dvobj.getCantidad(), dvobj.getPrecio_unitario(), 
					dvobj.getSub_total(), dvobj.getIdcompra(), dvobj.getIdarticulo()));
		}
	
	return "Exito en registrar el detalle compra !!";
	}
}
