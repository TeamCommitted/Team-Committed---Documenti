/*
 * Name: punteggi.java
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
 * | 20120611 | Lorenzo Braghetto   | Adeguamento backend
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
boolean risposta = appC.login(user, passw);
Login l = new Login(user, passw);
Punteggio p = appC.getStat(l);
Dipendente d = appC.getDati(l);
ArrayList<Badge> b = appC.getBadge(l, 2);
Punteggio pDip = d.getPunteggio();
%>
<response>
<%
if(risposta)
{ %>
	<status>OK</status>
	<punteggi>
		<rispostedate><%=p.getnDomRisp()%></rispostedate>
		<rispostecorrette><%=p.getnRispCorr()%></rispostecorrette>
		<risposteerrate><%=p.getnDomRisp()-p.getnRispCorr()%></risposteerrate>
		<punti><%=pDip.getPunti()%></punti>
	</punteggi>
	<badges>
 		<badgesNum><%=b.size()%></badgesNum>
	<% for(int z=0;z<b.size();z++)
	{  %>
		<badge id="<%=z%>">
			<img></img>
			<testo><%=b.get(z).getDescrizione()%></testo>
		</badge>
	<% } %>	
	</badges>
<% }else{ %>
	<status>FAILED</status>
<% } %>
</response>
