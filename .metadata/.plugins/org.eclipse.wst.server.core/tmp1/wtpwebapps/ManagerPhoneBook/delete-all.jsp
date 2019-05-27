<%@ page import="sample.*"%>

<html>
<head>

</head>

<body>
	<%
		
		String contacts;
		Main m = new Main();
		m.clear();
	    contacts = m.showAllContacts();
		
	%>
    Kontaktet u fshine.
	
	
	<form>
	<button formaction="view-allcontacts.jsp"> View All </button>
	<button formaction="register-phonebook.html"> Go back </button>
	</form>

</body>

</html>


