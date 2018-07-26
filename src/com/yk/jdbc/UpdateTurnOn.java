package com.yk.jdbc;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updo")
public class UpdateTurnOn extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private MyJdbc jdbc;
	public void init() throws ServletException {
		jdbc = new MyJdbc();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		
		Map<String, Object> info = jdbc.seleInfo(id);
		info.put("id", id);
		
		req.setAttribute("info", info);
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
		
	}

}
