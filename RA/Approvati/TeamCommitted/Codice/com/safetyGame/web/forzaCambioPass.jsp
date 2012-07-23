<%
    Login log = new Login (username, password);
	Dipendente dipend = connection.getDati(log);
	if ( (dipend.getNuovaPass() != null)) response.sendRedirect("modPassD.jsp");
%>