// Recuperer toutes les tribunals

function loadDossiers(val){

	event.preventDefault();
   var numeroDossier = $("#numero_dossier").val();
	
  $.ajax({
		type: "GET",
		url: "consulterDossier/Dossier/"+numeroDossier,
		processData: false,
		contentType: false,
		cache: false,
		timeout: 600000,
		success: function (data){
		
			//infos dossier
		    $("#date_accident").val(data["dateAccident"]);
		    $("#date_dossier").val(data["dateDossier"]);
		    $("#date_seance").val(data["dateSeance"]);
		    $("#tribunal").val(data["dossier"]["tribunal"]);
		    $("#remarque").val(data["dossier"]["commentaire"]);
		    
		    //infos victimes
		    var victimes = data["victimes"];
		    var html = "<option disabled selected>اختر ضحية</option>";
		    for (const key in victimes){
            html = html +"<option value=\""+ victimes[key]["id"]+"\">"+ victimes[key]["prenom"] + " "+victimes[key]["nom"] +"</option>";
         	}
			$("#liste_victimes").empty();
			$("#liste_victimes").append(html);
			
			
			// vider les champs
			$('#field_victime').css('display', 'none');
			$('#field_table_dawi').css('display', 'none');
			$('#field_avocat_victime').css('display', 'none');
			
			
			
			//infos accuses
			console.log(data["accuses"])
		    var accuses = data["accuses"];
		    var html = "<option disabled selected>اختر متهم</option>";
		    for (const key in accuses){
            html = html +"<option value=\""+ accuses[key]["id"]+"\">"+ accuses[key]["prenom"] + " "+accuses[key]["nom"] +"</option>";
         	}
			$("#liste_accuses").empty();
			$("#liste_accuses").append(html);
			
			
			// vider les champs
			$('#field_accuse').css('display', 'none');
			$('#field_officier_civil').css('display', 'none');
			$('#field_avocat_accuse').css('display', 'none');
		    
		    
		},
		error: function (e){

		}
	});

}


// Modifier la remarque d'une dossier

function addRemarqueEvent(event){
   event.preventDefault();
   var formData = new FormData();
   formData.append("numeroDossier",$("#numero_dossier").val());
   formData.append("remarqueDossier",$("#remarque_dossier").val());
   $.ajax({
		type: "POST",
		url: "consulterDossier/ajouterRemarque",
		processData: false,
		contentType: false,
		cache: false,
		data : formData,
		timeout: 600000,
		success: function (data){
		    if(data[0]["error"]=="success"){
		    
             var success = data[0]["message"];
             $("#rmqDossierModalBody").empty();
			$("#rmqDossierModalBody").append(success);
			
			var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"consulterDossier\">حفظ</a>";
			$("#rmqDossierModalBtn").empty();
			$("#rmqDossierModalBtn").append(btn);
			
             } else{
             
             var error = data[0]["message"];
             $("#rmqDossierModalBody").empty();
			 $("#rmqDossierModalBody").append(error);
			 
			 var btn = "<a type=\"button\" class=\"btn btn-danger\" href=\"consulterDossier\">اعادة المحاولة</a>";
			 $("#rmqDossierModalBtn").empty();
			 $("#rmqDossierModalBtn").append(btn);
             
             }
		},
		error: function (e){
			alert("Error");
		}
	});
}


// Modifier la date de seance

function addDateSeanceEvent(event){
   event.preventDefault();
   var formData = new FormData();
   formData.append("numeroDossier",$("#numero_dossier").val());
   formData.append("dateSeanceDossier",$("#date_seance_dossier").val());
   $.ajax({
		type: "POST",
		url: "consulterDossier/ajouterDateSeance",
		processData: false,
		contentType: false,
		cache: false,
		data : formData,
		timeout: 600000,
		success: function (data){
		    if(data[0]["error"]=="success"){
		    
             var success = data[0]["message"];
             $("#dateSeanceDossierModalBody").empty();
			$("#dateSeanceDossierModalBody").append(success);
			
			var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"consulterDossier\">حفظ</a>";
			$("#dateSeanceDossierModalBtn").empty();
			$("#dateSeanceDossierModalBtn").append(btn);
			
             } else{
             
             var error = data[0]["message"];
             $("#dateSeanceDossierModalBody").empty();
			 $("#dateSeanceDossierModalBody").append(error);
			 
			 var btn = "<a type=\"button\" class=\"btn btn-danger\" href=\"consulterDossier\">اعادة المحاولة</a>";
			 $("#dateSeanceDossierModalBtn").empty();
			 $("#dateSeanceDossierModalBtn").append(btn);
             
             }
		},
		error: function (e){
			alert("Error");
		}
	});
}


