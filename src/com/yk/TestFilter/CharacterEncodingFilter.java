package com.yk.TestFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter {

	private String encoding;
	private boolean forceencoding = false;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");

		this.forceencoding = Boolean.valueOf(filterConfig
				.getInitParameter("force"));

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		if (hasLength(encoding)
				&& (req.getCharacterEncoding() != null || forceencoding)) {
			req.setCharacterEncoding(encoding);
		}

		System.out.println(encoding);

		chain.doFilter(req, resp);

	}

	@Override
	public void destroy() {

	}

	private boolean hasLength(String encoding) {
		return encoding != null && "".equals(encoding);
	}

}
