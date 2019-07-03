package com.byzx.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.bean.UserInfo;
import com.byzx.util.DBCUtil;

/**
 * 
 * @Description 回显用户信息
 * @author 景
 * @date 2019年5月1日 下午7:41:00
 * @version v1.0
 */
@WebServlet("/getAccount")
public class GetAccountServlet extends HttpServlet {

	private static final long serialVersionUID = 4068291357159173296L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取用户ID
		String userId = req.getParameter("userId");
		ResultSet rs = null;
		try {

			// 执行sql语句
			String sql = "SELECT * FROM `user_info` WHERE `user_id` = "
					+ userId;
			rs = DBCUtil.findAll(sql);
			UserInfo userInfo = null;
			while (rs.next()) {
				userInfo = new UserInfo(rs.getInt("user_id"),
						rs.getString("user_surname"),
						rs.getString("user_name"), rs.getString("user_sex"),
						rs.getString("password"),
						rs.getString("password_pawd"), 0,
						rs.getString("phone"), rs.getString("post_code"));
			}
			// 返回页面
			req.getSession().setAttribute("userInfo", userInfo);
			req.getRequestDispatcher("/register01.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rs);
		}
	}

}
