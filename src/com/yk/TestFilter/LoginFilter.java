package com.yk.TestFilter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFilter implements Filter {

	private String [] unCheckUris = {"/Kdl_jsp/login.jsp","/Kdl_jsp/logins"};
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String rurl = req.getRequestURI();
		System.out.println(rurl);
		if(!Arrays.asList(unCheckUris).contains(rurl))
		{
			String username = (String) req.getSession().getAttribute("username");
			System.out.println(username);
			if(username == null)
			{
				resp.sendRedirect("/Kdl_jsp/login.jsp");
				return;
			}
		}
		
		chain.doFilter(req, resp);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
