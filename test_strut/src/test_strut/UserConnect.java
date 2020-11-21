package test_strut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserConnect {
	private  Connection dbConnection;
	
	public void connectDB() {
		try {
			dbConnection = DBCon.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static final String LOGIN_QUERY = "select * from users where user_name=? and password=?";
	
	/*
	 * checks if username and password exists in database
	 */
	public boolean validateUserNamePassword(String[] params) throws Exception {
		boolean contains = false;
		Connection conn = null;
		try {
			conn = dbConnection;
			PreparedStatement prepStmt = conn.prepareStatement(LOGIN_QUERY);
			int count = 1;
			for (String param : params) {
				prepStmt.setString(count, param);
				count++;
			}

			ResultSet rs = prepStmt.executeQuery();
			if (rs.next()) {
				System.out.println("User login is valid in DB");
				contains = true;
			}
		} catch (Exception e) {
			System.out.println("validateLogon: Error while validating password: " + e.getMessage());
			throw e;
		} finally {
			DBCon.closeConnection(conn);
		}
		return contains;
	}

}
