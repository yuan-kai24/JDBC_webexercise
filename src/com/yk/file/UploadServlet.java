package com.yk.file;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try{
			
			new FileUtil().service(req);
		}catch(LogicException e)
		{
			req.setAttribute("info",e.getMessage());
			req.getRequestDispatcher("/fileon/file.jsp").forward(req, resp);
		}
		
	}
	
}
