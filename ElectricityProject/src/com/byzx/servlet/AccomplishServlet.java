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
import com.byzx.bean.OrderInfo;
import com.byzx.bean.OrderItem;
import com.byzx.util.DBCUtil;

/**
 * 
 * @Description 完成
 * @author 景
 * @date 2019年5月6日 下午5:17:43
 * @version v1.0
 */
@WebServlet("/accomplish")
public class AccomplishServlet extends HttpServlet {

	private static final long serialVersionUID = -1052583139988903515L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String addrId = req.getParameter("addrId");
		String orderId = req.getParameter("orderId");
		String sql = "";
		ResultSet rsa = null;
		ResultSet rsb = null;
		ResultSet rsc = null;
		OrderInfo orderInfo = null;
		OrderItem orderItem = null;
		Address address = null;
		try {
			// 获取用户用户收货地址
			sql = "SELECT * FROM `address` WHERE `addr_id` = " + addrId;
			rsa = DBCUtil.findAll(sql);
			while (rsa.next()) {
				address = new Address(rsa.getInt("addr_id"),
						rsa.getInt("user_id"), rsa.getString("addr_info"),
						rsa.getString("post_code"),
						rsa.getString("reap_person"), rsa.getString("phone"));
			}
			// 获取商品信息
			sql = "SELECT * FROM `order_item` WHERE `order_id` = " + orderId ;
			rsb = DBCUtil.findAll(sql);
			List items = new ArrayList();
			while (rsb.next()) {
				orderItem = new OrderItem(rsb.getInt("item_id"),
						rsb.getInt("order_id"), rsb.getInt("pro_id"),
						rsb.getString("pro_name"), rsb.getFloat("pro_price"),
						rsb.getInt("pro_count"), 0.0f, rsb.getString("pro_pic"));
				items.add(orderItem);
			}
			sql = "SELECT * FROM `order_info` WHERE `order_id` = " + orderId ;
			rsc = DBCUtil.findAll(sql);
			while (rsc.next()) {
				orderInfo = new OrderInfo(rsc.getInt("order_id"),
						rsc.getString("order_num"), rsc.getInt("user_id"),
						rsc.getInt("addr_id"), rsc.getFloat("total_money"),
						rsc.getString("pay_way"), rsc.getString("order_state"),
						rsc.getString("cart_state"),
						rsc.getString("create_time"));
			}
			req.setAttribute("address", address);
			req.setAttribute("items", items);
			req.setAttribute("orderInfo", orderInfo);
			req.getRequestDispatcher("/contact.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsc);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsb);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsa);
		}

	}
}
