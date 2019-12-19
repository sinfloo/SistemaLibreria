$(document).ready(function(){
	listar();
});

function listar(){ 
	$.post("/lista_todas_ventas", function(data){
		var d = JSON.parse(data)
//		console.log(data);
		var j =1;
			$("#tablita").find("tr:gt(0)").remove();
			for(var i= 0; i<d.length;i++){
				if (d[i].idCliente===undefined) {
					$("#tablita").append("<tr><td>"+d[i].idventa+"</td><td>"+j+"</td><td>"+d[i].montototal+"</td><td>"+d[i].ven_fecha+"</td><td>"+ " <input type='button' id='b1' style='width:100px;' class='btn btn-success' value='General'>" +"</td><td>" +"General"+"</td>"+
							"<td>"+
							"<a href='#' onclick='ver_detalles_ventas("+d[i].idventa+")'><i class='fas fa-eye fa-lg' aria-hidden='true'  ></i>></a>"+
							"</td>" +
							"</tr>");
							j++;
				} 
				else {
					$("#tablita").append("<tr><td>"+d[i].idventa+"</td><td>"+j+"</td><td>"+d[i].montototal+"</td><td>"+d[i].ven_fecha+"</td><td>"+ " <input type='button' id='b2' style='width:100px;' class='btn btn-success' value='Especifico'>" +"</td><td>" +d[i].nombres+"</td>"+
							"<td>"+
							"<a href='#' onclick='ver_detalles_ventas("+d[i].idventa+")'><i class='fas fa-eye fa-lg' aria-hidden='true'  ></i>></a>"+
							"</td>" +
							"</tr>");
							j++;
					}
				}
		    $('#tablita tr > *:nth-child(1)').hide();
	});
	}

function ver_detalles_ventas(idv){
	$("#modalone").modal("show");
	$("#cabecera").text("DETALLE VENTA");
	$("#id_presta").val(idv);
	var des="A0B0";
	 $("#numero_ticket").val(des+idv);
	 $("#ruc_empresa").val("10096620620");
	$.post("lista_detalles_venta",{idv:idv}, function(data){
		var d = JSON.parse(data)
		console.log("los detalles de la venta"+d);
		var j =1;
			$("#tabla_detallito").find("tr:gt(0)").remove();
			for(var i= 0; i<d.length;i++){
				$("#tabla_detallito").append("<tr><td>"+d[i].iddetalle_venta+"</td><td>"+j+"</td><td>"+d[i].cantidad+"</td><td>"+d[i].nombre+"</td><td>"+d[i].precio_unitario+"</td><td>"+d[i].sub_total+"</td><td>"+ d[i].descuento +"</td>"+
			
				"</tr>");
				j++;
				}
			
			if (d[0].nombres!=null) {
			console.log("aqui va el input con el cliente especifico");
			$("#nombre_cliente").val(d[0].nombres+" "+d[0].apellidos);
			} else {
		     console.log("aqui va el input de cliente como general");
		     $("#nombre_cliente").val("Cliente General");
			}
			$("#fecha_venta").val(d[0].ven_fecha);
			$("#monto_totall").val(d[0].montototal+".00");
		    $('#tabla_detallito tr > *:nth-child(1)').hide();
	});
}
