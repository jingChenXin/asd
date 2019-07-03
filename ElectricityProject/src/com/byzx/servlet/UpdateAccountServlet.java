package com.byzx.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.util.DBCUtil;

/**
 * 
 * @Description 修改用户信息
 * @author 景
 * @date 2019年5月1日 下午7:57:12
 * @version v1.0
 */
@WebServlet("/updateAccount")
public class UpdateAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 1148371386165658420L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String sql = "";
		ResultSet rs = null;
		int newUserId = 0;
		// 1.获取参数
		String userId = req.getParameter("userId");
		String userSurname = req.getParameter("userSurname");
		String userName = req.getParameter("userName");
		String userSex = req.getParameter("userSex");
		String passWord = req.getParameter("passWord");
		String passwordPawd = req.getParameter("passwordPawd");
		String phone = req.getParameter("phone");
		String postCode = req.getParameter("postCode");
		// 判断用户名是否重复
		try {
			sql = "SELECT `user_id` FROM `user_info`"
					+ "WHERE `user_surname`  = '" + userSurname
					+ "' AND `user_info`.`user_name` = '" + userName + "'";
			rs = DBCUtil.findAll(sql);
			if (rs.next()) {
				newUserId = rs.getInt("user_id");
			}
			if (newUserId > 0) {
				resp.sendRedirect(req.getContextPath() + "/getAccount?userId="
						+ userId + "&msg=3");
			} else if (newUserId == 0 && (passWord.equals(passwordPawd))) {
				sql = "UPDATE `user_info` SET `user_surname` = '" + userSurname
						+ "',`user_name`= '" + userName + "',`user_sex` = '"
						+ userSex + "'" + ",`password` = '" + passWord
						+ "',`password_pawd` = '" + passwordPawd
						+ "',`phone` = '" + phone + "',`post_code` = '"
						+ postCode + "' WHERE `user_id` = " + userId;

				boolean f = DBCUtil.saveOrUpdate(sql);
				if (f) {
					// 成功跳转页面
					req.getRequestDispatcher("/account.jsp?msg=1").forward(req,
							resp);
				} else {
					// 失败跳转页面
					resp.sendRedirect(req.getContextPath()
							+ "/getAccount?userId=" + userId + "&msg=0");
				}
			} else {
				// 两次密码不一致
				resp.sendRedirect(req.getContextPath() + "/getAccount?userId="
						+ userId + "&msg=2");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rs);
		}

	}

}
