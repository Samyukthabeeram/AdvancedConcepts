package com.jdbc.learning;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementExmple 
{
	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306?";
		String user="root";
		String password="12345678";
		String cal_sp="{call test.Secondsd()}";
		try 
		{
			Connection conn=DriverManager.getConnection(url, user, password);
			CallableStatement cstmp=conn.prepareCall(cal_sp);
			ResultSet rs=cstmp.executeQuery();
			rs.next();
			String emailId=rs.getString("EmailId");
			
			System.out.println(emailId);
			
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
