package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

		public static Connection getConnection() throws SQLException {
			
			//For compatibility with other technologies/frameworks
			try {
				Class.forName("org.postgresql.ApplicationMain");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String url = "jdbc:postgresql:javafs200803.cb2jxgoiogdh.us-west-1.rds.amazonaws.com:5432/postgres_training";
			String username = "postgres";
			String password = "Password"; 
			
			return DriverManager.getConnection(url, username, password);
		}
}
