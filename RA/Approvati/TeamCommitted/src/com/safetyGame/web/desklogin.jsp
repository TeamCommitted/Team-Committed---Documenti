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
String username = request.getParameter("username"); // Ottengo lo username dal post
String password = request.getParameter("password"); // Ottengo la psw dal post
boolean logged = false;
WebConnection connection = Inizializzatore.getWeb();
logged = connection.loginDip(username, password);
if (logged) out.println("s");
else out.println("n");
%>