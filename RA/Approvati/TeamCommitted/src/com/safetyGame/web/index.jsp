<% 
/*
	La pagina index.jsp serve esclusivamente a reindirizare l'utente verso la pagina corretta.
    Se non esiste il cookie relativo allo username (o all'ambito) si viene rimandati alla pagina di login.
    Altrimenti, si fa un controllo sull'ambito e si viene reindirizzati alla pagina utente o alla pagina amministratore.
*/
%>

<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language= "java" import="java.util.Date"%>

<%

	Cookie cookies [] = request.getCookies();
	String cookieName = null;
	String username = null;
	String ambito = null;
	
	if (cookies != null){
		cookieName = "username";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				username = cookies[i].getValue();
				break;
			}
		}
		cookieName = "ambito";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				ambito = cookies[i].getValue();
				break;
			}
		}
	}
	
	if ((username == null) || (ambito == null)) response.sendRedirect("login.jsp");
	else if (ambito.equals("Dipendente")) response.sendRedirect("user_page.jsp");
	else response.sendRedirect("admin_page.jsp");
	
%>