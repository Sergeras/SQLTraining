package a;

import java.sql.*;



public class SQLTraining {
	public static void main (String[] args) {
		
		Connection conn = null;
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-N8FNPVH\\SQLEXPRESS;databaseName=Training;integratedSecurity=true;");
			Statement sqlStatement = conn.createStatement();
			SQLManipulator sql = new SQLManipulator(conn);
			sql.createTables();
			sql.fillTables();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
