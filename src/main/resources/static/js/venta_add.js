$(document).ready(function(){
    		listar_articulos();
    		listar();
    		$('#combazo').select2();
    		$('#combito').select2();
    		var d = new Date();
    		var strDate = d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate();
    		$("#fecha_venta").val(strDate);
    		$("#estado_venta").val("1");
    		$('#estado_venta').prop('disabled', true);
    		$("#alerta").css("display", "none");
    		$("#alerta_cliente").css("display", "none");
    	});

function listar(){ 
	$.post("/lista_clientes", function(data){
		var d = JSON.parse(data)
//			$("#combito").find("tr:gt(0)").remove();
			for(var i= 0; i<d.length;i++){
			$("#combito").append("<option value="+d[i].idCliente+">"+d[i].nombres+' '+d[i].apellidos+' '+d[i].dni+"</option>");
			
			}
	});
	}

function listar_articulos(){ 
	$.post("/lista_articulos_activos", function(data){
		var d = JSON.parse(data)
		var j =1;
			$("#tablita").find("tr:gt(0)").remove();
			for(var i= 0; i<d.length;i++){
			$("#tablita").append("<tr><td>"+d[i].idArticulos+"</td><td>"+j+"</td><td>"+d[i].nombre+"</td><td>"+d[i].stock+"</td><td>"+d[i].precio_venta+"</td><td>"+d[i].dep_nombre+"</td><td>"+" <input type='button' class='btn btn-success' value='Activo'>"+"</td>" +
			"<td>"+
			"<a href='#' onclick='añadir_cantidad("+d[i].idArticulos+")'><i class='fas fa-plus-circle fa-2x' aria-hidden='true' id='c2'></i></a>"+
			"</td>" +
			"</tr>");
			j++;
			}
			
			
		    $('#tablita tr > *:nth-child(1)').hide();
	});
	
	}
function añadir_cantidad(ida){
	$("#modal_carrito").modal("show");
	$.post("/listar_fila_articulo",{ida:ida}, function(data){
		var d = JSON.parse(data)
		$("#stock_articulo").val(d[0].stock);
		$("#nombre_articulo").val(d[0].nombre);
	});
	$("#id_article").val(ida);
	$('#cantidad_add').trigger('focus')

}
function añadir_carrito(){
	var ida = $("#id_article").val();
	var cantidad=$("#cantidad_add").val();
	 $("#modal_carrito").modal("hide");
	$.post('/listar_fila_articulo',{
		ida:ida
		},function(data){
			var d = JSON.parse(data)
			
				$("#carrito").append("<tr><td>"+d[0].idArticulos+"</td><td>"+d[0].nombre+"</td><td>"+cantidad+"</td><td>"+d[0].precio_venta+"</td><td>"+d[0].precio_venta*cantidad+"</td><td>"+0.00+"</td>" +
//				"<td>"+
//				"<a href='#' onclick='ver_idarticulo("+d[0].idArticulos+")'><i class='fas fa-eye fa-lg' aria-hidden='true'  ></i>></a>"+
//				"</td>" +
						"<td>"+"<input type='button' class='btn btn-danger borrar' value='Eliminar'"+"/></td>"+
				"</tr>");
			  var monto_tt=d[0].precio_venta*cantidad;
			   console.log(monto_tt);
			   var monto_input=$("#montoo").val();
			   console.log(monto_input);
				if (monto_input=="") {
					   var multi = monto_tt;
					   console.log(parseFloat(multi));
						$("#montoo").val(multi);
				} else {
					  var multi = parseFloat(monto_tt) + parseFloat(monto_input);
					   console.log(parseFloat(multi));
						$("#montoo").val(multi);
				}
			});
	$("#cantidad_add").val("");
			   
}

function seleccionar_tipo_cliente(){
	var tipoCliente = $("#combazo").val();
	if (tipoCliente==='Cliente General') {
		console.log("el tipo de cliente es Cliente General");
		$("#alerta").empty();
		$("#alerta").css("display", "block");
		$("#alerta").append("<p>"+'Excelente! seleccionaste'+" "+tipoCliente+"</p>");
		$('#combito').prop("disabled", "disabled");
		$("#alerta_cliente").empty();
		$("#alerta_cliente").css("display", "none");
		
	} else {
		console.log("el tipo de cliente es Cliente Especifico");
		$('#combito').prop('disabled', false);
		$("#alerta").empty();
		$("#alerta").css("display", "block");
		$("#alerta").append("<p>"+'Excelente! seleccionaste'+" "+tipoCliente+"</p>");
	}
}

//eliminamos la fila que no queremos del carrito preparado para la venta
$(function () {
    $(document).on('click', '.borrar', function (event) {
        event.preventDefault();
        $(this).closest('tr').remove();
    });
});

