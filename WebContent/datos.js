$(document).ready(function(){
	
	$.ajax({
		dataType: 'json',
		contentType: 'application/json',
		type:'GET',
		url:'dd',
		success: function(lana){
			console.log(lana);
			for(i=0;i<lana.length;i++){
				console.log(lana[i].apell_nom)
				$("#tablita").append("<tr><td>"+lana[i].iddatos+
						"</td><td>"+lana[i].nombreescuela+
						"</td><td>"+lana[i].apell_nom+
						"</td><td>"+lana[i].correo+
						"</td><td>"+lana[i].telefono+
						"</td><td><a href='#'modificar("+lana[i].iddatos+")'><i class = 'far fa-edit'></i></a></td><td><a href='#' onclick='eliminar("+lana[i].iddatos+"'><i class='far fa-trash-alt'></i></a></td></tr>");
			}
		}
	});
	
	$("#enviar").click(function(){
		var alumno = {
				apell_nom: $("#nombre").val(),
				correo: $("#correo").val(),
				telefono: $("#telefono").val(),
				nombreescuela : $("#dat").val()
			}
		$.ajax({
			dataType:'json',
			type:'POST',
			url:'ac',
			data: alumno,
			success: function(lana){
				console.log(lana);
				console.log(alumno);
				location.reload();
			}
		})
	})
	
	 
});
/*
$.get("dd",function(response){
	console.log(JSON.parse(response));
	let lana = JSON.parse(response);
	for(i=0;i<lana.length;i++){
		console.log(lana[i].apell_nom)
		$("#tablita").append("<tr><td>"+lana[i].iddatos+
				"</td><td>"+lana[i].nombreescuela+
				"</td><td>"+lana[i].apell_nom+
				"</td><td>"+lana[i].correo+
				"</td><td>"+lana[i].telefono+
				"</td><td><a href='#'modificar("+lana[i].iddatos+")'><i class = 'far fa-edit'></i></a></td><td><a href='#' onclick='eliminar("+lana[i].iddatos+"'><i class='far fa-trash-alt'></i></a></td></tr>");
	}
});
$('#enviar').click(function(){
	
});
		
$('#boton').click(function(){
	var dat = $("dat").val();
	var idd = $("idd").val();
	if(idd == o){
		$.post("dc",{escuela:dat,opc:1}).done(function(data){
			$("#idd").val(0);
			listarDat();
			limpiar();
		});
	}else{
		$.post("dd",{od:idd,datos:dat,opc5}).done(function(data){
			$("#idd").val(0);
			listarDat();
			limpiar();
		});
	}
});
function listarDat() {
	$.get("dd",function(data){
		data = JSON.parse(data);
		console.log(data);
		$("#tablita tbody").empty();
		for(i=0;i<dc.length;i++){
			$("#tablita").append("<tr><td>"+dc[i].iddatos+"</td><td>"+dc[i].nombre+"</td><td><a href='#'modificar("+dc[i].iddatos+")'><i class = 'far fa-edit'></i></a></td><td><a href='#' onclick='eliminar("+dc[i].iddatos+"'><i class='far fa-trash-alt'></i></a></td></tr>");
		}
	});
}
function eliminar(id) {
	bootbox.confirm("Desea Eliminar?",function(result){
		if(result){
			bootbox.alert("Registro eliminado carrectamente...!", function(){
				$.get("dc",{id:id,opc:3},function(data){
					listarDat();
				});
			});
		}else{
			bootbox.alert("Registro no se elimino...!")
		}});
}
function modificar(id) {
	$.get("dc",{idd:idd,opc:4},function(data){
		var x = JSON.parse(data);
		$("#dat").val(x.nombre);
		$("#idd").val(x.iddatos);
	});
}*/