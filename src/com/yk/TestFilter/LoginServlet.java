package com.yk.TestFilter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logins")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(!"".equals(password))
		{
			if(!"".equals(username))
			{
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
			}
		}
		
		req.getRequestDispatcher("RandomCode.jsp").forward(req, resp);
		
	}

}
