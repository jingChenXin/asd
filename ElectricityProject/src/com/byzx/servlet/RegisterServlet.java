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
 * @Description 注册
 * @author 景
 * @date 2019年4月23日 下午12:04:55
 * @version v1.0
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 3940249084085798863L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String sql = "";
		String msg = "";
		ResultSet rs = null;
		int userId = 0;
		// 1.获取参数
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
				userId = rs.getInt("user_id");
			}
			if (userId > 0) {
				resp.sendRedirect(req.getContextPath() + "/register.jsp?msg=3");
			} else if (passWord.equals(passwordPawd)) {

				sql = "INSERT INTO `user_info` (`user_surname`,`user_name`,`user_sex`,`password`,`password_pawd`,`phone`,`post_code`) "
						+ "VALUES ('"+ userSurname+ "','"+ userName+ "','"+ userSex+ "','"+ passWord+ "','"+ passwordPawd+ "','" + phone + "','" + postCode + "')";
				boolean f = DBCUtil.saveOrUpdate(sql);

				if (f) {
					// 成功跳转页面
					req.getRequestDispatcher("/account.jsp?msg=1")
					.forward(req,resp);
				} else {
					// 失败跳转页面
					resp.sendRedirect(req.getContextPath() + "/register.jsp?msg=0");
					
				}

			} else {
				// 两次密码不一致
				resp.sendRedirect(req.getContextPath() + "/register.jsp?msg=2");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
