package login1;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  

public class LoginAuth {

	public static boolean validate(String username, String password){  
		 
		boolean loginSuccess = false;
		 
		  try {  
		   // Load the mySQL driver
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   
		   System.out.println("Driver loaded");
		   
		   // Attempt to connect to database
		   Connection connect = DriverManager.getConnection(  
		   "jdbc:mysql://127.0.0.1:3306/", "root", "root");  
		   
		   System.out.println("Database connected");
		   
		   // Setup mySQL authentication query
		   PreparedStatement statement = connect.prepareStatement(  
		     "SELECT * FROM websiteuser.user WHERE username = ? AND password = ?");
		   
		   statement.setString(1, username);
		   statement.setString(2, password);
		   
		   System.out.println("Query set up");
		   
		   // Execute query, get result of query
		   ResultSet results = statement.executeQuery();
		   
		   System.out.println("Query executed");
		   
		   // See if result is empty
		   loginSuccess = results.next();
		   
		   System.out.println("Result obtained: " + loginSuccess);
		   
		  } catch(Exception e) {e.printStackTrace();}
		  
		 return loginSuccess;  
	}  
	
}