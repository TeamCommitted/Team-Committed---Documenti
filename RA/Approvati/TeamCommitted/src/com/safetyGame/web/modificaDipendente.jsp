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
Modifica Dipendente
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
        <h2>Modifica Dipendente</h2>
        
        <form id="modDipendente" title="Form per l'aggiunta di un nuovo Dipendente" action="checkModDipendente.jsp" method="post">
        	<fieldset>
            	<ul>
                	<li><span class="etichetta">ID:</span><span> <% out.println(id); %></span></li>
                    <li><span class="etichetta">Nome:</span><input type="text" name="input_nome" value="<% out.println(d.getNome()); %>" /></li>
                    <li><span class="etichetta">Cognome:</span><input type="text" name="input_cognome" value="<% out.println(d.getCognome()); %>" /></li>
                    <li><span class="etichetta">Codice fiscale:</span><input type="text" name="input_codfis" value="<% out.println(d.getCodFiscale()); %>" /></li>
                    <li><span class="etichetta">Email:</span><input type="text" name="input_email" value="<% out.println(d.getEmail()); %>" /></li>
                    <li><span class="etichetta">Ruolo:</span>
                        <select name="input_ruolo">
                            <%
                                ArrayList<String> elencoRuoli = connection.getElencoRuoli();
                                String nomeRuolo = null;
                                for (int it=0; it < elencoRuoli.size(); it++) {
                                    nomeRuolo = elencoRuoli.get(it);
									if (nomeRuolo.equals(d.getRuolo())) out.println("<option value=\""+nomeRuolo+"\" selected>"+nomeRuolo+"</option>");
                                    else out.println("<option value=\""+nomeRuolo+"\">"+nomeRuolo+"</option>");
                                }
                            %>
                        </select>
                    </li>
                    <li><input type="reset" /></li>
                </ul>
                <input type="hidden" name="input_id" value="<%out.println(id);%>" />
                <input class="button" type="submit" value="Modifica Dipendente" />
            </fieldset>
        </form>
        
<%@ include file="html/footer.html" %> 
