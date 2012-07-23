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
Pannello Amministratore
<%@ include file="html/header_post_title.html" %> 
<div class="voceMenu"><a href="index.jsp">Login</a></div>
<%@ include file="html/menu_content.html" %> 

<% 
	String username = request.getParameter("account_username"); // Ottengo lo username dal post
	String password = request.getParameter("account_password"); // Ottengo la psw dal post
	// Ottengo il valore del radio button
	String ambito = null;
	boolean tipoAdmin = true;
	if (request.getParameter("radio").equals("radioD")) {
		ambito = "Dipendente";}
	if (request.getParameter("radio").equals("radioAA")) {
		ambito = "Amministratore Azienda";
		tipoAdmin = true;
	}
	if (request.getParameter("radio").equals("radioAS")) {
		ambito = "Amministratore Sicurezza";
		tipoAdmin = false;
	}
	
	boolean logged = false;
	WebConnection connection = Inizializzatore.getWeb();
	
	if (ambito.equals("Dipendente")) logged = connection.loginDip(username, password);
	else logged = connection.loginAdmin(username, password, tipoAdmin);
	
	// Imposto i cookie salvando username, password e ambito utente
	// Purtroppo bisogna impostare un cookie per ogni dato
	if (logged) {
		Cookie usernameCookie = new Cookie ("username",username);
		Cookie passwordCookie = new Cookie ("password",password);
		Cookie ambitoCookie = new Cookie ("ambito",ambito);
		usernameCookie.setMaxAge(24 * 60 * 60); // 24h di validità
		passwordCookie.setMaxAge(24 * 60 * 60);
		ambitoCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(usernameCookie);
		response.addCookie(passwordCookie);
		response.addCookie(ambitoCookie);
	}
	else out.println("<span class=\"fallimento\">I dati che hai inserito non corrispondono.</span><p>Controlla che i dati inseriti siano corretti<p>");
	
	// Redirect alla pagina successiva
	String redirectURL = "";
	// Se il login è di tipo Dipendente
	if (ambito.equals("Dipendente")) redirectURL = "http://localhost/examples/user_page.jsp";
	// Altrimenti, se è di tipo amministratore:
	else redirectURL = "http://localhost/examples/admin_page.jsp";
	if (logged) response.sendRedirect(redirectURL);
%>

<%@ include file="html/footer.html" %>