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
Domanda d = appC.mostraDomanda(l);

%>
<response>
<%
if(risposta)
{ %>
	<status>OK</status>
	<domanda>
		<% String tipo = d.getTipologia();
		 %>
			<id><%=d.getId()%></id>
			<type><%=tipo%></type>
			<testo><%=d.getTesto()%></testo>
			<punteggio><%=d.getPunteggio().getPunti()%></punteggio>
			<corretta><%=d.getCorretta()%></corretta>
		<% if(!tipo.equals("sino"))
		   {
			ArrayList<String> risposte = d.getRisposte(); 
		%>
		<risposte num="<%=risposte.size()%>">
		<%	for(int z=0;z<risposte.size();z++)
			{	
		%>
				<risposta id="<%=z%>"><%=risposte.get(z)%></risposta>
			<% } %>
			</risposte>
		<% } %>
	</domanda>
<% }else{ %>
	<status>FAILED</status>
<% } %>		
</response>
