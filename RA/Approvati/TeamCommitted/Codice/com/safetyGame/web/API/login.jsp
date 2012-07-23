<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" import="com.safetyGame.back.connection.*"  %>
<%@page import="com.safetyGame.back.*"  %>
<% 
Inizializzatore i = new Inizializzatore();
ApplicazioniConnection appC = i.getApp();
String user = request.getParameter("username");
String passw = request.getParameter("password");
boolean risposta = appC.login(user, passw);
%>
<response>
<%
if(risposta)
{ %>
	<status>OK</status>
<% }else{ %>
	<status>FAILED</status>
<% } %>
</response>
