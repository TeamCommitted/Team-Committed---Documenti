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
Rimuovi Dipendente
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
			
		%>
        <h2>Elimina Dipendente</h2>
        
        <form id="delDipendente" title="Elimina questo dipendente" action="checkDelDipendente.jsp" method="post">
        	<fieldset>
            	<span id="attenzione">Sei sicuro di voler eliminare questo dipentente?</span>
            	<ul>
                	<li><span class="etichetta">ID: </span><span> <% out.println(id); %></span></li>
                    <li><span class="etichetta">Nome: </span> <% out.println(d.getNome()); %></li>
                    <li><span class="etichetta">Cognome: </span> <% out.println(d.getCognome()); %></li>
                    <li><span class="etichetta">Codice fiscale: </span> <% out.println(d.getCodFiscale()); %></li>
                    <li><span class="etichetta">Email: </span> <% out.println(d.getEmail()); %></li>
                    <li><span class="etichetta">Ruolo: </span> <%out.println(d.getRuolo());%></li>
                </ul>
                <input type="hidden" name="input_id" value="<%out.println(id);%>" />
                <input class="button" type="submit" value="Elimina Dipendente" />
            </fieldset>
        </form>
        
<%@ include file="html/footer.html" %> 
