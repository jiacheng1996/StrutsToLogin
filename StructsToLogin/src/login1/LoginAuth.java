package login1;

import java.io.InputStream;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.util.Properties;

public class LoginAuth {

	public static boolean validate(String username, String password){  
		 
		boolean loginSuccess = false;
		  InputStream input = null;
		  Properties prop = new Properties();
		  try {  
		   // Load the mySQL driver
		   input =  LoginAuth.class.getClassLoader().getResourceAsStream("db.properties");
		   prop.load(input);
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   
		   System.out.println("Driver loaded");
		   
		   // Attempt to connect to database
		   Connection connect = DriverManager.getConnection(  
		   "jdbc:mysql://127.0.0.1:3306/"+ prop.getProperty("dbName")+"?serverTimezone=UTC", prop.getProperty("dbUser"), prop.getProperty("dbPassword"));   
		   
		   System.out.println("Database connected");
		   
		   // Setup mySQL authentication query
		   PreparedStatement statement = connect.prepareStatement(  
		     "select * FROM users where user_name=? and password=?");
		   
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