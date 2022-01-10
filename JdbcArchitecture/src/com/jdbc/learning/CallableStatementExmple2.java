package com.jdbc.learning;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementExmple2 {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306?";
		String user = "root";
		String password = "12345678";
		String cal_sp = "{call test.Thirdsd()}";
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			CallableStatement cstmp = conn.prepareCall(cal_sp);
			cstmp.executeUpdate();
			System.out.println("executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
