
// Recuperer les infos

function rechercherEvent(event) {
	event.preventDefault();
	var formData = new FormData();
	formData.append("search_type", $("#search_type").val());
	formData.append("search_keyword", $("#search_keyword").val());

	$.ajax({
		type: "POST",
		url: "rechercher/action",
		processData: false,
		contentType: false,
		cache: false,
		data: formData,
		timeout: 600000,
		success: function(data) {
			if (data[0]["error"] == "success") {
				if (formData.get("search_type") == "dossier") {
					$("#search_results").empty();
					$("#search_results").append('<div class="hr-line-dashed"></div><div class="search-result"><h3><a href="#">' + data[1]["numeroDossier"] + '</a></h3><span class="search-link">ملف</span><p><span class="font-bold"> المحكمة: </span><span >' + data[1]["tribunal"] + '</span><br><span class="font-bold"> ملاحظة: </span><span >' + data[1]["commentaire"] + '</span><br></p></div>');

				} else if (formData.get("search_type") == "victime") {
					$("#search_results").empty();
					if (data.length == 1) {
						$("#search_results").empty();
						$("#search_results").append('<div class="hr-line-dashed"></div><div class="search-result"><h3>لا يوجد نتائج</h3><p><span class="font-bold">حاول تغيير محتوى البحث</span><br></p></div>');
					} else {
						for (let i = 1; i < data.length; i++) {
							$("#search_results").append('<div class="hr-line-dashed"></div><div class="search-result"><h3><a href="#">' + data[i]["prenom"] + ' ' + data[i]["nom"] + '</a></h3><span class="search-link">ضحية</span><p><span class="font-bold"> المهنة: </span><span >' + data[i]["proffession"] + '</span><br><span class="font-bold"> الحالة: </span><span >' + data[i]["etat"] + '</span><br><span class="font-bold"> العنوان: </span><span >' + data[i]["addresse"] + '</span><br></p></div>');
						}
					}

				} else if (formData.get("search_type") == "accuse") {
					$("#search_results").empty();
					if (data.length == 1) {
						$("#search_results").empty();
						$("#search_results").append('<div class="hr-line-dashed"></div><div class="search-result"><h3>لا يوجد نتائج</h3><p><span class="font-bold">حاول تغيير محتوى البحث</span><br></p></div>');
					} else {
						for (let i = 1; i < data.length; i++) {
							$("#search_results").append('<div class="hr-line-dashed"></div><div class="search-result"><h3><a href="#">' + data[i]["prenom"] + ' ' + data[i]["nom"] + '</a></h3><span class="search-link">متهم</span><p><span class="font-bold"> المهنة: </span><span >' + data[i]["proffession"] + '</span><br><span class="font-bold"> رقم البطاقة الوطنية: </span><span >' + data[i]["cin"] + '</span><br><span class="font-bold"> العنوان: </span><span >' + data[i]["addresse"] + '</span><br></p></div>');
						}
					}
				} else {
					$("#search_results").empty();
					if (data.length == 1) {
						$("#search_results").empty();
						$("#search_results").append('<div class="hr-line-dashed"></div><div class="search-result"><h3>لا يوجد نتائج</h3><p><span class="font-bold">حاول تغيير محتوى البحث</span><br></p></div>');
					} else {
						for (let i = 1; i < data.length; i++) {
							$("#search_results").append('<div class="hr-line-dashed"></div><div class="search-result"><h3><a href="#">' + data[i]["prenom"] + ' ' + data[i]["nom"] + '</a></h3><span class="search-link">شاهد</span><p><span class="font-bold"> رقم البطاقة الوطنية: </span><span >' + data[i]["cinTemoin"] + '</span><br><span class="font-bold"> العنوان: </span><span >' + data[i]["addresse"] + '</span><br></p></div>');
						}
					}
				}

			} else {
				$("#search_results").empty();
				$("#search_results").append('<div class="hr-line-dashed"></div><div class="search-result"><h3>لا يوجد نتائج</h3><p><span class="font-bold">حاول تغيير محتوى البحث</span><br></p></div>');
			}
		},
		error: function(e) {
			alert("Error");
		}
	});
}
