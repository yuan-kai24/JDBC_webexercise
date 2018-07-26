package com.yk.jdbc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delp")
public class DeletePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MyJdbc jdbc;
	public void init() throws ServletException {
		jdbc = new MyJdbc();
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		jdbc.deletInfo(id);
		
		resp.sendRedirect("jdbc");
	}

}
