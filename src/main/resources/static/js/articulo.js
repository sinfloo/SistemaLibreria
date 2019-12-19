$(document).ready(function(){
	listar();
	$.get("/cargar_busqueda", function(htmlexterno){
		   $("#searchText").html(htmlexterno);
		    	});
		});

function listar(){ 
	$.post("/lista_todos_articulos", function(data){
		var d = JSON.parse(data)
		var j =1;
			$("#tablita").find("tr:gt(0)").remove();
			
				for(var i= 0; i<d.length;i++){
					if (d[i].estado != 0) {
					$("#tablita").append("<tr><td>"+d[i].idArticulos+"</td><td>"+j+"</td><td>"+d[i].nombre+"</td><td style='width:300px;'>"+d[i].descripcion+"</td><td>"+'Activo'+"</td><td>"+d[i].stock+"</td><td>"+"S/."+" "+d[i].precio_venta+".00"+"</td>" +
					"<td>"+
					"<a href='#' onclick='editar_u("+d[i].idArticulos+")'><i class='fas fa-pen-nib fa-lg' aria-hidden='true' id='c2'></i></a>"+
					"</td>" +
					"<td>"+
					"<a href='#' onclick='eliminar_u("+d[i].idArticulos+")'><i class='fas fa-trash-alt fa-lg' aria-hidden='true' id='c2'></i></a>"+
					"</td>" +
					"</tr>");
					j++;
					} else {
						$("#tablita").append("<tr><td>"+d[i].idArticulos+"</td><td>"+j+"</td><td>"+d[i].nombre+"</td><td>"+d[i].descripcion+"</td><td>"+'Inactivo'+"</td><td>"+d[i].stock+"</td><td>"+"S/."+" "+d[i].precio_venta+".00"+"</td>" +
								"<td>"+
								"<a href='#' onclick='editar_u("+d[i].idArticulos+")'><i class='fas fa-pen-nib fa-lg' aria-hidden='true' id='c2'></i></a>"+
								"</td>" +
								"<td>"+
								"<a href='#' onclick='eliminar_u("+d[i].idArticulos+")'><i class='fas fa-trash-alt fa-lg' aria-hidden='true' id='c2'></i></a>"+
								"</td>" +
								"</tr>");
						j++;
					}
					}
			
		    $('#tablita tr > *:nth-child(1)').hide();
	});
	}
