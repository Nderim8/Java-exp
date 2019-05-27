<%@ page import="sample.*"%>
<html>

<body>
	<%
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String newfname = request.getParameter("newfname");
		String newlname = request.getParameter("newlname");
		String newtype = request.getParameter("newtype");
		String newnumber = request.getParameter("newnumber");
		String contacts;
		Main m = new Main();
		m.editContact(fname, lname, newfname, newlname, newtype, newnumber);
	    contacts = m.showAllContacts();
		
	%>

	Kontaktet :<%=contacts%>
	
	<form>
	<button formaction="view-allcontacts.jsp"> View All </button>
	<button formaction="register-phonebook.html"> Go back </button>
	</form>

</body>

</html>