/*
 * Name: domanda.java
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
			<tempo><%=d.getTempo()%></tempo>
			<mobile><%=d.isMobile()%></mobile>
			<ambito><%=d.getAmbito()%></ambito>
		<% if(!tipo.equals("sino"))
		   {
			ArrayList<String> risposte = d.getRisposte(); 
		%>
		<risposte>
			 <risposteNum><%=risposte.size()%></risposteNum>
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
