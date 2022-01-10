package com.servlet.learning;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Verify PhoneNumber")
public class ServletExample2 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String phoneNo=req.getParameter("phone");
		String emailId=req.getParameter("id");
		System.out.println(phoneNo +" "+emailId);
		JavaClass jc=new JavaClass();
			jc.jdbcCode(phoneNo,emailId);
		
		 PrintWriter pw=resp.getWriter();
		 pw.println();
	}
		
	}  


	

