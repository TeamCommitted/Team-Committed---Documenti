<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" import="com.safetyGame.back.connection.*"  %>
<%@page import="com.safetyGame.back.condivisi.*" %>
<%@page import="com.safetyGame.back.*" %>
<%@page import="java.util.ArrayList" %>
<% 
Inizializzatore i = new Inizializzatore();
ApplicazioniConnection appC = i.getApp();
String user = request.getParameter("username");
String passw = request.getParameter("password");
boolean risposta = appC.login(user, passw);
Login l = new Login(user, passw);
Punteggio p = appC.getStat(l);
ArrayList<Badge> b = appC.getBadge(l, 2);
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
		<punti><%=p.getPunti()%></punti>
	</punteggi>
	<badges num="<%=b.size()%>">
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
