$(document).ready(function(){
	listar();
});

function listar(){ 
	$.post("/ListarTodo_Proveedores_Pro", function(data){
		var d = JSON.parse(data)
		var j =1;
			$("#tablita").find("tr:gt(0)").remove();
			for(var i= 0; i<d.length;i++){
			$("#tablita").append("<tr><td>"+d[i].idproveedor+"</td><td>"+j+"</td><td>"+d[i].tipo+"</td><td>"+d[i].razonsocial+"</td><td>"+d[i].ruc+"</td><td>"+d[i].direccion+"</td><td>"+d[i].telefono+"</td><td>"+" <input type='button' class='btn btn-success' value='Activo'>"+"</td>"+
			"<td>"+
			"<a href='#' onclick='editar_p("+d[i].idproveedor+")'><i class='fas fa-pen-nib fa-lg' aria-hidden='true' id='c2'></i></a>"+
			"</td>" +
			"<td>"+
			"<a href='#' onclick='eliminar_p("+d[i].idproveedor+")'><i class='fas fa-trash-alt fa-lg' aria-hidden='true' id='c2'></i></a>"+
			"</td>" +
			"</tr>");
			j++;
			}
		    $('#tablita tr > *:nth-child(1)').hide();
	});
	}

function eliminar_p(ip){
	$.post('/Delete_Proveedor_Pro',{ip:ip},function(){
		listar();
		$("#ModalEliminar").modal("show");
	});
}

function editar_p(ip){
	$.post('/Fila_Proveedor_Pro',{ip:ip},function(data){
		alert(data);
		var d = JSON.parse(data)
		 $("#tipo").val(d[0].tipo);
		 $("#razonso").val(d[0].razonsocial);
		 $("#ruc").val(d[0].ruc);
		 $("#direc").val(d[0].direccion);
		 $("#telefono").val(d[0].telefono);
		 $("#est").val(d[0].estado);
		 $("#idproveedor").val(d[0].idproveedor);
		 $("#modal_us").modal("show");
		 
	});
		
}
function actualizar_u(){
	var tipo = $("#tipo").val();
	var razonso= $("#razonso").val();
	var ruc = $("#ruc").val();
	var direc = $("#direc").val();
	var telefono = $("#telefono").val();
	var est = $("#est").val();
	var id =  $("#idproveedor").val();
	
	$.post('/Act_Proveedor_pro',{
		tipo:tipo,
		razonso:razonso,
		ruc:ruc,
		direc:direc,
		telefono:telefono,
		est:est,
		id:id
		},function(data){
			alert(data);
		$("#modal_us").modal("hide");
		listar();
	});
}