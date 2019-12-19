$(document).ready(function() {
	$("#ruc").focus();
	$(".alert-success").css("display", "none");
	$(".alert-danger").css("display", "none");
});


function validar_prov(){
	console.log("dentro de validar proveedor ")
	var rucc = $("#ruc").val();
	$.post('/validar_proveedor_ruc', {
		ruc : rucc
	}, function(data) {
		console.log(data)
			var d = JSON.parse(data)
			if(Object.entries(d).length===0){
				
				$(".alert-danger").css("display", "block");
				$(".alert-success").css("display", "none");
			}else{
				$("#new_provider").focus();
				$(".alert-success").css("display", "block");
				$(".alert-danger").css("display", "none");
			}

	});
}