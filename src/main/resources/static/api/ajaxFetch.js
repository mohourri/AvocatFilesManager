/**
 * 
 */

function addFolderEvent(event){
	event.preventDefault();
	fire_ajax();
}

function fire_ajax(){
	$.ajax({
		type: "GET",
		url: "/fetchExemple",
		processData: false,
		contentType: false,
		cache: false,
		timeout: 600000,
		success: function (data){
			$("#insertAjaxReturnedValue").empty();
			$("#insertAjaxReturnedValue").append(data);
		},
		error: function (e){
			 
		}
	})
}