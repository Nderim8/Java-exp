<html>
<head><title> Student Confirmation Title </title></head>
<body>

The student is confirmed : ${param.firstname} ${param.lastname}
<br>
<!-- Display a list of the student's favourite programming languages. -->

The student's favourite languages are : 
<ul>
<% 
 String[] langs = request.getParameterValues("favouriteLanguage");
 for(String tempLang: langs){
	 out.println("<li>"+ tempLang +"</li>");
 }

%>
</ul>

</body>
</html>