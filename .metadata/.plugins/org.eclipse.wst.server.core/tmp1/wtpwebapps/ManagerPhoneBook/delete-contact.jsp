<%@ page import="sample.*"%>
<html>

<body>
	<%
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		
		String contacts;
		Main m = new Main();
		m.deleteContact(fname, lname);
	    contacts = m.showAllContacts();
		
	%>
    Kontakti me emer "<%=fname %>" dhe mbiemer "<%=lname %>" u fshi nga kontaktet.
    <br>
	Kontaktet :<%=contacts%>
	
	
	<form>
	<button formaction="view-allcontacts.jsp"> View All </button>
	<button formaction="register-phonebook.html"> Go back </button>
	</form>

</body>

</html>