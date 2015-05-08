function contactLoader() {

	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", "/IPLFantasy/contact", true);

	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			contactRequestHandler(xmlhttp);
		}
	};

	xmlhttp.send();
}

function contactRequestHandler(request) {
	var responseData = request.responseText;
	var jsonObject = JSON.parse(responseData);
	$("#teamTitle span").text(jsonObject.players[0].name);
	for (var i = 1; i < 9; i++) {
		$(".player" + i + " span").text(jsonObject.players[i].name);
	}

	// setTimeout(contactLoader, 200);
}

function sendTeam() {
	var teamName = $("#team").val();
	window.location.href = "yourTeam.do?teamName=" + teamName;
}