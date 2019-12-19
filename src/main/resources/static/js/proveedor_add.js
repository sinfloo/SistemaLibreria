$(document).ready(function() {
	$("#tipo").focus();
	$("#est").val("1");
});

function validar_campos_vacios(){
	console.log("dentro de validar campos vacios");
		 //obteniendo el valor que se puso en el campo tipo
		 var tipop = document.getElementById("tipo").value;
		 //la condición
		 if (tipop.length == 0 || /^\s+$/.test(tipop)) {
			 $(".class").append("<div class='alert alert-danger' role='alert'>"+"El campo del tipo de proveedor es requerido"+"</div>");
			 $("#tipo").focus();
		     return false;
		 }
		 return true;
}

function validar_campos_vacios1(){
	 //obteniendo el valor que se puso en el campo razon social 
	 var razonsol = document.getElementById("razonso").value;
	 //la condición
	 if (razonsol.length == 0 || /^\s+$/.test(razonsol)) {
		 $("#razonso").append("<div class='alert alert-danger' role='alert'>"+"El campo de la razon social es requerido"+"</div>");
		 $("#razonso").focus();
	     return false;
	 }
	 return true;
}
function validar_campos_vacios2(){
	//obteniendo el valor que se puso en el campo rucc 
	 var rucc = document.getElementById("ruc").value;
	 //la condición
	 if (rucc.length == 0 || /^\s+$/.test(rucc)) {
		 $("#ruc").append("<div class='alert alert-danger' role='alert'>"+"El campo ruc es requerido"+"</div>");
		 //$("#ruc").focus();
	     return false;
	 }
	 return true;
}

function validar_campos_vacios3(){
	//obteniendo el valor que se puso en el campo direccion 
	 var direcc = document.getElementById("direc").value;
	 //la condición
	 if (direcc.length == 0 || /^\s+$/.test(direcc)) {
		 $("#direc").append("<div class='alert alert-danger' role='alert'>"+"El campo dirección es requerido"+"</div>");
		 $("#direc").focus();
	     return false;
	 }
	 return true;
}

function validar_campos_vacios4(){
	//obteniendo el valor que se puso en el campo telefono 
	 var telefonot = document.getElementById("telefono").value;
	 //la condición
	 if (telefonot.length == 0 || /^\s+$/.test(telefonot)) {
		 $("#telefono").append("<div class='alert alert-danger' role='alert'>"+"El campo teléfono es requerido"+"</div>");
		 $("#telefono").focus();
	     return false;
	 }
	 return true;
}

function guardar_p() {
	/*if (validar_campos_vacios() == false) {
		console.log("lo siento, intentalo nuevamente");
		console.log(validar_campos_vacios())
	} else {
		console.log("vamos, a continuar")
	}*/
	var tipo = $("#tipo").val();
	var razonso = $("#razonso").val();
	var ruc = $("#ruc").val();
	var direc = $("#direc").val();
	var telefono = $("#telefono").val();
	var est = $("#est").val();

	$.post('/guardar_proveedor_nuevo', {
		tipo : tipo,
		razonso : razonso,
		ruc : ruc,
		direc : direc,
		telefono : telefono,
		est : est
	}, function(data) {
		console.log(data)
		
		switch (data) {
		case "1":
			$("#tipo").val("");
			$("#razonso").val("");
			$("#ruc").val("");
			$("#direc").val("");
			$("#telefono").val("");
			$("#est").val("");
			$("#tipo").focus();
			$(".error").append("<div class='alert alert-success' role='alert'>"+"Proveedor Registrado satisfactoriamente"+"</div>");
			
			break;

		case "error en el controlador":
			$(".error").append("<div class='alert alert-danger' role='alert'>"+"Por favor complete todos los campos, NO se ha registrado al proveedor"+"</div>");
			break;
		}

	});
	

}




