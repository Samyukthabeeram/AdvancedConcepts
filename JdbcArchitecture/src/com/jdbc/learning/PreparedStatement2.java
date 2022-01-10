package com.jdbc.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatement2  {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306?";
		String user="root";
		String password="12345678";
		//String query="insert into test.registration values(?,?,?)";
		String query="update test.registration set phoneNo=? where name=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter phone number");
		int phone=sc.nextInt();
		System.out.println("enter password");
		String passWord=sc.next();
		System.out.println("enter name");
		String name=sc.next();
		try {
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement pstmp=con.prepareStatement(query);
			pstmp.setInt(2, phone);
			pstmp.setString(1, passWord);
			pstmp.setString(3,name);
			pstmp.executeUpdate();
			System.out.println("data inserted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
