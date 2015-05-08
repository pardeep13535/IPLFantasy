function loaders() {
	var table = document.getElementById('myTable').getElementsByTagName('tbody')[0];

	$.getJSON('data.json', function(data) {
		for (var i = 0; i < data.WicketKeeper.length; i++) {

			var row = table.insertRow(table.rows.length);

			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);

			cell1.innerHTML = data.WicketKeeper[i].Name;
			cell2.innerHTML = data.WicketKeeper[i].Money;
		}
	});
	
	 //("#myTable").tablesorter(); 
}