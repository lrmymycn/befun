function showDialog(url, width, height) {
	var w = 600;
	var h = 400;
	if(width){
		w = width;
	}
	if(height){
		h = height;
	}
	if (document.all) // IE
	{
		feature = "dialogWidth:"+w+"px;dialogHeight:"+h+"px;status:no;help:no;location:no;scrollbars:yes;modal:yes";
		window.showModalDialog(url, null, feature);
	} else {
		feature = "width="+w+",height="+h+",menubar=no,toolbar=no,location=no,";
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
