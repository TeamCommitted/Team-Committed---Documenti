<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.util.regex.*"%>
<%@ page language="java" import="com.safetyGame.back.connection.*" %>
<%@ page language="java" import="com.safetyGame.back.controller.*" %>
<%@ page language="java" import="com.safetyGame.back.condivisi.*" %>
<%@ page language="java" import="com.safetyGame.back.access.*" %>
<%@ page language="java" import="com.safetyGame.back.*" %>
<%@ include file="html/header_pre_title.html" %> 
Modifica Email
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menud.html" %> 
<%@ include file="html/menu_content.html" %> 

<%@ include file="getCookies.jsp" %>
<% if (!(ambito.equals("Dipendente"))) response.sendRedirect("index.jsp"); %>
    
    <%
		String nuovaEmail = request.getParameter("nuovaEmail");
		String psw = request.getParameter("password");
		if (!(psw.equals(password))) out.println("<span class=\"fallimento\">Attenzione! La password non &egrave; corretta</span><p>Torna indietro ed inserisci i dati corretti</p>");
		else {
			WebConnection connection = Inizializzatore.getWeb();
			
			Login l = new Login(username, password);			
			Dipendente d = new Dipendente();
			d = connection.getDati(l);
			
			boolean success = false;
			
			String regex = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(nuovaEmail);
			if (matcher.matches()) {
				success = connection.modMail(d, nuovaEmail); 
				if (!success) out.println("<span class=\"fallimento\">Cambio Email non riuscito.</span><p>Ritenta o contatta l'amministratore di sistema</p>");
				else out.println("<span class=\"successo\">L'Email &eacute; stata cambiata!</span>");
			}
			else out.println("<span class=\"fallimento\">L'indirizzo email inserito non &egrave; valido!</span><p>Torna indietro e inserisci un indirizzo valido</p>");
		}
	%>

<%@ include file="html/footer.html" %> 