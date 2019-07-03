package com.byzx.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.byzx.util.GrenOrderNum;

/**
 * 
 * @Description ���ﳵȷ�Ϲ���
 * @author ��
 * @date 2019��5��7�� ����2:02:39
 * @version v1.0
 */
@WebServlet("/getCartOrd")
public class GetCartOrdServlet extends HttpServlet {

	private static final long serialVersionUID = 932389689793099771L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1. ��ȡ�û���Ϣ
		Object obj = req.getSession().getAttribute("username");
		UserInfo user = (UserInfo) obj;
		String ids = req.getParameter("ids");
		String proCount = req.getParameter("proCount");
		String sql = "";
		OrderItem orderItem = null;
		ResultSet rsa = null;
		ResultSet rsb = null;
		ResultSet rsc = null;
		ResultSet rsd = null;
		int orderId = 0;
		float cartTotal = 0;
		try {
			// ��ȡ�û��û��ջ���ַ
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
			//ȥ����ѡ��Ʒ��������
			String[] idss = ids.split(",");
			String[] proCounts = proCount.split(",");
			// �޸���Ʒ����
				for (int i = 0; i < proCounts.length; i++) {
					sql= "UPDATE `order_item` SET `pro_count` = "+proCounts[i] +" WHERE `item_id` = " + idss[i];
					DBCUtil.saveOrUpdate(sql);
				}
			//ȥ����ѡ��Ʒid����
			if (ids != null && ids.lastIndexOf(",") != -1) {
				ids = ids.substring(0, ids.lastIndexOf(","));
			}
			// ��ѯ���ﳵ��ϸ��Ϣ
				sql = "SELECT * FROM `order_item` WHERE `item_id` IN (" + ids + ")";
				rsb = DBCUtil.findAll(sql);
				List items = new ArrayList();
				while (rsb.next()) {
					orderItem = new OrderItem(rsb.getInt("item_id"),
							rsb.getInt("order_id"), rsb.getInt("pro_id"),
							rsb.getString("pro_name"),
							rsb.getFloat("pro_price"), rsb.getInt("pro_count"),
							0.0f, rsb.getString("pro_pic"));
					items.add(orderItem);
				}

			//�������Ʒ�ܼ۸�
			sql = "SELECT SUM(`pro_price`*`pro_count`) AS cartTotal FROM `order_item` WHERE `item_id` IN (" + ids + ")";
			rsd = DBCUtil.findAll(sql);
			if(rsd.next()){
				cartTotal = rsd.getFloat("cartTotal");
			}
			BigDecimal b = new BigDecimal(cartTotal);
			float cartTotals = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
			// �����µĹ��ﳵ ����һ���µ� ����Ψһ����
			sql = "INSERT INTO order_info (`order_num`,`user_id`,`total_money`,`order_state`,`cart_state`)"
					+ " VALUES ('"+ GrenOrderNum.grenOrderNum()+ "','"+ user.getUserId() + "','"+cartTotals+"','0','1')";
			DBCUtil.saveOrUpdate(sql);
			// ���ɹ��ﳵ����
			sql = "SELECT MAX(`order_id`) AS orderId FROM `order_info`" + " WHERE `user_id`= " + user.getUserId();
			rsc = DBCUtil.findAll(sql);
			if (rsc.next()) {
				orderId = rsc.getInt("orderId");
			}
			sql = "UPDATE `order_item` SET `order_id` = " + orderId + "  WHERE  `item_id` IN (" + ids + ")";
			DBCUtil.saveOrUpdate(sql);
			

			// ��תҳ��
			req.setAttribute("orderId", orderId);
		 	req.setAttribute("cartTotals", cartTotals);
			req.setAttribute("addrList", addrList);
			req.setAttribute("items", items);
			
			req.getRequestDispatcher("/checkoutCart.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsd);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsc);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsb);
			DBCUtil.close(DBCUtil.con, DBCUtil.stm, rsa);
			
		}
	}

}
