// ajout d'un victime

function addVictimeEvent(event) {

	event.preventDefault();
	var formData = new FormData();

	if ($("#check_victime").prop('checked') == true) {
		formData.append("cni_victime", $("#cni_victime").val());
		formData.append("prenom_victime", $("#prenom_victime").val());
		formData.append("nom_victime", $("#nom_victime").val());
		formData.append("etat_social_victime", $("#etat_social_victime").val());
		formData.append("nombre_enfants_victime", $("#nombre_enfants_victime").val());
		formData.append("salaire_annuel_victime", $("#salaire_annuel_victime").val());
		formData.append("date_naissance_victime", $("#date_naissance_victime").val());
		formData.append("job_victime", $("#job_victime").val());
		formData.append("lieu_naissance_victime", $("#lieu_naissance_victime").val());
		formData.append("sexe_victime", $(".sexe_victime:checked").val());
		formData.append("pere_victime", $("#pere_victime").val());
		formData.append("mere_victime", $("#mere_victime").val());
		formData.append("addresse_victime", $("#addresse_victime").val());
		formData.append("numero_dossier", $("#numero_dossier").val());
		console.log("Test1");
		fire_ajax_victime(formData);
	} else {
		console.log($('#liste_victimes').val());
		console.log($("#numero_dossier").val());
		formData.append("id_victime", $('#liste_victimes').val());
		formData.append("numero_dossier", $("#numero_dossier").val());
		console.log("Test2");
		insert_victime(formData);
	}



}

