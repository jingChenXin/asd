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
 * @Description 登陆
 * @author 景
 * @date 2019年4月23日 上午10:34:22
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
			// 1.获取请求参数
			String userName = req.getParameter("userName");
			String passWord = req.getParameter("passWord");
			// 判断是否登陆成功
			String msg = "";
			if ((userName != null && !"".equals(userName)) && (passWord != null && !"".equals(passWord))) {
				String sql = "SELECT * FROM  user_info WHERE CONCAT(user_surname,user_name) = '"
						+ userName + "' AND PASSWORD ='" + passWord + "'";
				rs = DBCUtil.findAll(sql);
				if (rs.next() && rs != null) {
					// 登陆成功,把用户信息放入session中
					UserInfo uif = new UserInfo(rs.getInt("user_id"),
							rs.getString("user_surname"),
							rs.getString("user_name"), null,
							rs.getString("password"), null, 0, null, null);
					req.getSession().setAttribute("username", uif);
					// 登陆成功， 返回首页
					req.getRequestDispatcher("/frontProlist")
							.forward(req, resp);
				} else {
					// 登陆失败，返回登录页面
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
