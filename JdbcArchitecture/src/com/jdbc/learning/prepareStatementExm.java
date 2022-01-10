 package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class prepareStatementExm {
	public static void main(String[] args)  {
		
	
	String url="jdbc:mysql://localhost:3306?";
	String user="root";
	String password="12345678";
	String query="select emailid from test.register where PHONE=? and PWD=?";
	Scanner sc=new Scanner(System.in);
	System.out.print("enter phonenumber");
	String PHONE=sc.next();
	System.out.println("enter password");
	String PWD=sc.next();
	try
	{
		Connection conn=DriverManager.getConnection(url, user, password);
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1,PHONE );
		ps.setString(2,PWD );
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			String mailId=rs.getString("EMAILID");
			System.out.println("login sucess"+ " "+mailId);
		}
		else
		{System.err.println("login failure");
	}
	conn.close();
	sc.close();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}
}
