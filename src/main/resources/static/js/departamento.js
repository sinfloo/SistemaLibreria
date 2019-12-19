$(document).ready(function(){
	listar();
});

function listar(){ 
	$.post("/lista_todos_departamento", function(data){
		var d = JSON.parse(data)
		var j =1;
			$("#tablita").find("tr:gt(0)").remove();
			for(var i= 0; i<d.length;i++){
			$("#tablita").append("<tr><td>"+d[i].iddepartamento+"</td><td>"+j+"</td><td>"+d[i].dep_nombre+"</td><td>"+d[i].descripcion+"</td><td>"+d[i].estado+"</td>"+
			"<td>"+
			"<a href='#' onclick='editar_u("+d[i].iddepartamento+")'><i class='fas fa-pen-nib fa-lg' aria-hidden='true' id='c2'></i></a>"+
			"</td>" +
			"<td>"+
			"<a href='#' onclick='eliminar_u("+d[i].iddepartamento+")'><i class='fas fa-trash-alt fa-lg' aria-hidden='true' id='c2'></i></a>"+
			"</td>" +
			"</tr>");
			j++;
			}
		    $('#tablita tr > *:nth-child(1)').hide();
	});
	}
function save(){
	var nr = $("#save_departamento").val();
	$.post('save',{departamento:nr},function(){
		$("#exampleModal").modal("hide");
		listarDepartamento();
	});
}

function eliminar_u(iddep){
	$.post('/Delete_Departamento_U',{iddep:iddep},function(){
	listar();
	$("#eliminarmodal").modal("show");
	});
	}

function editar_u(iddep){
	$.post('/Fila_Departamento_U',{iddep:iddep},function(data){
	alert(data);
	var d = JSON.parse(data)
	$("#iddepartamento").val(d[0].iddepartamento);
	$("#nombre").val(d[0].dep_nombre);
	$("#descripcion").val(d[0].descripcion);
	$("#estadoo").val(d[0].estado);
	$("#modal_us").modal("show");
	});
	}

function actualizar_u(){
	var iddep = $("#iddepartamento").val();
	var nombre = $("#nombre").val();
	var descri= $("#descripcion").val();
	var est= $("#estadoo").val();
    $.post('/Act_Departamento_U',{
	iddep:iddep,
	nombre:nombre,
	descri:descri,
	est:est
	},function(data){
		$("#modal_us").modal("hide");
	listar();
	$("#actualizarmodal").modal("show");
	});
	}

