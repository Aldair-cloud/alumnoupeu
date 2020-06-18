$(document).ready(function(){
	listarDat();
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
		$.post("dc",{od:idd,datos:dat,opc5}).done(function(data){
			$("#idd").val(0);
			listarDat();
			limpiar();
		});
	}
});
function listarDat() {
	$.get("dc",{opc:2},function(data){
		data = JSON.parse(data);
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
}