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
	
	 String query = "INSERT INTO contacts VALUES ('"+fname+"','"+lname+"','"+type+"','"+number+"')";
      
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
				out.println("New contact was created successfully.");
				System.out.println("New contact was created successfully.");
				
			    System.out.println("Firstname LastName Type Number");
				while(myRs.next()) {						
					System.out.println(myRs.getString("firstname")+"  ,  " +myRs.getString("lastname")+"  ,  " +myRs.getString("type")
					+"  ,  " +myRs.getString("number"));
				}
							
			}catch(Exception e){
				e.printStackTrace();
			}
	
	
	%>
	
<%-- 	
<% 
		// contacts = m.showAllContacts();
 		
////  jdbc:mysql://localhost:3306/NDERIM
				String url= "jdbc:mysql://localhost:3306/NDERIM";
				// userID = root
				String userID = "root";
				// database password
				String password = "88nero88";
				// query
				String query = "";
				
		//		String cFname = "", cLname ="", cType = "", cNumber = "";

			//	url = JOptionPane.showInputDialog("Input your database url : ");
			//	userID = JOptionPane.showInputDialog("Input your database userID : ");
				
		  //      password = JOptionPane.showInputDialog("Input your database password :");
		        
		    //  query = JOptionPane.showInputDialog("Execute a query :");
		    
		        query = "INSERT INTO contacts VALUES ('"+fname+"','"+lname+"','"+type+"','"+number+"')";
		        
		    //  query = "INSERT INTO contacts VALUES ('Nero', 'Kurti', 'WORK', '1111')"; 
		        try {
					
					//1. Get a connection to database
					Connection myCon = DriverManager.getConnection(url, userID, password);
					//2. Create a statement
					Statement myStmt = myCon.createStatement();
					//3. Execute statement
							
					myStmt.execute(query);
					System.out.println("Query was executed successfully.");
					
				    ResultSet myRs = myStmt.executeQuery("SELECT * FROM contacts");
				    System.out.println();
					//4. Process the result set
				    System.out.println("Firstname LastName Type Number");
					while(myRs.next()) {						
						System.out.println(myRs.getString("firstname")+"," +myRs.getString("lastname")+"," +myRs.getString("type")
						+"," +myRs.getString("number"));
					}
								
				}catch(Exception e){
					e.printStackTrace();
				}

		
	%>
	 --%>
	 
<%-- 	 
    Kontakti i ri u shtua ne databaze.
	<ol>
		<li>Firstname:<%=fname%></li>
		<li>Lastname :<%=lname%></li>
		<li>Type of number :<%=type%></li>
		<li>Number :<%=number%></li>
	</ol>
	

	
	<form>
	<button formaction="view-allcontacts.jsp"> View All </button>
	<button formaction="register-phonebook.html"> Go back </button>
	</form> --%>

	<form>
	<button formaction="register-phonebook.html"> Go back </button>
	</form>
</body>

</html>