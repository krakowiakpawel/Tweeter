function getCookie(cname) {
	var name = cname + "=";
	var decodedCookie = decodeURIComponent(document.cookie);
	var ca = decodedCookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		
		if (c.indexOf(name) == 0) {
			var temp = c.substring(name.length, c.length);
			var splitedArr = temp.split('+');
			var output = "";
	
			for (var i = 0; i < splitedArr.length; i++) {
				output += splitedArr[i] + " ";
			}
			
			return output.trim();
		}
	}
	return "";
}

function print(data) {
	console.log(data);
}



