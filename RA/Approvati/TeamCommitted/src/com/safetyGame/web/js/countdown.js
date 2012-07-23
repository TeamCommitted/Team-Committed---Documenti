function init(){
  var loggedDesktop = getCookie("loggedDesktop");
  // Se il login è stato effettuato tramite desktop non attivo il pop-up web
  if (loggedDesktop != "true") {
	  var c=getCookie("tempo_rimasto");
	  if (c==null){
		var tempo=120000;
		setCookie("tempo_rimasto",tempo,80000);
		setCookie("delta",tempo/10,80000);
		c=getCookie("tempo_rimasto");
	  }
	  countdown(c);
  }
}

function countdown(tempo){
  if (tempo <=0){
    azzera();
    var r = confirm('Ti suggeriamo di rispondere ad una nuova domanda');
	if (r==true) {
		location.href = "nuovaDomanda.jsp";
	}
	else {
		init();
		var l = location.href;
		location.href = "posticipa.jsp?page="+l;
	}
  }
  else{
    setCookie("tempo_rimasto",tempo,80000);  
    var delta=getCookie("delta");
    var delta2=tempo-delta;
    setTimeout("countdown("+delta2+")",delta);
  }
}

function azzera(){
  setCookie("tempo_rimasto",0,0);
  setCookie("delta",0,0);
}

function setCookie(c_name,value,exdays){ //presa da w3s
  var exdate=new Date();
  exdate.setDate(exdate.getDate() + exdays);
  var c_value=escape(value) + ((exdays==null) ? "" : "; expires="+exdate.toUTCString());
  document.cookie=c_name + "=" + c_value;
}

function getCookie(c_name){ //presa da w3s
  var i,x,y,ARRcookies=document.cookie.split(";");
  for (i=0;i<ARRcookies.length;i++){
    x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
    y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
    x=x.replace(/^\s+|\s+$/g,"");
    if (x==c_name){
      return unescape(y);
    }
  }
  return null;
}

//<body onload="init()"> 
//logout.jsp--> <body onload="azzera()">
