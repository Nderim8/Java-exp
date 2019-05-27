package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Driver {
	
	
	public Connection getConnection() {
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NDERIM","root","88nero88");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	/*public static void insertQuery(String fname, String lname, String type, String number) {
		
		// jdbc:mysql://localhost:3306/NDERIM
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

		
	}

*/
	
	public static void main(String[] args) {
	  	
	    System.out.println("main");
	//	Driver driver = new Driver();
		
	//	driver.insertQuery("Nderim", "Kurti", "HOME", "0686485341");

	}

}
