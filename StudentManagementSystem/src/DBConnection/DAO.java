package DBConnection;

import java.sql.*;

public class DAO {

	private static final String URL = "jdbc:mysql://localhost:3306/Students";
	private static final String uname = "root";
	private static final String password = "ujval123";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, uname, password);
	
	}

	
}
