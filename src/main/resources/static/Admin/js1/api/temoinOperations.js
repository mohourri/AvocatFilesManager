// recuperer les infos de victime

function loadTemoinInfos(event){
	event.preventDefault();
   var cinTemoin = $("#liste_temoins_info").val();
  $.ajax({
		type: "GET",
		url: "consulterDossier/Temoin/"+cinTemoin,
		processData: false,
		contentType: false,
		cache: false,
		timeout: 600000,
		success: function (data){
			
			$('#field_temoin_info').css('display', 'block');
		
			$("#cni_temoin_info").val(data["temoin"]["cinTemoin"]);
			$("#prenom_temoin_info").val(data["temoin"]["prenom"]);
			$("#nom_temoin_info").val(data["temoin"]["nom"]);
			$("#etat_social_temoin_info").val(data["temoin"]["situation"]);
			$("#job_temoin_info").val(data["temoin"]["proffession"]);
			$("#sexe_temoin_info").val(data["temoin"]["sexe"]);
			$("#date_naissance_temoin_info").val(data["dateNaissance"]);
			$("#lieu_naissance_temoin_info").val(data["temoin"]["lieuNaissance"]);
			$("#pere_temoin_info").val(data["temoin"]["prenomPere"]);
			$("#mere_temoin_info").val(data["temoin"]["prenomMere"]);
			$("#addresse_temoin_info").val(data["temoin"]["addresse"]);
			
			$("#cni_temoin_up").val(data["temoin"]["cinTemoin"]);
			$("#prenom_temoin_up").val(data["temoin"]["prenom"]);
			$("#nom_temoin_up").val(data["temoin"]["nom"]);
			$("#etat_social_temoin_up").val(data["temoin"]["situation"]);
			$("#job_temoin_up").val(data["temoin"]["proffession"]);
			$("#sexe_temoin_up").val(data["temoin"]["sexe"]);
			$("#date_naissance_temoin_up").val(data["dateNaissance"]);
			$("#lieu_naissance_temoin_up").val(data["temoin"]["lieuNaissance"]);
			$("#pere_temoin_up").val(data["temoin"]["prenomPere"]);
			$("#mere_temoin_up").val(data["temoin"]["prenomMere"]);
			$("#addresse_temoin_up").val(data["temoin"]["addresse"]);
			
			
		},
		error: function (e){

		}
	});
}



// modifier le temoin

function updateTemoin(event){
		event.preventDefault();
		var formData = new FormData();
		
		formData.append("cni_temoin", $("#cni_temoin_up").val());
		formData.append("prenom_temoin", $("#prenom_temoin_up").val());
		formData.append("nom_temoin",$("#nom_temoin_up").val());
		formData.append("etat_social_temoin",$("#etat_social_temoin_up").val());
		formData.append("job_temoin",$("#job_temoin_up").val());
		formData.append("sexe_temoin",$("#sexe_temoin_up").val());
		formData.append("date_naissance_temoin",$("#date_naissance_temoin_up").val());
		formData.append("lieu_naissance_temoin",$("#lieu_naissance_temoin_up").val());
		formData.append("pere_temoin",$("#pere_temoin_up").val());
		formData.append("mere_temoin",$("#mere_temoin_up").val());
		formData.append("addresse_temoin",$("#addresse_temoin_up").val());
		
		$.ajax({
			type: "POST",
			url: "consulterDossier/updateTemoin",
			processData: false,
			contentType: false,
			cache: false,
			data : formData,
			timeout: 600000,
			success: function (data){
	             if(data["message"]["error"]=="success"){
	             	
					$("#prenom_temoin").val(data["temoin"]["prenom"]);
					$("#nom_temoin").val(data["temoin"]["nom"]);
					$("#etat_social_temoin").val(data["temoin"]["situation"]);
					$("#job_temoin").val(data["temoin"]["proffession"]);
					$("#sexe_temoin").val(data["temoin"]["sexe"]);
					$("#date_naissance_temoin").val(data["dateNaissance"]);
					$("#lieu_naissance_temoin").val(data["temoin"]["lieuNaissance"]);
					$("#pere_temoin").val(data["temoin"]["prenomPere"]);
					$("#mere_temoin").val(data["temoin"]["prenomMere"]);
					$("#addresse_temoin").val(data["temoin"]["addresse"]);
					
					var success = data["message"]["message"];
		            $("#updateTemoinModalBody").empty();
					$("#updateTemoinModalBody").append(success);
					
					var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"consulterDossier\">حفظ</a>";
					$("#updateTemoinModalBtn").empty();
					$("#updateTemoinModalBtn").append(btn);
					
	             } else if(data[0]["error"]=="error"){
	             	var error = data["message"]["message"];
		            $("#updateTemoinModalBody").empty();
					$("#updateTemoinModalBody").append(error);
					 
					var btn = "<a type=\"button\" class=\"btn btn-danger\" href=\"consulterDossier\">اعادة المحاولة</a>";
					$("#updateTemoinModalBtn").empty();
					$("#updateTemoinModalBtn").append(btn);
	             }
				
			},
			error: function (e){
	
			}
		})
}






