<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.util.regex.*"%>

<%
	String regex = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
	String input = "cicio@gjfkdit";
	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(input);
	if (matcher.matches()) out.println("email valida");
	else out.println("email NON valida");
%>


<%@ include file="html/header_pre_title.html" %> 
<% out.println("title"); %>
<%@ include file="html/header_post_title.html" %> 
<%
	out.println("menu");
%>
<%@ include file="html/menu_content.html" %> 
ciao
<%

%>


<%@ include file="html/footer.html" %> 