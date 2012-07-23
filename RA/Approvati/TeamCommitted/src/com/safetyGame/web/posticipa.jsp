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
	Domanda nuovadomanda = connection.mostraDomanda(l);
	boolean posticipata = true;
	if(nuovadomanda != null){
		posticipata = connection.posticipa(l, nuovadomanda);
	}
	else posticipata = true;
	String nextPage;
	nextPage = request.getParameter("page");
	
	if (!((nextPage == null)||(nextPage.equals("")))) {
		if (posticipata) {
			response.sendRedirect(nextPage);
		}
		else {
			out.print("Impossibile posticipare la domanda.");
		}
	}
	else response.sendRedirect("index.jsp");

%>