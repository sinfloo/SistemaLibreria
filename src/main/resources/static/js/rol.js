$(document).ready(function(){
	listar();
});

function listar(){ 
	$.post("/lista_todo_roles", function(data){
		var d = JSON.parse(data)
		var j =1;
			$("#tablita").find("tr:gt(0)").remove();
			for(var i= 0; i<d.length;i++){
			$("#tablita").append("<tr><td>"+d[i].idrol+"</td><td>"+j+"</td><td>"+d[i].nombre+"</td><td>"+d[i].descripcion+"</td><td>"+" <input type='button' class='btn btn-success' value='Activo'>"+"</td>"+
			"<td>"+
			"<a href='#' onclick='editar_r("+d[i].idrol+")'><i class='fas fa-pen-nib fa-lg' aria-hidden='true' id='c2'></i></a>"+
			"</td>" +
			"<td>"+
			"<a href='#' onclick='eliminar_r("+d[i].idrol+")'><i class='fas fa-trash-alt fa-lg' aria-hidden='true' id='c2'></i></a>"+
			"</td>" +
			"</tr>");
			j++;
			}
		    $('#tablita tr > *:nth-child(1)').hide();
	});
	}
