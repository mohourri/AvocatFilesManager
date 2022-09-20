// recuperer les infos de victime

function loadVictimeInfos(event){
	event.preventDefault();
   var idVictime = $("#liste_victimes_info").val();
   
  $.ajax({
		type: "GET",
		url: "consulterDossier/Victime/"+idVictime,
		processData: false,
		contentType: false,
		cache: false,
		timeout: 600000,
		success: function (data){
			
			$('#field_victime_info').css('display', 'block');
		
			$("#cni_victime_info").val(data["victime"]["cin"]);
			$("#nom_victime_info").val(data["victime"]["nom"]);
			$("#prenom_victime_info").val(data["victime"]["prenom"]);
			$("#etat_social_victime_info").val(data["victime"]["situationFamiliale"]);
			$("#nombre_enfants_victime_info").val(data["victime"]["nombreEnfant"]);
			$("#salaire_annuel_victime_info").val(data["victime"]["salaire"]);
			$("#date_naissance_victime_info").val(data["dateNaissance"]);
			$("#job_victime_info").val(data["victime"]["proffession"]);
			$("#lieu_naissance_victime_info").val(data["victime"]["lieuNaissance"]);
			$("#sexe_victime_info").val(data["victime"]["sexe"]);
			$("#pere_victime_info").val(data["victime"]["prenomPere"]);
			$("#mere_victime_info").val(data["victime"]["prenomMere"]);
			$("#addresse_victime_info").val(data["victime"]["addresse"]);
			$("#etat_victime_info").val(data["victime"]["etat"]);
			
			if(data["victime"]["etat"] == "ميت"){
				$('#field_table_dawi_info').css('display', 'block');
				$("#table_dawi_body").empty();
				for (let i = 0; i < data["dawis"].length; i++){
					var dawi_element = '<tr><td>'+data["indemnites"][i]["coteFamille"]+'</td><td>'+data["dawis"][i]["prenom"]+'</td><td>'+data["dawis"][i]["nom"]+'</td><td>'+data["indemnites"][i]["ha9Ta3wid"]+'</td></tr>';
					$("#table_dawi_body").append(dawi_element);
				}
				
				
			}else{
				$("#table_dawi_body").empty();
				$('#field_table_dawi_info').css('display', 'none');
			}
			
			if(data["avocats"].length != 0){
			
				$('#field_table_avocat_victime_info').css('display', 'block');
				$("#table_avocat_victime_body").empty();
				for (let i = 0; i < data["avocats"].length; i++){
					
					var barreau;
					
					switch(data["avocats"][i]["haya"]){
						case 10:
							barreau = "هيئة المحامين بتازة";
							break;
						case 11:
							barreau = "هيئة المحامين بآسفي";
							break;
						case 12:
							barreau = "هيئة المحامين ببني ملال";
							break;
						case 13:
							barreau = "هيئة المحامين بتطوان";
							break;
						case 14:
							barreau = "هيئة المحامين بالجديدة";
							break;
						case 15:
							barreau = "هيئة المحامين بخريبكة";
							break;
						case 16:
							barreau = "هيئة المحامين بالدار البيضاء";
							break;
						case 17:
							barreau = "هيئة المحامين بالرباط ";
							break;
						case 18:
							barreau = "هيئة المحامين بطنجة";
							break;
						case 19:
							barreau = "هيئة المحامين بمكناس";
							break;
						case 20:
							barreau = "هيئة المحامين بالناظور";
							break;
						case 21:
							barreau = "هيئة المحامين بفاس";
							break;
						case 22:
							barreau = "هيئة المحامين بالقنيطرة";
							break;
						case 23:
							barreau = "هيئة المحامين بسطات";
							break;
						case 24:
							barreau = "هيئة المحامين بوجدة";
							break;
						case 25:
							barreau = "هيئة المحامين بمراكش";
							break;
						case 26:
							barreau = "هيئة المحامين بأكاير والعيون";
							break;
						default:
					    	barreau = "";
					}
					
					var avocat_element = '<tr><td>'+data["avocats"][i]["cin"]+'</td><td>'+data["avocats"][i]["prenom"]+'</td><td>'+data["avocats"][i]["nom"]+'</td><td>'+barreau+'</td></tr>';
					$("#table_avocat_victime_body").append(avocat_element);
				}
				
			}else{
				$("#table_avocat_victime_body").empty();
				$('#field_table_avocat_victime_info').css('display', 'none');
			}
			
			//Modal Modify Victime
			
			$("#cni_victime_up").val(data["victime"]["cin"]);
			$("#nom_victime_up").val(data["victime"]["nom"]);
			$("#prenom_victime_up").val(data["victime"]["prenom"]);
			$("#etat_social_victime_up").val(data["victime"]["situationFamiliale"]);
			$("#nombre_enfants_victime_up").val(data["victime"]["nombreEnfant"]);
			$("#salaire_annuel_victime_up").val(data["victime"]["salaire"]);
    		console.log("data type of this date is : "+data["dateNaissance"]);
			$("#date_naissance_victime_up").val(data["dateNaissance"]);
			$("#job_victime_up").val(data["victime"]["proffession"]);
			$("#lieu_naissance_victime_up").val(data["victime"]["lieuNaissance"]);
			$("#sexe_victime_up").val(data["victime"]["sexe"]);
			$("#pere_victime_up").val(data["victime"]["prenomPere"]);
			$("#mere_victime_up").val(data["victime"]["prenomMere"]);
			$("#addresse_victime_up").val(data["victime"]["addresse"]);
			$("#etat_victime_up").val(data["victime"]["etat"]);
			
		},
		error: function (e){

		}
	});
}



