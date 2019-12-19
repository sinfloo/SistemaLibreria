$(document).ready(function(){
	$("#estado_cierre").val(1);
});

function fechas(){
	console.log("soy el buscador de monto total por fechas");
	var fecha_init = $("#date_inicio").val();
	var fecha_fin = $("#date_fin").val();
	
	$.get("quieroMontoFechas",{fecha_init:fecha_init,fecha_fin:fecha_fin},function(data){
		var d = JSON.parse(data)
		console.log(data);
		$("#monto_total").val(d[0].montoo);
	});
}

function guardar_cierre(){
	var f1 = $("#date_inicio").val();
	var f2 = $("#date_fin").val();
	var monto = $("#monto_total").val();
	var estado = $("#estado_cierre").val();
	var us = 2;
	var monto_prueba = 200;
	$.post('quieroCerrar',{ 
		monto:monto_prueba,
		f1:f1,
		f2:f2,
		us:us,
		estado:estado
	},	
				 function(obj){
				console.log(obj);
	     $("#date_inicio").val("");
	     $("#date_fin").val("");
	     $("#monto_total").val("");
	});
	
}