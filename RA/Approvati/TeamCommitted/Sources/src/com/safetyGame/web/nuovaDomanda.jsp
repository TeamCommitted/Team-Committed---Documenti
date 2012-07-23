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
Nuova Domanda
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menud.html" %> 
<%@ include file="html/menu_content.html" %> 

<%@ include file="getCookies.jsp" %>
        
	<%		
		if (!(ambito.equals("Dipendente"))) response.sendRedirect("admin_page.jsp");		
		else { // I cookie ritornano correttamente username, psw e ambito
			// Prendo la data dell'ultima risposta data
			String ultimaDomanda = "";
			cookieName = "dataUltimaDomanda";
			for (int i = 0; i < cookies.length; i++) {
				if (cookies [i].getName().equals(cookieName)) {
					ultimaDomanda=cookies[i].getValue();
					break;
				}
			}
			// Ottengo la differenza di tempo fra l'ultima risposta e l'ora attuale
			Long ultimaRisposta = null;
			boolean puorispondere = true;
			if (!(ultimaDomanda.equals(""))) {
				ultimaRisposta = new Long(ultimaDomanda);
				Date now = new Date();
				Long ora = now.getTime();
				Long longDiffTempo = ora-ultimaRisposta;
				String stringDiffTempo = longDiffTempo.toString();
				int diffTempo = Integer.parseInt(stringDiffTempo);
				if (diffTempo<60000) puorispondere=false;
			}
			
			if (!(puorispondere)) out.println("<h3>Non &egrave; passato abbastanza tempo dall'ultima risposta. Riprova pi&ugrave; tardi.</h3>");
			else {
				WebConnection connection = Inizializzatore.getWeb();
				Login l = new Login(username,password);
				try {
					Domanda nuovadomanda = connection.mostraDomanda(l);
					String testo = nuovadomanda.getTesto();
					out.println("<h2>Stai rispondendo ad una nuova domanda</h2>");
					out.println("<p>"+testo+"</p>");
					out.println("<form id=\"form_domanda\" title=\"Form per rispondere a una domanda\" action=\"checkRisposta.jsp\" method=\"post\"><fieldset><ul>");
					ArrayList risposte = nuovadomanda.getRisposte();
					session.setAttribute("oggetto_domanda", nuovadomanda);
					String risposta;
					for (int j=0; j<risposte.size(); j++) {
						risposta = risposte.get(j).toString();
						out.println("<li><input type=\"radio\" name=\"group1\" value=\"" +(j+1)+ "\" />" +risposta+ "</li>");
					}
					out.println("</ul><input class=\"button\" type=\"submit\" name=\"rispondi_domanda\" value=\"Invia la risposta\" /></fieldset></form>");
				}
				catch(Exception e) { out.println("<h3>Complimenti! Hai risposto a tutte le domande.</h3>"); }
			}
			WebConnection connection = Inizializzatore.getWeb();
			%><%@ include file="forzaCambioPass.jsp" %><%
		}
%>

<%@ include file="html/footer.html" %> 
