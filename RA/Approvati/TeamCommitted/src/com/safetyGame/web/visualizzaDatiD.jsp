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
<%
	// WebConnection connection = new WebConnection
%>

<%@ include file="html/header_pre_title.html" %>
I tuoi dati
<%@ include file="html/header_post_title.html" %>
<%@ include file="html/menud.html" %> 
<%@ include file="html/menu_content.html" %> 

<%@ include file="getCookies.jsp" %>
<% if (!(ambito.equals("Dipendente"))) response.sendRedirect("user_page.jsp"); %>

	<h2>Dati Personali</h2>
    <%
        WebConnection connection = Inizializzatore.getWeb();
		Dipendente dip = new Dipendente();
		Login l = new Login(username, password);
		dip = connection.getDati(l);
		
		if (dip == null) out.println("<span class=\"fallimento\">Impossibile recuperare i dati personali</span><p>Contattare l'amministratore di sistema</p>");
		else {
			out.println("<dl class=\"dati_utente\">");
			out.println("<dt>Nome:</dt><dd>"+dip.getNome()+"</dd>");
			out.println("<dt>Cognome:</dt><dd>"+dip.getCognome()+"</dd>");
			out.println("<dt>Nickname:</dt><dd>"+dip.getNickname()+"</dd>");
			out.println("<dt>Codice fiscale:</dt><dd>"+dip.getCodFiscale()+"</dd>");
			out.println("<dt>Email:</dt><dd>"+dip.getEmail()+"</dd>");
			out.println("</dl>");
			out.println("<h2>Modifica dati personali</h2>");
			out.println("<p><a href=\"modEmailD.jsp\">Modifica l'indirizzo Email</a></p>");
			out.println("<p><a href=\"modPassD.jsp\">Modifica password</a></p>");
		}
		%><%@ include file="forzaCambioPass.jsp" %><%
	%>
        
<%@ include file="html/footer.html" %> 