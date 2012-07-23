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
				out.println("<br>User: "+cookies[i].getValue());
				break;
			}
		}
		cookieName = "password";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				out.println("<br>Pass: "+cookies[i].getValue());
				break;
			}
		}
		cookieName = "ambito";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				out.println("<br>Ambito: "+cookies[i].getValue());
				break;
			}
		}
		cookieName = "loggedDesktop";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				out.println("<br>Desk: "+cookies[i].getValue());
				break;
			}
		}
		cookieName = "dataUltimaDomanda";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				out.println("<br>Ultima dom: "+cookies[i].getValue());
				break;
			}
		}
	}

%>