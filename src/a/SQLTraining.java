package a;

import java.sql.*;



public class SQLTraining {
	public static void main (String[] args) {
		
		
		try (Connection conn = new SQLConnector().getConnection()) {
			ResultSet  rs = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			SQLManipulator sql = new SQLManipulator(conn);
			//sql.createTables();
			//sql.fillTables();
			rs = sql.countStudentSet("Maria");
			
			while (rs.next()) {
				StringBuffer buff = new StringBuffer();
				
				buff.append( rs.getString(1) +" ");
				buff.append( rs.getString(2) +" ");
				buff.append( rs.getInt(3) +" ");
				buff.append( rs.getString(4) +" ");
				buff.append( rs.getString(5) +" ");
				buff.append( rs.getInt(6) +" ");
				
				System.out.println(buff.toString());
			}
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
