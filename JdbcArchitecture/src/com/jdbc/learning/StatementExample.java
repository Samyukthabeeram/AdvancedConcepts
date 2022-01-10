package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306?";
		String user ="root"; 
		String password="12345678";
		//String query="insert into test.employee values(12, 'shiva', 20000.0)";
		String query="select * from test.employee where empName='shiva'";
		try{
			Connection conn=(Connection)DriverManager.getConnection(url, user, password);
			Statement stmp=conn.createStatement();
		ResultSet rs=stmp.executeQuery(query);
		rs.next();
		String empName=rs.getString("EMPNAME");
		String empId=rs.getString("EMPID");
		double empSal=rs.getDouble("EMPSAL");
		System.out.println(empName+" " + empId+" "+empSal+" ");
			conn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		
		}

	}
}
