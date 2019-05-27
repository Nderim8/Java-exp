<%@ page import="driver.*"%>
<%@ page import = "java.sql.Connection"%>
<%@ page import = "java.sql.DriverManager"%>
<%@ page import = "java.sql.ResultSet"%>
<%@ page import = "java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>


<body>
	<%
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String type = request.getParameter("type");
		String number = request.getParameter("number");
		String contacts;
		
     	Driver driver = new Driver();
	//	driver.insertQuery(fname, lname, type, number);
		
	Connection conn = driver.getConnection();
	
	if(conn == null){
		out.print("Connection failed! ");
		
	}else{
		out.print("Connection succeeded! ");
		
	}
	
	 String query = "DELETE FROM contacts;";
      
	        try {
				
				
				//2. Create a statement
				Statement myStmt = conn.createStatement();
				//3. Execute statement
						
				myStmt.execute(query);
				System.out.println("Query was executed successfully.");
				
			    ResultSet myRs = myStmt.executeQuery("SELECT * FROM contacts");
			    System.out.println();
				//4. Process the result set
				out.println("All contacts are deleted successfully.");
				System.out.println("All contacts are deleted successfully.");
				
			    System.out.println("Firstname LastName Type Number");
				while(myRs.next()) {						
					System.out.println(myRs.getString("firstname")+"  ,  " +myRs.getString("lastname")+"  ,  " +myRs.getString("type")
					+"  ,  " +myRs.getString("number"));
				}
							
			}catch(Exception e){
				e.printStackTrace();
			}
	
	
	%>
	

	<form>
	<button formaction="register-phonebook.html"> Go back </button>
	</form>

</body>

</html>