package by.aghmi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	
	public static Connection getConnection(Environment env){
		Connection conn = null;
		try {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			conn = DriverManager.getConnection(
					env.getUrl(), env.getUser(), env.getPass());
			System.out.println("Created Connection :" + conn);
		} catch (SQLException e) {
			System.err.println("getConnection() error : " 
		+ e.getMessage());
			
		}
		return conn;
		
	}
	
	public static Connection getConnection(){
		Environment env = null;
		String key = AppSettings.getSettings().getProp("env");
		switch (key) {
		case "DEV":
			env = Environment.DEV;
			break;
		case "PROD":
			env = Environment.PROD;
			break;
		case "PRE_PROD":
			env = Environment.PRE_PROD;
			break;

		default:
			System.out.println("No implementation for instance = " +  key);
		}
		return getConnection(env);
	}
	
	public static void release(Connection conn, ResultSet rs, Statement stmt , PreparedStatement pstmt){
		if (conn != null){
			try {
				conn.close();
				System.out.println("Connection is closed:" + conn);
			} catch (SQLException e) {
				System.err.println("Error of Connection closing : " 
						+ e.getMessage());
			}
		}
		
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println("Error of ResultSet closing : " 
						+ e.getMessage());
			}
		}
		
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println("Error of Statement closing : " 
						+ e.getMessage());
			}
		}
		
		if(pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				System.err.println("Error of PreparedStatement closing : " 
						+ e.getMessage());
			}
		}
		
	}
	
}
