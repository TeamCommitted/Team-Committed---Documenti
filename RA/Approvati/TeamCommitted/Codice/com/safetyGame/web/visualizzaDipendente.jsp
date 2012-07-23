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
SafetyGame - Dettagli Dipendente
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
        <h2>Dettagli Dipendente</h2>
        <ul>
            <li><span class="etichetta">ID:</span><span> <% out.println(id); %></span></li>
            <li><span class="etichetta">Nome:</span><span> <% out.println(d.getNome()); %></span></li>
            <li><span class="etichetta">Cognome:</span><span> <% out.println(d.getCognome()); %></span></li>
            <li><span class="etichetta">Codice fiscale:</span><span> <% out.println(d.getCodFiscale()); %></span></li>
            <li><span class="etichetta">Email:</span><span> <% out.println(d.getEmail()); %></span></li>
            <li><span class="etichetta">Ruolo:</span>
                <span>
                    <%
                        ArrayList<String> elencoRuoli = connection.getElencoRuoli();
                        String nomeRuolo = null;
                        for (int it=0; it < elencoRuoli.size(); it++) {
                            nomeRuolo = elencoRuoli.get(it);
                            if (nomeRuolo.equals(d.getRuolo())) {
                                out.println(nomeRuolo);
                                break;
                            }
                        }
                    %>
                </span>
            </li>
        </ul>
        
        <h2>Punteggio Dipendente</h2>
		<%
            Login l = new Login(d.getNickname() ,d.getPassword());
            Punteggio p = connection.getPunteggio(l);
            int punt = p.getPunti();
            out.println("Il punteggio di questo dipendente &egrave; <em>");
            out.println(punt+"</em>");
        %>
        
    	<h2>Badge</h2>
        <%
            // Funzione per ottenere l'elenco dei trovei e dei badge
            ArrayList<Badge> elencoTrofei = null;
            elencoTrofei = connection.getBadge(l,10);
            //
            if (elencoTrofei == null) out.println("Questo dipendente non ha guadagnato nessun badge.");
            else if (elencoTrofei.size() == 0) out.println("Questo dipendente non ha guadagnato nessun badge.");
            else {
                out.println("Questo dipendente ha guadagnato i seguenti Badge:");
                out.println("<dl>");
                String nomebadge;
                String descrbadge;
                Badge trofeo;
                for (int it = elencoTrofei.size()-1; it >= 0; it--) { 
                    trofeo = elencoTrofei.get(it);
                    nomebadge = trofeo.getNome();
                    descrbadge = trofeo.getDescrizione();
                    out.println("<dt>"+nomebadge+"</dt>");
                    out.println("<dd>"+descrbadge+"</dd>");
                }
                out.println("</dl>");
            }
		%>
			
        <h2>Trofei</h2>
		<%
			Dipendente dip = connection.getDati(l);
			int numTrofei = dip.getTrofei();
			out.println("Questo dipendente ha guadagnato <em>"+numTrofei+"</em> Trofei");
			out.println("<a href=\"addTrofeo.jsp?id="+id+"\" title=\"Aggiungi un trofeo\">+</a>");
			out.println("<a href=\"subTrofeo.jsp?id="+id+"\" title=\"Rimuovi un trofeo\">-</a>");
		%>
        
<%@ include file="html/footer.html" %> 