function fire_ajax_victime(formData) {
	console.log("Test3");
	$.ajax({
		type: "POST",
		url: "ajouterDossier/victime",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			if (data[0]["error"] == "success") {
				console.log(data[0]["message"]);

				$('#victime_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#victime_returned_div").empty();
				$("#victime_returned_div").append(success);

				var etatVict = "2 - وضعية الضحية [" + $('#prenom_victime').val() + " " + $('#nom_victime').val() + "]";
				$("#etatVictime").empty();
				$("#etatVictime").append(etatVict);
				$("#etatVictime").val(data[1]['id']);

				var avocatVict = "3 - محامي الضحية [" + $('#prenom_victime').val() + " " + $('#nom_victime').val() + "]";
				$("#avocatVictime").empty();
				$("#avocatVictime").append(avocatVict);
				$("#avocatVictime").val(data[1]['id']);

				var victime_element = '<tr><td>' + data[1]["cin"] + '</td><td>' + data[1]["prenom"] + '</td > <td>' + data[1]["nom"] + '</td> <td>' + data[1]["proffession"] + '</td><td class="text-right"><div class="btn-group"><button class="btn-white btn btn-xs">إطلاع</button><button class="btn-white btn btn-xs">حذف</button></div></td></tr>';
				$("#table_victime_body").append(victime_element);

			} else if (data[0]["error"] = "error") {
				$('#victime_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#victime_returned_div").empty();
				$("#victime_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}

function insert_victime(formData) {
	console.log("Test4");
	$.ajax({
		type: "POST",
		url: "ajouterDossier/insertVictime",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			if (data[0]["error"] == "success") {
				console.log(data[1]);
				var success = data[0]["message"];

				$('#victime_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#victime_returned_div").empty();
				$("#victime_returned_div").append(success);

				var etatVict = "2 - وضعية الضحية [" + data[1]["prenom"] + " " + data[1]["nom"] + "]";
				$("#etatVictime").empty();
				$("#etatVictime").append(etatVict);
				$("#etatVictime").val(data[1]['id']);

				var avocatVict = "3 - محامي الضحية [" + data[1]["prenom"] + " " + data[1]["nom"] + "]";
				$("#avocatVictime").empty();
				$("#avocatVictime").append(avocatVict);
				$("#avocatVictime").val(data[1]['id']);

				var victime_element = '<tr><td>' + data[1]["cin"] + '</td><td>' + data[1]["prenom"] + '</td > <td>' + data[1]["nom"] + '</td> <td>' + data[1]["proffession"] + '</td><td class="text-right"><div class="btn-group"><button class="btn-white btn btn-xs">إطلاع</button><button class="btn-white btn btn-xs">حذف</button></div></td></tr>';
				$("#table_victime_body").append(victime_element);

			} else if (data[0]["error"] = "error") {
				$('#victime_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#victime_returned_div").empty();
				$("#victime_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}

function updateEtatVictime() {
	console.log($('#etatVictime').val() + " # " + $(".etat_victime:checked").val());
	var formData = new FormData();
	formData.append("id_victime", $('#etatVictime').val());
	formData.append("etat_victime", $(".etat_victime:checked").val());

	$.ajax({
		type: "POST",
		url: "ajouterDossier/updateEtatVictime",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			if (data[0]["error"] == "success") {
				console.log(data);
				console.log(data[0]);
				console.log(data[1]);
			} else if (data[0]["error"] == "error") {
				console.log(data);
				console.log(data[0]);
				console.log(data[1]);
			}
		},
		error: function(e) {

		}
	})
}


// Ajout d'un dawi
/*
function addDawiEvent(event) {
	event.preventDefault();
	var formData = new FormData();

	if ($("#check_dawi").prop('checked') == true) {
		formData.append("relation_avec_victime", $('#relation_dawi').val());
		formData.append("droit_compensation", $('.droit_compensation:checked').val());
		formData.append("id_victime", $("#etatVictime").val());

		formData.append("cni", $('#cni_famille_victime').val());
		formData.append("nom", $('#nomfam_famille_victime').val());
		formData.append("prenom", $('#prenom_famille_victime').val());
		formData.append("date_naissance", $('#naissance_famille_victime').val());
		formData.append("etat_sociale", $('#etat_sociale_famille_victime').val());
		formData.append("job", $('#job_famille_victime').val());
		formData.append("addresse", $('#addresse_famille_victime').val());
		
		//fire_ajax_dawi(formData);
	} else {
		console.log($('#liste_dawis').val());
		console.log($("#numero_dossier").val());
		console.log($('#relation_dawi').val());
		console.log($('.droit_compensation:checked').val());

		formData.append("id_victime", $("#etatVictime").val());
		formData.append("id_dawi", $('#liste_dawis').val());

		formData.append("relation_avec_victime", $('#relation_dawi').val());
		formData.append("droit_compensation", $('.droit_compensation:checked').val());

		insert_dawi(formData);
	}
}
*/

function fire_ajax_dawi(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/dawi",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			console.log(data)

			if (data["error"] == "success") {

				$('#dawi_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#dawi_returned_div").empty();
				$("#dawi_returned_div").append(success);

			} else {
				$('#dawi_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#dawi_returned_div").empty();
				$("#dawi_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}


function insert_dawi(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/insertDawi",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			console.log(data)

			if (data["error"] == "success") {

				$('#dawi_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#dawi_returned_div").empty();
				$("#dawi_returned_div").append(success);

			} else {
				$('#dawi_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#dawi_returned_div").empty();
				$("#dawi_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}


// Ajout d'un avocat pour victime

function addAvocatVictimeEvent(event) {
	event.preventDefault();
	var formData = new FormData();

	if ($("#check_avocat_victime").prop('checked') == true) {
		formData.append("cni_avocat_victime", $("#cni_avocat_victime").val());
		formData.append("prenom_avocat_victime", $("#prenom_avocat_victime").val());
		formData.append("nom_avocat_victime", $("#nom_avocat_victime").val());
		formData.append("ville_avocat_victime", $("#ville_avocat_victime").val());
		formData.append("addresse_avocat_victime", $("#addresse_avocat_victime").val());

		formData.append("id_victime", $("#etatVictime").val());

		console.log(...formData);
		fire_ajax_avocat_victime(formData);

	} else {
		formData.append("cni_avocat_victime", $('#liste_avocats_victime').val());
		formData.append("id_victime", $("#etatVictime").val());

		console.log(...formData);
		insert_avocat_victime(formData);
	}

}

function fire_ajax_avocat_victime(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/avocatVictime",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			console.log(data)

			if (data["error"] == "success") {

				$('#avocat_victime_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#avocat_victime_returned_div").empty();
				$("#avocat_victime_returned_div").append(success);

			} else {
				$('#avocat_victime_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#avocat_victime_returned_div").empty();
				$("#avocat_victime_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}


function insert_avocat_victime(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/insertAvocatVictime",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			console.log(data)

			if (data["error"] == "success") {

				$('#avocat_victime_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#avocat_victime_returned_div").empty();
				$("#avocat_victime_returned_div").append(success);

			} else {
				$('#avocat_victime_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#avocat_victime_returned_div").empty();
				$("#avocat_victime_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}


// ajout d'un accuse

function addAccuseEvent(event) {
	event.preventDefault();
	var formData = new FormData();

	if ($("#check_accuse").prop('checked') == true) {
		formData.append("cni_accuse", $("#cni_accuse").val());
		formData.append("prenom_accuse", $("#prenom_accuse").val());
		formData.append("nom_accuse", $("#nom_accuse").val());
		formData.append("etat_social_accuse", $("#etat_social_accuse").val());
		formData.append("nombre_enfants_accuse", $("#nombre_enfants_accuse").val());
		formData.append("assurance_accuse", $("#assurance_accuse").val());
		formData.append("date_naissance_accuse", $("#date_naissance_accuse").val());
		formData.append("job_accuse", $("#job_accuse").val());
		formData.append("lieu_naissance_accuse", $("#lieu_naissance_accuse").val());
		formData.append("sexe_accuse", $(".sexe_accuse:checked").val());
		formData.append("pere_accuse", $("#pere_accuse").val());
		formData.append("mere_accuse", $("#mere_accuse").val());
		formData.append("addresse_accuse", $("#addresse_accuse").val());

		formData.append("numero_dossier", $("#numero_dossier").val());
		formData.append("charge_accuse", $("#charge_accuse").val());

		console.log(...formData);
		fire_ajax_accuse(formData);
	} else {
		console.log($('#liste_accuses').val());
		console.log($("#numero_dossier").val());
		console.log($("#charge_accuse").val());

		formData.append("id_accuse", $('#liste_accuses').val());
		formData.append("numero_dossier", $("#numero_dossier").val());
		formData.append("charge_accuse", $("#charge_accuse").val());

		insert_accuse(formData);
	}
}

function fire_ajax_accuse(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/accuse",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			if (data[0]["error"] == "success") {
				console.log(data[1]);
				console.log(data[1]['id']);
				$('#accuse_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#accuse_returned_div").empty();
				$("#accuse_returned_div").append(success);

				var offCivil = "2 - المسؤول المدني [" + $('#prenom_accuse').val() + " " + $('#nom_accuse').val() + "]";
				$("#officierCivil").empty();
				$("#officierCivil").append(offCivil);
				$("#officierCivil").val(data[1]['id']);

				var avocatAcc = "3 - محامي المتهم [" + $('#prenom_accuse').val() + " " + $('#nom_accuse').val() + "]";
				$("#avocatAccuse").empty();
				$("#avocatAccuse").append(avocatAcc);
				$("#avocatAccuse").val(data[1]['id']);

				var accuse_element = '<tr><td>' + data[1]["cin"] + '</td><td>' + data[1]["prenom"] + '</td > <td>' + data[1]["nom"] + '</td> <td>' + data[1]["proffession"] + '</td><td class="text-right"><div class="btn-group"><button class="btn-white btn btn-xs">إطلاع</button><button class="btn-white btn btn-xs">حذف</button></div></td></tr>';
				$("#table_accuse_body").append(accuse_element);

			} else if (data[0]["error"] == "error") {
				$('#accuse_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#accuse_returned_div").empty();
				$("#accuse_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}

function insert_accuse(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/insertAccuse",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			if (data[0]["error"] == "success") {
				console.log(data[1]);
				console.log(data[1]['id']);
				$('#accuse_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#accuse_returned_div").empty();
				$("#accuse_returned_div").append(success);

				var offCivil = "2 - المسؤول المدني [" + data[1]["prenom"] + " " + data[1]["nom"] + "]";
				$("#officierCivil").empty();
				$("#officierCivil").append(offCivil);
				$("#officierCivil").val(data[1]['id']);

				var avocatAcc = "3 - محامي المتهم [" + data[1]["prenom"] + " " + data[1]["nom"] + "]";
				$("#avocatAccuse").empty();
				$("#avocatAccuse").append(avocatAcc);
				$("#avocatAccuse").val(data[1]['id']);

				var accuse_element = '<tr><td>' + data[1]["cin"] + '</td><td>' + data[1]["prenom"] + '</td > <td>' + data[1]["nom"] + '</td> <td>' + data[1]["proffession"] + '</td><td class="text-right"><div class="btn-group"><button class="btn-white btn btn-xs">إطلاع</button><button class="btn-white btn btn-xs">حذف</button></div></td></tr>';
				$("#table_accuse_body").append(accuse_element);

			} else if (data[0]["error"] == "error") {
				$('#accuse_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#accuse_returned_div").empty();
				$("#accuse_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}


// Ajout d'un officier civil pour victime

function addOfficierCivilEvent(event) {
	event.preventDefault();
	var formData = new FormData();

	if ($("#check_officier_civil").prop('checked') == true) {
		formData.append("cni_officier_civil", $("#cni_officier_civil").val());
		formData.append("prenom_officier_civil", $("#prenom_officier_civil").val());
		formData.append("nom_officier_civil", $("#nom_officier_civil").val());
		formData.append("assurance_officier_civil", $("#assurance_officier_civil").val());
		formData.append("addresse_officier_civil", $("#addresse_officier_civil").val());

		formData.append("id_accuse", $("#officierCivil").val());

		console.log(...formData);
		fire_ajax_officier_civil(formData);
	} else {
		formData.append("cni_officier_civil", $("#liste_officier_civils").val());
		formData.append("id_accuse", $("#officierCivil").val());

		console.log(...formData);
		insert_officier_civil(formData);
	}



}

function fire_ajax_officier_civil(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/officierCivil",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			console.log(data)

			if (data["error"] == "success") {

				$('#officier_civil_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#officier_civil_returned_div").empty();
				$("#officier_civil_returned_div").append(success);

			} else {

				$('#officier_civil_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#officier_civil_returned_div").empty();
				$("#officier_civil_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}


function insert_officier_civil(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/insertOfficierCivil",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			console.log(data)

			if (data["error"] == "success") {

				$('#officier_civil_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#officier_civil_returned_div").empty();
				$("#officier_civil_returned_div").append(success);

			} else {

				$('#officier_civil_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#officier_civil_returned_div").empty();
				$("#officier_civil_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}



// Ajout d'un avocat pour accuse

function addAvocatAccuseEvent(event) {
	event.preventDefault();
	var formData = new FormData();

	if ($("#check_avocat_accuse").prop('checked') == true) {
		formData.append("cni_avocat_accuse", $("#cni_avocat_accuse").val());
		formData.append("prenom_avocat_accuse", $("#prenom_avocat_accuse").val());
		formData.append("nom_avocat_accuse", $("#nom_avocat_accuse").val());
		formData.append("ville_avocat_accuse", $("#ville_avocat_accuse").val());
		formData.append("addresse_avocat_accuse", $("#addresse_avocat_accuse").val());

		formData.append("id_accuse", $("#avocatAccuse").val());

		console.log(...formData);
		fire_ajax_avocat_accuse(formData);
	} else {
		formData.append("cni_avocat_accuse", $('#liste_avocats_accuse').val());
		formData.append("id_accuse", $("#officierCivil").val());

		console.log(...formData);
		insert_avocat_accuse(formData);
	}



}

function fire_ajax_avocat_accuse(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/avocatAccuse",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			console.log(data)

			if (data["error"] == "success") {

				$('#avocat_accuse_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#avocat_accuse_returned_div").empty();
				$("#avocat_accuse_returned_div").append(success);

			} else {

				$('#avocat_accuse_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#avocat_accuse_returned_div").empty();
				$("#avocat_accuse_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}


function insert_avocat_accuse(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/insertAvocatAccuse",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			console.log(data)

			if (data["error"] == "success") {

				$('#avocat_accuse_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#avocat_accuse_returned_div").empty();
				$("#avocat_accuse_returned_div").append(success);

			} else {

				$('#avocat_accuse_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data["message"] + '</span></div>';
				$("#avocat_accuse_returned_div").empty();
				$("#avocat_accuse_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}



// ajout d'un temoin

function addTemoinEvent(event) {
	event.preventDefault();
	var formData = new FormData();

	if ($("#check_temoin").prop('checked') == true) {
		formData.append("cni_temoin", $("#cni_temoin").val());
		formData.append("prenom_temoin", $("#prenom_temoin").val());
		formData.append("nom_temoin", $("#nom_temoin").val());
		formData.append("etat_sociale_temoin", $("#etat_sociale_temoin").val());
		formData.append("date_naissance_temoin", $("#date_naissance_temoin").val());
		formData.append("job_temoin", $("#job_temoin").val());
		formData.append("lieu_naissance_temoin", $("#lieu_naissance_temoin").val());
		formData.append("sexe_temoin", $(".sexe_temoin:checked").val());
		formData.append("pere_temoin", $("#pere_temoin").val());
		formData.append("mere_temoin", $("#mere_temoin").val());
		formData.append("addresse_temoin", $("#addresse_temoin").val());

		formData.append("numero_dossier", $("#numero_dossier").val());

		console.log(...formData);
		fire_ajax_temoin(formData);
	} else {
		console.log($('#liste_temoins').val());
		console.log($("#numero_dossier").val());

		formData.append("cni_temoin", $('#liste_temoins').val());
		formData.append("numero_dossier", $("#numero_dossier").val());

		insert_temoin(formData);
	}

}


function fire_ajax_temoin(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/temoin",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			if (data[0]["error"] == "success") {
				console.log(data[1]);
				
				$('#temoin_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#temoin_returned_div").empty();
				$("#temoin_returned_div").append(success);

				var temoin_element = '<tr><td>' + data[1]["cinTemoin"] + '</td><td>' + data[1]["prenom"] + '</td><td>' + data[1]["nom"] + '</td ><td>' + data[1]["proffession"] + '</td><td class="text-right"><div class="btn-group"><button class="btn-white btn btn-xs">إطلاع</button><button class="btn-white btn btn-xs">حذف</button></div></td></tr>';
				$("#table_temoin_body").append(temoin_element);

			} else if (data[0]["error"] == "error") {
				$('#temoin_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#temoin_returned_div").empty();
				$("#temoin_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}


function insert_temoin(formData) {
	$.ajax({
		type: "POST",
		url: "ajouterDossier/insertTemoin",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			if (data[0]["error"] == "success") {
				console.log(data[1]);
				$('#temoin_returned_div').css('display', 'block');

				var success = '<br><div class="alert alert-success alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#temoin_returned_div").empty();
				$("#temoin_returned_div").append(success);

				var temoin_element = '<tr><td>' + data[1]["cinTemoin"] + '</td><td>' + data[1]["prenom"] + '</td><td>' + data[1]["nom"] + '</td ><td>' + data[1]["proffession"] + '</td><td class="text-right"><div class="btn-group"><button class="btn-white btn btn-xs">إطلاع</button><button class="btn-white btn btn-xs">حذف</button></div></td></tr>';
				$("#table_temoin_body").append(temoin_element);

			} else if (data[0]["error"] == "error") {
				$('#temoin_returned_div').css('display', 'block');

				var error = '<br><div class="alert alert-danger alert-dismissable"><button aria-hidden="true" data-dismiss="alert" class="close" type="button">×</button><span >' + data[0]["message"] + '</span></div>';
				$("#temoin_returned_div").empty();
				$("#temoin_returned_div").append(error);

			}

		},
		error: function(e) {

		}
	})
}