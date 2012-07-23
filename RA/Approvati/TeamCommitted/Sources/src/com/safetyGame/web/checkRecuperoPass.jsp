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
Recupero Password
<%@ include file="html/header_post_title.html" %>
<%@ include file="html/menu.html" %>
<%@ include file="html/menu_content.html" %> 

<%
	String email = request.getParameter("email");
	String codfis = request.getParameter("codfis");
	String ambito = request.getParameter("radio");
	boolean successo = false;
	
	WebConnection connection = Inizializzatore.getWeb();
	
	Recupero r = new Recupero(email, codfis);
	if (ambito.equals("Amministratore")) {
		successo = connection.resetPassA(r);
	}
	else {
		successo = connection.resetPassD(r);
	}
	
	if (successo) out.println("<span class=\"successo\">La tua password &egrave; stata cambiata!</span><p>Riceverai la nuova password all'indirizzo che hai specificato</p>");
	else out.println("<span class=\"fallimento\">Errore nel cambio password!</span><p>Ritenta o contatta l'amministratore di sistema</p>");
	
%>
	
<%@ include file="html/footer.html" %> 