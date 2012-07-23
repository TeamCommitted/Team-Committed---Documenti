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
Pannello Amministratore
<%@ include file="html/header_post_title.html" %> 

<%@ include file="getCookies.jsp" %> 
<% 
	if ((ambito.equals("Dipendente"))) response.sendRedirect("user_page.jsp");
	if (ambito.equals("Amministratore Azienda")) { %>
    <%@ include file="html/menuaa.html" %> 
    <% } else { %>
    <%@ include file="html/menuas.html" %> 
    <% } %>


<%@ include file="html/menu_content.html" %> 
 
    <h2>Informazioni sull'account</h2>
    <%
        out.println("<p>Benvenuto ");
        out.println(username);
        out.println("</p><p>Hai effettuato il login come ");
        out.println(ambito);
        out.println("</p>");
    %>
<% WebConnection connection = Inizializzatore.getWeb(); %>
<%@ include file="forzaCambioPassA.jsp" %>
<%@ include file="html/footer.html" %>
