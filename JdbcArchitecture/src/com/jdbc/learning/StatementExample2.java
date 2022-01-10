package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample2 {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306?";
		String user="root";
		String password="12345678";
		//String query="insert into test.login values(900498064, 'samyuktha@gmail.com', 'chinna', 'sam_sony', 'sammu')";
		String query="select * from test.login where phone=900498064 ";
			try {
			Connection con=DriverManager.getConnection(url, user, password);
			Statement stmp=con.createStatement();
			//stmp.executeUpdate(query);
			ResultSet rs=stmp.executeQuery(query);
			rs.next();
			int phone=rs.getInt("Phone");
			String emailId=rs.getString("EmailId");
			String passWord=rs.getString("Password");
			String userName=rs.getString("Username");
			String name=rs.getString("Name");
			
			
			System.out.println(phone+" "+emailId+" "+passWord+" "+userName+" "+name);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
