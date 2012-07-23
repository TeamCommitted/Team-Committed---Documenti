/*
 * Name: cambioPassw.java
 * Package: com.safetygame.back.connection.API
 * Author: Lorenzo Braghetto
 * Date: {Data di approvazione del file}
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120722 | Lorenzo Braghetto   | Adeguamento backend
 * +----------+---------------------+----------------------
 * | 20120718 | Lorenzo Braghetto   | 
 * +----------+---------------------+----------------------
 * 
 */
<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" import="com.safetyGame.back.connection.*"  %>
<%@page import="com.safetyGame.back.condivisi.*" %>
<%@page import="com.safetyGame.back.*" %>
<% 
ApplicazioniConnection appC = Inizializzatore.getApp();
String user = request.getParameter("username");
String passw = request.getParameter("vecchiaPassword");
String nuovaPass = request.getParameter("nuovaPassword");
boolean risposta = appC.login(user, passw);
Login l = new Login(user, passw);
Dipendente d = appC.getDati(l);
boolean risposta2 = false;
d.setNuovaPass(nuovaPass);
if(nuovaPass.length()>0)
	risposta2 = appC.modPass(d);
%>
<response>
<%
if(risposta && risposta2)
{ %>
	<status>OK</status>
<% }else{ %>
	<status>FAILED</status>
<% } %>		
</response>
