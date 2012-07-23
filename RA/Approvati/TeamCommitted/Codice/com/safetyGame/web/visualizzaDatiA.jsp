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
I tuoi dati
<%@ include file="html/header_post_title.html" %>

<%@ include file="getCookies.jsp" %>
<% if ((ambito.equals("Dipendente"))) response.sendRedirect("user_page.jsp");
	if (ambito.equals("Amministratore Azienda")) { %>
	<%@ include file="html/menuaa.html" %> 
<%  }
	else if (ambito.equals("Amministratore Sicurezza")) { %>
    <%@ include file="html/menuas.html" %> 
<% } %>
<%@ include file="html/menu_content.html" %> 



	<h2>Dati Personali</h2>
    <%
        WebConnection connection = Inizializzatore.getWeb();
		%><%@ include file="forzaCambioPassA.jsp" %><%
		Login loginA = new Login(username, password);
		Dipendente adm = connection.getDatiA(loginA);
		if (adm == null) out.println("<span class=\"fallimento\">Impossibile recuperare i dati personali</span><p>Contattare l'amministratore di sistema</p>");
		else {
			out.println("<dl class=\"dati_utente\">");
			out.println("<dt>Nickname:</dt><dd>"+adm.getNickname()+"</dd>");
			out.println("<dt>Codice fiscale:</dt><dd>"+adm.getCodFiscale()+"</dd>");
			out.println("<dt>Email:</dt><dd>"+adm.getEmail()+"</dd>");
			out.println("</dl>");
		}
	%>
        
<%@ include file="html/footer.html" %> 