package com.yk.randomcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rlogin")
public class RandomCodeLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String usercode = req.getParameter("randomcode");
		if(req.getSession().getAttribute("randomcode") == null)
		{
			req.setAttribute("errorlogin", "验证码已过期！");
			req.getRequestDispatcher("RandomCode.jsp").forward(req, resp);
			return;
		}
		String randomcode = req.getSession().getAttribute("randomcode").toString();
		
		System.out.println(username + "\r\n" + password + "\r\n" + usercode + "\r\n" + randomcode);		
		if(usercode != null && randomcode.equals(usercode)){
			System.out.println(username + "\r\n" + password + "\r\n" + usercode + "\r\n" + randomcode);
		}
		else
		{
			req.setAttribute("errorlogin", "密码或验证码错误！");
			req.getRequestDispatcher("RandomCode.jsp").forward(req, resp);
			
		}
		req.getSession().removeAttribute("randomcode");
		
	}

}
