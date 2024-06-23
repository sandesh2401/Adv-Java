package com.studentmvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlUtil {
	static final String DB_USER = "root";
	static final String DB_PASSWORD = "cdac";
	static final String DB_NAME = "cdac_java";
	static final String DB_URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static PreparedStatement stmt;
	public static Connection conn;
	
	public SqlUtil() {	
	}
	
	public static void connectDb() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	}
	
	 public static int insert() throws SQLException {
	      int result = -1;
	      result = stmt.executeUpdate();
	      return result;
	   }
	 
	 public static int update() throws SQLException {
	      int result = -1;
	      result = stmt.executeUpdate();
	      return result;
	   }

	   public static int delete() throws SQLException {
	      int result = -1;
	      result = stmt.executeUpdate();
	      return result;
	   }

	   public static ResultSet fetch() throws SQLException {
	      ResultSet rs = null;
	      rs = stmt.executeQuery();
	      return rs;
	   }

	   public static void close() throws SQLException {
	      if (conn != null && stmt != null) {
	         stmt.close();
	         conn.close();
	      }

	   }
	   
	   
	   
}
