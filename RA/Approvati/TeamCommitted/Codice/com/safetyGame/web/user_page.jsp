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
SafetyGame - Pannello utente
<%@ include file="html/header_post_title.html" %>
<%@ include file="html/menud.html" %> 
<%@ include file="html/menu_content.html" %> 

<%@ include file="getCookies.jsp" %>
<% if (!(ambito.equals("Dipendente"))) response.sendRedirect("index.jsp"); %>

    <h2>Informazioni sull'account</h2>
    <%			
        out.println("<p>Benvenuto <em>");
        out.println(username);
        out.println("</em></p><p>Hai effettuato il login come <em>");
        out.println(ambito);
        out.println("</em></p>");
    %>
    
    <h2>Punteggi</h2>
    <%
        WebConnection connection = Inizializzatore.getWeb();
        Login l = new Login(username ,password);
        Punteggio p = connection.getPunteggio(l);
        int punt = p.getPunti();
                    
        out.println("Il tuo punteggio &egrave; <em>");
        out.println(punt+"</em>");
		%><%@ include file="forzaCambioPass.jsp" %><%
    %>
    
    <h2>Badge</h2>
    <%
        // Funzione per ottenere l'elenco dei trovei e dei badge
        ArrayList<Badge> elencoTrofei = null;
        elencoTrofei = connection.getBadge(l,10);
        //
        if (elencoTrofei == null) out.println("Non hai guadagnato nessun badge.");
		else if (elencoTrofei.size() == 0) out.println("Non hai guadagnato nessun badge.");
        else {
            out.println("Segue l'elenco dei tuoi badge:");
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
		out.println("Hai guadagnato <em>"+numTrofei+"</em> Trofei");
	%>
<%@ include file="html/footer.html" %> 