// recuperer les infos de victime

function loadVictimeInfos(event){
	event.preventDefault();
   var idVictime = $("#liste_victimes").val();
   
  $.ajax({
		type: "GET",
		url: "consulterDossier/Victime/"+idVictime,
		processData: false,
		contentType: false,
		cache: false,
		timeout: 600000,
		success: function (data){
			
			$('#field_victime').css('display', 'block');
		
			$("#cni_victime").val(data["victime"]["cin"]);
			$("#nom_victime").val(data["victime"]["nom"]);
			$("#prenom_victime").val(data["victime"]["prenom"]);
			$("#etat_social_victime").val(data["victime"]["situationFamiliale"]);
			$("#nombre_enfants_victime").val(data["victime"]["nombreEnfant"]);
			$("#salaire_annuel_victime").val(data["victime"]["salaire"]);
			$("#date_naissance_victime").val(data["dateNaissance"]);
			$("#job_victime").val(data["victime"]["proffession"]);
			$("#lieu_naissance_victime").val(data["victime"]["lieuNaissance"]);
			$("#sexe_victime").val(data["victime"]["sexe"]);
			$("#pere_victime").val(data["victime"]["prenomPere"]);
			$("#mere_victime").val(data["victime"]["prenomMere"]);
			$("#addresse_victime").val(data["victime"]["addresse"]);
			$("#etat_victime").val(data["victime"]["etat"]);
			
			if(data["victime"]["etat"] == "ميت"){
				$('#field_table_dawi').css('display', 'block');
				$("#table_dawi_body").empty();
				for (let i = 0; i < data["dawis"].length; i++){
					var dawi_element = '<tr><td>'+data["dawis"][i]["relationAvecVictime"]+'</td><td>'+data["dawis"][i]["prenom"]+'</td><td>'+data["dawis"][i]["nom"]+'</td><td>'+data["dawis"][i]["droitCompensation"]+'</td></tr>';
					$("#table_dawi_body").append(dawi_element);
				}
				
			}else{
				$("#table_dawi_body").empty();
				$('#field_table_dawi').css('display', 'none');
			}
			
			if(data["avocat"] != null){
				$('#field_avocat_victime').css('display', 'block');
				$("#cni_avocat_victime").val(data["avocat"]["cin"]);
				$("#prenom_avocat_victime").val(data["avocat"]["prenom"]);
				$("#nom_avocat_victime").val(data["avocat"]["nom"]);
				$("#ville_avocat_victime").val(data["avocat"]["haya"]);
				$("#addresse_avocat_victime").val(data["avocat"]["addresse"]);
				
				$("#avocat_victime").val(data["avocat"]["prenom"]+" "+data["avocat"]["nom"]);
			}else{
				$('#field_avocat_victime').css('display', 'none');
				$("#avocat_victime").empty();
				$("#avocat_victime").val("");
			}
			
			
		},
		error: function (e){

		}
	});
}



// modifier le victime

