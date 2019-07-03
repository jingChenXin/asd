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
 * @Description ��½
 * @author ��
 * @date 2019��4��23�� ����10:34:22
 * @version v1.0
 */
@WebServlet("/login")
public class AccountServlet extends HttpServlet {

	private static final long serialVersionUID = 5520940647213911588L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		ResultSet rs = null;
		try {
			// 1.��ȡ�������
			String userName = req.getParameter("userName");
			String passWord = req.getParameter("passWord");
			// �ж��Ƿ��½�ɹ�
			String msg = "";
			if ((userName != null && !"".equals(userName)) && (passWord != null && !"".equals(passWord))) {
				String sql = "SELECT * FROM  user_info WHERE CONCAT(user_surname,user_name) = '"
						+ userName + "' AND PASSWORD ='" + passWord + "'";
				rs = DBCUtil.findAll(sql);
				if (rs.next() && rs != null) {
					// ��½�ɹ�,���û���Ϣ����session��
					UserInfo uif = new UserInfo(rs.getInt("user_id"),
							rs.getString("user_surname"),
							rs.getString("user_name"), null,
							rs.getString("password"), null, 0, null, null);
					req.getSession().setAttribute("username", uif);
					// ��½�ɹ��� ������ҳ
					req.getRequestDispatcher("/frontProlist")
							.forward(req, resp);
				} else {
					// ��½ʧ�ܣ����ص�¼ҳ��
					msg = "0";
					req.setAttribute("msg", msg);
					req.getRequestDispatcher("/account.jsp?msg=0").forward(req,
							resp);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rs);
		}

	}

}
