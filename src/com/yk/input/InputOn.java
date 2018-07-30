package com.yk.input;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/input")
public class InputOn extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String data = req.getParameter("data");
		
		String usertoken = req.getParameter("token");
		String sesstoken = (String) req.getSession().getAttribute("token");
		
		if(usertoken.equals(sesstoken))
		{
			req.getSession().removeAttribute("token");
			System.out.println("Success!");
		}
		else
		{
			System.out.println(data + usertoken);			
		}
		
	}

}
