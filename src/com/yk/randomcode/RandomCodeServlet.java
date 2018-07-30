package com.yk.randomcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RandomCodeServlet
 */
@WebServlet("/randomcode")
public class RandomCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//生成随机验证码
		String randomCode = UUID.randomUUID().toString().substring(0,5);
		req.getSession().setAttribute("randomcode", randomCode);
		
		
		//创建图片对象
		int width = 80;
		int height = 40;
		int imageType = BufferedImage.TYPE_INT_RGB;
		BufferedImage image = new BufferedImage(width, height, imageType);
		
		//创建画板
		Graphics g = image.getGraphics();
		g.setColor(Color.ORANGE);
		
		//绘制
		g.fillRect(1, 1, width-2, height-2);
		
		//放置随机数
		g.setColor(Color.red);
		Font font = new Font("微软雅黑",Font.BOLD+Font.ITALIC,20);
		g.setFont(font);
		g.drawString(randomCode, 10, 28);
		
		//干扰视觉区（简单做了下）
		g.setColor(Color.blue);
		Random ran = new Random();
		for(int i = 0;i < 100;i++)
		{
			g.fillOval(ran.nextInt(width), ran.nextInt(height), 2, 2);
		}//增加100个圆点，干扰视觉
		
		//关闭画板
		g.dispose();
		
		//把图片响应出去，以流的方式
		ImageIO.write(image, "jpg", resp.getOutputStream());
		
		
	}

}
