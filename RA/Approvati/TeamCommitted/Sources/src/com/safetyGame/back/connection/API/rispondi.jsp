/*
 * Name: rispondi.java
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
 * | 20120611 | Lorenzo Braghetto   | 
 * +----------+---------------------+----------------------
 * 
 */ 
<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" import="com.safetyGame.back.connection.*"  %>
<%@page import="com.safetyGame.back.condivisi.*" %>
<%@page import="com.safetyGame.back.*" %>
<%@page import="java.util.ArrayList" %>
<% 
ApplicazioniConnection appC = Inizializzatore.getApp();
String user = request.getParameter("username");
String passw = request.getParameter("password");
int id = Integer.parseInt(request.getParameter("id"));
int punti = Integer.parseInt(request.getParameter("punti"));
Punteggio p = new Punteggio(punti);
int corretta = Integer.parseInt(request.getParameter("corretta"));
int rispostaData = Integer.parseInt(request.getParameter("rispostaData"));
String ambito = request.getParameter("ambito");

boolean risposta = appC.login(user, passw);
Login l = new Login(user, passw);

Domanda d = new Domanda();
d.setId(id);
d.setPunteggio(p);
d.setCorretta(corretta);
d.setRispostaData(rispostaData);
d.setAmbito(ambito);

boolean risposto = appC.rispondi(l, d);
if(risposta && risposto)
{ %>
	<status>OK</status>
<% }else{ %>
	<status>FAILED</status>
<% }	%>	
</response>
