<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="com.safetyGame.back.connection.*" %>
<%@ page language="java" import="com.safetyGame.back.controller.*" %>
<%@ page language="java" import="com.safetyGame.back.condivisi.*" %>
<%@ page language="java" import="com.safetyGame.back.access.*" %>
<%@ page language="java" import="com.safetyGame.back.*" %>

<%
	String getUsername = request.getParameter("nick"); // Ottengo lo username dal get
	String getPassword = request.getParameter("pass"); // Ottengo la psw dal get
	String nextPage = request.getParameter("page"); // Ottengo la prossima pagina dal get
	
// Ottengo le informazioni dai cookies
	Cookie usernameCookie = null;
	Cookie passwordCookie = null;
	Cookie ambitoCookie = null;
	Cookie loggedDesktop = null;
	Cookie cookies [] = request.getCookies();
	String cookieName = null;
	String username = "";
	String password = null;
	String ambito = null;
	
	boolean logged = true;
	
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
		catch (Exception e) { logged = false; }
	}
	else response.sendRedirect("login.jsp");
	
	if ( (!(username.equals(getUsername))) && (logged) ) response.sendRedirect("error.jsp");
	else {	
		usernameCookie = new Cookie ("username",getUsername);
		passwordCookie = new Cookie ("password",getPassword);
		ambitoCookie = new Cookie ("ambito","Dipendente");
		loggedDesktop = new Cookie ("loggedDesktop", "true");
		usernameCookie.setMaxAge(24 * 60 * 60); // 24h di validità
		passwordCookie.setMaxAge(24 * 60 * 60);
		ambitoCookie.setMaxAge(24 * 60 * 60);
		loggedDesktop.setMaxAge(24 * 60 * 60);
		response.addCookie(usernameCookie);
		response.addCookie(passwordCookie);
		response.addCookie(ambitoCookie);
		response.addCookie(loggedDesktop);
		response.sendRedirect(nextPage);
	}
	
%>