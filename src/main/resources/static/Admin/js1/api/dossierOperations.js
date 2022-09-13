// Recuperer toutes les tribunals

function loadDossiers(val){

	event.preventDefault();
	var formData = new FormData();
	formData.append("numero_dossier",$("#numero_dossier").val());
	
  $.ajax({
		type: "POST",
		url: "consulterDossier/loadDossier",
		processData: false,
		contentType: false,
		cache: false,
		data:formData,
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
			$("#liste_victimes_info").empty();
			$("#liste_victimes_info").append(html);
			
			
			// vider les champs
			$('#field_victime_info').css('display', 'none');
			$('#field_table_dawi_info').css('display', 'none');
			$('#field_table_avocat_victime_info').css('display', 'none');
			
			
			
			//infos accuses
		    var accuses = data["accuses"];
		    var html = "<option disabled selected>اختر متهم</option>";
		    for (const key in accuses){
            html = html +"<option value=\""+ accuses[key]["id"]+"\">"+ accuses[key]["prenom"] + " "+accuses[key]["nom"] +"</option>";
         	}
			$("#liste_accuses_info").empty();
			$("#liste_accuses_info").append(html);
			
			
			// vider les champs
			$('#field_accuse_info').css('display', 'none');
			$('#field_officier_civil_info').css('display', 'none');
			$('#field_table_avocat_accuse_info').css('display', 'none');
			
			
			
			//infos temoin
		    var temoins = data["temoins"];
		    var html = "<option disabled selected>اختر شاهد</option>";
		    for (const key in temoins){
            html = html +"<option value=\""+ temoins[key]["cinTemoin"]+"\">"+ temoins[key]["prenom"] + " "+temoins[key]["nom"] +"</option>";
         	}
			$("#liste_temoins_info").empty();
			$("#liste_temoins_info").append(html);
			
			
			// vider les champs
			$('#field_temoin_info').css('display', 'none');
		    
		    
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


//supprimer dossier
function deleteDossierEvent(event){
   event.preventDefault();
   var formData = new FormData();
   formData.append("numero_dossier", $("#numero_dossier").val());
   
   $.ajax({
		type: "POST",
		url: "consulterDossier/deleteDossier",
		processData: false,
		contentType: false,
		cache: false,
		data : formData,
		timeout: 600000,
		success: function (data){
		    if(data["error"]=="success"){
		    
             var success = data["message"];
             $("#deleteDossierModalBody").empty();
			$("#deleteDossierModalBody").append(success);
			
			var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"consulterDossier\">غلق</a>";
			$("#deleteDossierModalBtn").empty();
			$("#deleteDossierModalBtn").append(btn);
			
             } else{
             
             var error = data["message"];
             $("#deleteDossierModalBody").empty();
			 $("#deleteDossierModalBody").append(error);
			 
			 var btn = "<a type=\"button\" class=\"btn btn-warning\" href=\"consulterDossier\">اعادة المحاولة</a>";
			 $("#deleteDossierModalBtn").empty();
			 $("#deleteDossierModalBtn").append(btn);
             
             }
		},
		error: function (e){
			alert("Error");
		}
	});
}