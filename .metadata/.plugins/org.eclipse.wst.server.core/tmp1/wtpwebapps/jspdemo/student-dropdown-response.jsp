<html>
<head><title> Student Confirmation Title </title></head>
<body>

The student is confirmed : ${param.firstname} ${param.lastname}
<br>
The student is confirmed : <%= request.getParameter("firstname")%>  <%= request.getParameter("lastname")%>
<br><br>
The student's country : ${param.country}

</body>
</html>