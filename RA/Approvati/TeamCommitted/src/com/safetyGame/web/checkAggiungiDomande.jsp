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
Safety Game - Pannello Amministratore
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menuas.html" %> 
<%@ include file="html/menu_content.html" %> 

<% 
	int numDomande = (Integer.parseInt(request.getParameter("numDomande"))) ;
	WebConnection connection = Inizializzatore.getWeb();
	Domanda d;
	ArrayList elencoDomande = connection.getElencoDomande();
	for (int it=0; it<numDomande; it++) {
		String checkbox = request.getParameter("check"+it);
		if (checkbox != null) {
			int intcheck = Integer.parseInt(checkbox);
			for (int j=0; j<elencoDomande.size(); j++) {
				d = (Domanda) elencoDomande.get(j);
				if (d.getId() == intcheck) {
					if (d.isInternaAzienda()) {
						connection.cancellaDomanda(d);
					}
					else connection.aggiungiDomanda(d);
				}
			}
		}
	}
	
	out.println("<span class=\"successo\">Operazione eseguita con successo!</span>");
%>

<%@ include file="html/footer.html" %> 