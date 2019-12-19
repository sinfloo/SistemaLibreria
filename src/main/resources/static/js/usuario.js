$(document).ready(function(){
	listar();
});

function listar(){ 
	$.post("/ListarTodo_Usuario_Us", function(data){
		var d = JSON.parse(data)
		var j =1;
			$("#tablita").find("tr:gt(0)").remove();
			for(var i= 0; i<d.length;i++){
			$("#tablita").append("<tr><td>"+d[i].idusuario+"</td><td>"+j+"</td><td>"+d[i].usuario+"</td><td>"+d[i].password_u+"</td><td>"+" <input type='button' class='btn btn-success' value='Activo'>"+"</td><td>"+d[i].nombres+"</td><td>"+d[i].apellidos+"</td><td>"+d[i].dni+"</td>"+
			"<td>"+
			"<a href='#' onclick='editar_u("+d[i].idusuario+")'><i class='fas fa-pen-nib fa-lg' aria-hidden='true' id='c2'></i></a>"+
			"</td>" +
			"<td>"+
			"<a href='#' onclick='eliminar_u("+d[i].idusuario+")'><i class='fas fa-trash-alt fa-lg' aria-hidden='true' id='c2'></i></a>"+
			"</td>" +
			"</tr>");
			j++;
			}
		    $('#tablita tr > *:nth-child(1)').hide();
	});
	}

function editar_u(idu){
	$.post('/Fila_Usuario_Us',{idu:idu},function(data){
		alert(data);
		var d = JSON.parse(data)
		 $("#idusua").val(d[0].idusuario);
		 $("#nombre_u").val(d[0].usuario);
		 $("#pass_u").val(d[0].password_u);
		 $("#estadoo").val(d[0].estado);
		 $("#idpersona").val(d[0].Persona_idPersona);
		 $("#modal_us").modal("show");
	});
}


function eliminar_u(idu){
	$.post('/Delete_Usuario_Us',{idu:idu},function(){
		listar();
	});
}

function actualizar_u(){
	var idu = $("#idusua").val();
	var user = $("#nombre_u").val();
	var pass= $("#pass_u").val();
	var est= $("#estadoo").val();
	alert("idusua"+idu);
	alert("nombre_u"+user);
	alert("pass_u"+pass);
	alert("estadoo"+est);
	$.post('/Act_Usuario_Us',{
		idu:idu,
		user:user,
		pass:pass,
		est:est
		},function(data){
			alert(data);
		$("#modal_us").modal("hide");
		listar();
	});
}