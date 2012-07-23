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
Modifica Email
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menud.html" %> 
<%@ include file="html/menu_content.html" %> 

<%@ include file="getCookies.jsp" %>
<% if (!(ambito.equals("Dipendente"))) response.sendRedirect("index.jsp"); %>
    
    <h2>Modifica Email</h2>
    <form id="modPassDForm" action="checkModEmailD.jsp" method="post">
    	<fieldset>
        	<p><label for="nuovaPass">Nuova email:</label><input type="email" name="nuovaEmail" /></p>
            <p><label for="vecchiaPass">Password:</label><input type="password" name="password" /></p>
            <input type="submit" class="button" value="Cambia Indirizzo Email"/>
        </fieldset>
    </form>
<%
	WebConnection connection = Inizializzatore.getWeb();
	%><%@ include file="forzaCambioPass.jsp" %><%
%>

<%@ include file="html/footer.html" %> 