function updateVictime(event){
	if($("#updateVictime").val() == 'enabled'){ // modification
	
		$("#cni_victime").prop('disabled', true);
		$("#nom_victime").prop('disabled', true);
		$("#prenom_victime").prop('disabled', true);
		$("#etat_social_victime").prop('disabled', true);
		$("#nombre_enfants_victime").prop('disabled', true);
		$("#salaire_annuel_victime").prop('disabled', true);
		$("#date_naissance_victime").prop('disabled', true);
		$("#job_victime").prop('disabled', true);
		$("#lieu_naissance_victime").prop('disabled', true);
		$("#sexe_victime").prop('disabled', true);
		$("#pere_victime").prop('disabled', true);
		$("#mere_victime").prop('disabled', true);
		$("#addresse_victime").prop('disabled', true);
		$("#etat_victime").prop('disabled', true);
		
		$("#updateVictime").attr('class', 'btn btn-outline-dark');
		$("#updateVictime").text("تعديل البيانات");
		$("#updateVictime").val("disabled");
		
		event.preventDefault();
		var formData = new FormData();
		formData.append("id_victime", $("#liste_victimes").val());
		formData.append("cni_victime",$("#cni_victime").val());
		formData.append("prenom_victime",$("#prenom_victime").val());
		formData.append("nom_victime",$("#nom_victime").val());
		formData.append("etat_social_victime",$("#etat_social_victime").val());
		formData.append("nombre_enfants_victime",$("#nombre_enfants_victime").val());
		formData.append("salaire_annuel_victime",$("#salaire_annuel_victime").val());
		formData.append("date_naissance_victime",$("#date_naissance_victime").val());
		formData.append("job_victime",$("#job_victime").val());
		formData.append("lieu_naissance_victime",$("#lieu_naissance_victime").val());
		formData.append("pere_victime",$("#pere_victime").val());
		formData.append("mere_victime",$("#mere_victime").val());
		formData.append("addresse_victime",$("#addresse_victime").val());
		formData.append("etat_victime",$("#etat_victime").val());
		
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
	             } else if(data[0]["error"]=="error"){
	             
	             }
				
			},
			error: function (e){
	
			}
		})
		
	}else if($("#updateVictime").val() == 'disabled'){ //activation des inputs
		
		$("#cni_victime").prop('disabled', false);
		$("#nom_victime").prop('disabled', false);
		$("#prenom_victime").prop('disabled', false);
		$("#etat_social_victime").prop('disabled', false);
		$("#nombre_enfants_victime").prop('disabled', false);
		$("#salaire_annuel_victime").prop('disabled', false);
		$("#date_naissance_victime").prop('disabled', false);
		$("#job_victime").prop('disabled', false);
		$("#lieu_naissance_victime").prop('disabled', false);
		$("#sexe_victime").prop('disabled', false);
		$("#pere_victime").prop('disabled', false);
		$("#mere_victime").prop('disabled', false);
		$("#addresse_victime").prop('disabled', false);
		$("#etat_victime").prop('disabled', false);
		
		$("#updateVictime").attr('class', 'btn btn-dark');
		$("#updateVictime").text("حفظ البيانات");
		$("#updateVictime").val("enabled");
	}
}






// ajouter un victime

function addVictime(event){
	if($("#addVictime").val() == 'enabled'){ // modification
		
		$("#cni_victime").prop('disabled', true);
		$("#nom_victime").prop('disabled', true);
		$("#prenom_victime").prop('disabled', true);
		$("#etat_social_victime").prop('disabled', true);
		$("#nombre_enfants_victime").prop('disabled', true);
		$("#salaire_annuel_victime").prop('disabled', true);
		$("#date_naissance_victime").prop('disabled', true);
		$("#job_victime").prop('disabled', true);
		$("#lieu_naissance_victime").prop('disabled', true);
		$("#sexe_victime").prop('disabled', true);
		$("#pere_victime").prop('disabled', true);
		$("#mere_victime").prop('disabled', true);
		$("#addresse_victime").prop('disabled', true);
		$("#etat_victime").prop('disabled', true);
		
		$("#addVictime").attr('class', 'btn btn-outline-success');
		$("#addVictime").text("إضافة ضحية");
		$("#addVictime").val("disabled");
		
		event.preventDefault();
		var formData = new FormData();
		
		formData.append("cni_victime",$("#cni_victime").val());
		formData.append("prenom_victime",$("#prenom_victime").val());
		formData.append("nom_victime",$("#nom_victime").val());
		formData.append("etat_social_victime",$("#etat_social_victime").val());
		formData.append("nombre_enfants_victime",$("#nombre_enfants_victime").val());
		formData.append("salaire_annuel_victime",$("#salaire_annuel_victime").val());
		formData.append("date_naissance_victime",$("#date_naissance_victime").val());
		formData.append("job_victime",$("#job_victime").val());
		formData.append("lieu_naissance_victime",$("#lieu_naissance_victime").val());
		formData.append("sexe_victime",$(".sexe_victime:checked").val());
		formData.append("pere_victime",$("#pere_victime").val());
		formData.append("mere_victime",$("#mere_victime").val());
		formData.append("addresse_victime",$("#addresse_victime").val());
		formData.append("numero_dossier",$("#numero_dossier").val());
		
		$.ajax({
			type: "POST",
			url: "consulterDossier/addVictime",
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
	             } else if(data[0]["error"]=="error"){
	             
	             }
				
			},
			error: function (e){
	
			}
		})
		
	}else if($("#addVictime").val() == 'disabled'){ //activation des inputs
		$('#field_table_dawi').css('display', 'none');
		$('#field_avocat_victime').css('display', 'none');
		
		$('#field_victime').find('input:text').val('');
		$('#field_victime').css('display', 'block');
		
		$("#cni_victime").prop('disabled', false);
		$("#nom_victime").prop('disabled', false);
		$("#prenom_victime").prop('disabled', false);
		$("#etat_social_victime").prop('disabled', false);
		$("#nombre_enfants_victime").prop('disabled', false);
		$("#salaire_annuel_victime").prop('disabled', false);
		$("#date_naissance_victime").prop('disabled', false);
		$("#job_victime").prop('disabled', false);
		$("#lieu_naissance_victime").prop('disabled', false);
		$("#sexe_victime").prop('disabled', false);
		$("#pere_victime").prop('disabled', false);
		$("#mere_victime").prop('disabled', false);
		$("#addresse_victime").prop('disabled', false);
		$("#etat_victime").prop('disabled', false);
		
		$(".sexe_victime").prop('disabled', false);
		$(".avocat_etat").prop('style', 'display:none');
		
		$("#addVictime").attr('class', 'btn btn-primary');
		$("#addVictime").text("حفظ البيانات");
		$("#addVictime").val("enabled");
	}
}






