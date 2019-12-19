$(document).ready(function(){
	listar(); 
	//$("#idpersona_u").select2();
});

function guardar_u(){
	alert("guardar");
	var idp = $("#idpersona_u").val();
	var user = $("#us").val();
	var pass= $("#pass").val();
	var est= $("#num").val();
	if (idp==0) {
		alert("Falta seleccionar una persona");
		$("#mensaje_falta_persona").modal("show");
	} else {
		$.post('/Guardar_Usuario_Us',{
			user:user,
			pass:pass,
			est:est,
			idp:idp
			},function(data){
				alert(data);
		});
	}
}


function listar(){ 
$.post("/listar_personas", function(data){
	alert(data);
var d = JSON.parse(data)
// $("#combito").find("tr:gt(0)").remove();
for(var i= 0; i<d.length;i++){
$("#idpersona_u").append("<option value="+d[i].idPersona+">"+d[i].nombres+' '+d[i].apellidos+' '+d[i].dni+"</option>");

    }
  });
}