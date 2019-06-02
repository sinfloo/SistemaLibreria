$(document).ready(function(){
	$("#nombre_articulo").focus();
});

function guardar(){
	var nombre_articulo = $("#nombre_articulo").val();
	var descripcion_articulo = $("#descripcion_articulo").val();
	var estado_articulo = $("#estado_articulo").val();
	var stock= $("#stock_articulo").val();
	var stock_minimo= $("#stock_minimo_articulo").val();
	var precio_compra= $("#precio_compra_articulo").val();
	var precio_venta= $("#precio_venta_articulo").val();
	alert("dentro del guardar");
	var iddepartamento = $("#iddepartamento_template").val();
	alert("soy el iddepa"+iddepartamento);

	if (iddepartamento===0) {
		alert("Falta seleccionar un departamento");
	} else {
		$.post('/guardar_articulo_nuevo',{
			nom_art:nombre_articulo,
			des_art:descripcion_articulo,
			est_art:estado_articulo,
			stock:stock,
			stock_minimo:stock_minimo,
			precio_compra:precio_compra,
			precio_venta:precio_venta,
			idd:iddepartamento
			},function(data){
				alert(data);
				$("#nombre_articulo").val("");
				$("#descripcion_articulo").val("");
				$("#estado_articulo").val("");
				$("#stock_minimo_articulo").val("");
				$("#precio_compra_articulo").val("");
				$("#precio_venta_articulo").val("");
				$("#iddepartamento_template").val("");
				$("#stock_articulo").val("");

				$("#nombre_articulo").focus();
				
		});
	}
}
