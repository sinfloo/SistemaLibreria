$(document).ready(function(){
    		listar();
    		listar_articulos();
    		$('#combazo').select2();
    		$('#combito').select2();
    		var d = new Date();
    		var strDate = d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate();
    		$("#fecha_compra").val(strDate);
    		$("#estado_compra").val("1");
    		$('#estado_compra').prop('disabled', true);
    		$("#alerta_proveedor").css("display", "none");
    		$("#alerta_proveedor_error").css("display", "none");
    	});

function listar(){ 
	$.post("/ListarTodo_Proveedores_Pro", function(data){
		var d = JSON.parse(data)
//			$("#combito").find("tr:gt(0)").remove();
			for(var i= 0; i<d.length;i++){
			$("#combito").append("<option value="+d[i].idproveedor+">"+d[i].razonsocial+'  '+d[i].ruc+'  '+d[i].direccion+"</option>");
			
			}
	});
	}


$(function () {
    $(document).on('click', '.borrar', function (event) {
        event.preventDefault();
        $(this).closest('tr').remove();
    });
});


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
	});
	
	$("#id_article").val(ida);
	$("#modal_carrito #cantidad_add").focus();

}
function añadir_carrito(){
	var ida = $("#id_article").val();
	var cantidad=$("#cantidad_add").val();
	var precio_compra=$("#precio_unitario").val();
	 $("#modal_carrito").modal("hide");
	$.post('/listar_fila_articulo',{
		ida:ida
		},function(data){
			var d = JSON.parse(data)
			
				$("#carrito").append("<tr><td>"+d[0].idArticulos+"</td><td>"+d[0].nombre+"</td><td>"
						+
						cantidad+"</td><td>"+precio_compra+"</td>"
						+
						"<td>"+cantidad*precio_compra+"</td>"
						+
						"<td>"+"<input type='button' class='btn btn-danger borrar' value='Eliminar'"
						+"/></td>"+
						"</tr>");
			  var monto_tt=precio_compra*cantidad;
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
	$("#precio_unitario").val("");
			   
}

/*function seleccionar_tipo_cliente(){
	var idcliente = $("#combazo").val();
	if (idcliente=='Cliente General') {
		$('#combito').prop('disabled', 'disabled');
	} else {
		$('#combito').prop('disabled', false);
	}
}*/

function mostrar_proveedor(){
	var idc=$("#combito").val();
	if(idc != 0){ 
	$("#alerta_proveedor").empty();
	$("#alerta_proveedor").css("display", "block");
	$.post("/Fila_Proveedor_Pro",{ip:idc}, function(data){
		console.log(data)
		var d = JSON.parse(data)
		$("#alerta_proveedor").append("<p>"+'Excelente! elegiste a '+" "+d[0].razonsocial+" "+d[0].ruc+"</p>");
		$("#alerta_proveedor_error").css("display", "none");
		$("#alerta_proveedor_error").empty();
	});
	
	}else{
		$("#alerta_proveedor").empty();
		$("#alerta_proveedor").css("display", "block");
		$("#alerta_proveedor_error").css("display", "none");
		$("#alerta_proveedor_error").empty();
		$("#alerta_proveedor").append("<p style='color:red; font-weight: bold;'>"+' No has seleccionado ningún proveedor' +"</p>");
		// lo que tiene que ver con el color del alert aun no se ha configurado 
	}
}

function registrar_compra(){
	
	var fecha_compra = $("#fecha_compra").val();
	var estado_compra = $("#estado_compra").val();
	var idpp = $("#combito").val();
	var monto_total=$("#montoo").val();
	var tipo = $("#combazo").val();
	var usu = 2;
	if (idpp != 0) {
		
		$.post('/registrar_compra_nueva',{
			fecha_compra:fecha_compra,
			tipo:tipo,
			estado_compra:estado_compra,
			usu:usu,
			idpp:idpp,
			monto_total:monto_total
			
			},function(data){
				console.log("soy el obj de la funcion compra: "+data);
				var f = JSON.parse(data)
		  var idvv=f[0].idcompra;
				console.log("soy la variable idcompra:"+idvv);
			var filas=carrito.rows.length;
				var parametros={};
				  $("#carrito tbody tr").each(function(i,e){
				var tr = {};
				 $(this).find("td").each(function(index, element){
					 name = ""
						 
						 // se definen los cases en base a las columnas de la 
						 // tabla del id #carrito
					 switch(index){
					 
					 case 0:
						 tr["idarticulo"] = $(this).text();
						 break;
					 case 1:
						 tr["idcompra"] =idvv;
						 break;
					 case 2:
						 tr["cantidad"] = $(this).text();
						 break;
					 case 3:
						 tr["precio_unitario"] = $(this).text();
						 break;
					 case 4:
						 tr["subtotal"] = $(this).text();
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
				        url:'/insertar_detalle_compra',
				        datatype: 'json',
				        data: JSON.stringify(parametros),
				        'success': function(objview) {
				            console.log('hecho!!');
				            console.log(objview);
				            $("#mensaje_compra_exitosa").modal("show");
				            $("#carrito").find("tr:gt(0)").remove();
				            $("#combazo").focus();
				        },
				        error: function(jqXHR, textStatus, errorThrown) {
				            console.log('error en el metodo de envío');
				        }

				    });
			
			});
				   
	} else {
			console.log("Se ha verificado que no hay idproveedor ");
			// nos permite mostrar la alerta oculta div 
			
			$("#alerta_proveedor_error").empty();
			$("#alerta_proveedor_error").css("display", "block");
			$("#alerta_proveedor_error").append("<p style='color:red; font-weight: bold;'>"+' No has seleccionado ningún proveedor' +"</p>");
		    $("#combito").focus();
				
		
	}
	
}
