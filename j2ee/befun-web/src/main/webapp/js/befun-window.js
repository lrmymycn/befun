function showDialog(url) {
	if (document.all) // IE
	{
		feature = "dialogWidth:600px;dialogHeight:400px;status:no;help:no;location:no;scrollbars:yes;modal:yes";
		window.showModalDialog(url, null, feature);
	} else {
		feature = "width=600,height=400,menubar=no,toolbar=no,location=no,";
		feature += "scrollbars=yes,status=no,modal=yes";
		window.open(url, null, feature);
	}
}

function closeCurrentWindow() {
	window.open('', '_parent', '');
	window.top.opener = null;
	window.close();
	return true;
}
