$(document).ready(function(){

});
function guardar_u(){
	alert("guardar");
	var nombre = $("#nom").val();
	var descri= $("#des").val();
	var est= $("#num").val();
	$.post('/Guardar_Departamento_U',{
	nombre:nombre,
	descri:descri,
	est:est
	},function(data){
	   $("#mostrarmodal").modal("show");
	});
	
	}

