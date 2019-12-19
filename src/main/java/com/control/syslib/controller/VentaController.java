package com.control.syslib.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.control.syslib.entity.DetalleVenta;
import com.control.syslib.entity.Venta;
import com.control.syslib.service.DetalleVentaService;
import com.control.syslib.service.VentaService;
import com.google.gson.Gson;

@Controller
public class VentaController {
	@Autowired
	private VentaService vcc;

	@Autowired
	private DetalleVentaService dvss;

	Gson g = new Gson();

	@GetMapping("/lista_venta")
	public String lista(Model model) {
		return "venta";
	}

	// Este metodo utilizado con API REST - Android
	@RequestMapping(value = "/lista_todas_ventas", method = RequestMethod.GET)
	public @ResponseBody String getventas() {
		return g.toJson(vcc.readAll());
	}

	// --------------------------
	@RequestMapping(value = "/lista_todas_ventas", method = RequestMethod.POST)
	public @ResponseBody String vertodo_ventas(HttpServletRequest request) {
		return g.toJson(vcc.readAll());
	}

	@RequestMapping(value = "/lista_detalles_venta", method = RequestMethod.POST)
	public @ResponseBody String vertodo_detalle(HttpServletRequest request) {
		int idv = Integer.parseInt(request.getParameter("idv"));
		return g.toJson(vcc.read_detalle_ventas(idv));
	}

	@GetMapping("/agregar_venta")
	public String add(Model model) {
		return "add_venta";
	}

	@RequestMapping(value = "/lista_clientes", method = RequestMethod.POST)
	public @ResponseBody String ver_clientes(HttpServletRequest request) {
		return g.toJson(vcc.read_clientes());
	}

//-----------Este método utlizado con API REST - Android-----------------
	@RequestMapping(value = "/registrar_venta_api", method = RequestMethod.POST)
	public String save(@RequestBody Venta v) {
		return g.toJson(vcc.create(v));
	}

	@RequestMapping(value = "/insertar_detalle_api", method = RequestMethod.POST)
	public String imp(@RequestBody DetalleVenta dv) {
		dvss.create(dv);
		return "Se Genero la Venta con Exito";
	}
//-------------FIN API REST----------------------------

//	Este método nos permitirá obtener el valor del id
	@RequestMapping(value = "/registrar_venta_nueva", method = RequestMethod.POST)
	public @ResponseBody String save(HttpServletRequest request) {
		String fechaa = request.getParameter("fecha_venta");
		int estado_v = Integer.parseInt(request.getParameter("estado_venta"));
		int idu = Integer.parseInt(request.getParameter("usu"));
		int idc = Integer.parseInt(request.getParameter("idclientee"));
		double mont = Double.parseDouble(request.getParameter("monto_total"));
		return g.toJson(vcc.create(new Venta(mont, fechaa, estado_v, idu, idc)));
	}

	@RequestMapping(value = "/registrar_venta_nueva_dos", method = RequestMethod.POST)
	public @ResponseBody String save_venta(HttpServletRequest request) {
		String fechaa = request.getParameter("fecha_venta");
		int estado_v = Integer.parseInt(request.getParameter("estado_venta"));
		int idu = Integer.parseInt(request.getParameter("usu"));
		double mont = Double.parseDouble(request.getParameter("monto_total"));
		return g.toJson(vcc.create_second(new Venta(mont, fechaa, estado_v, idu)));
	}

	@RequestMapping(value = "/lista_articulos_activos", method = RequestMethod.POST)
	public @ResponseBody String ver_articulos(HttpServletRequest request) {
		return g.toJson(vcc.read_articulos());
	}

//	Visualizar pagina reportes ventas 
	@GetMapping("/ver_reporte_ventas")
	public String report(Model model) {
		return "reporte_ventas";
	}
}
