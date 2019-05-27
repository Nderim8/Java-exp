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
		String newfname = request.getParameter("newfname");
		String newlname = request.getParameter("newlname");
		String newtype = request.getParameter("newtype");
		String newnumber = request.getParameter("newnumber");
		String contacts;
		Driver driver = new Driver();
		//	driver.insertQuery(fname, lname, type, number);
			
		Connection conn = driver.getConnection();
		
		if(conn == null){
			out.println("Connection failed! ");
		}else{
			out.println("Connection succeeded! ");
		}
		
	
	String query =
"UPDATE contacts SET firstname = '"+newfname+"', lastname = '"+newlname+"', type = '"+newtype+"',number = '"+newnumber+
"' WHERE firstname = '"+fname+"'";
	      
		    //  query = "INSERT INTO contacts VALUES ('Nero', 'Kurti', 'WORK', '1111')"; 
		        try {
					
					
					//2. Create a statement
					Statement myStmt = conn.createStatement();
					//3. Execute statement
							
					myStmt.execute(query);
					System.out.println("Query was executed successfully.");
					
				    ResultSet myRs = myStmt.executeQuery("SELECT * FROM contacts");
				    System.out.println();
					//4. Process the result set
					out.println("Contact was updated successfully.");
					System.out.println("New contact was created successfully.");
				    System.out.println("Firstname LastName Type Number");
					while(myRs.next()) {						
						System.out.println(myRs.getString("firstname")+"," +myRs.getString("lastname")+"," +myRs.getString("type")
						+"," +myRs.getString("number"));
					}
								
				}catch(Exception e){
					e.printStackTrace();
				}
		
		
	%>


	
	<form>
	<button formaction="view-allcontacts.jsp"> View All </button>
	<button formaction="register-phonebook.html"> Go back </button>
	</form>

</body>

</html>