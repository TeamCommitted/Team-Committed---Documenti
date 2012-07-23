<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//IT"
	"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="it">
<head>
	<title>Login</title>
	<link rel="stylesheet" href="style/login.css" type="text/css" media="all" />
	
</head>

<body>
        
	<% 
        Cookie cookies [] = request.getCookies();
        String cookieName = null;
        String username = null;
        String ambito = null;
        
        if (cookies != null){
            cookieName = "username";
            for (int i = 0; i < cookies.length; i++) {
                if (cookies [i].getName().equals(cookieName)) {
                    username = cookies[i].getValue();
                    break;
                }
            }
            cookieName = "ambito";
            for (int i = 0; i < cookies.length; i++) {
                if (cookies [i].getName().equals(cookieName)) {
                    ambito = cookies[i].getValue();
                    break;
                }
            }
        }
        
        if ((username == null) || (ambito == null)) {
    %>
		
		<div id = "form_login">
			<form id="form_box" title="Form per effettuare il login" action="checkLogin.jsp" onsubmit="" method="post">
				<fieldset>
					<legend>Safety Game - Login</legend>
                    
                    <p>
                        <label for="account_username" class="form">Username</label>			
                        <input id="account_username" title="Casella di testo per lo username" type="text" name="account_username" onfocus="" value=""/>
                    </p>
                    <p>
                        <label for="account_password" class="form">Password</label>
                        <input id="account_password" title="Casella di testo per la password" type="password" name="account_password" onfocus=""/>
                    </p>
					
					<ul>
                        <li>
                            <input title="Seleziona se dipendente" type='radio' name="radio" value="radioD" checked="checked" /> 
                            <label class="option_label" for="radioD">Dipendente</label>
                        </li>
                        <li>
                            <input title="Seleziona se amministratore azienda" type='radio' name="radio" value="radioAA" /> 
                            <label class="option_label" for="radioAA">Amministratore azienda</label>
                        </li>
                        <li>
                            <input title="Seleziona se amministratore sicurezza" type='radio' name="radio" value="radioAS" /> 
                            <label class="option_label" for="radioAS">Amministratore sicurezza</label>
                        </li>
                    </ul>
					
					<input id="account_login" class="button" title="Pulsante per l&apos;invio dei dati inseriti" type="submit" name="account_login" value="Entra" />
					
				</fieldset>
			</form>
			
			

			<p class ="form_info">
				Password dimenticata? <a href="recuperaPass.jsp" tabindex="5" accesskey="p">Recupera l'accesso</a>
			</p>
			
		</div>
        <%
			}
			else if (ambito.equals("Dipendente")) response.sendRedirect("user_page.jsp");
			else response.sendRedirect("admin_page.jsp");
		%>
		
	</div>
</body>
</html>
