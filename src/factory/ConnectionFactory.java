package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public static Connection getConnection() throws SQLException {
		return DriverManager
				.getConnection("jdbc:mysql://pridedevdatabase.c3lbe0bvk2jp.us-east-1.rds.amazonaws.com/alice?useSSL=false","alice","alice");
		
	}
}
