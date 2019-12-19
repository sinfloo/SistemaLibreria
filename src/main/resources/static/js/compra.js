$(document).ready(function(){
	listar();
});

function listar(){ 
	$.post("/lista_todas_compras", function(data){
		var d = JSON.parse(data)
		var j =1;
			$("#tablita").find("tr:gt(0)").remove();
			
				for(var i= 0; i<d.length;i++){
					if (d[i].importeTotal != null) {
					$("#tablita").append("<tr><td>"+d[i].idcompra+"</td><td>"+j+"</td><td>"+d[i].fecha+"</td><td style='width:300px;'>"+"S/."+" "+d[i].importeTotal+".00"+"</td><td>"+d[i].tipocomprobante+"</td><td>"+"Activo"+"</td><td>"+d[i].usuario+"</td><td>"+d[i].razonsocial+"</td>" +
					"</tr>");
					j++;
					} else {
						$("#tablita").append("<tr><td>"+d[i].idcompra+"</td><td>"+j+"</td><td>"+d[i].fecha+"</td><td style='width:300px;'>"+"faltan"+"</td><td>"+d[i].tipocomprobante+"</td><td>"+"Activo"+"</td><td>"+d[i].usuario+"</td><td>"+d[i].razonsocial+"</td>" +
						"</tr>");
						j++;
					}
					}
			
		    $('#tablita tr > *:nth-child(1)').hide();
	});
	}
