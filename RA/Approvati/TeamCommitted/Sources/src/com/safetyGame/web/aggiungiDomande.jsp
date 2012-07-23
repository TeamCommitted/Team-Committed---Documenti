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
Inserisci Domande
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menuas.html" %> 
<%@ include file="html/menu_content.html" %> 

<%@ include file="getCookies.jsp" %>
<% if (!(ambito.equals("Amministratore Sicurezza"))) response.sendRedirect("user_page.jsp"); %>
        
        <% //Recupero le domande dal database ingDom
			WebConnection connection = Inizializzatore.getWeb();
			%><%@ include file="forzaCambioPassA.jsp" %><%
			ArrayList elencoDomande = null;
			elencoDomande = connection.getElencoDomande();
			int numeroDomInterne = 0;
			Domanda conteggioDomande;
			for (int j = 0; j < elencoDomande.size(); j++) { 
				conteggioDomande = (Domanda) elencoDomande.get(j);
				if (!(conteggioDomande.isInternaAzienda())) numeroDomInterne++;
			}
			if ( (elencoDomande == null) || (numeroDomInterne==0)) out.println("<h3>Non sono disponibili altre domande da inserire</h3>");
			else {
		%>
        
        <h2>Aggiungi Domande</h2>
        <form id="aggiungiDomande" action="checkAggiungiDomande.jsp">
        	<fieldset>
            	<table>
                	<thead>
                        <th>Selezione</th>
                        <th>Id</th>
                        <th>Anteprima</th>
                        <th>Tipologia</th>
                        <th>Ambito</th>
                    </thead>
                    <% 
						int idDom;
						String antDom;
						String tipDom;
						String ambitoDom;
						boolean alt = true;
						Domanda domanda;
						for (int j = 0; j < elencoDomande.size(); j++) { 
							domanda = (Domanda) elencoDomande.get(j);
							if (!(domanda.isInternaAzienda())) {
								if (alt) out.println("<tr>");
								else out.println("<tr class=\"odd\">");
								alt = !alt;
								idDom = domanda.getId();
								antDom = domanda.getTesto();
								tipDom = domanda.getTipologia();
								ambitoDom = domanda.getAmbito();
								out.println("<td><input type=\"checkbox\" name=\"check"+j+"\" value=\""+idDom+"\" /></td>");
								out.println("<td>"+idDom+"</td>");
								out.println("<td>"+antDom+"</td>");
								out.println("<td>"+tipDom+"</td>");
								out.println("<td>"+ambitoDom+"</td>");
								out.println("</tr>");
							}
						}
					%>
                </table>
            	<%
					out.println("<input type=\"hidden\" name=\"numDomande\" value=\""+elencoDomande.size()+"\" />");
				%>
                <input class="button" type="submit" value="Inserisci le domande selezionate" />
            </fieldset>
        </form>
        <%
			}
		%>
<%@ include file="html/footer.html" %> 