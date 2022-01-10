package com.httpservlet.learning;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/uploadclass")
@MultipartConfig(maxFileSize= 1624523564)
public class UploadClass extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String name=req.getParameter("name");
	Part pt=req.getPart("img");
	System.out.println(name+" "+pt);
	jdbcCode(name,pt);
}
public void jdbcCode(String name, Part pt) {
	String url="jdbc:mysql://localhost:3306?";
	String user="root";
	String password="12345678";
	String query="insert into test.uploadimage values(?,?)";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(url, user, password);
		PreparedStatement pstmp=conn.prepareStatement(query);
		pstmp.setString(1, name);
	InputStream input=pt.getInputStream();
	pstmp.setBlob(2, input);
		pstmp.executeUpdate();
		conn.close();
		System.out.println("executed");
	} catch (SQLException | IOException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
