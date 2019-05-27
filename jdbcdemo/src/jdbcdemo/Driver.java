package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import objects.Pet;



public class Driver {
	
	
	public void insertQuery(String fname, String lname, String type, String number) {
		
		// jdbc:mysql://localhost:3306/NDERIM 
				String url= "jdbc:mysql://localhost:3306/NDERIM";
				// userID = root
				String userID = "root";
				// database password
				String password = "";
				// query
				String query = "";
				
                Pet pet = Pet.newPet();
                String petName = "Mika";
                String petKind = "cat";
                String dateOfBirth = "2016-05-08";
                 int fixed = 0;
                
                pet.setName(petName);
                pet.setKind(petKind);
                pet.setDateOfBirth(dateOfBirth);
                pet.setFixed(fixed);
                
                
				
		        password = JOptionPane.showInputDialog("Input your database password :");
		        
		        
		        
		 //   query = JOptionPane.showInputDialog("Execute a query :");
	      query = "INSERT INTO pets VALUES ('"+petName+"','"+petKind+"','"+dateOfBirth+"','"+fixed+"')";
		        
		    //  query = "INSERT INTO contacts VALUES ('Nero', 'Kurti', 'WORK', '1111')"; 
		        try {
		        	
					
					//1. Get a connection to database
					Connection myCon = DriverManager.getConnection(url, userID, password);
					//2. Create a statement
					Statement myStmt = myCon.createStatement();
					//3. Execute statement
							
					myStmt.execute(query);
					System.out.println("Query was executed successfully.");
					
				    ResultSet myRs = myStmt.executeQuery("SELECT * FROM pets");
				    System.out.println();
					//4. Process the result set
				    System.out.println("Name Kind Birth Fixed");
					while(myRs.next()) {						
						System.out.println(myRs.getString("name")+"," +myRs.getString("kind")+"," +myRs.getString("birth")
						+"," +myRs.getString("fixed"));
					}
								
				}catch(Exception e){
					e.printStackTrace();
				}

		
	}

	public static void main(String[] args) {
		
	
		Driver driver = new Driver();
		
		driver.insertQuery("Nderim", "Kurti", "HOME", "0686485341");

	}

}
