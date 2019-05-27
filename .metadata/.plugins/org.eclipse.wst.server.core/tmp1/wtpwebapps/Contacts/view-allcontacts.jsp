<%@ page import="driver.*"%>
<%@ page import = "java.sql.Connection"%>
<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.ResultSet"%>
<%@ page import = "java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
<h1>My contacts.</h1>
<body>

	<%
 	Driver driver = new Driver();
	//	driver.insertQuery(fname, lname, type, number);
		
	Connection conn = driver.getConnection();
	
	if(conn == null){
		out.print("Connection failed! ");
		
	}else{
		out.print("Connection succeeded! ");
		
	}
	
	// String query = "INSERT INTO contacts VALUES ('"+fname+"','"+lname+"','"+type+"','"+number+"')";
      
	    //  query = "INSERT INTO contacts VALUES ('Nero', 'Kurti', 'WORK', '1111')"; 
	        try {
				
				
				//2. Create a statement
				Statement myStmt = conn.createStatement();
				//3. Execute statement
						
					
			    ResultSet myRs = myStmt.executeQuery("SELECT * FROM contacts");
			    System.out.println();
				//4. Process the result set
				out.println("<h2>"+"Showing all contacts."+"</h2>"+"<br>");
				System.out.println("Showing all contacts.");
				
				out.println("<b>");
				out.println("Firstname     LastName     Type     Number"+"<br>");
			    System.out.println("Firstname   LastName   Type  Number");
				while(myRs.next()) {						
					out.println(myRs.getString("firstname")+"  ,  " +myRs.getString("lastname")+"  ,  " +myRs.getString("type")
					+"  ,  " +myRs.getString("number")+"<br>");
					
					System.out.println(myRs.getString("firstname")+"  ,  " +myRs.getString("lastname")+"  ,  " +myRs.getString("type")
					+"  ,  " +myRs.getString("number"));
					
					;
				}
					
				out.println("</b>");
			}catch(Exception e){
				e.printStackTrace();
			}
	
	%>

	
	<form>
	<button formaction="register-phonebook.html"> Go back </button>
	</form>

</body>

</html>