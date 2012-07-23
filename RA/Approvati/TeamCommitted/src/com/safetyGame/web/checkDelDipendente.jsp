<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="java.util.regex.*"%>
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

<% 
	String input_id = request.getParameter("input_id");
	input_id = input_id.trim();
	int id = Integer.parseInt(input_id);
	
	WebConnection connection = Inizializzatore.getWeb();
	
	Dipendente dip = new Dipendente();
	
	ArrayList<Dipendente> dipendenti = connection.getElencoDipendenti();
	for (int it=0; it<dipendenti.size(); it++) {	
		if 	(dipendenti.get(it).getId() == id) {	
			dip = dipendenti.get(it);
			break;
		}
	}
	
	boolean operazioneRiuscita = false;	
	operazioneRiuscita = connection.cancellaDipendente(dip);
	
	if (operazioneRiuscita) out.println("<span class=\"successo\">Dipendente eliminato con successo!</span>");
	else out.println("<span class=\"fallimento\">Operazione fallita!</span><p>Ritentare o contattare l'Amministratore di sistema</p>");
%>

<%@ include file="html/footer.html" %> 