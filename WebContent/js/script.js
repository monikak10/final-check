function validate() {
	var val1 = document.forms["myform"]["txtName"].value;
	if (val1 == "") {
		alert("Title is required");
		return false;
	}
	if(val1.length < 2 || (val1.length > 100) ) {
		alert("Title should have 2 to 100 characters");
		return false;
	}
	
	var val2 = document.forms["myform"]["txtGross"].value;
	if ( val2 == "" ) {
		alert("Box Office is required");
		return false;
	}
	var num = /[^0-9]/;
	if( num.test(val2) ) {
		alert("Box Office enter only numbers");
		return false;
	}
	var val3 = document.forms["myform"]["dol"].value;
	if (val3 == "") {
		alert("Date of Launch is required");
		return false;
	}
}

	