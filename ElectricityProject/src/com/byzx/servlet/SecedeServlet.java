package com.byzx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @Description 退出
 * @author 景
 * @date 2019年4月23日 下午6:22:05
 * @version v1.0
 */
@WebServlet("/secede")
public class SecedeServlet extends HttpServlet {

	private static final long serialVersionUID = 4480557175845908271L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 立即销毁session
		req.getSession().invalidate();
		//跳转页面
		req.getRequestDispatcher("/account.jsp").forward(req, resp);

	}

}
