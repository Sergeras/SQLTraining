package a;

import java.sql.*;

public class SQLConnector {
	
	private String password = "";
	private String userName = "";
	private String url = "jdbc:sqlserver://DESKTOP-N8FNPVH\\SQLEXPRESS;databaseName=Training;integratedSecurity=true;";
	private Connection conn = null;
	
	public Connection getConnection () throws SQLException {
		return conn = DriverManager.getConnection(url + userName + password);
	}
	
	public SQLConnector() {
		// TODO Auto-generated constructor stub
	}
	
	public SQLConnector(String url) throws SQLException {
		this.url = url;
		
	}
	
	public SQLConnector(String password, String userName, String url) {
		this.password = password;
		this.userName = userName;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserNamer(String userName) {
		this.userName = userName;
	}
	
	
	
}
