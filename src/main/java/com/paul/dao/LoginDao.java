package com.paul.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String sql = "select * from table1 where name =? and password =?";
	String userName = "ANKUSH";
	String password = "root";
	
	public boolean check(String username, String pass) {
		
		try {
			// Load driver
			Class.forName("oracle.jdbc.OracleDriver");
			
			// Establish the connection between java app and Oracle db
			Connection connection = DriverManager.getConnection(url, userName, password);
			
			// Create Statement object
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, pass);
			
			ResultSet res = statement.executeQuery();
			if(res.next()) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
