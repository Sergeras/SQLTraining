package a;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public interface ResultSetDisplayer {
	
	public default  void display (ResultSet rs) throws SQLException {
		
		ResultSetMetaData metaData = rs.getMetaData();
		
		while (rs.next()) {
			
			StringBuffer buffer = new StringBuffer();
			
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				buffer.append(rs.getString(i) + " ");
			}
			
			System.out.println(buffer.toString());
		}
	}
}
