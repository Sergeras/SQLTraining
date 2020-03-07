package a;

import java.sql.*;



public class SQLTraining implements ResultSetDisplayer  {
	public static void main (String[] args) {
		
		try (Connection conn = new SQLConnector().getConnection()) {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			SQLManipulator sql = new SQLManipulator(conn);
			
			sql.createTables();
			sql.fillTables();
			
			System.out.println("-----------Students-----------");
			sql.display(sql.selectAllStudents());
			System.out.println("-----------Teachers-----------");
			sql.display(sql.selectAllTeachers());
			System.out.println("-----------Tests-----------");
			sql.display(sql.selectAllTests());
			System.out.println("-----------Selects-----------");
			sql.display(sql.selectTeacher("Maria"));
			sql.display(sql.selectStudent("Frank"));
			sql.display(sql.selectTestByStudentName("Frank"));
			sql.display(sql.selectTestByTeacherName("Maria"));
			
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
