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


function showModalDialog(destUrl, w, h) {
	var wi = 600;
	var he = 400;
	if(w){
		wi = w;
	}
	if(h){
		he = h;
	}
    $.ajax({  
        type:"post",  
        url: destUrl,
        dataType:"html",  
        success:function(html){  
            $("#childrenDiv").empty();  
            $("#childrenDiv").html(html);  
            $("#childrenDiv").dialog({
            	autoOpen: false,
                title : "Information",  
                top : '20%',  
                left : '22%',  
                width : wi,  
                height : he,  
                modal : true,  
                buttons : {
	    			"Close" : function() {
	    				$(this).dialog("close");
	    			}
    			},
    			close : function() {
    				document.getElementById("queryButton").onclick();
    			}
            });
            $("#childrenDiv").dialog("open");
        },  
        error:function(){  
        	window.alert("error");
        }
    });  
}
