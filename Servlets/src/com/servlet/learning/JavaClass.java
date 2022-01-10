package com.servlet.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JavaClass {


	public void jdbcCode(String phoneNo, String emailId)  {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306?";
		String user="root";
		String password="12345678";
				String query="insert into test.info values(?,?)";
			try {
				Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,password);
			PreparedStatement pstmp=conn.prepareStatement(query);
			pstmp.setString(1,phoneNo);
			pstmp.setString(2,emailId);
			pstmp.executeUpdate();
			System.out.println("executed");
		
			} catch (SQLException | ClassNotFoundException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}