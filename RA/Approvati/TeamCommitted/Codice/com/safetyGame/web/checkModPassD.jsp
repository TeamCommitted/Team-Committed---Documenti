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
Modifica Password
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menud.html" %> 
<%@ include file="html/menu_content.html" %> 

<%@ include file="getCookies.jsp" %>
<% if (!(ambito.equals("Dipendente"))) response.sendRedirect("index.jsp"); %>
    
    <%
		String nuovaPass = request.getParameter("nuovaPass");
		String confPass = request.getParameter("confPass");
		String vecchiaPass = request.getParameter("vecchiaPass");
		WebConnection connection = Inizializzatore.getWeb();
		Dipendente d = null;
		Login l = new Login(username, password);
		d = connection.getDati(l);
		String modPass = d.getNuovaPass();
		if (!(nuovaPass.equals(confPass))) out.println("<span class=\"fallimento\">Attenzione! La nuova password non coincide con la sua conferma</span><p>Torna indietro ed inserisci i dati corretti</p>");
		else if ( !((vecchiaPass.equals(password)) || (vecchiaPass.equals(modPass))) ) out.println("<span class=\"fallimento\">Attenzione! La vecchia password non &egrave; corretta</span><p>Torna indietro ed inserisci i dati corretti</p>");
		else {
			
			
			d.setNuovaPass(nuovaPass);
			connection.modPassD(d);
			out.println("<span class=\"successo\">La password &eacute; stata cambiata!</span>");
			
			// Ora cambio il cookie relativo alla password
			String psw = d.getNuovaPass();
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