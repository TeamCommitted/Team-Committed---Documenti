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

<%@ include file="html/header_pre_title.html" %> 
Nuova Domanda
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menud.html" %> 
<%@ include file="html/menu_content.html" %> 

<%@ include file="getCookies.jsp" %>
<%
	
	WebConnection connection = Inizializzatore.getWeb();
	Login l = new Login(username,password);	
	
	try {
		int risposta = Integer.parseInt(request.getParameter("group1")); 
		Domanda domanda = (Domanda) session.getAttribute("oggetto_domanda");
		domanda.setRispostaData(risposta);
		boolean rispostoConSuccesso = connection.setRisposta(l, domanda);
		out.println("<span class=\"successo\">La tua risposta &egrave; stata inviata con successo!</span>");
		
		// Imposto il cookie per la data dell'ultima domanda
		Date now = new Date();
		String timestamp = ""+now.getTime();
		Cookie dataUltimaDomanda = new Cookie("dataUltimaDomanda", timestamp);
		dataUltimaDomanda.setMaxAge(24 * 60 * 60);
		response.addCookie(dataUltimaDomanda);
	}
	catch(Exception e) {
		out.println("<span class=\"fallimento\">Errore - Impossibile recuperare la risposta dalla pagina precedente. Torna indietro e riprova</span>");
	}
	
%>

<%@ include file="html/footer.html" %> 