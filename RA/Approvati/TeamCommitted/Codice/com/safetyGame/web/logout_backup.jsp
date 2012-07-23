<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language= "java" import= "java.util.Date"%>

<% 
	Cookie cookies [] = request.getCookies();
	String cookieName = null;
	
	if (cookies != null){
		cookieName = "username";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				break;
			}
		}
		cookieName = "password";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				break;
			}
		}
		cookieName = "ambito";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				break;
			}
		}
		cookieName = "loggedDesktop";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				break;
			}
		}
	}
	
	//
	// Qua va richiamata la funziona che avvisa il back-end di un avvenuto Logout
	// logout(username);
	//
	
	response.sendRedirect("index.jsp");
%>