// aqui al seleccionar a un cliente, mostramos su nombre en la alerta de la interface
function mostrarNombreCliente(){
	var idc=$("#combito").val();
	if(idc != 0){ 
	$("#alerta_cliente").empty();
	$("#alerta_cliente").css("display", "block");
	$.post("/listar_fila_cliente",{idc:idc}, function(data){
		console.log(data)
		var d = JSON.parse(data)
	
		$("#alerta_cliente").append("<p>"+'Excelente! elegiste a '+" "+d[0].nombres+" "+d[0].apellidos+"</p>");
	});
	
	}else{
		$("#alerta_cliente").empty();
		$("#alerta_cliente").css("display", "block");
		$("#alerta_cliente").append("<p style='color:red; font-weight: bold;'>"+' No has seleccionado ningún cliente' +"</p>");
		// lo que tiene que ver con el color del alert aun no se ha configurado 
	}
	
}

function registrar_venta(){
	
	var fecha_venta = $("#fecha_venta").val();
	var estado_venta = $("#estado_venta").val();
	var idclientee = $("#combito").val();
	var tipo = $("#combazo").val();
	var monto_total=$("#montoo").val();
	var usu = 2;
	if(tipo == 0){
		console.log("ningun cliente ha sido seleccionado");
	}
	else if (tipo != 'Cliente General') {
		
		$.post('/registrar_venta_nueva',{
			fecha_venta:fecha_venta,
			estado_venta:estado_venta,
			idclientee:idclientee,
			usu:usu,
			monto_total:monto_total
			},function(data){
				console.log("soy el obj de la funcion venta: "+data);
				var f = JSON.parse(data)
		  var idvv=f[0].idventa;
				console.log("soy la variable idventa:"+idvv);
			var filas=carrito.rows.length;
				var parametros={};
				  $("#carrito tbody tr").each(function(i,e){
				var tr = {};
				 $(this).find("td").each(function(index, element){
					 name = ""
					 switch(index){
					 
					 case 0:
						 tr["idarticulo"] = $(this).text();
						 break;
					 case 1:
						 tr["idventa"] =idvv;
						 break;
					 case 2:
						 tr["cantidad"] = $(this).text();
						 break;
					 case 3:
						 tr["preciounitario"] = $(this).text();
						 break;
					 case 4:
						 tr["subtotal"] = $(this).text();
						 break;
					 case 5:
						 tr["descuento"] = $(this).text();
						 break;
					
					 }
			    });
				   parametros["data"+i] = tr;
				});
				  console.log(parametros);
				  console.log(JSON.stringify(parametros));
				   $.ajax({
					   contentType : 'application/json; charset=utf-8',
				        type:'POST',
				        url:'/insertar_detalle_venta',
				        datatype: 'json',
				        data: JSON.stringify(parametros),
				        'success': function(objview) {
				            console.log('hecho!!');
				            console.log(objview);
				            $.get("/agregar_venta", function(htmlexterno){
					     		   $("#contenedor_venta").html(htmlexterno);
					     		   $("#mensaje_venta_exitosa").modal("show");
					     		   $("#combazo").focus();
					     		   $("#combazo").css("border","solid #2e86de 2px");
					     		    	});
				        },
				        error: function(jqXHR, textStatus, errorThrown) {
				            console.log('error en el metodo de envío');
				        }

				    });
			
			});
				   
	} else {
			console.log("procedemos con el registro de la venta sin idcliente");
			console.log(monto_total);
			$.post('/registrar_venta_nueva_dos',{
				fecha_venta:fecha_venta,
				estado_venta:estado_venta,
				usu:usu,
				monto_total:monto_total
				},function(data){
					console.log("soy el obj de la funcion venta: "+data);
					var f = JSON.parse(data)
			        var idvvv=f[0].idventa;
					console.log("soy la variable idventa:"+idvvv);
					
				    var filas=carrito.rows.length;
					var parametros={};
					  $("#carrito tbody tr").each(function(i,e){
					var tr = {};
					 $(this).find("td").each(function(index, element){
						 name = ""
						 switch(index){
						 
						 case 0:
							 tr["idarticulo"] = $(this).text();
							 break;
						 case 1:
							 tr["idventa"] =idvvv;
							 break;
						 case 2:
							 tr["cantidad"] = $(this).text();
							 break;
						 case 3:
							 tr["preciounitario"] = $(this).text();
							 break;
						 case 4:
							 tr["subtotal"] = $(this).text();
							 break;
						 case 5:
							 tr["descuento"] = $(this).text();
							 break;
						
						 }
				    });
					   parametros["data"+i] = tr;
					});
					  console.log(parametros);
					  console.log(JSON.stringify(parametros));
					   $.ajax({
						   contentType : 'application/json; charset=utf-8',
					        type:'POST',
					        url:'/insertar_detalle_venta',
					        datatype: 'json',
					        data: JSON.stringify(parametros),
					        'success': function(objview) {
			
					            console.log('hecho!!');
					            console.log(objview);
					            
					            $.get("/agregar_venta", function(htmlexterno){
					     		   $("#contenedor_venta").html(htmlexterno);
					     		   $("#mensaje_venta_exitosa").modal("show");
					     		   $("#combazo").focus();
					     		   $("#combazo").css("border","solid #2e86de 2px");
					     		    	});
					        },
					        error: function(jqXHR, textStatus, errorThrown) {
					            console.log('error en el metodo de envío');
					        }

					    });
				
				});
	}
	
	
}

