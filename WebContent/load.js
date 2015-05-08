var playerNum = 0;

function loaders() {
	var amount = 8000000;
	$(".money  span").text("$ " + amount);
	var khiladiType = "WicketKeeper";
	var selectorID = document.getElementById("playerType");
	selectorID.onchange = function() {
		khiladiType = $("#playerType :selected").text();
		var table = document.getElementById('myTable').getElementsByTagName('tbody')[0];
		$("#myTable > tbody").html("");
		$(".players").height();
		$.getJSON('data.json', function(data) {
			//alert(data["WicketKeeper"].length);
			//alert("pk " + data[khiladiType].length);
			for (var i = 0; i < data[khiladiType].length; i++) {
				var row = table.insertRow(table.rows.length);
				row.id = data[khiladiType][i].Id;

				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);

				cell1.innerHTML = '<div class="rowTable"><img src="images/back.png" alt="Mountain View" style="width:18px;height:20px"></div>';
				cell2.innerHTML = data[khiladiType][i].Name;
				cell3.innerHTML = data[khiladiType][i].Team;
				cell4.innerHTML = data[khiladiType][i].Money;
			}
		});
		setTimeout(enableClicks, 100);
	};
	var table = document.getElementById('myTable').getElementsByTagName('tbody')[0];
	$("#myTable > tbody").html("");
	$.getJSON('data.json', function(data) {

		for (var i = 0; i < data.Batsmen.length; i++) {
			var row = table.insertRow(table.rows.length);
			row.id = data.Batsmen[i].Id;

			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);

			cell1.innerHTML = '<div class="rowTable"><img src="images/back.png" alt="Mountain View" style="width:18px;height:20px"></div>';
			cell2.innerHTML = data.Batsmen[i].Name;
			cell3.innerHTML = data.Batsmen[i].Team;
			cell4.innerHTML = data.Batsmen[i].Money;
		}
	});

	setTimeout(enableClicks, 100);

	
	$(".close").click(function() {
		if (playerNum>0) {
			var pl_id = $(this).next().next().text();
			// alert(pl_id);
			$("#" + pl_id).show();
			var delID = $(this).next().attr('class');
			delID = parseInt(delID.slice(-1));
			//$(this).prev().html('<input type="text" name="player' + delID + '" maxlength="255" required >');
			amount = parseInt($(".money  span").text().slice(1)) + parseInt($(".khiladi" + delID).find("input[name='money" + delID + "']:text").val().replace(/,/g,""));
			$(".money  span").text("$ " + amount);
			
			for (var i = delID; i < playerNum; i++) {
				var j = i + 1;
				$(".khiladi" + i).find("input[name='player" + i + "']:text").val($(".khiladi" + j).find("input[name='player" + j + "']:text").val());
				$(".khiladi" + i).find("input[name='team" + i + "']:text").val($(".khiladi" + j).find("input[name='team" + j + "']:text").val());
				$(".khiladi" + i).find("input[name='money" + i + "']:text").val($(".khiladi" + j).find("input[name='money" + j + "']:text").val());
				$(".khiladi" + i).find("input[name='playerType" + i + "']:text").val($(".khiladi" + j).find("input[name='playerType" + j + "']:text").val());
				$(".khiladi" + i).next().next().html($(".khiladi" + j).next().next().text());
				$(".player" + i).css('background-image', 'url(' + "teamImages/" + $(".khiladi" + j).find("input[name='team" + j + "']:text").val() + ".jpg" + ')');
			}
			$(".khiladi" + i).find("input[name='player" + i + "']:text").val("");
			$(".khiladi" + i).find("input[name='team" + i + "']:text").val("");
			$(".khiladi" + i).find("input[name='money" + i + "']:text").val("");
			$(".khiladi" + i).find("input[name='playerType" + i + "']:text").val("");
			$(".khiladi" + i).next().next().html("");
			$(".player" + i).css('background-image', 'url("")');
			$(".player" + i).find("span").hide();
			
			playerNum--;
		}
	});
	
}

function enableClicks() {
	var amount;
	$(".rowTable").click(function() {
		var $row = $(this).closest("tr"); // Find the row
		var $tds = $row.find("td");
		var playerType = $(this).closest('table').find('th').eq(1).find('option:selected').val();

		amount = parseInt($(".money  span").text().slice(1)) - parseInt($tds[3].textContent.replace(/,/g, ""));
		if (playerNum < 9 && amount > 0) {
			playerNum++;
			var addedPlayer = $row.attr('id');
			$("#" + addedPlayer).hide();
			//var field = $(".khiladi" + playerNum);
			$(".khiladi" + playerNum).find("input[name='player" + playerNum + "']:text").val($tds[1].textContent);
			$(".khiladi" + playerNum).find("input[name='team" + playerNum + "']:text").val($tds[2].textContent);
			$(".khiladi" + playerNum).find("input[name='money" + playerNum + "']:text").val($tds[3].textContent);
			$(".khiladi" + playerNum).find("input[name='playerType" + playerNum + "']:text").val(playerType);
			//$(".khiladi" + playerNum).html($tds[1].textContent);
			$(".khiladi" + playerNum).next().html(addedPlayer);
			$(".player" + playerNum).css('background-image', 'url(' + "teamImages/" + $tds[2].textContent + ".jpg" + ')');
			amount = parseInt($(".money  span").text().slice(1)) - parseInt($tds[3].textContent.replace(/,/g, ""));
			$(".player" + playerNum).find("span").show();
			$(".money  span").text("$ " + amount);
		}
	});

}