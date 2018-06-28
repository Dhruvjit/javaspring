package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcurl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("connecting to database: " + jdbcurl);
			
			Connection myConn = 
					DriverManager.getConnection(jdbcurl, user, password);
			
			System.out.println("connection successful!!");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	

}