// Supprimer un victime

function deleteVictime(event){
   event.preventDefault();
   var formData = new FormData();
   formData.append("id_victime", $("#liste_victimes").val());
   
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









// recuperer les infos de accuses

function loadAccuseInfos(event){
	event.preventDefault();
   var idAccuse = $("#liste_accuses").val();
   
  $.ajax({
		type: "GET",
		url: "consulterDossier/Accuse/"+idAccuse,
		processData: false,
		contentType: false,
		cache: false,
		timeout: 600000,
		success: function (data){
			
			$('#field_accuse').css('display', 'block');
			
			console.log(data["accuse"]);
			
			$("#cni_accuse").val(data["accuse"]["cin"]);
			$("#nom_accuse").val(data["accuse"]["nom"]);
			$("#prenom_accuse").val(data["accuse"]["prenom"]);
			$("#etat_social_accuse").val(data["accuse"]["situationFamilialle"]);
			$("#assurance_accuse").val(data["accuse"]["assurance"]);
			$("#date_naissance_accuse").val(data["dateNaissance"]);
			$("#job_accuse").val(data["accuse"]["proffession"]);
			$("#lieu_naissance_accuse").val(data["accuse"]["lieuNaissance"]);
			$("#sexe_accuse").val(data["accuse"]["sexe"]);
			$("#pere_accuse").val(data["accuse"]["prenomPere"]);
			$("#mere_accuse").val(data["accuse"]["prenomMere"]);
			$("#addresse_accuse").val(data["accuse"]["addresse"]);
			$("#charge_accuse").val(data["accuse"]["tohma"]);
			
			
			if(data["avocat"] != null){
				$('#field_avocat_accuse').css('display', 'block');
				$("#cni_avocat_accuse").val(data["avocat"]["cin"]);
				$("#prenom_avocat_accuse").val(data["avocat"]["prenom"]);
				$("#nom_avocat_accuse").val(data["avocat"]["nom"]);
				$("#ville_avocat_accuse").val(data["avocat"]["haya"]);
				$("#addresse_avocat_accuse").val(data["avocat"]["addresse"]);
				
				$("#avocat_accuse").val(data["avocat"]["prenom"]+" "+data["avocat"]["nom"]);
			}else{
				$('#field_avocat_accuse').css('display', 'none');
				$("#avocat_accuse").empty();
				$("#avocat_accuse").val("");
			}
			
			if(data["officierCivil"] != null){
				$('#field_officier_civil').css('display', 'block');
				$("#cni_officier_civil").val(data["officierCivil"]["cniOfficierCivil"]);
				$("#prenom_officier_civil").val(data["officierCivil"]["prenom"]);
				$("#nom_officier_civil").val(data["officierCivil"]["nom"]);
				$("#assurance_officier_civil").val(data["officierCivil"]["assurance"]);
				$("#addresse_officier_civil").val(data["officierCivil"]["addresse"]);
			}else{
				$('#field_officier_civil').css('display', 'none');
			}
			
			
		},
		error: function (e){

		}
	});
}