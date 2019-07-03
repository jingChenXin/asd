package com.byzx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @Description �˳�
 * @author ��
 * @date 2019��4��23�� ����6:22:05
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
		// ��������session
		req.getSession().invalidate();
		//��תҳ��
		req.getRequestDispatcher("/account.jsp").forward(req, resp);

	}

}
