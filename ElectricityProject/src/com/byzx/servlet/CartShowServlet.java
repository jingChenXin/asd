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

import com.byzx.bean.Address;
import com.byzx.bean.OrderItem;
import com.byzx.bean.UserInfo;
import com.byzx.util.DBCUtil;

/**
 * 
 * @Description 购物车展示
 * @author 景
 * @date 2019年4月30日 上午10:49:16
 * @version v1.0
 */
@WebServlet("/cartShow")
public class CartShowServlet extends HttpServlet {

	private static final long serialVersionUID = 8530790464254877020L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Object obj = req.getSession().getAttribute("username");
		UserInfo user = (UserInfo) obj;
		String orderId = req.getParameter("orderId");
		ResultSet rsa = null;
		ResultSet rst = null;
		String sql = "";
		try {
			//获取用户用户收货地址
			sql = "SELECT * FROM `address` WHERE `user_id` = " + user.getUserId();
			rsa = DBCUtil.findAll(sql);
			Address address = null;
			List<Address> addrList = new ArrayList();
			while (rsa.next()) {
				address = new Address(rsa.getInt("addr_id"),
						rsa.getInt("user_id"), rsa.getString("addr_info"),
						null, rsa.getString("reap_person"),
						rsa.getString("phone"));
				addrList.add(address);
			}
			// 执行sql语句 显示购物车商品信息
			sql = "SELECT * FROM `order_item` WHERE `order_id` =  " + orderId;
			rst = DBCUtil.findAll(sql);
			List cartList = new ArrayList();
			OrderItem orderItem = null;
			while (rst.next()) {
				orderItem = new OrderItem(rst.getInt("item_id"),
						rst.getInt("order_id"), rst.getInt("pro_id"),
						rst.getString("pro_name"), rst.getFloat("pro_price"),
						rst.getInt("pro_count"), 0.0f, rst.getString("pro_pic"));
				cartList.add(orderItem);
			}
			// 跳转页面
			req.setAttribute("addrList", addrList);
			req.setAttribute("cartList", cartList);
			req.getRequestDispatcher("/checkout.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsa);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rst);
		}
	}
}
