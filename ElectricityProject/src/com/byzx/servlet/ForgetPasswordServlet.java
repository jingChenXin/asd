package com.byzx.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.bean.UserInfo;
import com.byzx.util.DBCUtil;

/**
 * 
 * @Description ��������
 * @author ��
 * @date 2019��5��2�� ����7:58:10
 * @version v1.0
 */
@WebServlet("/forgetPassword")
public class ForgetPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 7613962039228067499L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// 1.��ȡ�������
		String userName = req.getParameter("userName");
		String phone = req.getParameter("phone");
		ResultSet rs = null;
		int userId = 0;
		try {
			if ((userName != null && !"".equals(userName))
					&& (phone != null && !"".equals(phone))) {
				// ͨ���������Ϣ����û�id
				String sql = "SELECT `user_id` FROM  user_info WHERE CONCAT(user_surname,user_name) = '"
						+ userName + "' AND phone ='" + phone + "'";
				rs = DBCUtil.findAll(sql);
				if(rs.next()){
				userId = rs.getInt("user_id");
				
				}
				if (userId > 0) {
					req.getRequestDispatcher("/getAccount?userId=" + userId)
							.forward(req, resp);
				} else {
					// �ֻ��Ų���ȷ�����ص�¼ҳ��
					req.setAttribute("userName", userName);
					req.getRequestDispatcher("/account01.jsp?msg=0")
					.forward(req, resp);
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rs);
		}

	}

}
