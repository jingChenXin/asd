package com.byzx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byzx.bean.UserInfo;
import com.byzx.util.DBCUtil;

/**
 * 
 * @Description 收货地址
 * @author 景
 * @date 2019年5月3日 下午10:08:18
 * @version v1.0
 */

@WebServlet("/harvestAddress")
public class HarvestAddressServlet extends HttpServlet {

	private static final long serialVersionUID = 8424584848826267729L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		try {
			String sql = "";
			// 获取参数
			Object obj = req.getSession().getAttribute("username");
			UserInfo user = (UserInfo) obj;
			String reapPerson = req.getParameter("reapPerson");
			String phone = req.getParameter("phone");
			String addrInfo = req.getParameter("addrInfo");
			// 执行sql语句
			sql = "INSERT INTO `address` (`user_id`,`addr_info`,`reap_person`,`phone`) "
					+ " VALUES ('"+ user.getUserId()+ "' , '"+ addrInfo+ "','" + reapPerson + "','" + phone + "')";
			DBCUtil.saveOrUpdate(sql);

			// 跳转页面
			resp.sendRedirect(req.getContextPath() + "/contact.jsp?m=0");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