// ajouter un temoin

function addTemoin(event){
		event.preventDefault();
		var formData = new FormData();
		
		formData.append("cni_temoin", $("#cni_temoin").val());
		formData.append("prenom_temoin", $("#prenom_temoin").val());
		formData.append("nom_temoin",$("#nom_temoin").val());
		formData.append("etat_social_temoin",$("#etat_social_temoin").val());
		formData.append("job_temoin",$("#job_temoin").val());
		formData.append("sexe_temoin",$(".sexe_temoin:checked").val());
		formData.append("date_naissance_temoin",$("#date_naissance_temoin").val());
		formData.append("lieu_naissance_temoin",$("#lieu_naissance_temoin").val());
		formData.append("pere_temoin",$("#pere_temoin").val());
		formData.append("mere_temoin",$("#mere_temoin").val());
		formData.append("addresse_temoin",$("#addresse_temoin").val());
		formData.append("numero_dossier",$("#numero_dossier").val());
		
		for (var value of formData.values()) {
		   console.log(value);
		}
		
		$.ajax({
			type: "POST",
			url: "consulterDossier/addTemoin",
			processData: false,
			contentType: false,
			cache: false,
			data : formData,
			timeout: 600000,
			success: function (data){
	             if(data["message"]["error"]=="success"){
	             	console.log("helo1");
	             	console.log(data["temoin"]);
	             	console.log("helo2");
	             	$("#cni_temoin").val(data["temoin"]["cinTemoin"]);
					$("#prenom_temoin").val(data["temoin"]["prenom"]);
					$("#nom_temoin").val(data["temoin"]["nom"]);
					$("#etat_social_temoin").val(data["temoin"]["situation"]);
					$("#job_temoin").val(data["temoin"]["proffession"]);
					$("#sexe_temoin").val(data["temoin"]["sexe"]);
					$("#date_naissance_temoin").val(data["dateNaissance"]);
					$("#lieu_naissance_temoin").val(data["temoin"]["lieuNaissance"]);
					$("#pere_temoin").val(data["temoin"]["prenomPere"]);
					$("#mere_temoin").val(data["temoin"]["prenomMere"]);
					$("#addresse_temoin").val(data["temoin"]["addresse"]);
					
	             } else if(data[0]["error"]=="error"){
	             
	             }
				
			},
			error: function (e){
	
			}
		})
}






// Supprimer un temoin

function deleteTemoin(event){
   event.preventDefault();
   var formData = new FormData();
   formData.append("cin_temoin", $("#liste_temoins_info").val());
   formData.append("numero_dossier", $("#numero_dossier").val());
   
   $.ajax({
		type: "POST",
		url: "consulterDossier/deleteTemoin",
		processData: false,
		contentType: false,
		cache: false,
		data : formData,
		timeout: 600000,
		success: function (data){
		    if(data["error"]=="success"){
		    
             var success = data["message"];
             $("#deleteTemoinModalBody").empty();
			$("#deleteTemoinModalBody").append(success);
			
			var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"consulterDossier\">حفظ</a>";
			$("#deleteTemoinModalBtn").empty();
			$("#deleteTemoinModalBtn").append(btn);
			
             } else{
             
             var error = data["message"];
             $("#deleteTemoinModalBody").empty();
			 $("#deleteTemoinModalBody").append(error);
			 
			 var btn = "<a type=\"button\" class=\"btn btn-danger\" href=\"consulterDossier\">اعادة المحاولة</a>";
			 $("#deleteTemoinModalBtn").empty();
			 $("#deleteTemoinModalBtn").append(btn);
             
             }
		},
		error: function (e){
			alert("Error");
		}
	});
}