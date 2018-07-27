package com.yk.download;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFormat.Encoding;

import com.sun.xml.internal.fastinfoset.Encoder;

@WebServlet("/down")
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String filename = req.getParameter("filename");
		
		System.out.println(filename.trim());
		
		if(filename != null && !"".equals(filename.trim()))
		{
			filename = new String(filename.getBytes("ISO-8859-1"),"utf-8");
		}
		
		String path = super.getServletContext().getRealPath("/WEB-INF/download/"+filename);
		
		//设置响应头(弹框询问)
		resp.setContentType("application/x-msdownload");
		
		String useragent = req.getHeader("User-Agent");
		
		if(useragent.contains("MSIE"))
		{
			filename = URLEncoder.encode(filename, "utf-8");
		}
		else
		{
			
			filename = new String(filename.getBytes("utf-8"),"ISO-8859-1");
		}
		//设置建议保存名称
		resp.setHeader("Content-Disposition", "attachment;filename="+filename);

		Files.copy(Paths.get(path), resp.getOutputStream());
		
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

}