// modifier le victime

function updateVictime(event){
		
		event.preventDefault();
		var formData = new FormData();
		formData.append("id_victime", $("#liste_victimes_info").val());
		
		formData.append("cni_victime",$("#cni_victime_up").val());
		formData.append("prenom_victime",$("#prenom_victime_up").val());
		formData.append("nom_victime",$("#nom_victime_up").val());
		formData.append("etat_social_victime",$("#etat_social_victime_up").val());
		formData.append("nombre_enfants_victime",$("#nombre_enfants_victime_up").val());
		formData.append("salaire_annuel_victime",$("#salaire_annuel_victime_up").val());
		formData.append("date_naissance_victime",$("#date_naissance_victime_up").val());
		formData.append("job_victime",$("#job_victime_up").val());
		formData.append("lieu_naissance_victime",$("#lieu_naissance_victime_up").val());
		formData.append("pere_victime",$("#pere_victime_up").val());
		formData.append("mere_victime",$("#mere_victime_up").val());
		formData.append("addresse_victime",$("#addresse_victime_up").val());
		formData.append("etat_victime",$("#etat_victime_up").val());
		
		$.ajax({
			type: "POST",
			url: "consulterDossier/updateVictime",
			processData: false,
			contentType: false,
			cache: false,
			data : formData,
			timeout: 600000,
			success: function (data){
	             if(data["message"]["error"]=="success"){
	             
					$("#cni_victime").val(data["victime"]["cin"]);
					$("#nom_victime").val(data["victime"]["nom"]);
					$("#prenom_victime").val(data["victime"]["prenom"]);
					$("#etat_social_victime").val(data["victime"]["situationFamiliale"]);
					$("#nombre_enfants_victime").val(data["victime"]["nombreEnfant"]);
					$("#salaire_annuel_victime").val(data["victime"]["salaire"]);
					$("#date_naissance_victime").val(data["dateNaissance"]);
					$("#job_victime").val(data["victime"]["proffession"]);
					$("#lieu_naissance_victime").val(data["victime"]["lieuNaissance"]);
					$("#pere_victime").val(data["victime"]["prenomPere"]);
					$("#mere_victime").val(data["victime"]["prenomMere"]);
					$("#addresse_victime").val(data["victime"]["addresse"]);
					$("#etat_victime").val(data["victime"]["etat"]);
					
					var success = data["message"]["message"];
		            $("#updateVictimeModalBody").empty();
					$("#updateVictimeModalBody").append(success);
					
					var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"consulterDossier\">حفظ</a>";
					$("#updateVictimeModalBtn").empty();
					$("#updateVictimeModalBtn").append(btn);
	             } else if(data["message"]["error"]=="error"){
	             	var error = data["message"]["message"];
		            $("#updateVictimeModalBody").empty();
					$("#updateVictimeModalBody").append(error);
					 
					var btn = "<a type=\"button\" class=\"btn btn-danger\" href=\"consulterDossier\">اعادة المحاولة</a>";
					$("#updateVictimeModalBtn").empty();
					$("#updateVictimeModalBtn").append(btn);
	             }
				
			},
			error: function (e){
	
			}
		})
}

// Supprimer un victime

function deleteVictime(event){
   event.preventDefault();
   var formData = new FormData();
   formData.append("id_victime", $("#liste_victimes_info").val());
   formData.append("numero_dossier", $("#numero_dossier").val());
   
   $.ajax({
		type: "POST",
		url: "consulterDossier/deleteVictime",
		processData: false,
		contentType: false,
		cache: false,
		data : formData,
		timeout: 600000,
		success: function (data){
		    if(data["error"]=="success"){
		    
             var success = data["message"];
             $("#deleteVictimeModalBody").empty();
			$("#deleteVictimeModalBody").append(success);
			
			var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"consulterDossier\">حفظ</a>";
			$("#deleteVictimeModalBtn").empty();
			$("#deleteVictimeModalBtn").append(btn);
			
             } else{
             
             var error = data["message"];
             $("#deleteVictimeModalBody").empty();
			 $("#deleteVictimeModalBody").append(error);
			 
			 var btn = "<a type=\"button\" class=\"btn btn-danger\" href=\"consulterDossier\">اعادة المحاولة</a>";
			 $("#deleteVictimeModalBtn").empty();
			 $("#deleteVictimeModalBtn").append(btn);
             
             }
		},
		error: function (e){
			alert("Error");
		}
	});
}