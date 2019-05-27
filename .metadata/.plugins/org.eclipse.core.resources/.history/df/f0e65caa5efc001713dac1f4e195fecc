
<%@ page import="sample.*" %>
<html>

<body>
<%
String fname = request.getParameter("firstname");
String lname = request.getParameter("lastname");
String type = request.getParameter("type");
String number = request.getParameter("number");
  Main m= new Main();
  m.createContact(fname,lname, type, number);
  m.printAllData();
%>
Kontaktri i ri u krijua.
<br>
Emri : <%=fname %>
<br>
Mbiemri : <%=lname %>
<br>
Tipi numrit : <%=type %>
<br>
Numri : <%=number %>

</body>

</html>