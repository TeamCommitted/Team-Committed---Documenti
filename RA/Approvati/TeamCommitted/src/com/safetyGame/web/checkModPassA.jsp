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
Safety Game - Modifica Password
<%@ include file="html/header_post_title.html" %> 
<%@ include file="getCookies.jsp" %>
<% if ((ambito.equals("Dipendente"))) response.sendRedirect("index.jsp"); %>
<%	if (ambito.equals("Amministratore Azienda")) {%>
	<%@ include file="html/menuaa.html" %> 
<% }if (ambito.equals("Amministratore Sicurezza")) {%>
	<%@ include file="html/menuas.html" %> 
<% } %><%@ include file="html/menu_content.html" %> 
    
    <%
		String nuovaPass = request.getParameter("nuovaPass");
		String confPass = request.getParameter("confPass");
		String vecchiaPass = request.getParameter("vecchiaPass");
		if (!(nuovaPass.equals(confPass))) out.println("<span class=\"fallimento\">Attenzione! La nuova password non coincide con la sua conferma</span><p>Torna indietro ed inserisci i dati corretti</p>");
		else if (!(vecchiaPass.equals(password))) out.println("<span class=\"fallimento\">Attenzione! La vecchia password non &egrave; corretta</span><p>Torna indietro ed inserisci i dati corretti</p>");
		else {
			WebConnection connection = Inizializzatore.getWeb();
			Login loginA = new Login(username, password);
			Dipendente adm = connection.getDatiA(loginA);
			adm.setNuovaPass(nuovaPass);
			connection.modPassA(adm);
			out.println("<span class=\"successo\">La password &eacute; stata cambiata!</span>");
			
			// Ora cambio il cookie relativo alla password
			String psw = adm.getNuovaPass();
			String nomeCookie = "password";
			// Elimino il cookie già esistente
			if (cookies != null){
				for (int it = 0; it < cookies.length; it++) {
					if (cookies [it].getName().equals(nomeCookie)) {
						cookies[it].setMaxAge(0);
						response.addCookie(cookies[it]);
						break;
					}
				}
			}
			// Creo e aggiungo un nuovo cookie
			Cookie pswCookie = new Cookie ("password",psw);
			pswCookie.setMaxAge(24 * 60 * 60);
			response.addCookie(pswCookie);
		}
	%>

<%@ include file="html/footer.html" %> 