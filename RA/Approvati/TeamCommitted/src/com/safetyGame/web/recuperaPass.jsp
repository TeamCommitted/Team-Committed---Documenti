<%@ include file="html/header_pre_title.html" %> 
Recupero Password
<%@ include file="html/header_post_title.html" %>
<%@ include file="html/menu.html" %>
<%@ include file="html/menu_content.html" %> 

<h2>Recupero Password</h2>
<form id="recuperoPass" title="Form per il recupero della password" action="checkRecuperoPass.jsp" method="post">
	<fieldset>
    	<p>
            <label for="email">Email:</label>
            <input type="email" name="email" />
        </p>
    	<p>
            <label for="codfis">Codice Fiscale:</label>
            <input type="text" name="codfis" />
        </p>
        <p>
        	Seleziona il tuo ruolo
            <ul>
                <li>
                    <input title="Seleziona se dipendente" type="radio" name="radio" value="Dipendente" checked="checked" /> 
                    <label class="option_label" for="radioD">Dipendente</label>
                </li>
                <li>
                    <input title="Seleziona se amministratore" type="radio" name="radio" value="Amministratore" /> 
                    <label class="option_label" for="radioA">Amministratore</label>
                </li>
            </ul>
         </p>
        <input type="submit" class="button" name="recuparaPass" value="Recupera Password" />
    </fieldset>
</form>

<%@ include file="html/footer.html" %> 