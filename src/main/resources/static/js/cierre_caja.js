$(document).ready(function(){
	listar();
});

function listar(){ 
	$.post("/lista_cierre_caja", function(obj){
		var d = JSON.parse(obj)
		var j =1;
			$("#tablita").find("tr:gt(0)").remove();
			
				for(var i= 0; i<d.length;i++){
					if (d[i].estado != 0) {
					$("#tablita").append("<tr><td>"+d[i].idcierre_caja+"</td><td>"+j+"</td><td>"+d[i].fecha_cierre+"</td><td style='width:300px;'>"+d[i].monto_total+"</td><td>"+'Activo'+"</td><td>"+d[i].estado+"</td><td>"+d[i].usuario+"</td>" +
					"</tr>");
					j++;
					} else {
						$("#tablita").append("<tr><td>"+d[i].idcierre_caja+"</td><td>"+j+"</td><td>"+d[i].fecha_cierre+"</td><td>"+d[i].monto_total+"</td><td>"+'Inactivo'+"</td><td>"+d[i].estado+"</td><td>"+d[i].usuario+"</td>" +
								"</tr>");
					}
					}
			
		    $('#tablita tr > *:nth-child(1)').hide();
	});
	}
