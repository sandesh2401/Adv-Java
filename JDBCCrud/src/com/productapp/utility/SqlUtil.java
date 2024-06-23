package com.productapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {

	final static String DB_USER = "root";
	final static String DB_PASSWORD = "cdac";
	final static String DB_NAME = "cdac";
	final static String DB_URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
	final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static Statement stmt;
	static Connection conn;
	
	static public void connectDb() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		stmt = conn.createStatement();
	}
	
	static public int insert(String qry) throws SQLException {
		int result = -1;
		if(qry != "") {
			result = stmt.executeUpdate(qry);
		}
		return result;
	}
	
	static public int update(String qry) throws SQLException {
		int result = -1;
		if(qry != "") {
			result = stmt.executeUpdate(qry);
		}
		return result;
	}
	
	static public int delete(String qry) throws SQLException {
		int result = -1;
		if(qry != "") {
			result = stmt.executeUpdate(qry);
		}
		return result;
	}
	
	static public ResultSet fetch(String qry) throws SQLException {
		ResultSet rs = null;
		if(qry != "") {
			rs = stmt.executeQuery(qry);
		}
		return rs;
	}
	
	static public void close() throws SQLException {
		if(conn != null && stmt != null ) {
			stmt.close();
			conn.close();
		}
	}

}
