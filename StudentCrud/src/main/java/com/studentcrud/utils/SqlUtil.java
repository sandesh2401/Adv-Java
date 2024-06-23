package com.studentcrud.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUtil {
	   static final String DB_USER = "root";
	   static final String DB_PASSWORD = "cdac";
	   static final String DB_NAME = "cdac_java";
	   static final String DB_URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
	   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	   static Statement stmt;
	   static Connection conn;

	   public SqlUtil() {
	   }

	   public static void connectDb() throws ClassNotFoundException, SQLException {
	      Class.forName(JDBC_DRIVER);
	      conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	      stmt = conn.createStatement();
	   }

	   public static int insert(String qry) throws SQLException {
	      int result = -1;
	      if (qry != "") {
	         result = stmt.executeUpdate(qry);
	      }

	      return result;
	   }

	   public static int update(String qry) throws SQLException {
	      int result = -1;
	      if (qry != "") {
	         result = stmt.executeUpdate(qry);
	      }

	      return result;
	   }

	   public static int delete(String qry) throws SQLException {
	      int result = -1;
	      if (qry != "") {
	         result = stmt.executeUpdate(qry);
	      }

	      return result;
	   }

	   public static ResultSet fetch(String qry) throws SQLException {
	      ResultSet rs = null;
	      if (qry != "") {
	         rs = stmt.executeQuery(qry);
	      }

	      return rs;
	   }

	   public static void close() throws SQLException {
	      if (conn != null && stmt != null) {
	         stmt.close();
	         conn.close();
	      }

	   }
	}
