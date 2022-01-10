package com.httpservlet.learning;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verification")
public class ServletClass extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String phone = req.getParameter("ph");
			String emailId = req.getParameter("mail");
			String pass = req.getParameter("ps");
			String confirmPass = req.getParameter("confirmps");
			String userName = req.getParameter("username");
			String name = req.getParameter("name");
			if(pass.equals(confirmPass)) 
			{
				jdbcCode(phone,emailId,pass,userName,name);
				System.out.println("executed");
			}
			else{
				System.out.println("password missmatch");
			}
		}
	
public void jdbcCode(String phone, String emailId, String pass, String userName, String name) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306?";
		String user = "root";
		String password = "12345678";
		String query = "insert into test.login values(?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmp = conn.prepareStatement(query);
			pstmp.setString(1, phone);
			pstmp.setString(2, emailId);
			pstmp.setString(3, pass);
			pstmp.setString(4, userName);
			pstmp.setString(5, name);
			pstmp.executeUpdate();
			System.out.println("executed1");

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}