<% 
	// Ottengo le informazioni dai cookies
	Cookie usernameCookie = null;
	Cookie passwordCookie = null;
	Cookie ambitoCookie = null;
	Cookie cookies [] = request.getCookies();
	String cookieName = null;
	String username = null;
	String password = null;
	String ambito = null;
	
	cookieName = "username";
	if (cookies != null){
		for (int i = 0; i < cookies.length; i++){
			if (cookies [i].getName().equals(cookieName)){
				usernameCookie = cookies[i];
				break;
			}
		}
		cookieName = "password";
		for (int i = 0; i < cookies.length; i++){
			if (cookies [i].getName().equals(cookieName)){
				passwordCookie = cookies[i];
				break;
			}
		}
		cookieName = "ambito";
		for (int i = 0; i < cookies.length; i++){
			if (cookies [i].getName().equals(cookieName)){
				ambitoCookie = cookies[i];
				break;
			}
		}
		try {
			username = usernameCookie.getValue();
			password = passwordCookie.getValue();
			ambito = ambitoCookie.getValue();
		}
		catch (Exception e) { response.sendRedirect("login.jsp"); }
	}
	else response.sendRedirect("login.jsp");
%>