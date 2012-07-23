<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" import="com.safetyGame.back.connection.*"  %>
<%@page import="com.safetyGame.back.condivisi.*" %>
<%@page import="com.safetyGame.back.*" %>
<% 
Inizializzatore i = new Inizializzatore();
ApplicazioniConnection appC = i.getApp();
String user = request.getParameter("username");
String passw = request.getParameter("password");
boolean risposta = appC.login(user, passw);
Login l = new Login(user, passw);
Dipendente d = appC.getDati(l);
%>
<response>
<%
if(risposta)
{ %>
	<status>OK</status>
	<dati>
		<nome><%=d.getNome()%></nome>
		<cognome><%=d.getCognome()%></cognome>
	</dati>
<% }else{ %>
	<status>FAILED</status>
<% } %>
</response>
