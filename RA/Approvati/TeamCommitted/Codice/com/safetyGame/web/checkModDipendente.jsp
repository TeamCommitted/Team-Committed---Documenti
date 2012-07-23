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
Modifica Dipendente
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menuaa.html" %> 
<%@ include file="html/menu_content.html" %> 
<%@ include file="getCookies.jsp" %> 

<% 
	String nome = request.getParameter("input_nome");
	String cognome = request.getParameter("input_cognome");
	String codfis = request.getParameter("input_codfis");
	String email = request.getParameter("input_email");
	String ruolo = request.getParameter("input_ruolo");
	String input_id = request.getParameter("input_id");
	input_id = input_id.trim();
	int id = Integer.parseInt(input_id);
	
	WebConnection connection = Inizializzatore.getWeb();
	
	Dipendente newDip = new Dipendente();
	Dipendente oldDip = new Dipendente();
	
	ArrayList<Dipendente> dipendenti = connection.getElencoDipendenti();
	for (int it=0; it<dipendenti.size(); it++) {	
		if 	(dipendenti.get(it).getId() == id) {	
			oldDip = dipendenti.get(it);
			break;
		}
	}
	
	String regex = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(email);
	if (matcher.matches()) {
	
		boolean operazioneRiuscita = false;
		//newDip = oldDip;
		newDip.setId(oldDip.getId());
		newDip.setNome(nome);
		newDip.setCognome(cognome);
		newDip.setNickname(oldDip.getNickname());
		newDip.setCodFiscale(codfis);
		newDip.setEmail(email);
		newDip.setRuolo(ruolo);
		newDip.setPassword(oldDip.getPassword());
		
		operazioneRiuscita = connection.modDipendente(oldDip, newDip);
		
		if (operazioneRiuscita) {
			out.println("<span class=\"successo\">Dati dipendente aggiornati con successo!</span>");
			out.println("<p>Nome: "+newDip.getNome()+oldDip.getNome()+"</p>");
			out.println("<p>Cognome: "+newDip.getCognome()+oldDip.getCognome()+"</p>");
			out.println("<p>Codice Fiscale: "+newDip.getCodFiscale()+oldDip.getCodFiscale()+"</p>");
			out.println("<p>Email: "+newDip.getEmail()+oldDip.getEmail()+"</p>");
			out.println("<p>Ruolo: "+ruolo+"</p>");
		}
		else out.println("<span class=\"fallimento\">Operazione fallita!</span><p>Ritentare o contattare l'Amministratore di sistema</p>");
	}
	else out.println("<span class=\"fallimento\">Email non valida!</span><p>Inserisci un indirizzo Email valido</p>");
%>

<%@ include file="html/footer.html" %> 