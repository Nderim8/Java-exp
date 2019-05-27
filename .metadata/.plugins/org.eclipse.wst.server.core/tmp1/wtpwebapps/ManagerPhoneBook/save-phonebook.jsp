<%@ page import="sample.*"%>
<html>

<body>
	<%
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String type = request.getParameter("type");
		String number = request.getParameter("number");
		String contacts;
		Main m = new Main();
		m.createContact(fname, lname, type, number);
		// m.printAllData();
		// contacts = m.showAllContacts();
		
	%>
    Kontakti i ri u krijua.
	<ol>
		<li>Firstname:<%=fname%></li>
		<li>Lastname :<%=lname%></li>
		<li>Type of number :<%=type%></li>
		<li>Number :<%=number%></li>
	</ol>
	

	
	<form>
	<button formaction="view-allcontacts.jsp"> View All </button>
	<button formaction="register-phonebook.html"> Go back </button>
	</form>

</body>

</html>