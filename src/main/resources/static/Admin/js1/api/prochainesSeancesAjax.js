
// Modifier la date d'une seance

function dateSeanceEvent(event){
   event.preventDefault();
   var formData = new FormData();   
   formData.append("numeroDossier",$("#numero_seance").val());
   formData.append("dateSeanceDossier",$("#date_seance").val());
   
   $.ajax({
		type: "POST",
		url: "prochainesSeances/dateSeance",
		processData: false,
		contentType: false,
		cache: false,
		data : formData,
		timeout: 600000,
		success: function (data){
		    if(data["error"]=="success"){
             
             var success = data["message"];
             $("#dateSeanceModalBody").empty();
			$("#dateSeanceModalBody").append(success);
			
			var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"prochainesSeances\">حفظ</a>";
			$("#dateSeanceModalBtn").empty();
			$("#dateSeanceModalBtn").append(btn);
			
             } else{
             var error = data["message"];
             $("#dateSeanceModalBody").empty();
			 $("#dateSeanceModalBody").append(error);
			 
			 var btn = "<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">اعادة المحاولة</button>";
			 $("#dateSeanceModalBtn").empty();
			 $("#dateSeanceModalBtn").append(btn);
             
             }
		},
		error: function (e){
			alert("Error");
		}
	});
}


// Modifier la remarque d'une seance

function rmqSeanceEvent(event){
   event.preventDefault();
   var formData = new FormData();   
   formData.append("numeroDossier",$("#numero_seance").val());
   formData.append("rmqSeanceDossier",$("#rmq_seance").val());
   
   $.ajax({
		type: "POST",
		url: "prochainesSeances/rmqSeance",
		processData: false,
		contentType: false,
		cache: false,
		data : formData,
		timeout: 600000,
		success: function (data){
		    if(data["error"]=="success"){
             
             var success = data["message"];
             $("#rmqSeanceModalBody").empty();
			$("#rmqSeanceModalBody").append(success);
			
			var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"prochainesSeances\">حفظ</a>";
			$("#rmqSeanceModalBtn").empty();
			$("#rmqSeanceModalBtn").append(btn);
			
             } else{
             var error = data["message"];
             $("#rmqSeanceModalBody").empty();
			 $("#rmqSeanceModalBody").append(error);
			 
			 var btn = "<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">اعادة المحاولة</button>";
			 $("#rmqSeanceModalBtn").empty();
			 $("#rmqSeanceModalBtn").append(btn);
             
             }
		},
		error: function (e){
			alert("Error");
		}
	});
}






// Modifier la date d'une seance Aujourd'hui

function dateSeanceDayEvent(event){
   event.preventDefault();
   var formData = new FormData();   
   formData.append("numeroDossier",$("#numero_seance").val());
   formData.append("dateSeanceDossier",$("#date_seance").val());
   
   $.ajax({
		type: "POST",
		url: "seancesAujourdhui/dateSeance",
		processData: false,
		contentType: false,
		cache: false,
		data : formData,
		timeout: 600000,
		success: function (data){
		    if(data["error"]=="success"){
             
             var success = data["message"];
             $("#dateSeanceModalBody").empty();
			$("#dateSeanceModalBody").append(success);
			
			var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"seancesAujourdhui\">حفظ</a>";
			$("#dateSeanceModalBtn").empty();
			$("#dateSeanceModalBtn").append(btn);
			
             } else{
             var error = data["message"];
             $("#dateSeanceModalBody").empty();
			 $("#dateSeanceModalBody").append(error);
			 
			 var btn = "<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">اعادة المحاولة</button>";
			 $("#dateSeanceModalBtn").empty();
			 $("#dateSeanceModalBtn").append(btn);
             
             }
		},
		error: function (e){
			alert("Error");
		}
	});
}


// Modifier la remarque d'une seance Aujourd'hui

function rmqSeanceDayEvent(event){
   event.preventDefault();
   var formData = new FormData();   
   formData.append("numeroDossier",$("#numero_seance").val());
   formData.append("rmqSeanceDossier",$("#rmq_seance").val());
   
   $.ajax({
		type: "POST",
		url: "seancesAujourdhui/rmqSeance",
		processData: false,
		contentType: false,
		cache: false,
		data : formData,
		timeout: 600000,
		success: function (data){
		    if(data["error"]=="success"){
             
             var success = data["message"];
             $("#rmqSeanceModalBody").empty();
			$("#rmqSeanceModalBody").append(success);
			
			var btn = "<a type=\"button\" class=\"btn btn-primary\" href=\"seancesAujourdhui\">حفظ</a>";
			$("#rmqSeanceModalBtn").empty();
			$("#rmqSeanceModalBtn").append(btn);
			
             } else{
             var error = data["message"];
             $("#rmqSeanceModalBody").empty();
			 $("#rmqSeanceModalBody").append(error);
			 
			 var btn = "<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">اعادة المحاولة</button>";
			 $("#rmqSeanceModalBtn").empty();
			 $("#rmqSeanceModalBtn").append(btn);
             
             }
		},
		error: function (e){
			alert("Error");
		}
	});
}