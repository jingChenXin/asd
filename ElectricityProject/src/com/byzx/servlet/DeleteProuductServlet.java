package com.byzx.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.util.DBCUtil;

/**
 * 
 * @Description ɾ����Ʒ
 * @author ��
 * @date 2019��4��26�� ����6:35:26
 * @version v1.0
 */
@WebServlet("/deletePro")
public class DeleteProuductServlet extends HttpServlet {

	private static final long serialVersionUID = -3336460705241177445L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ��ȡ����
		String proId = req.getParameter("proId");
		// ִ��sql���
		try {
			String sql = "DELETE FROM `product` WHERE product.`pro_id` = " + proId;
			boolean f = DBCUtil.saveOrUpdate(sql);
			// ��תҳ��
			if (f) {
				resp.sendRedirect(req.getContextPath() + "/commodity?msg=1");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
