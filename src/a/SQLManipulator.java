package a;

import java.sql.*;

public class SQLManipulator {
	
	Connection conn = null;
	
	public SQLManipulator(Connection conn) {
		this.conn = conn;
	}
	
	public void createTables () {
		try {
			Statement sqlStatement = conn.createStatement();
			
			String studentTable = "CREATE TABLE student(first_name VARCHAR(15) NOT NULL,"
					+ "last_name VARCHAR(15) NOT NULL,"
					+ "student_id INT PRIMARY KEY IDENTITY (1,1),"
					+ "adress VARCHAR (30) NOT NULL,"
					+ "post_code VARCHAR (9) NOT NULL,"
					+ "phone_number INT);";
			String teacherTable = "CREATE TABLE teacher(first_name VARCHAR(15) NOT NULL,"
					+ "last_name VARCHAR(15) NOT NULL,"
					+ "teacher_id INT PRIMARY KEY IDENTITY (1,1),"
					+ "adress VARCHAR (30) NOT NULL,"
					+ "post_code VARCHAR (9) NOT NULL,"
					+ "phone_number INT);";		
			String subjectTable = "CREATE TABLE subject(subject_name VARCHAR(30) NOT NULL,"
					+"subject_id VARCHAR(3),"
					+"teacher_id INT FOREIGN KEY REFERENCES teacher (teacher_id),"
					+ "PRIMARY KEY (subject_id, teacher_id));";
			String testTable = "CREATE TABLE test(test_id INT IDENTITY (1,1),"
					+ "student_id INT NOT NULL,"
					+ "subject_id VARCHAR(3) NOT NULL,"
					+ "date DATE,"
					+ "mark CHARACTER(1) NOT NULL,"
					+ "teacher_id INT NOT NULL,"
					+ "PRIMARY KEY (student_id, subject_id, date),"
					+ "FOREIGN KEY (student_id) REFERENCES student (student_id),"
					+ "FOREIGN KEY (subject_id, teacher_id) REFERENCES subject (subject_id, teacher_id));";
			
			sqlStatement.executeUpdate(studentTable);
			sqlStatement.executeUpdate(teacherTable);
			sqlStatement.executeUpdate(subjectTable);
			sqlStatement.executeUpdate(testTable);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}
	}
	
	public void fillTables () {
		try {
			Statement sqlStatement = conn.createStatement();
			String insert;
			// data for student table
			insert = "INSERT INTO student (first_name, last_name, adress, post_code, phone_number)"  
					+ "VALUES ( 'Frank', 'Draw', 'London', 'LO12PO', 0777474999);";
			sqlStatement.executeUpdate(insert);
			insert = "INSERT INTO student (first_name, last_name, adress, post_code, phone_number)"  
					+ "VALUES ( 'Alec', 'Cob', 'Cambridge', 'CB28PS', 0767441499);";
			sqlStatement.executeUpdate(insert);
			insert = "INSERT INTO student (first_name, last_name, adress, post_code, phone_number)"  
					+ "VALUES ( 'Peter', 'Grab', 'London', 'LO17PO', 0777444984);";
			sqlStatement.executeUpdate(insert);
			insert = "INSERT INTO student (first_name, last_name, adress, post_code, phone_number)"  
					+ "VALUES ( 'Pat', 'Flaw', 'Bath', 'BA56LO', 0777444468);";
			sqlStatement.executeUpdate(insert);
			insert = "INSERT INTO student (first_name, last_name, adress, post_code, phone_number)"  
					+ "VALUES ( 'Craig', 'Low', 'London', 'LO52PO', 0777168999);";
			sqlStatement.executeUpdate(insert);
			
			// data for teacher table
			insert = "INSERT INTO teacher (first_name, last_name, adress, post_code, phone_number)"  
					+ "VALUES ( 'Maria', 'Pak', 'Edinburgh', 'ED58LS', 0247474559);";
			sqlStatement.executeUpdate(insert);
			insert = "INSERT INTO teacher (first_name, last_name, adress, post_code, phone_number)"  
					+ "VALUES ( 'Alec', 'Dowland', 'Cambridge', 'CB12PS', 0767447819);";
			sqlStatement.executeUpdate(insert);
			insert = "INSERT INTO teacher (first_name, last_name, adress, post_code, phone_number)"  
					+ "VALUES ( 'Tara', 'False', 'London', 'LO11PO', 0776984584);";
			sqlStatement.executeUpdate(insert);
			
			// data for subject table
			insert = "INSERT INTO subject (subject_name, subject_id, teacher_id)" 
					+ "	VALUES ( 'Mathematic', 'MAT', 1 );";
			sqlStatement.executeUpdate(insert);
			insert = "INSERT INTO subject (subject_name, subject_id, teacher_id)" 
					+ "	VALUES ( 'Mathematic', 'MAT', 2 );";
			sqlStatement.executeUpdate(insert);
			insert = "INSERT INTO subject (subject_name, subject_id, teacher_id)" 
					+ "	VALUES ( 'Physics', 'PHY', 3 );";
			sqlStatement.executeUpdate(insert);
			insert = "INSERT INTO subject (subject_name, subject_id, teacher_id)" 
					+ "	VALUES ( 'English', 'ENG', 2 );";
			sqlStatement.executeUpdate(insert);
			insert = "INSERT INTO subject (subject_name, subject_id, teacher_id)" 
					+ "	VALUES ( 'Computer Science', 'CSC', 1 );";
			sqlStatement.executeUpdate(insert);
			
			// data for test table
			insert ="INSERT INTO test (student_id, subject_id, date, mark, teacher_id)"  
					+ "	VALUES (1, 'MAT', '2019-12-05', 'A', 1 );";
			sqlStatement.executeUpdate(insert);
			insert ="INSERT INTO test (student_id, subject_id, date, mark, teacher_id)"  
					+ "	VALUES (2, 'MAT', '2019-11-05', 'F', 1 );";
			sqlStatement.executeUpdate(insert);
			insert ="INSERT INTO test (student_id, subject_id, date, mark, teacher_id)"  
					+ "	VALUES (3, 'ENG', '2019-11-05', 'F', 2 );";
			sqlStatement.executeUpdate(insert);
			insert ="INSERT INTO test (student_id, subject_id, date, mark, teacher_id)"  
					+ "	VALUES (4, 'MAT', '2019-05-15', 'B', 1 );";
			sqlStatement.executeUpdate(insert);
			insert ="INSERT INTO test (student_id, subject_id, date, mark, teacher_id)"  
					+ "	VALUES (5, 'CSC', '2019-12-14', 'C', 1 );";
			sqlStatement.executeUpdate(insert);
			insert ="INSERT INTO test (student_id, subject_id, date, mark, teacher_id)"  
					+ "	VALUES (1, 'PHY', '2019-01-12', 'B', 3 );";
			sqlStatement.executeUpdate(insert);
			insert ="INSERT INTO test (student_id, subject_id, date, mark, teacher_id)"  
					+ "	VALUES (2, 'MAT', '2019-05-16', 'D', 2 );";
			sqlStatement.executeUpdate(insert);
			insert ="INSERT INTO test (student_id, subject_id, date, mark, teacher_id)"  
					+ "	VALUES (4, 'CSC', '2019-05-17', 'A', 1 );";
			sqlStatement.executeUpdate(insert);
			
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}
		
	}
	
	
}
