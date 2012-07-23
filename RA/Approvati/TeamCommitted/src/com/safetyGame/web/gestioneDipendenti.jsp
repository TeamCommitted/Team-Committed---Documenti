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
Gestione Dipendenti
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menuaa.html" %> 
<%@ include file="html/menu_content.html" %> 

		<%@ include file="getCookies.jsp" %>
        <% if (!(ambito.equals("Amministratore Azienda"))) response.sendRedirect("user_page.jsp"); %>
        
        <h2>Gestione Dipendenti</h2>
        
        <form id="modificaDipendenti" title="Form per modificare i dati di un dipendente o per rimuoverlo" action="checkAggiungiDipendente.jsp" method="get">
        	<fieldset>
            	<legend>Modifica Dipendente</legend>
                <table>
                	<thead>
                    	<tr>
                            <th>Id</th>
                            <th>Nickname</th>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Codice Fiscale</th>
                            <th>Email</th>
                            <th>Ruolo</th>
                            <th>Mod</th>
                            <th>Del</th>
                        </tr>
                    </thead>
                    <tbody class="elencoDip">
                    	<%
							WebConnection connection = Inizializzatore.getWeb();
							%><%@ include file="forzaCambioPassA.jsp" %><%
							ArrayList dipendenti = connection.getElencoDipendenti();
							Dipendente d = null;
							boolean alt = true;
							for (int it = 0; it < dipendenti.size(); it++) {
								d = (Dipendente) dipendenti.get(it);
								if (alt) out.println("<tr>");
								else out.println("<tr class=\"odd\">");
								out.println("<td title=\"Id\">"+d.getId()+"</td>");
								out.println("<td title=\"Visualizza info dipendente\"><a href=\"visualizzaDipendente.jsp?id="+d.getId()+"\">"+d.getNickname()+"</a></td>");
								out.println("<td title=\"Nome\">"+d.getNome()+"</td>");
								out.println("<td title=\"Cognome\">"+d.getCognome()+"</td>");
								out.println("<td title=\"Codice Fiscale\">"+d.getCodFiscale()+"</td>");
								out.println("<td title=\" Email\">"+d.getEmail()+"</td>");
								out.println("<td title=\" Ruolo\">"+d.getRuolo()+"</td>");
								out.println("<td><a href=\"modificaDipendente.jsp?id="+d.getId()+"\"><img src=\"style/img/mod.png\" alt=\"Modifica\" title=\"Modifica\" /></a></td>");
								out.println("<td><a href=\"eliminaDipendente.jsp?id="+d.getId()+"\"><img src=\"style/img/del.png\" alt=\"Elimina\" title=\"Elimina\" /></a></td>");
								out.println("</tr>");
								alt = !(alt);
							}
							
						%>
                        
  
                    </tbody>
                </table>
            </fieldset>
        </form>
        
        <form id="aggiungiDipendente" title="Form per l'aggiunta di un nuovo Dipendente" action="checkAggiungiDipendente.jsp" method="post">
        	<fieldset>
            	<legend>Aggiungi Dipendente</legend>
            	<ul>
                    <li><span class="etichetta">Nome:</span><input type="text" name="input_nome" /></li>
                    <li><span class="etichetta">Cognome:</span><input type="text" name="input_cognome" /></li>
                    <li><span class="etichetta">Codice fiscale:</span><input type="text" name="input_codfis" /></li>
                    <li><span class="etichetta">Email:</span><input type="text" name="input_email" /></li>
                    <li><span class="etichetta">Ruolo:</span>
                    <select name="input_ruolo">
                    	<%
							ArrayList<String> elencoRuoli = connection.getElencoRuoli();
							String nomeRuolo = null;
							for (int it=0; it < elencoRuoli.size(); it++) {
								nomeRuolo = elencoRuoli.get(it);
								out.println("<option value=\""+nomeRuolo+"\">"+nomeRuolo+"</option>");
							}
						%>
                    </select>
                </ul>
                <input class="button" type="submit" value="Aggiungi Dipendente" />
            </fieldset>
        </form>

<%@ include file="html/footer.html" %> 