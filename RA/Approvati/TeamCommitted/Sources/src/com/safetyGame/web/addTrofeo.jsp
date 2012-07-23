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
SafetyGame - Dettagli Dipendente
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menuaa.html" %> 
<%@ include file="html/menu_content.html" %> 

<%@ include file="getCookies.jsp" %>
<% if (!(ambito.equals("Amministratore Azienda"))) response.sendRedirect("user_page.jsp"); %>
			
	<%
        int id = Integer.parseInt(request.getParameter("id"));
        
        WebConnection connection = Inizializzatore.getWeb();
        ArrayList<Dipendente> dipendenti = connection.getElencoDipendenti();
        Dipendente d = null;
        for (int it=0; it<dipendenti.size(); it++) {	
            if 	(dipendenti.get(it).getId() == id) {	
                d = dipendenti.get(it);
                break;
            }
        }
        int numTrofei = d.getTrofei();
        connection.setTrofei(d,numTrofei+1);
		response.sendRedirect("visualizzaDipendente.jsp?id="+id);
    %>
		
<%@ include file="html/footer.html" %> 