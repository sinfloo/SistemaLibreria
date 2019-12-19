$(document).ready(function(){
	listar();
	var d = new Date();
	var strDate = d.getFullYear() + "/" + (d.getMonth()+1) + "/" + d.getDate();
	$("#fecha_orden").val(strDate);
});

function listar(){ 
	$.post("/lista_todos_articulos", function(data){
		var d = JSON.parse(data)
		var j =1;
			$("#tablita").find("tr:gt(0)").remove();
			
				for(var i= 0; i<d.length;i++){
					var prod_bajolim = 0;
					var prod_faltant = 0;
					if (d[i].estado != 0 && d[i].stock <= 10 && d[i].stock > 0) {
						
					$("#tablita").append("<tr><td>"+d[i].idArticulos+"</td><td>"+j+"</td><td>"+d[i].nombre+"</td><td>"+'Activo'+"</td><td>"+d[i].stock+"</td><td>"+"<button type='button' class='btn btn-warning'>Bajo Límite</button>"+"</td>" +
					"</tr>");
					j++;
					prod_bajolim ++;
					} else if(d[i].estado != 0 && d[i].stock == 0) {
						$("#tablita").append("<tr><td>"+d[i].idArticulos+"</td><td>"+j+"</td><td>"+d[i].nombre+"</td><td>"+'Activo'+"</td><td>"+d[i].stock+"</td><td>"+"<button type='button' class='btn btn-danger'>Faltante</button>"+"</td>" +
								"</tr>");
						j++;
						prod_faltant ++;
					}
					var total_bajolimite = $("#productos_bajolimite").val();
					var total_faltantes = $("#productos_faltantes").val();

					if (total_bajolimite=="" && total_faltantes=="") {
						   
							$("#productos_bajolimite").val(prod_bajolim);
							$("#productos_faltantes").val(prod_faltant);
					} else {
						  var multi = parseFloat(prod_bajolim) + parseFloat(total_bajolimite);
						  var falta = parseFloat(total_faltantes) + parseFloat(prod_faltant)
							$("#productos_bajolimite").val(multi);
						    $("#productos_faltantes").val(falta);
					}
					}
		    $('#tablita tr > *:nth-child(1)').hide();
	});
	}
