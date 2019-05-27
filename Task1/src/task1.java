import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class task1 
{
	public static void viewTweets(Connection con, String db)
		    throws SQLException {

		    Statement s = null;
		    String query = " SELECT Text from Tweets ";
		    try {
		        s = con.createStatement();
		        ResultSet rs = s.executeQuery(query);
		        while (rs.next()) {
		            String tweet = rs.getString("Text");
		            
		            System.out.println(tweet);
		        }
		    } catch (SQLException e ) {
		        task1.printSQLException(e);
		    } finally {
		        if (s!= null) { s.close(); }
		    }
		}
	

	private static void printSQLException(SQLException e) 
	{
		System.out.println(e);
		
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		
		Class.forName("cdata.jdbc.twitter.TwitterDriver");
		
	
	String connectionString = "jdbc:twitter:OAuth Access Token Secret=loiPn5xBjn3OXFVzCh1fkuGnZfr7z1oij1yKeHzIBCwvE;OAuth Access Token=844993152020832256-bdpp0sRtFlT0tsh0Ex0VRNTqtDKx3Al;OAuth Client Id=czIxWcvJavh0Yxrgt4BVe8ocC;OAuth Client Secret=E8iZHoiSUOBGdwwZdoudSSS7lNomhxqU1ruv01VGsrRcCfXCVb;";
	 

	Connection conn = DriverManager.getConnection(connectionString);

	task1.viewTweets(conn, "Tweets");

	
	}
	

	
}
	
	
 