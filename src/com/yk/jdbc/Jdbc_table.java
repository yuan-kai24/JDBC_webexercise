package com.yk.jdbc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jdbc")
public class Jdbc_table extends HttpServlet {
	private static final long serialVersionUID = 2028811069712597010L;
	private MyJdbc jdbc;
	public void init() throws ServletException {
		jdbc = new MyJdbc();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<SqlInfo> sin = jdbc.init();
		req.setAttribute("info", sin);
		
		req.getRequestDispatcher("/personinformation.jsp").forward(req, resp);
		
	}

}
