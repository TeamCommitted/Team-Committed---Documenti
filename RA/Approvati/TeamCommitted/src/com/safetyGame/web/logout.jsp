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
<%@ include file="getCookies.jsp" %>

<% 
	WebConnection connection = Inizializzatore.getWeb();
	Login l = new Login(username, password);
	boolean isAdmin = (!(ambito.equals("Dipendente")));
	cookies = request.getCookies();
	cookieName = null;
	
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
		cookieName = "dataUltimaDomanda";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				cookies[i].setMaxAge(0);
				response.addCookie(cookies[i]);
				break;
			}
		}
	}
	
	if (isAdmin) connection.logoutA(l);
	else connection.logoutD(l);
	
	response.sendRedirect("index.jsp");
%>