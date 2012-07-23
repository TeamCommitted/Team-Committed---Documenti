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
<%@ include file="getCookies.jsp" %>
<% if ((ambito.equals("Dipendente"))) response.sendRedirect("index.jsp"); %>
<%	if (ambito.equals("Amministratore Azienda")) {%>
	<%@ include file="html/menuaa.html" %> 
<% }if (ambito.equals("Amministratore Sicurezza")) {%>
	<%@ include file="html/menuas.html" %> 
<% } %>
<%@ include file="html/menu_content.html" %> 


    
    <h2>Modifica password</h2>
    <form id="modPassAForm" action="checkModPassA.jsp" method="post">
    	<fieldset>
        	<p><label for="nuovaPass">Nuova password:</label><input type="password" name="nuovaPass" /></p>
            <p><label for="confPass">Conferma password:</label><input type="password" name="confPass" /></p>
            <p><label for="vecchiaPass">Vecchia password:</label><input type="password" name="vecchiaPass" /></p>
            <input type="submit" class="button" value="Cambia Password"/>
        </fieldset>
    </form>

<%@ include file="html/footer.html" %> 