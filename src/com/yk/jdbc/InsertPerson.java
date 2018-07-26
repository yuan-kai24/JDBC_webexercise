package com.yk.jdbc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insp")
public class InsertPerson extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private MyJdbc jdbc;
	public void init() throws ServletException {
		jdbc = new MyJdbc();
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Map<String, Object> info = new HashMap<>();
		info.put("name", req.getParameter("name"));
		info.put("sex", req.getParameter("sex"));
		info.put("age", req.getParameter("age"));
		info.put("phone", req.getParameter("phone"));
		info.put("[e-mail]", req.getParameter("[e-mail]"));
		jdbc.insertInfo(info);
		resp.sendRedirect("jdbc");
	}


}
