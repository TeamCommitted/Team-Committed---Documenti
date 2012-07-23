<%
    Login log = new Login (username, password);
	Dipendente admin = connection.getDatiA(log);
	if ( (admin.getNuovaPass() != null)) response.sendRedirect("modPassA.jsp");
%>