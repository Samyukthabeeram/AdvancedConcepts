package com.servlet.learning;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/sample")
public class ServletSample extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Random r= new Random();
		int otp=r.nextInt(5000  );
		if(otp<0)
		{
			otp=otp*-1;
		}
		System.out.println(otp);
		PrintWriter pw=res.getWriter();
		pw.println();
	}

}
