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
	String email = request.getParameter("email");
	String codfis = request.getParameter("codfis");
	boolean successo = false;
	
	WebConnection connection = Inizializzatore.getWeb();
	
	Recupero r = new Recupero(email, codfis);
	successo = connection.resetPassD(r);
	
	if (successo) out.println("s");
	else out.println("n");
	
%>